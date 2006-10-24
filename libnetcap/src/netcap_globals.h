/*
 * Copyright (c) 2003-2006 Untangle Networks, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Metavize Inc. ("Confidential Information").  You shall
 * not disclose such Confidential Information.
 *
 * $Id$
 */
#ifndef __NETCAP_GLOBALS_
#define __NETCAP_GLOBALS_

#define NETCAP_SYNACK_MARK 0x20

/**
 * maximum queue packet size
 */
#define QUEUE_BUFSIZE 65535
#define UDP_MAX_MESG_SIZE   65536
#define QUEUE_MAX_MESG_SIZE 65536

/**
 * size of the subscription table
 */
#define SUBSCRIPTION_TABLE_SIZE 1025

/**
 * max control massge size
 * WARNING: fragile
 */
#define MAX_CONTROL_MSG 200

/**
 * max length of an iptables command
 */
#define MAX_CMD_LEN 500

/**
 * max iptables commands per redirect
 */
#define MAX_CMD_IPTABLES_PER_RDR 8


/**
 * max fd in the epoll server
 */
#define EPOLL_MAX_EVENT 4096

/**
 * Maximum number of messages inside of a mailbox for UDP/ICMP
 */
#define MAX_MB_SIZE    16

/**
 * XXX should be in kernel config 
 * if not, make good guesses
 */

#ifndef IP_NONLOCAL
#define IP_NONLOCAL 18
#endif
#ifndef IP_SADDR
#define IP_SADDR	20
#endif
#ifndef IP_DEVICE
#define IP_DEVICE	21
#endif
#ifndef IP_RECVNFMARK
#define IP_RECVNFMARK	22
#endif
#ifndef IP_SENDNFMARK
struct ip_sendnfmark_opts {
    u_int32_t on;
    u_int32_t mark;
};
#define IP_SENDNFMARK	23
#endif
#ifndef IP_FIRSTNFMARK
#define IP_FIRSTNFMARK	24
#endif

/* Bits for the Netfilter marks */
#define MARK_ANTISUB   0x01000000
#define MARK_NOTRACK   0x02000000

/* This mark is used to indicate that a packet came in on one of the internal interfaces.
 * this is used by the https server to determined.
 * XXXXXX This information shouldn't be here, it is not related to netcap it is only here to
 * avoid confusion.  netcap should reserve 8 bits for its own marks and then allow for helper
 * applications to use unreserved bits. */
#define MARK_INSIDE    0x04000000
#define MARK_DHCP_SERVER_ANTISUBSCRIBE 0x08000000

/* This mark is used to release a TCP/UDP/ICMP session that was queued */
#define MARK_LIBERATE  0x10000000

/* Indicates a packet destined for the local host */
#define MARK_LOCAL     0x00000100

#define MARK_LOCAL_OFFSET     4
#define MARK_LOCAL_MASK    0xF0

#ifndef SOL_UDP /* missing from early kernels */
#define SOL_UDP 17
#endif
#ifndef UDP_RECVDPORT
#define UDP_RECVDPORT 2
#endif
#ifndef UDP_RECVDHDR
#define UDP_RECVDHDR 2
#endif
#ifndef UDP_SPORT
#define UDP_SPORT 1 
#endif


#endif
