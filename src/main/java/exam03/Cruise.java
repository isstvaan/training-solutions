package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cruise {
    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers = new ArrayList<>();


    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() + 1 > boat.getMaxPassengers()) {
            throw new IllegalArgumentException("No more space.");
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().getPriceMultiplier();
    }

    public Passenger findPassengerByName(String passengerName) {
        for (Passenger item : passengers) {
            if (item.getName().equals(passengerName)) {
                return item;
            }
        }
        throw new IllegalStateException("Passanger not found");
    }

    public List<String> getPassengerNamesOrdered() {
        return getPassengers()
                .stream()
                .map(Passenger::getName)
                .sorted(Collator.getInstance(new Locale("hu", "HU")))
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers.stream().mapToDouble(this::getPriceForPassenger).sum();
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> passengersByClass = new HashMap<>();
        for (Passenger item : passengers) {
            if (!passengersByClass.containsKey(item.getCruiseClass())) {
                passengersByClass.put(item.getCruiseClass(), 0);
            }
            passengersByClass.put(item.getCruiseClass(), passengersByClass.get(item.getCruiseClass()) + 1);
        }

        return passengersByClass;
    }
}
