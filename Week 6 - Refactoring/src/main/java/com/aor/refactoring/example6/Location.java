package com.aor.refactoring.example6;

public class Location {
    public String locationLatitude;
    public String locationLongitude;
    public String locationName;

    public Location(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    public String toStringLocation() {
        return " in location " + this.locationLatitude + "," + this.locationLongitude + " (" + this.locationName + ")";
    }
}
