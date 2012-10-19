/**
 * $Id: CaptureUserTable.java,v 1.00 2011/12/14 01:02:03 mahotz Exp $
 */

package com.untangle.node.capture;

import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TimerTask;
import java.io.Serializable;
import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class CaptureUserTable implements Serializable
{
    private final Logger logger = Logger.getLogger(getClass());
    private Hashtable<String,CaptureUserEntry> userTable;

    public CaptureUserTable()
    {
        userTable = new Hashtable<String,CaptureUserEntry>();
    }

///// ------------------------------------------------------------------------
///// getter and setter functions for loading and saving the table

    public ArrayList<CaptureUserEntry> getUserList()
    {
        ArrayList<CaptureUserEntry> userList = new ArrayList<CaptureUserEntry>(userTable.values());
        return(userList);
    }

    public void setUserList(ArrayList<CaptureUserEntry> loadList)
    {
        Hashtable<String,CaptureUserEntry>loadTable = new Hashtable<String,CaptureUserEntry>();

        for (CaptureUserEntry entry : loadList)
        {
            loadTable.put(entry.getUserAddress(),entry);
        }

        userTable = loadTable;
    }

///// ------------------------------------------------------------------------
///// other public functions for authentication, logout, and such

    public CaptureUserEntry insertActiveUser(String address,String username)
    {
        CaptureUserEntry local = new CaptureUserEntry(address,username);
        userTable.put(address,local);
        return(local);
    }

    public boolean removeActiveUser(String address)
    {
        CaptureUserEntry user = userTable.get(address);
        if (user == null) return(false);
        userTable.remove(address);
        return(true);
    }

    public CaptureUserEntry searchByAddress(String address)
    {
        return(userTable.get(address));
    }

    public CaptureUserEntry searchByUsername(String username)
    {
        Enumeration ee = userTable.elements();

        while (ee.hasMoreElements())
        {
            CaptureUserEntry item = (CaptureUserEntry)ee.nextElement();
            if (username.equals(item.getUserName()) == true) return(item);
        }

        return(null);
    }

    public ArrayList<String> buildStaleList(long idleTimeout,long userTimeout)
    {
        ArrayList<String> wipeList = new ArrayList<String>();
        long currentTime,idleTrigger,userTrigger;
        int wipecount;
        int wipeflag;

        currentTime = (System.currentTimeMillis() / 1000);
        Enumeration ee = userTable.elements();
        wipecount = 0;

            while (ee.hasMoreElements())
            {
            CaptureUserEntry item = (CaptureUserEntry)ee.nextElement();
            userTrigger = ((item.getSessionCreation() / 1000) + userTimeout);
            idleTrigger = ((item.getSessionActivity() / 1000) + idleTimeout);
            wipeflag = 0;

                // look for users with no traffic within the configured non-zero idle timeout
                if ( (idleTimeout > 0) && (currentTime > idleTrigger) )
                {
                    logger.info("Idle timeout removing user " + item.getUserAddress() + " " + item.getUserName());
                    wipeList.add(item.getUserAddress());
                    wipecount++;
                    wipeflag = 1;
                }

                // look for users who have exceeded the configured maximum session time
                if (currentTime > userTrigger)
                {
                    logger.info("Session timeout removing user " + item.getUserAddress() + " " + item.getUserName());
                    wipeList.add(item.getUserAddress());
                    wipecount++;
                    wipeflag = 2;
                }

                if (wipeflag == 0)
                {
                    logger.debug("Keeping active user " + item.getUserAddress() + " " + item.getUserName());
                }
            }

        return(wipeList);
    }
}
