package schoolrecords.records;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        if (className == null || className.isBlank()) {
            throw new IllegalArgumentException("Class name must not be empty!");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        try {
            findStudentByName(student.getName());
            return false;
        } catch (Exception e) {
        }

        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        try {
            return students.remove(findStudentByName(student.getName()));
        } catch (Exception ex) {
            return false;
        }
    }

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double avg = 0;
        int counter = 0;
        for (Student item : students) {
            double avgTmp = item.calculateAverage();
            if (avgTmp > 0) {
                avg += avgTmp;
                counter++;
            }
        }

        //Ha nincsenek osztályzatok
        if (avg == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }


        return new BigDecimal(avg / counter).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double avg = 0;
        int counter = 0;
        for (Student item : students) {
            double avgStudent = item.calculateSubjectAverage(subject);
            if (avgStudent > 0) {
                counter++;
            }
            avg += avgStudent;
        }

        //Ha nincsenek osztályzatok
        if (avg == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

        return new BigDecimal(avg / counter).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Student findStudentByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }

        for (Student item : students) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() {
        if (students.size() > 0) {
            return students.get(rnd.nextInt(students.size()));
        } else {
            throw new IllegalStateException("No students to select for repetition!");
        }
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNamesList = new ArrayList<>();
        for (Student item : students) {
            studyResultByNamesList.add(new StudyResultByName(item.calculateAverage(), item.getName()));
        }
        return studyResultByNamesList;
    }

    public String listStudentNames() {
        String nameList = "";
        for (int i = 0; i < students.size(); i++) {
            nameList += students.get(i).getName() + (i < students.size() - 1 ? ", " : "");
        }
        return nameList;
    }

}
