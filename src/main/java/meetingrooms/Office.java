package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        StringBuilder names = new StringBuilder("Tárgyalók: ");

        for (MeetingRoom item : meetingRooms) {
            names.append(item.getName()).append("; ");
        }
        System.out.println(names);
    }

    public void printNamesReverse() {
        StringBuilder names = new StringBuilder("Tárgyalók fordított sorrendben: ");

        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            names.append(meetingRooms.get(i).getName()).append("; ");
        }

        System.out.println(names);
    }

    public void printEventNames() {
        StringBuilder names = new StringBuilder("Minden második tárgyaló: ");

        for (int i = 0; i < meetingRooms.size(); i++) {
            if (i % 2 != 0) {
                names.append(meetingRooms.get(i).getName()).append("; ");
            }
        }
        System.out.println(names);
    }

    public void printAreas() {
        StringBuilder areas = new StringBuilder("Tárgyalók területei:\n");

        for (MeetingRoom item : meetingRooms) {
            areas.append(item.toString()).append("\n");
        }

        System.out.println(areas);
    }

    public void printMeetingRoomsWithName(String name) {
        StringBuilder rooms = new StringBuilder();
        for (MeetingRoom item : meetingRooms) {
            if (item.getName().equals(name)) {
                rooms.append(item.toString()).append("\n");
            }
        }
        System.out.println(rooms);
    }

    public void printMeetingRoomsContaint(String part) {
        StringBuilder rooms = new StringBuilder();
        for (MeetingRoom item : meetingRooms) {
            if (item.getName().toLowerCase().contains(part.toLowerCase())) {
                rooms.append(item.toString()).append("\n");
            }
        }
        System.out.println(rooms);
    }

    public void printAreasLargerThan(int area) {
        StringBuilder areas = new StringBuilder();
        for (MeetingRoom item : meetingRooms) {
            if (item.getArea() > area) {
                areas.append(item.toString()).append("\n");
            }
        }
        System.out.println(areas);
    }
}
