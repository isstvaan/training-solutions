package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        this(timeSheetItem.employee, timeSheetItem.project, timeSheetItem.from, timeSheetItem.to);
//        this.employee = employee;
//        this.project = project;
//        this.from = from;
//        this.to = to;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate date) {
        TimeSheetItem retVal = new TimeSheetItem(timeSheetItem);
        retVal.from = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), retVal.from.getHour(), retVal.from.getMinute(), retVal.from.getSecond());
        retVal.to = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), retVal.to.getHour(), retVal.to.getMinute(), retVal.to.getSecond());
        return retVal;
    }
}
