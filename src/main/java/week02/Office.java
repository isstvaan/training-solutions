package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        String names = "Tárgyalók: ";

        for (MeetingRoom item : meetingRooms) {
            names += item.getName() + "; ";
        }
        System.out.println(names);
    }

    public void printNamesReverse() {
        String names = "Tárgyalók fordított sorrendben: ";

        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            names += meetingRooms.get(i).getName() + "; ";
        }

        System.out.println(names);
    }

    public void printEventNames() {
        String names = "Minden második tárgyaló: ";

        for (int i = 0; i < meetingRooms.size(); i++) {
            if (i % 2 != 0) {
                names += meetingRooms.get(i).getName() + "; ";
            }
        }
        System.out.println(names);
    }

    public void printAreas() {
        String areas = "Tárgyalók területei:\n";

        for (MeetingRoom item : meetingRooms) {
            areas += item.toString() + "\n";
        }

        System.out.println(areas);
    }

    public void printMeetingRoomsWithName(String name) {
        String rooms = "";
        for (MeetingRoom item : meetingRooms) {
            if (item.getName().equals(name)) {
                rooms += item.toString() + "\n";
            }
        }
        System.out.println(rooms);
    }

    public void printMeetingRoomsContaint(String part) {
        String rooms = "";
        for (MeetingRoom item : meetingRooms) {
            if (item.getName().toLowerCase().contains(part.toLowerCase())) {
                rooms += item.toString() + "\n";
            }
        }
        System.out.println(rooms);
    }

    public void printAreasLargerThan(int area) {
        String areas = "";
        for (MeetingRoom item : meetingRooms) {
            if (item.getArea() > area) {
                areas += item.toString() + "\n";
            }
        }
        System.out.println(areas);
    }
}
