package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private final List<Activity> activites;

    public Activities(List<Activity> activites) {
        this.activites = activites;
    }

    public void addActivity(Activity activity) {
        activites.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for (ActivityType item : ActivityType.values()) {
            reports.add(new Report(item, 0));
        }

        for (Activity item : activites) {
            reports.set(item.getType().ordinal(), new Report(item.getType(), reports.get(item.getType().ordinal()).getDistance() + item.getDistance()));
        }
        return reports;
    }

    public int numberOfTrackActivities() {
        int counts = 0;
        for (Activity item : activites) {
            if (item instanceof ActivityWithTrack) {
                counts++;
            }
        }
        return counts;
    }

    public int numberOfWithoutTrackActivities() {
        int counts = 0;
        for (Activity item : activites) {
            if (item instanceof ActivityWithoutTrack) {
                counts++;
            }
        }
        return counts;
    }

}
