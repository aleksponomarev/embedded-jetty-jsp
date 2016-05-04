//
//  ========================================================================
//  Copyright (c) 1995-2013 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package com.acme;

import monocle.macros.GenLens;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class Counter implements java.io.Serializable
{

    private final Log LOG = LogFactory.getLog(getClass());
    
    int counter=0;
    String last;

    public int getCount()
    {
	counter++;
    LOG.info("counter increase to - " + counter);
	return counter;
    }

    public void setLast(String uri) {
        last=uri;
    }

    public String getLast() {
        return last;
    }
}

