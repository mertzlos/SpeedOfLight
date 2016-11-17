package com.mertzlos.speedoflight;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Hashtable;

/**
 * Created by amert_000 on 13/9/2016.
 */
public class SolarSystem extends PrintData{
    protected Hashtable<String,Double> solar = new Hashtable<>();



    public SolarSystem(String vehicle){
        this.vehicle = vehicle;
        solar.put("Moon",300000.0);//km
        solar.put("Mars",78340000.0);//km
        solar.put("Jupiter",628730000.0);//km
        solar.put("Neptune",4351400000.0);//km
        solar.put("Sun",149600000.0);//km
        solar.put("Solar Edge",16900000000.0);//km
        solar.put("Saturn",1275000000.0);
        solar.put("Mercury",91691000.0);
        solar.put("Venus",41400000.0);
        solar.put("Uranus",2723950000.0);


        print(vehicle,solar);
    }


    @Override
    public void print(String vehicle,Hashtable solar){
        super.print(vehicle,solar);
    }
}
