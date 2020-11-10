package controlselection.week;

public class DayOfWeeks {

    public String getDayOfWeek(String dayOfWeek) {
        switch (dayOfWeek.toLowerCase()) {
            case "hetfo":
            case "hétfo":
            case "hetfő":
            case "hétfő":
                return "hét eleje";
            case "kedd":
            case "szerda":
            case "csutortok":
            case "csütortok":
            case "csutörtok":
            case "csutortök":
            case "csütörtok":
            case "csütörtök":
                return "hét közepe van";
            case "pentek":
            case "péntek":
                return "majdnem hétvége";
            case "szombat":
            case "vasarnap":
            case "vasárnap":
                return "hétvége";
        }

        throw new IllegalArgumentException("Invalid day: " + dayOfWeek);
    }
}
