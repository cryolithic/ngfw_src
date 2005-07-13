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

package com.metavize.mvvm.reporting;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.util.Rotation;
import org.jfree.ui.Drawable;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import net.sf.jasperreports.engine.JRAbstractSvgRenderer;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

import com.metavize.mvvm.util.PortServiceNames;


public abstract class TimeSeriesGraph extends ReportGraph
{
    // Means use minutes, not hours
    public static final String PARAM_HIGH_TIME_RESOLUTION = "HighTimeResolution";

    public static final String PARAM_TIME_AXIS_LABEL = "TimeAxisLabel";
    public static final String PARAM_VALUE_AXIS_LABEL = "ValueAxisLabel";

    // Time series specific
    protected boolean highTimeResolution;
    protected String timeAxisLabel;
    protected String valueAxisLabel;

    protected TimeSeriesGraph()
    {

    }

    // Get the parameters
    protected void initParams()
    {
        super.initParams();

        // Get the parameters
        Boolean hiResBool = (Boolean) gpv(PARAM_HIGH_TIME_RESOLUTION);
        if (hiResBool == null)
            highTimeResolution = endDate.getTime() - startDate.getTime() <= DAY_INTERVAL ? true : false;
        else
            highTimeResolution = hiResBool.booleanValue();
        timeAxisLabel = (String) gpv(PARAM_TIME_AXIS_LABEL);
        if (timeAxisLabel == null) {
            if (highTimeResolution)
                timeAxisLabel = "time of day";
            else
                timeAxisLabel = "day of week";
        }
        valueAxisLabel = (String) gpv(PARAM_VALUE_AXIS_LABEL);
        if (valueAxisLabel == null)
            valueAxisLabel = "kB/sec";
    }
}
