package schoolrecords.records;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private final List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateAverage() {
        double avg = 0;

        for (Mark item : marks) {
            avg += item.getMarkType().getValue();
        }
        if (marks.size() == 0) {
            return 0;
        }
        return new BigDecimal(avg / marks.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double calculateSubjectAverage(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject must not be null!");
        }
        double avg = 0;
        int counter = 0;
        for (Mark item : marks) {
            if (item.getSubject().getSubjectName().equalsIgnoreCase(subject.getSubjectName())) {
                avg += item.getMarkType().getValue();
                counter++;
            }
        }
        if (counter == 0) {
            return 0;
        }
        return new BigDecimal(avg / counter).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    @Override
    public String toString() {
        String tmp = "";
        for (Mark item : marks) {
            tmp += item.getSubject().getSubjectName() + ": " + item.toString();
        }

        return name + " marks: " + tmp;
    }

}
