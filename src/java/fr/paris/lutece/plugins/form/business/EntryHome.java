/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.form.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.List;


/**
 * This class provides instances management methods (create, find, ...) for Entry objects
 */
public final class EntryHome
{
    // Static variable pointed at the DAO instance
    private static IEntryDAO _dao = (IEntryDAO) SpringContextService.getPluginBean( "form", "entryDAO" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private EntryHome(  )
    {
    }

    /**
     * Creation of an instance of Entry
     *
     * @param entry The instance of the Entry which contains the informations to store
     * @param plugin the Plugin
     * @return The primary key of the new entry.
     */
    public static int create( IEntry entry, Plugin plugin )
    {
        return _dao.insert( entry, plugin );
    }

    /**
     * Copy of an instance of Entry
     *
     * @param entry The instance of the Entry who must copy
     * @param plugin the Plugin
     *
     */
    public static void copy( IEntry entry, Plugin plugin )
    {
        IEntry entryCopy = entry;
        List<Field> listField;
        listField = FieldHome.getFieldListByIdEntry( entry.getIdEntry(  ), plugin );
        entryCopy.setIdEntry( create( entry, plugin ) );

        for ( Field field : listField )
        {
            field = FieldHome.findByPrimaryKey( field.getIdField(  ), plugin );

            for ( IEntry entryConditionnal : field.getConditionalQuestions(  ) )
            {
                entryConditionnal.setForm( entry.getForm(  ) );
            }

            field.setParentEntry( entryCopy );
            FieldHome.copy( field, plugin );
        }

        if ( entryCopy.getEntryType(  ).getGroup(  ) )
        {
            for ( IEntry entryChild : entry.getChildren(  ) )
            {
                entryChild = EntryHome.findByPrimaryKey( entryChild.getIdEntry(  ), plugin );
                entryChild.setParent( entryCopy );
                entryChild.setForm( entryCopy.getForm(  ) );
                copy( entryChild, plugin );
            }
        }
    }

    /**
     * Update of the entry which is specified in parameter
     *
     * @param entry The instance of the Entry which contains the informations to update
     * @param plugin the Plugin
     *
     */
    public static void update( IEntry entry, Plugin plugin )
    {
        _dao.store( entry, plugin );
    }

    /**
     * Remove the entry whose identifier is specified in parameter
     *
     * @param nIdEntry The entry Id
     * @param plugin the Plugin
     */
    public static void remove( int nIdEntry, Plugin plugin )
    {
        IEntry entry = findByPrimaryKey( nIdEntry, plugin );

        if ( entry != null )
        {
            for ( Field field : entry.getFields(  ) )
            {
                FieldHome.remove( field.getIdField(  ), plugin );
            }

            for ( IEntry entryChild : entry.getChildren(  ) )
            {
                remove( entryChild.getIdEntry(  ), plugin );
            }

            _dao.delete( nIdEntry, plugin );
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a Entry whose identifier is specified in parameter
     *
     * @param nKey The entry primary key
     * @param plugin the Plugin
     * @return an instance of Entry
     */
    public static IEntry findByPrimaryKey( int nKey, Plugin plugin )
    {
        IEntry entry = _dao.load( nKey, plugin );

        if ( entry != null )
        {
            EntryFilter filter = new EntryFilter(  );
            filter.setIdEntryParent( entry.getIdEntry(  ) );
            entry.setChildren( getEntryList( filter, plugin ) );
            entry.setFields( FieldHome.getFieldListByIdEntry( nKey, plugin ) );
        }

        return entry;
    }

    /**
         * Load the data of all the entry who verify the filter and returns them in a  list
         * @param filter the filter
         * @param plugin the plugin
         * @return  the list of entry
         */
    public static List<IEntry> getEntryList( EntryFilter filter, Plugin plugin )
    {
        return _dao.selectEntryListByFilter( filter, plugin );
    }

    /**
         * Return  the number of entry who verify the filter
         * @param filter the filter
         * @param plugin the plugin
         * @return   the number of entry who verify the filter
         */
    public static int getNumberEntryByFilter( EntryFilter filter, Plugin plugin )
    {
        return _dao.selectNumberEntryByFilter( filter, plugin );
    }
}
