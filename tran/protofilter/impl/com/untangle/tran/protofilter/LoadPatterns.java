
/*
 * Copyright (c) 2003-2006 Untangle, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Untangle, Inc. ("Confidential Information"). You shall
 * not disclose such Confidential Information.
 *
 */
package com.untangle.tran.protofilter;

import java.util.TreeMap;

/**
 * <b>WARNING WARNING WARNING WARNING WARNING WARNING</b>
 *
 * This class is autogenerated, do not edit
 *
 * <b>WARNING WARNING WARNING WARNING WARNING WARNING</b>
 */
public class LoadPatterns {

    private LoadPatterns() {}

    public static TreeMap getPatterns()
    {
        // Now that we have Policies,  we create a new map every time since we don't want sharing.
        return createPatterns();
    }

    private static TreeMap createPatterns()
    {
        TreeMap pats = new TreeMap();

	pats.put(160, new ProtoFilterPattern(160, "100bao", "Peer to Peer", " a Chinese P2P protocol/program - http://www.100bao.com", "^\\x01\\x01\\x05\\x0a", "ok veryfast", false,false,false));
	pats.put(170, new ProtoFilterPattern(170, "AIM", "Instant Messenger", " AOL instant messenger (OSCAR and TOC)", "^(\\*[\\x01\\x02].*\\x03\\x0b|\\*\\x01.?.?.?.?\\x01)|flapon|toc_signon.*0x", "good notsofast", false,false,false));
	pats.put(180, new ProtoFilterPattern(180, "AIM web content", "Instant Messenger", " ads/news content downloaded by AOL Instant Messenger", "user-agent:aim/", "good fast", false,false,false));
	pats.put(190, new ProtoFilterPattern(190, "Apple Juice", "Peer to Peer", " P2P filesharing - http://www.applejuicenet.de", "^ajprot\\x0d\\x0a", "great veryfast", false,false,false));
	pats.put(200, new ProtoFilterPattern(200, "Ares", "Peer to Peer", " P2P filesharing - http://aresgalaxy.sf.net", "^\\x03[]Z].?.?\\x05$", "good veryfast undermatch", false,false,false));
	pats.put(210, new ProtoFilterPattern(210, "Battlefield 1942", "Video Game", " An EA game", "^\\x01\\x11\\x10\\|\\xf8\\x02\\x10\\x40\\x06", "ok veryfast", false,false,false));
	pats.put(220, new ProtoFilterPattern(220, "Battlefield 2", "Video Game", " An EA game.", "^(\\x11\\x20\\x01\\xa0\\x98\\x11|\\xfe\\xfd.?.?.?.?.?.?(\\x14\\x01\\x06|\\xff\\xff\\xff))|[]\\x01].?battlefield2", "ok notsofast", false,false,false));
	pats.put(230, new ProtoFilterPattern(230, "BGP", "Networking", " Border Gateway Protocol - RFC 1771", "^\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff..?\\x01[\\x03\\x04]", "ok veryfast", false,false,false));
	pats.put(240, new ProtoFilterPattern(240, "Bittorrent", "Peer to Peer", " P2P filesharing / publishing tool - http://www.bittorrent.com", "\\x13bittorrent protocol|d1:ad2:id20:|\\x08'7P\\)[RP]|^azver\\x01$|^get /scrape?info_hash=", "good veryfast undermatch", false,false,false));
	pats.put(250, new ProtoFilterPattern(250, "Cisco VPN", "Networking", " VPN client software to a Cisco VPN server", "^\\x01\\xf4\\x01\\xf4", "ok veryfast", false,false,false));
	pats.put(260, new ProtoFilterPattern(260, "Code Red", "Worm", " a worm that attacks Microsoft IIS web servers", "/default\\.ida\\?NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN%u9090%u6858%ucbd3%u7801%u9090%u6858%ucbd3%u7801%u9090%u6858%ucbd3%u7801%u9090%u9090%u8190%u00c3%u0003%u8b00%u531b%u53ff%u0078%u0000%u00=a", "ok fast subset", false,false,false));
	pats.put(270, new ProtoFilterPattern(270, "Counterstrike (using the new Source engine)", "Video Game", " network game", "^\\xff\\xff\\xff\\xff.*cstrikeCounter-Strike", "good veryfast", false,false,false));
	pats.put(280, new ProtoFilterPattern(280, "CVS", "Software Development", " Concurrent Versions System", "^BEGIN (AUTH|VERIFICATION|GSSAPI) REQUEST\\x0a", "good veryfast", false,false,false));
	pats.put(290, new ProtoFilterPattern(290, "Day of Defeat: Source", "Video Game", " game (Half-Life 2 mod) - http://www.valvesoftware.com", "^\\xff\\xff\\xff\\xff.*dodDay of Defeat", "good veryfast", false,false,false));
	pats.put(300, new ProtoFilterPattern(300, "DHCP", "Networking", " Dynamic Host Configuration Protocol - RFC 1541", "^[\\x01\\x02][\\x01- ]\\x06.*c\\x82sc", "good veryfast", false,false,false));
	pats.put(310, new ProtoFilterPattern(310, "Direct Connect", "Peer to Peer", " P2P filesharing - http://www.neo-modus.com", "^(\\$mynick |\\$lock |\\$key )", "good veryfast", false,false,false));
	pats.put(330, new ProtoFilterPattern(330, "DNS", "Networking", " Domain Name System - RFC 1035", "^.?.?.?.?[\\x01\\x02].?.?.?.?.?.?[\\x01-?][a-z0-9][\\x01-?a-z]*[\\x02-\\x06][a-z][a-z][fglmoprstuvz]?[aeop]?(um)?[\\x01-\\x10\\x1c][\\x01\\x03\\x04\\xFF]", "great notsofast", false,false,false));
	pats.put(320, new ProtoFilterPattern(320, "Doom 3", "Video Game", " computer game", "^\\xff\\xffchallenge", "good veryfast", false,false,false));
	pats.put(340, new ProtoFilterPattern(340, "FastTrack", "Peer to Peer", " P2P filesharing (Kazaa, Morpheus, iMesh, Grokster, etc)", "^get (/.download/[ -~]*|/.supernode[ -~]|/.status[ -~]|/.network[ -~]*|/.files|/.hash=[0-9a-f]*/[ -~]*) http/1.1|user-agent: kazaa|x-kazaa(-username|-network|-ip|-supernodeip|-xferid|-xferuid|tag)|^give [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]?[0-9]?[0-9]?", "good notsofast", false,false,false));
	pats.put(350, new ProtoFilterPattern(350, "Freenet", "Peer to Peer", " Anonymous information retrieval - http://freenetproject.org", "^\\x01[\\x08\\x09][\\x03\\x04]", "marginal veryfast", false,false,false));
	pats.put(360, new ProtoFilterPattern(360, "FTP", "File Transfer", " File Transfer Protocol - RFC 959", "^220[\\x09-\\x0d -~]*ftp", "great fast", false,false,false));
	pats.put(370, new ProtoFilterPattern(370, "Gkrellm", "System Administration", " a system monitor - http://gkrellm.net", "^gkrellm [23].[0-9].[0-9]\\x0a$", "great veryfast", false,false,false));
	pats.put(380, new ProtoFilterPattern(380, "GnucleusLAN", "Peer to Peer", " LAN-only P2P filesharing", "gnuclear connect/[\\x09-\\x0d -~]*user-agent: gnucleus [\\x09-\\x0d -~]*lan:", "good fast", false,false,false));
	pats.put(390, new ProtoFilterPattern(390, "Gnutella", "Peer to Peer", " P2P filesharing", "^(gnd[\\x01\\x02]?.?.?\\x01|gnutella connect/[012]\\.[0-9]\\x0d\\x0a|get /uri-res/n2r\\?urn:sha1:|get /.*user-agent: (gtk-gnutella|bearshare|mactella|gnucleus|gnotella|limewire|imesh)|get /.*content-type: application/x-gnutella-packets|giv [0-9]*:[0-9a-f]*/|queue [0-9a-f]* [1-9][0-9]?[0-9]?\\.[1-9][0-9]?[0-9]?\\.[1-9][0-9]?[0-9]?\\.[1-9][0-9]?[0-9]?:[1-9][0-9]?[0-9]?[0-9]?|gnutella.*content-type: application/x-gnutella|...................?lime)", "good fast", false,false,false));
	pats.put(400, new ProtoFilterPattern(400, "GoBoogy", "Peer to Peer", " a Korean P2P protocol", "<peerplat>|^get /getfilebyhash\\.cgi\\?|^get /queue_register\\.cgi\\?|^get /getupdowninfo\\.cgi\\?", "marginal notsofast", false,false,false));
	pats.put(410, new ProtoFilterPattern(410, "Gopher", "Networking", " A precursor to HTTP - RFC 1436", "^[\\x09-\\x0d]*[1-9,+tgi][\\x09-\\x0d -~]*\\x09[\\x09-\\x0d -~]*\\x09[a-z0-9.]*\\.[a-z][a-z].?.?\\x09[1-9]", "good notsofast undermatch", false,false,false));
	pats.put(420, new ProtoFilterPattern(420, "H.323", "Voice over IP", " Voice over IP.", "^\\x03..?\\x08...?.?.?.?.?.?.?.?.?.?.?.?.?.?.?\\x05", "ok veryfast", false,false,false));
	pats.put(430, new ProtoFilterPattern(430, "Half-Life 2 Deathmatch", "Video Game", "Life 2 Deathmatch - popular computer game", "^\\xff\\xff\\xff\\xff.*hl2mpDeathmatch", "good veryfast", false,false,false));
	pats.put(440, new ProtoFilterPattern(440, "hddtemp", "System Administration", " Hard drive temperature reporting", "^\\|/dev/[a-z][a-z][a-z]\\|[0-9a-z]*\\|[0-9][0-9]\\|[cfk]\\|", "great veryfast", false,false,false));
	pats.put(450, new ProtoFilterPattern(450, "Hotline", "Peer to Peer", " An old P2P filesharing protocol", "^....................TRTPHOTL\\x01\\x02", "marginal veryfast", false,false,false));
	pats.put(460, new ProtoFilterPattern(460, "HTTP", "Web", " iTunes (Apple's music program)", "http/(0\\.9|1\\.0|1\\.1).*(user-agent: itunes)", "good fast subset", false,false,false));
	pats.put(120, new ProtoFilterPattern(120, "RTSP tunneled within HTTP", "Streaming Video", "RTSP tunneled within HTTP", "^(get[\\x09-\\x0d -~]* Accept: application/x-rtsp-tunnelled|http/(0\\.9|1\\.0|1\\.1) [1-5][0-9][0-9] [\\x09-\\x0d -~]*a=control:rtsp://)", "ok notsofast subset", false,false,false));
	pats.put(460, new ProtoFilterPattern(460, "HTTP", "Web", " HyperText Transfer Protocol - RFC 2616", "http/(0\\.9|1\\.0|1\\.1) [1-5][0-9][0-9] [\\x09-\\x0d -~]*(connection:|content-type:|content-length:|date:)|post [\\x09-\\x0d -~]* http/[01]\\.[019]", "great notsofast superset", false,false,false));
	pats.put(470, new ProtoFilterPattern(470, "Ident", "Networking", " Identification Protocol - RFC 1413", "^[1-9][0-9]?[0-9]?[0-9]?[0-9]?[\\x09-\\x0d]*,[\\x09-\\x0d]*[1-9][0-9]?[0-9]?[0-9]?[0-9]?(\\x0d\\x0a|[\\x0d\\x0a])?$", "good veryfast", false,false,false));
	pats.put(480, new ProtoFilterPattern(480, "IMAP", "Email", " Internet Message Access Protocol (A common e-mail protocol)", "^(\\* ok|a[0-9]+ noop)", "good veryfast", false,false,false));
	pats.put(505, new ProtoFilterPattern(505, "iMesh", "Peer to Peer", " the native protocol of iMesh, a P2P application - http://imesh.com", "^(post[\\x09-\\x0d -~]*<PasswordHash>................................</PasswordHash><ClientVer>|\\x34\\x80?\\x0d?\\xfc\\xff\\x04|get[\\x09-\\x0d -~]*Host: imsh\\.download-prod\\.musicnet\\.com|\\x02(\\x01|\\x02)\\x83.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?.?\\x02(\\x01|\\x02)\\x83)", "ok fast", false,false,false));
	pats.put(490, new ProtoFilterPattern(490, "IP printing", "Printing", " a new standard for UNIX printing - RFC 2911", "ipp://", "good fast", false,false,false));
	pats.put(500, new ProtoFilterPattern(500, "IRC", "Instant Messenger", " Internet Relay Chat - RFC 1459", "^(nick[\\x09-\\x0d -~]*user[\\x09-\\x0d -~]*:|user[\\x09-\\x0d -~]*:[\\x02-\\x0d -~]*nick[\\x09-\\x0d -~]*\\x0d\\x0a)", "good veryfast", false,false,false));
	pats.put(510, new ProtoFilterPattern(510, "Jabber (XMPP)", "Instant Messenger", " open instant messenger protocol - RFC 3920 - http://jabber.org", "<stream:stream[\\x09-\\x0d ][ -~]*[\\x09-\\x0d ]xmlns=['\"]jabber", "good fast", false,false,false));
	pats.put(520, new ProtoFilterPattern(520, "KuGoo", "Peer to Peer", " a Chinese P2P program - http://www.kugoo.com", "^\\x31..\\x8e", "ok veryfast", false,false,false));
	pats.put(530, new ProtoFilterPattern(530, "live365", "Music", " An Internet radio site - http://live365.com", "membername.*session.*player", "marginal fast", false,false,false));
	pats.put(540, new ProtoFilterPattern(540, "LPD", "Printing", " Line Printer Daemon Protocol (old-style UNIX printing) - RFC 1179", "^(\\x01[!-~]+|\\x02[!-~]+\\x0a.[\\x01\\x02\\x03][\\x01-\\x0a -~]*|[\\x03\\x04][!-~]+[\\x09-\\x0d]+[a-z][\\x09-\\x0d -~]*|\\x05[!-~]+[\\x09-\\x0d]+([a-z][!-~]*[\\x09-\\x0d]+[1-9][0-9]?[0-9]?|root[\\x09-\\x0d]+[!-~]+).*)\\x0a$", "ok veryfast", false,false,false));
	pats.put(545, new ProtoFilterPattern(545, "Medal of Honor Allied Assault", "Video Game", " an Electronic Arts game", "^\\xff\\xff\\xff\\xffgetstatus\\x0a", "good veryfast", false,false,false));
	pats.put(550, new ProtoFilterPattern(550, "MSN (Microsoft Network) Messenger file transfers (MSNFTP and MSNSLP)", "Instant Messenger", "MSN (Microsoft Network) Messenger file transfers (MSNFTP and MSNSLP)", "^(ver [ -~]*msnftp\\x0d\\x0aver msnftp\\x0d\\x0ausr|method msnmsgr:)", "good veryfast", false,false,false));
	pats.put(560, new ProtoFilterPattern(560, "MSN Messenger", "Instant Messenger", " Microsoft Network chat client", "ver [0-9]+ msnp[1-9][0-9]? [\\x09-\\x0d -~]*cvr0\\x0d\\x0a$|usr 1 [!-~]+ [0-9. ]+\\x0d\\x0a$|ans 1 [!-~]+ [0-9. ]+\\x0d\\x0a$", "good notsofast", false,false,false));
	pats.put(570, new ProtoFilterPattern(570, "MUTE", "Peer to Peer", " P2P filesharing - http://mute-net.sourceforge.net", "^(Public|AES)Key: [0-9a-f]*\\x0aEnd(Public|AES)Key\\x0a$", "marginal veryfast", false,false,false));
	pats.put(590, new ProtoFilterPattern(590, "Napster", "Peer to Peer", " P2P filesharing", "^(.[\\x02\\x06][!-~]+ [!-~]+ [0-9][0-9]?[0-9]?[0-9]?[0-9]? \"[\\x09-\\x0d -~]+\" ([0-9]|10)|1(send|get)[!-~]+ \"[\\x09-\\x0d -~]+\")", "good veryfast", false,false,false));
	pats.put(580, new ProtoFilterPattern(580, "NBNS", "Networking", " NetBIOS name service", "\\x01\\x10\\x01|\\)\\x10\\x01\\x01|0\\x10\\x01", "good notsofast", false,false,false));
	pats.put(620, new ProtoFilterPattern(620, "NCP", "Networking", " Novell Core Protocol", "^(dmdt.*\\x01.*(\"\"|\\x11\\x11|uu)|tncp.*33)", "good veryfast", false,false,false));
	pats.put(610, new ProtoFilterPattern(610, "NetBIOS", "Networking", " Network Basic Input Output System", "\\x81.?.?.[A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P][A-P]", "marginal fast", false,false,false));
	pats.put(630, new ProtoFilterPattern(630, "Nimda", "Worm", " a worm that attacks Microsoft IIS web servers, and MORE!", "GET (/scripts/root\\.exe\\?/c\\+dir|/MSADC/root\\.exe\\?/c\\+dir|/c/winnt/system32/cmd\\.exe\\?/c\\+dir|/d/winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.%5c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/_vti_bin/\\.\\.%5c\\.\\./\\.\\.%5c\\.\\./\\.\\.%5c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/_mem_bin/\\.\\.%5c\\.\\./\\.\\.%5c\\.\\./\\.\\.%5c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/msadc/\\.\\.%5c\\.\\./\\.\\.%5c\\.\\./\\.\\.%5c/\\.\\.\\xc1\\x1c\\.\\./\\.\\.\\xc1\\x1c\\.\\./\\.\\.\\xc1\\x1c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.\\xc1\\x1c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.\\xc0/\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.\\xc0\\xaf\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.\\xc1\\x9c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.%35c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.%35c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.%5c\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir|/scripts/\\.\\.%2f\\.\\./winnt/system32/cmd\\.exe\\?/c\\+dir)", "ok fast subset", false,false,false));
	pats.put(640, new ProtoFilterPattern(640, "NNTP", "Internet News", " Network News Transfer Protocol - RFCs 977 and 2980", "^(20[01][\\x09-\\x0d -~]*AUTHINFO USER|20[01][\\x09-\\x0d -~]*news)", "good veryfast", false,false,false));
	pats.put(650, new ProtoFilterPattern(650, "(S)NTP", "Networking", " (Simple) Network Time Protocol - RFCs 1305 and 2030", "^([\\x13\\x1b\\x23\\xd3\\xdb\\xe3]|[\\x14\\x1c$].......?.?.?.?.?.?.?.?.?[\\xc6-\\xff])", "good veryfast overmatch ", false,false,false));
	pats.put(660, new ProtoFilterPattern(660, "OpenFT", "Peer to Peer", " P2P filesharing (implemented in giFT library)", "x-openftalias: [-)(0-9a-z ~.]", "good fast", false,false,false));
	pats.put(670, new ProtoFilterPattern(670, "POCO and PP365", "Peer to Peer", " Chinese P2P filesharing - http://pp365.com http://poco.cn", "^\\x80\\x94\\x0a\\x01....\\x1f\\x9e", "ok veryfast", false,false,false));
	pats.put(680, new ProtoFilterPattern(680, "POP3", "Email", " Post Office Protocol version 3 (popular e-mail protocol) - RFC 1939", "^(\\+ok |-err )", "good veryfast", false,false,false));
	pats.put(690, new ProtoFilterPattern(690, "pressplay", "Music", " A legal music distribution site - http://pressplay.com", "user-agent: nsplayer", "ok fast", false,false,false));
	pats.put(700, new ProtoFilterPattern(700, "Half Life 1 engine games (HL 1, Quake 2/3/World, Counterstrike 1.6, etc.)", "Video Game", "Half Life 1 engine games (HL 1, Quake 2/3/World, Counterstrike 1.6, etc.)", "^\\xff\\xff\\xff\\xffget(info|challenge)", "good veryfast", false,false,false));
	pats.put(710, new ProtoFilterPattern(710, "Quake 1", "Video Game", " A popular computer game.", "^\\x80\\x0c\\x01quake\\x03", "marginal veryfast", false,false,false));
	pats.put(130, new ProtoFilterPattern(130, "Quicktime HTTP", "Streaming Video", "Quicktime HTTP", "user-agent: quicktime \\(qtver=[0-9].[0-9].[0-9];os=[\\x09-\\x0d -~]+\\)\\x0d\\x0a", "good fast subset", false,false,false));
	pats.put(720, new ProtoFilterPattern(720, "RDP", "Remote Deskop", " Remote Desktop Protocol (used in Windows Terminal Services)", "rdpdr.*cliprdr.*rdpsnd", "ok fast", false,false,false));
	pats.put(730, new ProtoFilterPattern(730, "rlogin", "System Administration", " remote login - RFC 1282", "^[a-z][a-z0-9][a-z0-9]+/[1-9][0-9]?[0-9]?[0-9]?00", "ok veryfast", false,false,false));
	pats.put(740, new ProtoFilterPattern(740, "RTSP", "Streaming Video", " Real Time Streaming Protocol - http://www.rtsp.org - RFC 2326", "rtsp/1.0 200 ok", "good fast", false,false,false));
	pats.put(750, new ProtoFilterPattern(750, "Shoutcast and Icecast", "Music", " streaming audio", "icy [1-5][0-9][0-9] [\\x09-\\x0d -~]*(content-type:audio|icy-)", "good fast", false,false,false));
	pats.put(770, new ProtoFilterPattern(770, "SIP", "Voice over IP", " Session Initiation Protocol - Internet telephony - RFC 3261", "^(invite|register|cancel) sip[\\x09-\\x0d -~]*sip/[0-2]\\.[0-9]", "ok veryfast", false,false,false));
	pats.put(760, new ProtoFilterPattern(760, "Samba/SMB", "Networking", " Server Message Block - Microsoft Windows filesharing", "\\xffsmb[\\x72\\x25]", "good fast", false,false,false));
	pats.put(780, new ProtoFilterPattern(780, "SMTP", "Email", " Simple Mail Transfer Protocol - RFC 2821 (See also RFC 1869)", "^220[\\x09-\\x0d -~]* (e?smtp|simple mail)", "great fast", false,false,false));
	pats.put(790, new ProtoFilterPattern(790, "SNMP", "Networking", " Simple Network Management Protocol - RFC 1157", "^\\x02\\x01\\x04.+([\\xa0-\\xa3]\\x02[\\x01-\\x04].?.?.?.?\\x02\\x01.?\\x02\\x01.?\\x30|\\xa4\\x06.+\\x40\\x04.?.?.?.?\\x02\\x01.?\\x02\\x01.?\\x43)", "good veryfast superset", false,false,false));
	pats.put(820, new ProtoFilterPattern(820, "SOCKS Version 5", "Networking", " Firewall traversal protocol - RFC 1928", "\\x05[\\x01-\\x08]*\\x05[\\x01-\\x08]?.*\\x05[\\x01-\\x03][\\x01\\x03].*\\x05[\\x01-\\x08]?[\\x01\\x03]", "ok fast", false,false,false));
	pats.put(800, new ProtoFilterPattern(800, "Soribada", "Peer to Peer", " A Korean P2P filesharing program/protocol - http://www.soribada.com", "^GETMP3\\x0d\\x0aFilename|^\\x01.?.?.?(\\x51\\x3a\\+|\\x51\\x32\\x3a)|^\\x10[\\x14-\\x16]\\x10[\\x15-\\x17].?.?.?.?$", "good notsofast", false,false,false));
	pats.put(810, new ProtoFilterPattern(810, "Soulseek", "Peer to Peer", " P2P filesharing - http://slsknet.org", "^(\\x05..?|.\\x01.[ -~]+\\x01F..?.?.?.?.?.?.?)$", "good veryfast", false,false,false));
	pats.put(830, new ProtoFilterPattern(830, "SSDP", "Networking", " Simple Service Discovery Protocol - easy discovery of network devices", "^notify[\\x09-\\x0d ]\\*[\\x09-\\x0d ]http/1\\.1[\\x09-\\x0d -~]*ssdp:(alive|byebye)|^m-search[\\x09-\\x0d ]\\*[\\x09-\\x0d ]http/1\\.1[\\x09-\\x0d -~]*ssdp:discover", "good notsofast", false,false,false));
	pats.put(840, new ProtoFilterPattern(840, "SSH", "System Administration", " Secure SHell", "^ssh-[12]\\.[0-9]", "great veryfast", false,false,false));
	pats.put(845, new ProtoFilterPattern(845, "STUN", "Networking", " Simple Traversal of UDP Through NAT - RFC 3489", "^[\\x01\\x02]................?$", "ok veryfast", false,false,false));
	pats.put(850, new ProtoFilterPattern(850, "Subspace", "Video Game", " 2D asteroids-style space game - http://sscentral.com", "^\\x01....\\x11\\x10........\\x01$", "marginal veryfast", false,false,false));
	pats.put(855, new ProtoFilterPattern(855, "Subversion", "Software Development", " a version control system", "^\\( success \\( 1 2 \\(", "ok veryfast", false,false,false));
	pats.put(860, new ProtoFilterPattern(860, "TeamSpeak", "Voice over IP", " VoIP application - http://goteamspeak.com", "^\\xf4\\xbe\\x03.*teamspeak", "good veryfast", false,false,false));
	pats.put(870, new ProtoFilterPattern(870, "Telnet", "System Administration", " Insecure remote login - RFC 854", "^\\xff[\\xfb-\\xfe].\\xff[\\xfb-\\xfe].\\xff[\\xfb-\\xfe]", "good veryfast", false,false,false));
	pats.put(890, new ProtoFilterPattern(890, "Tesla Advanced Communication", "Peer to Peer", " P2P filesharing (?)", "\\x03\\x9a\\x89\\x22\\x31\\x31\\x31\\.\\x30\\x30\\x20\\x42\\x65\\x74\\x61\\x20|\\xe2\\x3c\\x69\\x1e\\x1c\\xe9", "marginal notsofast", false,false,false));
	pats.put(900, new ProtoFilterPattern(900, "TFTP", "File Transfer", " Trivial File Transfer Protocol - used for bootstrapping - RFC 1350", "^(\\x01|\\x02)[ -~]*(netascii|octet|mail)", "marginal veryfast", false,false,false));
	pats.put(910, new ProtoFilterPattern(910, "The Circle", "Peer to Peer", " P2P application - http://thecircle.org.au", "^t\\x03ni.?[\\x01-\\x06]?t[\\x01-\\x05]s[\\x0a\\x0b](glob|who are you$|query data)", "ok veryfast", false,false,false));
	pats.put(150, new ProtoFilterPattern(150, "SSL and TLS", "Networking", " Secure Socket Layer / Transport Layer Security - RFC 2246", "^(.?.?\\x16\\x03.*\\x16\\x03|.?.?\\x01\\x03\\x01?.*\\x0b)", "good fast superset", false,false,false));
	pats.put(920, new ProtoFilterPattern(920, "Tor", "Networking", " The Onion Router - used for anonymization - http://tor.eff.org", "TOR1.*<identity>", "good fast", false,false,false));
	pats.put(140, new ProtoFilterPattern(140, "Valid certificate SSL", "Networking", "Valid certificate SSL", "^.?.?\\x01\\x03\\x01?.*\\x0b.*(thawte|equifax secure certificate authority|rsa data security, inc|verisign, inc|gte cybertrust root|entrust\\.net limited)", "good notsofast subset", false,false,false));
	pats.put(930, new ProtoFilterPattern(930, "Ventrilo", "Voice over IP", " VoIP - http://ventrilo.com", "^..?v\\$\\xcf", "good veryfast", false,false,false));
	pats.put(940, new ProtoFilterPattern(940, "VNC", "Remote Desktop", " Virtual Network Computing. Also known as RFB - Remote Frame Buffer", "^rfb 00[1-9]\\.00[0-9]\\x0a$", "good fast", false,false,false));
	pats.put(950, new ProtoFilterPattern(950, "World of Warcraft", "Video Game", " popular network game - http://blizzard.com/", "^\\x06\\xec\\x01", "ok veryfast", false,false,false));
	pats.put(960, new ProtoFilterPattern(960, "X Windows Version 11", "Remote Desktop", " Networked GUI system used in most Unices", "^[lb].?\\x0b", "good veryfast", false,false,false));
	pats.put(970, new ProtoFilterPattern(970, "XBox Live", "Video Game", " Console gaming", "^\\x58\\x80........\\xf3|^\\x06\\x58\\x4e", "marginal notsofast", false,false,false));
	pats.put(980, new ProtoFilterPattern(980, "Xunlei", "Peer to Peer", " Chinese P2P filesharing - http://xunlei.com", "^[()]...?.?.?(reg|get|query)", "good veryfast", false,false,false));
	pats.put(990, new ProtoFilterPattern(990, "Yahoo messenger", "Instant Messenger", " an instant messenger protocol - http://yahoo.com", "^(ymsg|ypns|yhoo).?.?.?.?.?.?.?[lwt].*\\xc0\\x80", "good veryfast", false,false,false));
	pats.put(1000, new ProtoFilterPattern(1000, "ZMAAP", "Networking", " Zeroconf Multicast Address Allocation Protocol", "^\\x1b\\xd7\\x3b\\x48[\\x01\\x02]\\x01?\\x01", "ok veryfast", false,false,false));
/*
 * Copyright (c) 2003-2006 Untangle, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Untangle, Inc. ("Confidential Information"). You shall
 * not disclose such Confidential Information.
 *
 * $Id$
 */

	return pats;
    }
}
