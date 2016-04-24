package com.example.zhang.location;


import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by zhang on 24/04/16.
 */
public final class Constants {

    private Constants() {}

    public static final HashMap<String, LatLng> TESTED_AREA = new HashMap<String, LatLng>();

    static {
        TESTED_AREA.put("EV Building", new LatLng(45.495291, -73.577894));
        TESTED_AREA.put("Restaurant Shi Tang", new LatLng(45.495225, -73.579596));
        TESTED_AREA.put("Apartment", new LatLng(45.492555, -73.580343));
    }

}
