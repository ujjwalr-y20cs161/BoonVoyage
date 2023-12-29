package com.example.boonvoyage;

import com.google.android.gms.maps.model.LatLng;

public class Trip {

    public double startLat;
    public double startLong;
    public double endLat;
    public double endLong;

    public Trip(double sLat,double sLong, double eLat, double eLong){
        this.startLat = sLat;
        this.startLong = sLong;
        this.endLat = eLat;
        this.endLong = eLong;
    }

    public Trip(){

    }

}
