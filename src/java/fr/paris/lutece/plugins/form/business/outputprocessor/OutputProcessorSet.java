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
package fr.paris.lutece.plugins.form.business.outputprocessor;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;


/**
 * OutputProcessorSet Object
 */
public class OutputProcessorSet implements IOutputProcessorSet
{
    private static Map<String, IOutputProcessor> _mapOutputProcessor;

    /* (non-Javadoc)
    * @see fr.paris.lutece.plugins.form.business.outputprocessor.IOutputProcessorSet#setOutputProcessorMap(java.util.Map)
    */
    public void setOutputProcessorMap( Map<String, IOutputProcessor> mapOutputProcessor )
    {
        _mapOutputProcessor = mapOutputProcessor;

        for ( Object entryMap : _mapOutputProcessor.entrySet(  ) )
        {
            ( (Entry<String, IOutputProcessor>) entryMap ).getValue(  )
              .setKey( ( (Entry<String, IOutputProcessor>) entryMap ).getKey(  ) );
        }
    }

    /* (non-Javadoc)
    * @see fr.paris.lutece.plugins.form.business.outputprocessor.IOutputProcessorSet#getOutputProcessor(java.lang.String)
    */
    public IOutputProcessor getOutputProcessor( String strKey )
    {
        IOutputProcessor outputProcessor = (IOutputProcessor) (IOutputProcessor) _mapOutputProcessor.get( strKey );

        return outputProcessor;
    }

    /*
     * (non-Javadoc)
     * @see fr.paris.lutece.plugins.form.business.outputprocessor.IOutputProcessorSet#getAllOutputProcessor()
     */
    public Collection<IOutputProcessor> getAllOutputProcessor(  )
    {
        String test;
        Collection list = _mapOutputProcessor.values(  );

        return list;
    }
}
