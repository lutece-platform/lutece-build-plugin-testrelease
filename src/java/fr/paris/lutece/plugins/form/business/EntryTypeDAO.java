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
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * class EntryTypeDAO
 *
 */
public class EntryTypeDAO implements IEntryTypeDAO
{
    private static final String SQL_QUERY_FIND_BY_PRIMARY_KEY = "SELECT id_type,title,is_group,is_comment,class_name" +
        " FROM form_entry_type WHERE id_type=?";
    private static final String SQL_QUERY_SELECT = "SELECT id_type,title,is_group,is_comment,class_name" +
        " FROM form_entry_type ";

    /**
     * Load the data of the entry type from the table
     *
     * @param idKey The identifier of the entry type
     * @param plugin the plugin
     * @return the instance of the EntryType
     */
    public EntryType load( int idKey, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_FIND_BY_PRIMARY_KEY, plugin );
        daoUtil.setInt( 1, idKey );
        daoUtil.executeQuery(  );

        EntryType entryType = null;

        if ( daoUtil.next(  ) )
        {
            entryType = new EntryType(  );
            entryType.setIdType( daoUtil.getInt( 1 ) );
            entryType.setTitle( daoUtil.getString( 2 ) );
            entryType.setGroup( daoUtil.getBoolean( 3 ) );
            entryType.setComment( daoUtil.getBoolean( 4 ) );
            entryType.setClassName( daoUtil.getString( 5 ) );
        }

        daoUtil.free(  );

        return entryType;
    }

    /**
     * Load the data of all  entry type returns them in a  list
     * @param plugin the plugin
     * @return  the list of entry type
     */
    public List<EntryType> select( Plugin plugin )
    {
        List<EntryType> listEntryType = new ArrayList<EntryType>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.executeQuery(  );

        EntryType entryType = null;

        while ( daoUtil.next(  ) )
        {
            entryType = new EntryType(  );
            entryType.setIdType( daoUtil.getInt( 1 ) );
            entryType.setTitle( daoUtil.getString( 2 ) );
            entryType.setGroup( daoUtil.getBoolean( 3 ) );
            entryType.setComment( daoUtil.getBoolean( 4 ) );
            entryType.setClassName( daoUtil.getString( 5 ) );
            listEntryType.add( entryType );
        }

        daoUtil.free(  );

        return listEntryType;
    }
}
