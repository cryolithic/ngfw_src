{
    "uniqueId": "bandwidth-control-2ZsLKieT4r",
    "category": "Bandwidth Control",
    "description": "The sum of the data transferred grouped by country.",
    "displayOrder": 901,
    "enabled": true,
    "javaClass": "com.untangle.node.reports.ReportEntry",
    "orderByColumn": "value",
    "orderDesc": true,
    "units": "MB",
    "pieGroupColumn": "server_country",
    "pieSumColumn": "round(coalesce(sum(s2p_bytes + p2s_bytes), 0) / (1024*1024),1)",
    "readOnly": true,
    "table": "sessions",
    "title": "Top Countries (by total bytes)",
    "pieStyle": "PIE",
    "type": "PIE_GRAPH"
}
