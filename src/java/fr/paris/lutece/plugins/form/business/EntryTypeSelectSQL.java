/*
 * Copyright (c) 2002-2013, Mairie de Paris
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

import fr.paris.lutece.plugins.form.utils.FormUtils;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.util.html.Paginator;
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * class EntryTypeSelectSQL
 *
 */
public class EntryTypeSelectSQL extends Entry
{
    private final String _template_create = "admin/plugins/form/create_entry_type_select_sql.html";
    private final String _template_modify = "admin/plugins/form/modify_entry_type_select_sql.html";
    private final String _template_html_code = "admin/plugins/form/html_code_entry_type_select_sql.html";

    /**
     * Get the HtmlCode  of   the entry
     * @return the HtmlCode  of   the entry
     *
     * */
    @Override
    public String getHtmlCode(  )
    {
        this.setFields( getSqlQueryFields(  ) );

        return _template_html_code;
    }

    /**
     * Get the request data
     * @param request HttpRequest
     * @param locale the locale
     * @return null if all data requiered are in the request else the url of jsp error
     */
    @Override
    public String getRequestData( HttpServletRequest request, Locale locale )
    {
        String strTitle = request.getParameter( PARAMETER_TITLE );
        String strHelpMessage = ( request.getParameter( PARAMETER_HELP_MESSAGE ) != null )
            ? request.getParameter( PARAMETER_HELP_MESSAGE ).trim(  ) : null;
        String strComment = request.getParameter( PARAMETER_COMMENT );
        String strMandatory = request.getParameter( PARAMETER_MANDATORY );

        String strFieldError = EMPTY_STRING;

        if ( ( strTitle == null ) || strTitle.trim(  ).equals( EMPTY_STRING ) )
        {
            strFieldError = FIELD_TITLE;
        }

        if ( !strFieldError.equals( EMPTY_STRING ) )
        {
            Object[] tabRequiredFields = { I18nService.getLocalizedString( strFieldError, locale ) };

            return AdminMessageService.getMessageUrl( request, MESSAGE_MANDATORY_FIELD, tabRequiredFields,
                AdminMessage.TYPE_STOP );
        }

        // for don't update fields listFields=null
        this.setFields( null );
        this.setTitle( strTitle );
        this.setHelpMessage( strHelpMessage );
        this.setComment( strComment );

        if ( strMandatory != null )
        {
            this.setMandatory( true );
        }
        else
        {
            this.setMandatory( false );
        }

        return null;
    }

    /**
     * Get template create url of the entry
     * @return template create url of the entry
     */
    @Override
    public String getTemplateCreate(  )
    {
        return _template_create;
    }

    /**
     * Get the template modify url  of the entry
     * @return template modify url  of the entry
     */
    @Override
    public String getTemplateModify(  )
    {
        return _template_modify;
    }

    /**
     * The paginator who is use in the template modify of the entry
     * @param nItemPerPage Number of items to display per page
     * @param strBaseUrl The base Url for build links on each page link
     * @param strPageIndexParameterName The parameter name for the page index
     * @param strPageIndex The current page index
     * @return the paginator who is use in the template modify of the entry
     */
    @Override
    public Paginator getPaginator( int nItemPerPage, String strBaseUrl, String strPageIndexParameterName,
        String strPageIndex )
    {
        return new Paginator( this.getFields(  ), nItemPerPage, strBaseUrl, strPageIndexParameterName, strPageIndex );
    }

    /**
     * save in the list of response the response associate to the entry in the form submit
     * @param request HttpRequest
     * @param listResponse the list of response associate to the entry in the form submit
     * @param locale the locale
     * @return a Form error object if there is an error in the response
     */
    @Override
    public FormError getResponseData( HttpServletRequest request, List<Response> listResponse, Locale locale )
    {
        String strIdField = request.getParameter( FormUtils.EMPTY_STRING + this.getIdEntry(  ) );
        int nIdField = -1;
        Field field = null;
        Response response = new Response(  );
        response.setEntry( this );

        if ( strIdField != null )
        {
            try
            {
                nIdField = Integer.parseInt( strIdField );
            }
            catch ( NumberFormatException ne )
            {
                AppLogService.error( ne );
            }
        }

        if ( nIdField != -1 )
        {
            field = FormUtils.findFieldByIdInTheList( nIdField, getSqlQueryFields(  ) );
        }

        if ( this.isMandatory(  ) )
        {
            if ( ( field == null ) || field.getValue(  ).equals( FormUtils.EMPTY_STRING ) )
            {
                FormError formError = new FormError(  );
                formError.setMandatoryError( true );
                formError.setTitleQuestion( this.getTitle(  ) );

                return formError;
            }
        }

        if ( field != null )
        {
            response.setValueResponse( field.getValue(  ).getBytes(  ) );
            response.setField( field );
        }

        listResponse.add( response );

        return null;
    }

    /**
     * Get the response value  associate to the entry  to export in the file export
     * @param response the response associate to the entry
     * @param locale the locale
     * @param request the request
     * @return  the response value  associate to the entry  to export in the file export
     */
    @Override
    public String getResponseValueForExport( HttpServletRequest request, Response response, Locale locale )
    {
        return new String( response.getValueResponse(  ) );
    }

    /**
     * Get the response value  associate to the entry  to write in the recap
     * @param response the response associate to the entry
     * @param locale the locale
     * @param request the request
     * @return the response value  associate to the entry  to write in the recap
     */
    @Override
    public String getResponseValueForRecap( HttpServletRequest request, Response response, Locale locale )
    {
        return new String( response.getField(  ).getTitle(  ) );
    }

    /**
     * {@inheritDoc}
     * @return
     */

    /*    @Override
        public List<Field> getFields()
        {
            return null;
        }
    */

    /**
     * Return fields from a SQL query
     * @return A list of fields
     */
    private List<Field> getSqlQueryFields(  )
    {
        List<Field> list = new ArrayList<Field>(  );
        String strSQL = this.getComment(  );
        DAOUtil daoUtil = new DAOUtil( strSQL );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Field field = new Field(  );
            field.setIdField( daoUtil.getInt( 1 ) );
            field.setTitle( daoUtil.getString( 2 ) );
            field.setValue( field.getTitle(  ) );
            list.add( field );
        }

        daoUtil.free(  );

        return list;
    }
}
