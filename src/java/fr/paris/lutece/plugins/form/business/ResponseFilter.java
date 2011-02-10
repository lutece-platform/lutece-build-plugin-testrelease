/*
 * Copyright (c) 2002-2009, Mairie de Paris
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

import java.sql.Timestamp;


/**
 *
 * class ResponseFilter
 *
 */
public class ResponseFilter
{
    public static final int ALL_INT = -1;
    private int _nIdForm = ALL_INT;
    private int _nIdField = ALL_INT;
    private int _nIdEntry = ALL_INT;
    private Timestamp _tDateFirst;
    private Timestamp _tDateLast;
    private boolean _bGroupbyDay;
    private boolean _bGroupbyWeek;
    private boolean _bGroupbyMonth;

    /**
     *
     * @return  the id of form insert in the filter
     */
    public int getIdForm(  )
    {
        return _nIdForm;
    }

    /**
     * set  the id of form  in the filter
     * @param idForm the id of form to insert in the filter
     */
    public void setIdForm( int idForm )
    {
        _nIdForm = idForm;
    }

    /**
     *
     * @return true if the filter contain an id of form
     */
    public boolean containsIdForm(  )
    {
        return ( _nIdForm != ALL_INT );
    }

    /**
     *
     * @return  the id of field insert in the filter
     */
    public int getIdField(  )
    {
        return _nIdField;
    }

    /**
     * set the id of field depend  in the filter
     * @param idField the id of field depend to insert in the filter
     */
    public void setIdField( int idField )
    {
        _nIdField = idField;
    }

    /**
     *
     * @return true if the filter contain an id of field depend
     */
    public boolean containsIdField(  )
    {
        return ( _nIdField != ALL_INT );
    }

    /**
    *
    * @return  the id of entry insert in the filter
    */
    public int getIdEntry(  )
    {
        return _nIdEntry;
    }

    /**
     * set the id of entry depend  in the filter
     * @param idEntry the id of entry depend to insert in the filter
     */
    public void setIdEntry( int idEntry )
    {
        _nIdEntry = idEntry;
    }

    /**
     *
     * @return true if the filter contain an id of entry depend
     */
    public boolean containsIdEntry(  )
    {
        return ( _nIdEntry != ALL_INT );
    }

    /**
         *
         * @return date of the first submit
         */
    public Timestamp getDateFirst(  )
    {
        return _tDateFirst;
    }

    /**
     * set the date of the first submit
     * @param begin date of the first submit
     */
    public void setDateFirst( Timestamp begin )
    {
        _tDateFirst = begin;
    }

    /**
    *
    * @return true if the filter contain the date of the first submit
    */
    public boolean containsDateFirst(  )
    {
        return ( _tDateFirst != null );
    }

    /**
     *
     * @return date of the last submit
     */
    public Timestamp getDateLast(  )
    {
        return _tDateLast;
    }

    /**
     * set the date of the last submit
     * @param end  the date of the last submit
     */
    public void setDateLast( Timestamp end )
    {
        _tDateLast = end;
    }

    /**
    *
    * @return true if the filter contain the date of the last submit
    */
    public boolean containsDateLast(  )
    {
        return ( _tDateLast != null );
    }

    /**
     *
     * @return true if the response must be group by day
     */
    public boolean isGroupbyDay(  )
    {
        return _bGroupbyDay;
    }

    /**
     * set true if the response must be group by day
     * @param groupbyDay true if the response must be group by day
     */
    public void setGroupbyDay( boolean groupbyDay )
    {
        _bGroupbyDay = groupbyDay;
    }

    /**
     * true if the response must be group by month
     * @return true if the response must be group by month
     */
    public boolean isGroupbyMonth(  )
    {
        return _bGroupbyMonth;
    }

    /**
     * set true if the response must be group by month
     * @param groupbyMonth true if the response must be group by month
     */
    public void setGroupbyMonth( boolean groupbyMonth )
    {
        _bGroupbyMonth = groupbyMonth;
    }

    /**
     * true if the response must be group by week
     * @return true if the response must be group by week
     */
    public boolean isGroupbyWeek(  )
    {
        return _bGroupbyWeek;
    }

    /**
     * set true if the response must be group by week
     * @param groupbyWeek true if the response must be group by week
     */
    public void setGroupbyWeek( boolean groupbyWeek )
    {
        _bGroupbyWeek = groupbyWeek;
    }
}
