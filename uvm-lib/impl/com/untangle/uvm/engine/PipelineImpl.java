/*
 * $HeadURL$
 * Copyright (c) 2003-2007 Untangle, Inc.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License, version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * AS-IS and WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, TITLE, or
 * NONINFRINGEMENT.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.untangle.uvm.engine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.untangle.uvm.vnet.Fitting;
import com.untangle.uvm.vnet.ArgonConnector;
import com.untangle.uvm.vnet.Pipeline;

/**
 * Implementation of <code>Pipeline</code>.
 *
 * @author <a href="mailto:amread@untangle.com">Aaron Read</a>
 * @version 1.0
 */
class PipelineImpl implements Pipeline
{
    private static final File UVM_TMP = new File(System.getProperty("uvm.tmp.dir"));

    private final List<ArgonConnectorFitting> argonConnectorFittings;
    private final String sessionPrefix;

    // This does not need to be concurrent since there is only one thread per pipeline.
    private final Map<Long,Object> attachments = new HashMap<Long,Object>();
    private final List<File> files = new LinkedList<File>();

    private int attachId = 0;
        
    // constructors -----------------------------------------------------------

    PipelineImpl(int sessionId, List<ArgonConnectorFitting> argonConnectorFittings)
    {
        this.argonConnectorFittings = argonConnectorFittings;
        this.sessionPrefix = "sess-" + sessionId + "-";
    }

    // object registry methods ------------------------------------------------

    /**
     * Add object to registry. The object will remain in the token
     * manager as long as the key is held onto.
     *
     * @param object object to add.
     * @return the key.
     */
    public Long attach(Object o)
    {
        Long key;
        synchronized (attachments) {
            key = new Long(++attachId);
        }
        attachments.put(key, o);
        return key;
    }

    /**
     * Get object, by key..
     *
     * @param key object's key.
     * @return the object.
     */
    public Object getAttachment(Long key)
    {
        return attachments.get(key);
    }

    /**
     * Retrieve and remove an object from the pipeline.
     *
     * @param key key of the object.
     * @return the object.
     */
    public Object detach(Long key)
    {
        return attachments.remove(key);
    }

    public Fitting getClientFitting(ArgonConnector argonConnector)
    {
        for (ArgonConnectorFitting mpf : argonConnectorFittings) {
            if (mpf.argonConnector == argonConnector) {
                return mpf.fitting;
            }
        }
        throw new IllegalArgumentException("argonConnector not in pipeline: " + argonConnector);
    }

    public Fitting getServerFitting(ArgonConnector argonConnector)
    {
        for (Iterator<ArgonConnectorFitting> i = argonConnectorFittings.iterator(); i.hasNext(); ) {
            ArgonConnectorFitting mpf = i.next();
            if (mpf.argonConnector == argonConnector) {
                if (i.hasNext()) {
                    mpf = i.next();
                    return mpf.fitting;
                } else {
                    /* pipelines end as they begin */
                    return argonConnectorFittings.get(0).fitting;
                }
            }
        }
        throw new IllegalArgumentException("argonConnector not in pipeline: " + argonConnector);
    }

    public File mktemp() throws IOException
    {
        return mktemp(null);
    }

    public File mktemp(String prefix) throws IOException
    {
        String name;
        if (prefix == null) {
            name = sessionPrefix;
        } else {
            StringBuilder sb = new StringBuilder(prefix);
            sb.append("-");
            sb.append(sessionPrefix);
            name = sb.toString();
        }
        File f = File.createTempFile(name, null, UVM_TMP);
        synchronized (files) {
            files.add(f);
        }
        return f;
    }

    // package protected methods ----------------------------------------------

    protected void destroy()
    {
        for (File f : files) {
            f.delete();
        }
    }

}
