package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name can't be empty");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/test/resources/" +fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                students.add(getStudentFromStr(line));
            }

        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }

    private Student getStudentFromStr(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String can't be empty");
        }

        String[] splittedStr = str.split(" ");
        List<Integer> grades = new ArrayList<>();
        for (int i = 1; i < splittedStr.length; i++) {
            grades.add(Integer.parseInt(splittedStr[i]));
        }
        return new Student(splittedStr[0], grades);
    }

    public double classAverage() {
        double sum = 0;
        for (Student item : students) {
            sum += item.average();
        }
        return sum / students.size();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
