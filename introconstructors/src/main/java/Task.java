import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private int duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void start() {
        startDateTime = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Task task = new Task("Task1","Desc 1");

        task.setDuration(100);

        System.out.println(task.getDuration());

        task.start();

        System.out.println(task.getStartDateTime());
    }
}
