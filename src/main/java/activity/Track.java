package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final int LATITUDE_INDEX = 1;
    private static final int LONGITUDE_INDEX = 3;
    private static final int ELEVATION_INDEX = 2;
    private final List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint point) {
        trackPoints.add(point);
    }

    public Coordinate findMaximumCoordinate() {
        if (trackPoints.size() < 2) {
            return new Coordinate(0, 0);
        }

        return new Coordinate(getMaxLatitude(), getMaxLongitude());
    }

    public Coordinate findMinimumCoordinate() {
        if (trackPoints.size() < 2) {
            return new Coordinate(0, 0);
        }
        return new Coordinate(getMinLatitude(), getMinLongitude());

    }

    public double getDistance() {
        if (trackPoints.size() < 2) {
            return 0;
        }
        double distance = 0;
        TrackPoint prevPoint = trackPoints.get(0);
        for (int i = 1; i < trackPoints.size(); i++) {
            distance += prevPoint.getDistanceFrom(trackPoints.get(i));
            prevPoint = trackPoints.get(i);
        }
        return distance;
    }

    public void loadFromGpx(InputStream stream) {
        try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                if (isTrackPoint(line)) {
                    trackPoints.add(new TrackPoint(getCoordniatesFromStr(line), getElevationFromStr(inputStream.readLine())));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }


    private Coordinate getCoordniatesFromStr(String str) {
        String[] splittedStr = str.split("\"");
        return new Coordinate(Double.parseDouble(splittedStr[LATITUDE_INDEX]), Double.parseDouble(splittedStr[LONGITUDE_INDEX]));
    }


    private double getElevationFromStr(String str) {
        String[] splittedStr = str.split("[<>]");
        return Double.parseDouble(splittedStr[ELEVATION_INDEX]);
    }


    private boolean isTrackPoint(String str) {
        return str.trim().startsWith("<trkpt");
    }

    public double getFullDecrease() {
        if (trackPoints.size() < 2) {
            return 0;
        }

        double fullDecrease = 0;
        double prevValue = trackPoints.get(0).getElevation();
        for (int i = 1; i < trackPoints.size(); i++) {
            if (prevValue - trackPoints.get(i).getElevation() > 0) {
                fullDecrease += prevValue - trackPoints.get(i).getElevation();
            }
            prevValue = trackPoints.get(i).getElevation();
        }
        return fullDecrease;
    }

    public double getFullElevation() {
        if (trackPoints.size() < 2) {
            return 0;
        }

        double fullDecrease = 0;
        double prevValue = trackPoints.get(0).getElevation();
        for (int i = 1; i < trackPoints.size(); i++) {
            if (prevValue - trackPoints.get(i).getElevation() < 0) {
                fullDecrease += trackPoints.get(i).getElevation() - prevValue;
            }
            prevValue = trackPoints.get(i).getElevation();
        }
        return fullDecrease;
    }

    public double getRectangleArea() {
        Coordinate minCoordinate = findMinimumCoordinate();
        Coordinate maxCoordinate = findMaximumCoordinate();
        return (maxCoordinate.getLatitude() - minCoordinate.getLatitude()) * (maxCoordinate.getLongitude() - minCoordinate.getLongitude());
    }

    private double getMinLongitude() {
        if (trackPoints.size() < 2) {
            return 0;
        }
        TrackPoint minLongitudePoint = trackPoints.get(0);
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLongitude() < minLongitudePoint.getCoordinate().getLongitude()) {
                minLongitudePoint = item;
            }
        }
        return minLongitudePoint.getCoordinate().getLongitude();
    }

    private double getMaxLongitude() {
        if (trackPoints.size() < 2) {
            return 0;
        }
        TrackPoint maxLongitudePoint = trackPoints.get(0);
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLongitude() > maxLongitudePoint.getCoordinate().getLongitude()) {
                maxLongitudePoint = item;
            }
        }
        return maxLongitudePoint.getCoordinate().getLongitude();
    }

    private double getMinLatitude() {
        if (trackPoints.size() < 2) {
            return 0;
        }
        TrackPoint minLatitudePoint = trackPoints.get(0);
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() < minLatitudePoint.getCoordinate().getLatitude()) {
                minLatitudePoint = item;
            }
        }
        return minLatitudePoint.getCoordinate().getLatitude();
    }

    private double getMaxLatitude() {
        if (trackPoints.size() < 2) {
            return 0;
        }
        TrackPoint maxLatitudePoint = trackPoints.get(0);
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() > maxLatitudePoint.getCoordinate().getLatitude()) {
                maxLatitudePoint = item;
            }
        }
        return maxLatitudePoint.getCoordinate().getLatitude();
    }

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }
}
