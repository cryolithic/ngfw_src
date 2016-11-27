{
    "uniqueId": "network-StzlzfZAp8",
    "category": "Network",
    "description": "The approximate averaged data transfer rate (total, sent, received) over time.",
    "displayOrder": 103,
    "enabled": true,
    "javaClass": "com.untangle.node.reports.ReportEntry",
    "orderDesc": false,
    "units": "KB/s",
    "readOnly": true,
    "table": "session_minutes",
    "timeDataColumns": [
        "round(coalesce(sum(s2p_bytes + p2s_bytes), 0) / (1024*60*10),1) as total",
        "round(coalesce(sum(p2s_bytes), 0) / (1024*60*10),1) as sent",
        "round(coalesce(sum(s2p_bytes), 0) / (1024*60*10),1) as received"
    ],
    "colors": [
        "#396c2b",
        "#0099ff",
        "#6600ff"
    ],
    "timeDataInterval": "MINUTE",
    "timeStyle": "AREA",
    "title": "Bandwidth Usage",
    "type": "TIME_GRAPH"
}
