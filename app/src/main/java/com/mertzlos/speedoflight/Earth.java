package com.mertzlos.speedoflight;

import java.util.Hashtable;

/**
 * Created by amert_000 on 14/9/2016.
 */
public class Earth extends PrintData{
    private Hashtable<String,Double> Earth = new Hashtable<>();

    public Earth(String vehicle){
        this.vehicle = vehicle;
        Earth.put("London to NY",5585.0);
        Earth.put("London to Tokyo",9569.43);
        Earth.put("London to Melbourne",16917.27);
        Earth.put("London to Paris",343.93);
        Earth.put("London to Honolulu",11637.43);
        Earth.put("NY to Los Angeles",3940.16);


        print(vehicle, Earth);
    }

    public void print(String vehicle,Hashtable galaxy){
        super.print(vehicle,galaxy);
    }
}
