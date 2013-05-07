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

import fr.paris.lutece.portal.service.rbac.RBACResource;
import fr.paris.lutece.portal.service.regularexpression.RegularExpressionRemovalListenerService;
import fr.paris.lutece.portal.service.workgroup.AdminWorkgroupResource;
import fr.paris.lutece.portal.service.workgroup.WorkgroupRemovalListenerService;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;


/**
 *
 * Class form
 *
 */
public class Form implements AdminWorkgroupResource, RBACResource
{
    public static final String RESOURCE_TYPE = "FORM_FORM_TYPE";
    public static final int STATE_ENABLE = 1;
    public static final int STATE_DISABLE = 0;
    private static FormWorkgroupRemovalListener _listenerWorkgroup;
    private static FormRegularExpressionRemovalListener _listenerRegularExpression;
    private int _nIdForm;
    private String _strTitle;
    private String _strDescription;
    private String _strWelcomeMessage;
    private String _strUnavailabilityMessage;
    private String _strRequirement;
    private String _strWorkgroup;
    private int _nIdMailingList;
    private boolean _bActiveCaptcha;
    private boolean _bActiveStoreAdresse;
    private boolean _bLimitNumberResponse;
    private boolean _bActiveRequirement;
    private boolean _bSupportHTTPS;
    private String _strLibelleValidateButton;
    private String _strLibelleResetButton;
    private Date _tDateBeginDisponibility;
    private Date _tDateEndDisponibility;
    private Timestamp _tDateCreation;
    private boolean _nActive;
    private boolean _bAutoPublicationActive;
    private Recap _recap;
    private List<FormAction> _listActions;
    private int _nFormPageId;
    private String _strInfoComplementary1;
    private String _strInfoComplementary2;
    private String _strInfoComplementary3;
    private String _strInfoComplementary4;
    private String _strInfoComplementary5;

    /**
     * Initialize the Form
     */
    public static void init(  )
    {
        // Create removal listeners and register them
        if ( _listenerWorkgroup == null )
        {
            _listenerWorkgroup = new FormWorkgroupRemovalListener(  );
            WorkgroupRemovalListenerService.getService(  ).registerListener( _listenerWorkgroup );
        }

        if ( _listenerRegularExpression == null )
        {
            _listenerRegularExpression = new FormRegularExpressionRemovalListener(  );
            RegularExpressionRemovalListenerService.getService(  ).registerListener( _listenerRegularExpression );
        }
    }

    /**
     *
     * @return the id of the mailing list associate to the form
     */
    public int getIdMailingList(  )
    {
        return _nIdMailingList;
    }

    /**
     * set the id of the mailing list associate to the form
     * @param mailingListId the id of the mailing list associate to the form
     */
    public void setIdMailingList( int mailingListId )
    {
        _nIdMailingList = mailingListId;
    }

    /**
     *
     * @return true if the form contain a captcha
     */
    public boolean isActiveCaptcha(  )
    {
        return _bActiveCaptcha;
    }

    /**
     * set true if the form contain a captcha
     * @param activeCaptcha true if the form contain a captcha
     */
    public void setActiveCaptcha( boolean activeCaptcha )
    {
        _bActiveCaptcha = activeCaptcha;
    }

    /**
     * true if the  ip adresse of the user must be store
     * @return true if the  ip adresse of the user must be store
     */
    public boolean isActiveStoreAdresse(  )
    {
        return _bActiveStoreAdresse;
    }

    /**
     * set true if the  ip adresse of the user must be store
     * @param activeStoreAdrese true if the  ip adresse of the user must be store
     */
    public void setActiveStoreAdresse( boolean activeStoreAdrese )
    {
        _bActiveStoreAdresse = activeStoreAdrese;
    }

    /**
    *
    * @return true if the requirement must be activate
    */
    public boolean isActiveRequirement(  )
    {
        return _bActiveRequirement;
    }

    /**
     * set  true if the requirement must be activate
     * @param activeRequirement true if the form contain requirement
     */
    public void setActiveRequirement( boolean activeRequirement )
    {
        _bActiveRequirement = activeRequirement;
    }

    /**
     *
     * @return the libelle of the validate button
     */
    public String getLibelleValidateButton(  )
    {
        return _strLibelleValidateButton;
    }

    /**
     * set the libelle of the validate button
     * @param libelleValidateButton the libelle of the validate button
     */
    public void setLibelleValidateButton( String libelleValidateButton )
    {
        _strLibelleValidateButton = libelleValidateButton;
    }

