package com.mertzlos.speedoflight;

import java.util.Hashtable;

/**
 * Created by amert_000 on 15/9/2016.
 */
public class Stars extends PrintData {
    private Hashtable<String,Double> stars = new Hashtable<>();

    public Stars(String vehicle){
        this.vehicle = vehicle;
        stars.put("Proxima Centauri",39900000000000.0);//km
        stars.put("Orion Nebula",12715222164448690.0);//km
        stars.put("Vega",236991305966845.0);//km
        stars.put("Sirius",81000000000000.0);
        stars.put("Milky Way across",1000000000000000000.0);//km
        stars.put("Andromeda Galaxy",24001873981552325000.0);//km

        print(vehicle,stars);
    }

    public void print(String vehicle,Hashtable galaxy){
        super.print(vehicle,galaxy);

    }

}
