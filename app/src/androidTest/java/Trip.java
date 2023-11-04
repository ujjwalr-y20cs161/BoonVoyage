import com.google.android.gms.maps.model.LatLng;

public class Trip {

    double startLat;
    double startLong;
    double endLat;
    double endLong;

    public Trip(double sLat,double sLong, double eLat, double eLong){
        this.startLat = sLat;
        this.startLong = sLong;
        this.endLat = eLat;
        this.endLong = eLong;
    }

}