    /**
     *
     * @return the date of end diosponibility
     */
    public Date getDateEndDisponibility(  )
    {
        return _tDateEndDisponibility;
    }

    /**
     * set the date of end disponibility
     * @param dateEndDisponibility the date of end disponibility
     */
    public void setDateEndDisponibility( Date dateEndDisponibility )
    {
        _tDateEndDisponibility = dateEndDisponibility;
    }

    /**
     *
     * @return the requirement of the form
     */
    public String getRequirement(  )
    {
        return _strRequirement;
    }

    /**
     * set the requirement of the form
     * @param requirement the requierement of the form
     */
    public void setRequirement( String requirement )
    {
        _strRequirement = requirement;
    }

    /**
     *
     * @return the title of the form
     */
    public String getTitle(  )
    {
        return _strTitle;
    }

    /**
     * set the title of the form
     * @param strTitle the title of the form
     */
    public void setTitle( String strTitle )
    {
        this._strTitle = strTitle;
    }

    /**
     *
     * @return the description of the form
     */
    public String getDescription(  )
    {
        return _strDescription;
    }

    /**
     * set the description of the form
     * @param description the description of the form
     */
    public void setDescription( String description )
    {
        this._strDescription = description;
    }

    /**
     *
     * @return the welcome message of the form
     */
    public String getWelcomeMessage(  )
    {
        return _strWelcomeMessage;
    }

    /**
     * set the welcome message of the form
     * @param strWelcomeMessage the welcome message of the form
     */
    public void setWelcomeMessage( String strWelcomeMessage )
    {
        this._strWelcomeMessage = strWelcomeMessage;
    }

    /**
     *
     * @return the unavailability message of the form
     */
    public String getUnavailabilityMessage(  )
    {
        return _strUnavailabilityMessage;
    }

    /**
     * set the unavailability message of the form
     * @param unavailabilityMessage the unavailability message of the form
     */
    public void setUnavailabilityMessage( String unavailabilityMessage )
    {
        _strUnavailabilityMessage = unavailabilityMessage;
    }

    /**
     *
     * @return the work group associate to the form
     */
    public String getWorkgroup(  )
    {
        return _strWorkgroup;
    }

    /**
     * set  the work group associate to the form
     * @param workGroup  the work group associate to the form
     */
    public void setWorkgroup( String workGroup )
    {
        _strWorkgroup = workGroup;
    }

    /**
     *
     * @return the id of the form
     */
    public int getIdForm(  )
    {
        return _nIdForm;
    }

    /**
     * set the id of the form
     * @param idForm the id of the form
     */
    public void setIdForm( int idForm )
    {
        _nIdForm = idForm;
    }

    /**
     *
     * @return true if the form is active
     */
    public boolean isActive(  )
    {
        return _nActive;
    }

    /**
     * set true if the form is active
     * @param active true if the form is active
     */
    public void setActive( boolean active )
    {
        _nActive = active;
    }

    /**
     *
     * @return true if the user can submit just one  form
     */
    public boolean isLimitNumberResponse(  )
    {
        return _bLimitNumberResponse;
    }

    /**
     * set true if the user can submit just one  form
     * @param numberResponse true if the user can submit just one  form
     */
    public void setLimitNumberResponse( boolean numberResponse )
    {
        _bLimitNumberResponse = numberResponse;
    }

    /**
     *
     * @return the creation date
     */
    public Timestamp getDateCreation(  )
    {
        return _tDateCreation;
    }

    /**
     * set the creation date
     * @param dateCreation the creation date
     */
    public void setDateCreation( Timestamp dateCreation )
    {
        _tDateCreation = dateCreation;
    }

    /**
     *
     * @return the recap associate to the form
     */
    public Recap getRecap(  )
    {
        return _recap;
    }

    /**
     * set  the recap associate to the form
     * @param recap  the recap associate to the form
     */
    public void setRecap( Recap recap )
    {
        this._recap = recap;
    }

    /**
    * RBAC resource implmentation
    * @return The resource type code
    */
    public String getResourceTypeCode(  )
    {
        return RESOURCE_TYPE;
    }

    /**
     * RBAC resource implmentation
     * @return The resourceId
     */
    public String getResourceId(  )
    {
        return "" + _nIdForm;
    }

    /**
     *
     * @return a list of action can be use for the form
     */
    public List<FormAction> getActions(  )
    {
        return _listActions;
    }

    /**
     * set a list of action can be use for the form
     * @param formActions a list of action must be use for the form
     */
    public void setActions( List<FormAction> formActions )
    {
        _listActions = formActions;
    }

