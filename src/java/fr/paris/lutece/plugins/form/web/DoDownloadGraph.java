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
package fr.paris.lutece.plugins.form.web;

import com.keypoint.PngEncoder;

import fr.paris.lutece.plugins.form.business.EntryHome;
import fr.paris.lutece.plugins.form.business.GraphType;
import fr.paris.lutece.plugins.form.business.GraphTypeHome;
import fr.paris.lutece.plugins.form.business.IEntry;
import fr.paris.lutece.plugins.form.business.ResponseHome;
import fr.paris.lutece.plugins.form.business.StatisticEntrySubmit;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.util.AppLogService;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;

import java.awt.image.BufferedImage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 *  class DoDownloadGraph
 *
 */
public class DoDownloadGraph
{
    private static final String PARAMETER_ID_ENTRY = "id_entry";
    private static final String PARAMETER_ID_GRAPH_TYPE = "id_graph_type";
    private static final String PARAMETER_GRAPH_THREE_DIMENSION = "graph_three_dimension";
    private static final String PARAMETER_GRAPH_LABEL_VALUE = "graph_label_value";
    private static final String PARAMETER_PLUGIN_NAME = "plugin_name";
    private static final String EMPTY_STRING = "";

    /**
     * Write in the http response the statistic graph of a question
     * @param request the http request
     * @param response The http response
     *
     */
    public void doGenerateGraph( HttpServletRequest request, HttpServletResponse response )
    {
        JFreeChart chart = null;
        Plugin plugin = null;
        IEntry entry;
        GraphType graphType = null;
        int nIdEntry = -1;
        int nIdGraphType = -1;

        String strIdEntry = request.getParameter( PARAMETER_ID_ENTRY );
        String strIdGraphType = request.getParameter( PARAMETER_ID_GRAPH_TYPE );
        String strPluginName = request.getParameter( PARAMETER_PLUGIN_NAME );
        String strGraphThreeDimension = request.getParameter( PARAMETER_GRAPH_THREE_DIMENSION );
        String strGraphLabelValue = request.getParameter( PARAMETER_GRAPH_LABEL_VALUE );

        boolean nGraphThreeDimension = false;
        boolean nGraphLabelValue = false;

        if ( ( strGraphThreeDimension != null ) && strGraphThreeDimension.equals( "1" ) )
        {
            nGraphThreeDimension = true;
        }

        if ( ( strGraphLabelValue != null ) && strGraphLabelValue.equals( "1" ) )
        {
            nGraphLabelValue = true;
        }

        if ( ( strIdEntry != null ) && !strIdEntry.equals( EMPTY_STRING ) && ( strIdGraphType != null ) &&
                !strIdGraphType.equals( EMPTY_STRING ) && ( strPluginName != null ) &&
                !strPluginName.equals( EMPTY_STRING ) )
        {
            plugin = PluginService.getPlugin( strPluginName );

            try
            {
                nIdEntry = Integer.parseInt( strIdEntry );
                nIdGraphType = Integer.parseInt( strIdGraphType );
            }
            catch ( NumberFormatException ne )
            {
                AppLogService.error( ne );
            }

            entry = EntryHome.findByPrimaryKey( nIdEntry, plugin );

            List<StatisticEntrySubmit> listStatistic = ResponseHome.getStatisticByIdEntry( nIdEntry, plugin );
            graphType = GraphTypeHome.findByPrimaryKey( nIdGraphType, plugin );

            if ( graphType != null )
            {
                chart = graphType.createChart( listStatistic, entry.getTitle(  ), nGraphThreeDimension, nGraphLabelValue );
            }

            try
            {
                ChartRenderingInfo info = new ChartRenderingInfo( new StandardEntityCollection(  ) );
                BufferedImage chartImage = chart.createBufferedImage( 600, 200, info );
                response.setContentType( "image/PNG" );

                PngEncoder encoder = new PngEncoder( chartImage, false, 0, 9 );
                response.getOutputStream(  ).write( encoder.pngEncode(  ) );
                response.getOutputStream(  ).close(  );
            }
            catch ( Exception e )
            {
                AppLogService.error( e );
            }
        }
    }
}
