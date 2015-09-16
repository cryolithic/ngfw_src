{
    "uniqueId": "ipsec-DsSGEa7xqL",
    "category": "IPsec VPN",
    "description": "The amount of traffic for each IPsec tunnel.",
    "displayOrder": 90,
    "enabled": true,
    "javaClass": "com.untangle.node.reports.ReportEntry",
    "orderByColumn": "value",
    "orderDesc": false,
    "units": "bytes",
    "pieGroupColumn": "tunnel_name",
    "pieSumColumn": "sum(in_bytes::int + out_bytes::int)",
    "readOnly": true,
    "table": "ipsec_tunnel_stats",
    "title": "Top Tunnel Traffic",
    "type": "PIE_GRAPH"
}