    /**
     *
     * @return the id of the  page which contain the form
     */
    public int getFormPageId(  )
    {
        return _nFormPageId;
    }

    /**
     * set  the id of the  page which contain the form
     * @param formPageId  the id of the  page which contain the form
     */
    public void setFormPageId( int formPageId )
    {
        _nFormPageId = formPageId;
    }

    /**
     * Define the date begin of the publication
     * @param _tDateBeginDisponibility The date begin of the publication
     */
    public void setDateBeginDisponibility( Date _tDateBeginDisponibility )
    {
        this._tDateBeginDisponibility = _tDateBeginDisponibility;
    }

    /**
     * Return the date begin of the publication
     * @return The date begin of the publication
     */
    public Date getDateBeginDisponibility(  )
    {
        return _tDateBeginDisponibility;
    }

    /**
     * Set if Auto publication is effectively active
     * @param _bAutoPublicationActive
     */
    public void setAutoPublicationActive( boolean _bAutoPublicationActive )
    {
        this._bAutoPublicationActive = _bAutoPublicationActive;
    }

    /**
     * Return true if auto publication is effectively active
     * @return true of false
     */
    public boolean isAutoPublicationActive(  )
    {
        return _bAutoPublicationActive;
    }

    /**
     * Return true if the form is in auto publication mode, false else
     * @return true if the form is auto published
     */
    public boolean isAutoPublished(  )
    {
        return ( getDateBeginDisponibility(  ) != null ) || ( getDateEndDisponibility(  ) != null );
    }

    /**
     * The label to display for the Reset button
     * @param _strLibelleResetButton The label
     */
    public void setLibelleResetButton( String _strLibelleResetButton )
    {
        this._strLibelleResetButton = _strLibelleResetButton;
    }

    /**
     * The label to display for the Reset button
     * @return the Reset button name
     */
    public String getLibelleResetButton(  )
    {
        return _strLibelleResetButton;
    }

    /**
    *
    * @return the Information Complementary 1
    */
    public String getInfoComplementary1(  )
    {
        return _strInfoComplementary1;
    }

    /**
     * set the Information Complementary 1
     * @param strInfoComplementary1 the Information Complementary 1
     */
    public void setInfoComplementary1( String strInfoComplementary1 )
    {
        _strInfoComplementary1 = strInfoComplementary1;
    }

    /**
    *
    * @return the Information Complementary 1
    */
    public String getInfoComplementary2(  )
    {
        return _strInfoComplementary2;
    }

    /**
     * set the Information Complementary 2
     * @param strInfoComplementary2 the Information Complementary 2
     */
    public void setInfoComplementary2( String strInfoComplementary2 )
    {
        _strInfoComplementary2 = strInfoComplementary2;
    }

    /**
     *
     * @return the Information Complementary 3
     */
    public String getInfoComplementary3(  )
    {
        return _strInfoComplementary3;
    }

    /**
     * set the Information Complementary 3
     * @param strInfoComplementary3 the Information Complementary 3
     */
    public void setInfoComplementary3( String strInfoComplementary3 )
    {
        _strInfoComplementary3 = strInfoComplementary3;
    }

    /**
     *
     * @return the Information Complementary 4
     */
    public String getInfoComplementary4(  )
    {
        return _strInfoComplementary4;
    }

    /**
     * set the Information Complementary 4
     * @param strInfoComplementary4 the Information Complementary 4
     */
    public void setInfoComplementary4( String strInfoComplementary4 )
    {
        _strInfoComplementary4 = strInfoComplementary4;
    }

    /**
     *
     * @return the Information Complementary 5
     */
    public String getInfoComplementary5(  )
    {
        return _strInfoComplementary5;
    }

    /**
     * set the Information Complementary 5
     * @param strInfoComplementary5 the Information Complementary 5
     */
    public void setInfoComplementary5( String strInfoComplementary5 )
    {
        _strInfoComplementary5 = strInfoComplementary5;
    }

    /**
     * Set to <b>true</b> if the form support HTTPS, <b>false</b> otherwise 
     * @param _bSupportHTTPS the support value
     */
	public void setSupportHTTPS( boolean bSupportHTTPS )
	{
		this._bSupportHTTPS = bSupportHTTPS;
	}

	/**
	 * Returns <b>true</b> if the form support HTTPS, <b>false</b> otherwise
	 * @return <b>true</b> if the form support HTTPS, <b>false</b> otherwise
	 */
	public boolean isSupportHTTPS(  )
	{
		return _bSupportHTTPS;
	}
}
