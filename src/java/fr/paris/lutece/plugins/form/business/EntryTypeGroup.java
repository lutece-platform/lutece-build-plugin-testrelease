/*
 * Copyright (c) 2002-2012, Mairie de Paris
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

import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * class EntryTypeGroup
 *
 */
public class EntryTypeGroup extends Entry
{
    //	templates
    private final String _template_modify = "admin/plugins/form/modify_entry_type_group.html";
    private final String _template_html_code = "admin/plugins/form/html_code_entry_type_group.html";

    /**
     * Get the HtmlCode  of   the entry
     * @return the HtmlCode  of   the entry
     *
     * */
    public String getHtmlCode(  )
    {
        return _template_html_code;
    }

    /**
     * Get the request data
     * @param request HttpRequest
     *@param locale the locale
     * @return null if all data requiered are in the request else the url of jsp error
     */
    public String getRequestData( HttpServletRequest request, Locale locale )
    {
        String strTitle = request.getParameter( PARAMETER_TITLE );
        String strFieldError = EMPTY_STRING;

        if ( ( strTitle == null ) || strTitle.trim(  ).equals( EMPTY_STRING ) )
        {
            strFieldError = FIELD_INSERT_GROUP;
        }

        if ( !strFieldError.equals( EMPTY_STRING ) )
        {
            Object[] tabRequiredFields = { I18nService.getLocalizedString( strFieldError, locale ) };

            return AdminMessageService.getMessageUrl( request, MESSAGE_MANDATORY_FIELD, tabRequiredFields,
                AdminMessage.TYPE_STOP );
        }

        this.setTitle( strTitle );

        return null;
    }

    /**
     * Get the template modify url  of the entry
     * @return template modify url  of the entry
     */
    public String getTemplateModify(  )
    {
        return _template_modify;
    }
}
