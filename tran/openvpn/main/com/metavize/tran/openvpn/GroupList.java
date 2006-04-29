/*
 * Copyright (c) 2005 Metavize Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Metavize Inc. ("Confidential Information").  You shall
 * not disclose such Confidential Information.
 *
 * $Id$
 */
package com.metavize.tran.openvpn;

import java.io.Serializable;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

import com.metavize.mvvm.tran.AddressValidator;
import com.metavize.mvvm.tran.AddressRange;
import com.metavize.mvvm.tran.Validatable;
import com.metavize.mvvm.tran.ValidateException;

public class GroupList implements Serializable, Validatable
{
    // XXX SERIALVER private static final long serialVersionUID = 1032713361795879615L;
    
    List<VpnGroup> groupList;

    public GroupList()
    {
        this( new LinkedList<VpnGroup>());
    }

    public GroupList( List<VpnGroup> groupList )
    {
        this.groupList = groupList;
    }

    public List<VpnGroup> getGroupList()
    {
        return this.groupList;
    }
    
    public void setGroupList( List<VpnGroup> groupList )
    {
        this.groupList = groupList;
    }

    List<AddressRange> buildAddressRange()
    {
        List<AddressRange> checkList = new LinkedList<AddressRange>();

        for ( VpnGroup group : this.groupList ) {
            checkList.add( AddressRange.makeNetwork( group.getAddress().getAddr(), 
                                                     group.getNetmask().getAddr()));
        }
        
        return checkList;
    }
   
    /** 
     * Validate the object, throw an exception if it is not valid */
    public void validate() throws ValidateException
    {
        Set<String> nameSet = new HashSet<String>();
        
        /* XXXXXXXX What else belongs in here */
        for ( VpnGroup group : this.groupList ) {
            String name = group.getInternalName();
            if ( !nameSet.add( name )) {
                throw new ValidateException( "Group names must be unique: '" + name + "'" );
            }
            group.validate();
        }

        /* Determine if all of the addresses are unique */
        AddressValidator.getInstance().validate( buildAddressRange());
    }
}
