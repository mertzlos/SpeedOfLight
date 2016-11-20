package com.mertzlos.speedoflight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final String MORE_ACTIVITY = "metric";

    private Button car;
    private Button plane;
    private Button rocket;
    private Button light;
    private Button solar;
    private Button earth;
    private Button stars;
    private Button more;

    protected TextView speedText;
    protected TextView outputText;

    private String vehicleName = "null";
    private String name = "null";
    private String metric = "";
    private String setMetricPh;

    private AdView mAdView;





    private DecimalFormat mDecimalFormat = new DecimalFormat("#,###,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Intent intent = getIntent();
        if(null != intent){

            metric = intent.getStringExtra(StartUpActivity.MESSAGE_FOR);
            PrintData.setStringMetric(metric);
        }
        switch (metric){
            case "Km":
            setMetricPh = "Kph";
                break;
            case "Miles":
            setMetricPh = "Mph";
                break;
        }



        car = (Button) findViewById(R.id.car);
        car.setOnClickListener(this);
        plane = (Button) findViewById(R.id.plane);
        plane.setOnClickListener(this);
        rocket = (Button) findViewById(R.id.rocket);
        rocket.setOnClickListener(this);
        light = (Button) findViewById(R.id.light);
        light.setOnClickListener(this);

        solar = (Button) findViewById(R.id.solar);
        solar.setOnClickListener(this);
        earth = (Button) findViewById(R.id.earth);
        earth.setOnClickListener(this);
        stars = (Button) findViewById(R.id.stars);
        stars.setOnClickListener(this);
        more = (Button) findViewById(R.id.more);
        more.setOnClickListener(this);

        speedText = (TextView) findViewById(R.id.speedText);
        outputText = (TextView) findViewById(R.id.data);


        outputText.setText("Please Select a vehicle and Then a Category");


    }

    public void speedText(String vehicle) {


        Double val = new TravelObj().travelWith.get(vehicle);
        if(metric.equals("Miles")){
           val = val * 0.621371192;
        }
        vehicleName = vehicle;
        String s = mDecimalFormat.format(val);

        speedText.setText(vehicleName+": "+ s + " "+setMetricPh);
        Log.v("metric","is: "+setMetricPh);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.car:
                speedText("Car");
                backgroundStateTopRow(0);
                break;
            case R.id.plane:
                speedText("Plane");
                backgroundStateTopRow(1);
                break;
            case R.id.rocket:
                speedText("Rocket");
                backgroundStateTopRow(2);
                break;
            case R.id.light:
                speedText("Light");
                backgroundStateTopRow(3);
                break;
            case R.id.solar:
                name = "solar";
                backgroundStateBottomRow(0);
                break;
            case R.id.earth:
                name = "Earth";
                backgroundStateBottomRow(1);
                break;
            case R.id.stars:
                name = "stars";
                backgroundStateBottomRow(2);
                break;
            case R.id.more:
                name = "more";
                Intent intent = new Intent(getApplicationContext(), MoreActivity.class);
                intent.putExtra(MORE_ACTIVITY,metric);
                startActivity(intent);

                break;
            default:
                break;
        }
        printOut(vehicleName, name);
    }

    public void backgroundStateTopRow(int state) {
        int[] background = new int[4];
        for (int i = 0; i < background.length; i++) {
            if (i == state) {
                background[i] = R.drawable.background_radial_pressed;
            } else {
                background[i] = R.drawable.background_radial;
            }
        }
        car.setBackgroundResource(background[0]);
        plane.setBackgroundResource(background[1]);
        rocket.setBackgroundResource(background[2]);
        light.setBackgroundResource(background[3]);
    }

    public void backgroundStateBottomRow(int state) {
        int[] background = new int[4];
        for (int i = 0; i < background.length; i++) {
            if (i == state) {
                background[i] = R.drawable.background_radial_pressed;
            } else {
                background[i] = R.drawable.background_radial;
            }
        }
        solar.setBackgroundResource(background[0]);
        earth.setBackgroundResource(background[1]);
        stars.setBackgroundResource(background[2]);
        more.setBackgroundResource(background[3]);
    }

    public void printOut(String vehicleName, String name) {
           // fix the problem when coming back from more activity vehicle buttons won't work.
        if (name == "null") {
            outputText.setText("Please select category");
        } else if (vehicleName == "null") {
            outputText.setText("Please select a vehicle");
        } else {
            switch (name) {
                case "solar":
                    outputText.setText(new SolarSystem(vehicleName).getSb());
                    break;
                case "Earth":
                    outputText.setText(new Earth(vehicleName).getSb());
                    break;
                case "stars":
                    outputText.setText(new Stars(vehicleName).getSb());
                default:
                    break;
            }
        }
    }
}
