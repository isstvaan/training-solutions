package schoolrecords.records;

import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> subjects) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty!");
        }
        if (subjects == null || subjects.size()==0)
        {
            throw new IllegalArgumentException("Subjects must not be empty!");
        }

        this.name = name;
        this.taughtSubjects = subjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject item : taughtSubjects) {
            if (item.getSubjectName().equalsIgnoreCase(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public String getName() {
        return name;
    }
}
