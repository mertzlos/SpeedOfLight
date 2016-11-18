package com.mertzlos.speedoflight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MoreActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView sunEarth;
    private TextView venusInfo;
    private TextView earthInfo;
    private TextView marsInfo;
    private TextView jupiterInfo;
    private TextView edgeSolarInfo;
    private TextView siriusInfo;
    private TextView andromedaInfo;

    private DecimalFormat decimalFormat;

    private static final double VENUS = 108200000.0;
    private static final double EARTH = 149600000.0;
    private static final double MARS = 227900000.0;
    private static final double JUPITER = 778600000.0;
    private static final double SOLAR_EDGE = 17049600000.0;
    private static final double SIRIUS = 81000000000000.0;
    private static final double ANDROMEDA = 24001873981552325000.0;

    private int step = 1;
    private int min = 1;
    private int max = 1000;
    private String metricSys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        sunEarth = (TextView) findViewById(R.id.diameter_text);
        venusInfo = (TextView) findViewById(R.id.venus_info);
        earthInfo = (TextView) findViewById(R.id.earth_info);
        marsInfo = (TextView) findViewById(R.id.mars_info);
        jupiterInfo = (TextView) findViewById(R.id.jupiter_info);
        edgeSolarInfo = (TextView) findViewById(R.id.solar_info);
        siriusInfo = (TextView) findViewById(R.id.sirius_info);
        andromedaInfo = (TextView) findViewById(R.id.andromeda_info);


        Intent intent = getIntent();
        if(null != intent) {
            metricSys = intent.getStringExtra(MainActivity.MORE_ACTIVITY);
        }
        Log.v("metricSys", metricSys);



        sunEarth.setText("" + seekBar.getProgress());


        seekBar.setMax((max - min) / step);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                double value = min + (progress * step);
                sunEarth.setText(value + " meters");
                planetsInfo(value);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


    }

    public void planetsInfo(double getInfo) {
        double scale = getInfo / 1;
        double earth = EARTH / scale;
        double venus = VENUS / earth;
        double mars = MARS / earth;
        double jupiter = JUPITER / earth;
        double solarEdge = SOLAR_EDGE / earth;
        double sirius = SIRIUS / earth;
        double andromeda = ANDROMEDA / earth;




        venusInfo.setText(convertMetric(venus));
        earthInfo.setText(convertMetric(scale));
        marsInfo.setText(convertMetric(mars));
        jupiterInfo.setText(convertMetric(jupiter));
        edgeSolarInfo.setText(convertMetric(solarEdge));
        siriusInfo.setText(convertMetric(sirius));
        andromedaInfo.setText(convertMetric(andromeda));

    }

    public String convertMetric(double planetInfo) {
        decimalFormat = new DecimalFormat("#,###,###.#");

        if(metricSys.equals("Miles")){
           planetInfo = planetInfo *0.621371192;
            Log.v("miles","tru");
        }

        double result;
        String metric;
        String output;

        if (planetInfo >= 1000) {
            result = planetInfo / 1000;
            metric = " km";
        } else {
            result = planetInfo;
            metric = " m";
        }

        return output = decimalFormat.format(result) + metric;
    }


}





