package com.mertzlos.speedoflight;

import java.util.Hashtable;

/**
 * Created by amert_000 on 14/9/2016.
 */
public class TravelObj {
    protected Hashtable<String,Double> travelWith = new Hashtable<>();

    public TravelObj(){

        travelWith.put("Car",120.0);//kph
        travelWith.put("Plane",900.0);//kph
        travelWith.put("Rocket",28000.0);//kph
        travelWith.put("Light",1079252848.8);//kph

    }
}
