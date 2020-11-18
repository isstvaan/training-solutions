package inheritanceconstructor.classroom;

public class BonusRoom extends ClassRoom {
    public BonusRoom(String location, int capacity, Facility facility) {
        super(location, capacity, facility);
        //default konstruktor nélkül nem lehet default konstruktoros osztályt származtatni
    }
}
