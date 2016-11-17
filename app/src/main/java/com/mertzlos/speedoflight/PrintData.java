package com.mertzlos.speedoflight;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by amert_000 on 14/9/2016.
 */
public class PrintData {


    private DecimalFormat decimalFormat = new DecimalFormat("#,###,###.##");
    private DecimalFormat decimalFormatTime;


    protected String vehicle;
    protected StringBuilder sb = new StringBuilder();
    Enumeration names;
    private String elementName;
    private String distUnit;
    private static String metric;


    public PrintData() {

    }


    public static void setStringMetric(String metricSys) {
        metric = metricSys;
    }


    public StringBuilder getSb() {
        return sb;
    }


    public void print(String vehicle, Hashtable hashtable) {


        sb.append("Traveling with: " + vehicle + "\n\n");
        names = hashtable.keys();
        double objSpeed = new TravelObj().travelWith.get(vehicle);
        if (metric.equals("Miles")) {
            objSpeed = objSpeed * 0.621371192;
        }

        while (names.hasMoreElements()) {
            elementName = (String) names.nextElement();
            double dest = (double) hashtable.get(elementName);
            if (metric.equals("Miles")) {
                dest = dest * 0.621371192;
            }
            double time = dest / objSpeed;
            if (time > (24 * 365)) {
                time = time / 8760;
                distUnit = " years";
                 decimalFormatTime = new DecimalFormat("#,###,###.#");
            } else if (time > 24) {
                time = time / 24;
                distUnit = " days";
                decimalFormatTime = new DecimalFormat("#,###,###.#");
            } else if ((time < 1) && (time > 0.01)) {
                time = time * 60;
                distUnit = " minutes";
                decimalFormatTime = new DecimalFormat("#,###,###.#");
            } else if (time < 0.01) {
                time = time * 60 * 60;
                distUnit = " seconds";
               decimalFormatTime = new DecimalFormat("#,###,###.###");
            } else {
                distUnit = " hours";
                decimalFormatTime = new DecimalFormat("#,###,###.#");
            }
            String distDisplay = decimalFormat.format(dest);
            String timeDisplay = decimalFormatTime.format(time);
            sb.append(elementName + ": " + distDisplay + " " + metric + " \n");
            sb.append("Time need: " + timeDisplay + distUnit + "\n\n");
            sb.append("");


        }

    }
}
