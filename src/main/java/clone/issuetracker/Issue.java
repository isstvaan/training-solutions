package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private final String name;
    private final LocalDateTime time;
    private final Status status;

    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
        comments = new ArrayList<>();
    }

    public Issue(Issue issue, CopyMode copyMode) {
        this(issue.name, issue.time, issue.status);
        if (copyMode == CopyMode.WITH_COMMENTS) {
            for (Comment item : issue.getComments()) {
                comments.add(new Comment(item));
            }
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }
}
