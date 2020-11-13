package schoolrecords.records;

import java.util.Objects;

public class Subject {
    private String subjectName;

    public Subject(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be null!");
        }
        subjectName = name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

}
