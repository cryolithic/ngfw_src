/**
 * $Id: ColumnDesc.java,v 1.00 2012/06/11 14:58:09 dmorris Exp $
 */
package com.untangle.node.reporting.items;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ColumnDesc implements Serializable
{
    private final String name;
    private final String title;
    private final String type;
    private final boolean hidden;

    public ColumnDesc(String name, String title, String type, boolean hidden)
    {
        this.name = name;
        this.title = title;
        this.type = type;
        this.hidden = hidden;
    }
    
    public ColumnDesc(String name, String title, String type)
    {
        this.name = name;
        this.title = title;
        this.type = type;
        this.hidden = true;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }
        
    public boolean getHidden()
    {
        return hidden;
    }
}