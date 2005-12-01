/*
 * Copyright (c) 2004, 2005 Metavize Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Metavize Inc. ("Confidential Information").  You shall
 * not disclose such Confidential Information.
 *
 * $Id$
 */

package com.metavize.tran.openvpn.gui;

import com.metavize.mvvm.security.*;
import com.metavize.gui.widgets.wizard.*;
import com.metavize.gui.widgets.editTable.*;
import com.metavize.gui.util.Util;
import javax.swing.SwingUtilities;

import java.awt.Color;

import java.util.*;

import com.metavize.tran.openvpn.*;
import com.metavize.mvvm.tran.*;

public class ServerRoutingWizardGroupsJPanel extends MWizardPageJPanel {

    private static final String EXCEPTION_MINIMUM_COUNT = "You must create at least one group.";

    private VpnTransform vpnTransform;
	
    public ServerRoutingWizardGroupsJPanel(VpnTransform vpnTransform) {
	this.vpnTransform = vpnTransform;
	initComponents();
	((MEditTableJPanel)configAddressGroupsJPanel).setShowDetailJPanelEnabled(false);
	((MEditTableJPanel)configAddressGroupsJPanel).setInstantRemove(true);
	((MEditTableJPanel)configAddressGroupsJPanel).setFillJButtonEnabled(false);
    }
    
    Vector<Vector> filteredDataVector;
    List<VpnGroup> elemList;
    Exception exception;
    
    public void doSave(Object settings, boolean validateOnly) throws Exception {

	SwingUtilities.invokeAndWait( new Runnable(){ public void run() {
	    ((MEditTableJPanel)configAddressGroupsJPanel).getJTable().getCellEditor().stopCellEditing();
	    ((MEditTableJPanel)configAddressGroupsJPanel).getJTable().clearSelection();
	    filteredDataVector = ((MEditTableJPanel)configAddressGroupsJPanel).getTableModel().getFilteredDataVector();
	    
	    exception = null;

	    if( filteredDataVector.size() < 1 ){
		exception = new Exception(EXCEPTION_MINIMUM_COUNT);
		return;
	    }

	    elemList = new ArrayList<VpnGroup>(filteredDataVector.size());
	    VpnGroup newElem = null;
	    int rowIndex = 0;
	
	    for( Vector rowVector : filteredDataVector ){
		rowIndex++;
		newElem = new VpnGroup();
		newElem.setLive( (Boolean) rowVector.elementAt(2) );
		newElem.setName( (String) rowVector.elementAt(3) );
		try{ newElem.setAddress( IPaddr.parse((String) rowVector.elementAt(4)) ); }
		catch(Exception e){ exception = new Exception("Invalid \"IP address\" in row: " + rowIndex); return; }
		try{ newElem.setNetmask( IPaddr.parse((String) rowVector.elementAt(5)) ); }
		catch(Exception e){ exception = new Exception("Invalid \"netmask\" in row: " + rowIndex); return; }
		newElem.setDescription( (String) rowVector.elementAt(6) );
		elemList.add(newElem);
	    }	
		
	}});

        if( exception != null)
            throw exception;
	        
        if( !validateOnly ){
	    GroupList groupList = new GroupList(elemList);
	    vpnTransform.setAddressGroups(groupList);
        }
    }
    
    
        private void initComponents() {//GEN-BEGIN:initComponents
                jLabel2 = new javax.swing.JLabel();
                configAddressGroupsJPanel = new ConfigAddressGroupsJPanel();
                jLabel3 = new javax.swing.JLabel();

                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                setOpaque(false);
                jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
                jLabel2.setText("<html><b>Please add at least one Address Pool.</b><br>Connecting VPN clients and sites will be assigned IP addresses from these pools, and each pool can have a policy applied to it.</html>");
                add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 410, -1));

                add(configAddressGroupsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 465, 210));

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metavize/tran/openvpn/gui/ProductShot.png")));
                jLabel3.setEnabled(false);
                add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 230, -1, -1));

        }//GEN-END:initComponents
    
    
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel configAddressGroupsJPanel;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        // End of variables declaration//GEN-END:variables
    
}
