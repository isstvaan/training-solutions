package week11d02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Courier {
    TreeSet<Ride> rides = new TreeSet<>();

    public TreeSet<Ride> getRides() {
        return rides;
    }

    public void readRidesFile(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rides.add(getRideFromString(line));
            }

        } catch (IOException e) {
            throw new IllegalStateException("File not found");
        }
    }

    private Ride getRideFromString(String str) {
        String[] splittedStr = str.split(" ");
        if (splittedStr.length < 3) {
            throw new IllegalArgumentException("Wrong string format.");
        }
        return new Ride(Integer.parseInt(splittedStr[0]),
                Integer.parseInt(splittedStr[1]),
                Integer.parseInt(splittedStr[2]));
    }

    public List<Integer> getHolidays() {
        List<Integer> rideList = new ArrayList<>();
        List<Integer> days = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        for (Iterator<Ride> item = rides.iterator(); item.hasNext(); ) {
            Ride rideItem = item.next();
            if (!rideList.contains(rideItem)) {
                rideList.add(rideItem.getDay());
            }
        }
        days.removeAll(rideList);
        return days;
    }

    public int[] getDistanceOfDay() {
        int[] distances = new int[7];
        for (Iterator<Ride> item = rides.iterator(); item.hasNext(); ) {
            Ride rideItem = item.next();
            distances[rideItem.getDay() - 1] += rideItem.getDistance();
        }
        return distances;
    }

    public Ride getFirstRide() {
        return rides.first();
    }

    public Ride getLastRide() {
        return rides.last();
    }
}
