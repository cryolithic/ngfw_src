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

package com.metavize.gui.login;

import com.metavize.gui.transform.Savable;
import java.util.Arrays;
import com.metavize.mvvm.tran.IPaddr;
import com.metavize.gui.util.Util;
import com.metavize.mvvm.NetworkingManager;
import com.metavize.mvvm.NetworkingConfiguration;
import com.metavize.gui.configuration.ConnectivityJDialog;

import java.awt.Dialog;

public class InitialSetupConnectivityJPanel extends javax.swing.JPanel implements Savable {
    



    public InitialSetupConnectivityJPanel() {
        initComponents();
    }

    public void doSave(Object settings, boolean validateOnly) throws Exception {}
    

    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        connectivityTestJButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setOpaque(false);
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel10.setText("<html><b>Connectivity Test</b> tells you if EdgeGuard can contact DNS<br>and the internet with the settings you have just saved.<br><br>Click the button below to run the Connectivity Test.<br>You do not need to run this test to continue with the wizard.</html>");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        connectivityTestJButton.setFont(new java.awt.Font("Dialog", 0, 12));
        connectivityTestJButton.setText("Run Connectivity Test");
        connectivityTestJButton.setFocusPainted(false);
        connectivityTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectivityTestJButtonActionPerformed(evt);
            }
        });

        add(connectivityTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel11.setText("<html>If the connectivity test does not pass,<br>\nyou should try different network settings.<br>\nYou may go back to the \"Network Settings\"<br>\npage by pressing \"Previous page\".</html>");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

    }//GEN-END:initComponents

    private void connectivityTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectivityTestJButtonActionPerformed
        try{
	    ConnectivityJDialog connectivityJDialog = new ConnectivityJDialog((Dialog)getTopLevelAncestor(), true);
	    connectivityJDialog.setVisible(true);
	}
	catch(Exception e){
	    try{ Util.handleExceptionWithRestart("Error showing connectivity tester", e); }
	    catch(Exception f){ Util.handleExceptionNoRestart("Error showing connectivity tester", f); }
	}
    }//GEN-LAST:event_connectivityTestJButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton connectivityTestJButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    // End of variables declaration//GEN-END:variables
    
}
