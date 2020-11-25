package exceptionclass.course;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Course {
    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null");
        }
        if (begin == null) {
            throw new IllegalArgumentException("Begin can't be null");

        }

        this.name = name;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {

        return begin + ": " + name;
    }
}
