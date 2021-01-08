package activity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        if (!isValidLatitude(latitude)) {
            throw new IllegalArgumentException("Invalid latitude. Value need between -90:90");
        }
        if (!isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid longitude. Value need between -180:180");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private boolean isValidLatitude(double value) {
        return value > -90 && value < 90;
    }

    private boolean isValidLongitude(double value) {
        return value > -180 && value < 180;
    }
}
