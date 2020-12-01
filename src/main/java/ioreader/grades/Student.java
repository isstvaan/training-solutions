package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Integer> grades;
    private String name;

    public Student(String name, List<Integer> grades) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
        this.grades = grades;
    }

    public double average() {
        double sum = 0;
        for (int item : grades) {
            sum += item;
        }
        return sum / grades.size();
    }

    public boolean isIncreasing() {
        for (int i = 0; i < grades.size() - 1; i++) {
            if (grades.get(i) > grades.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(grades);
    }

    public String getName() {
        return name;
    }
}
