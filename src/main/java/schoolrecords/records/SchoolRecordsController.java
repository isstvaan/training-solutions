package schoolrecords.records;

import java.util.*;

public class SchoolRecordsController {
    ClassRecords classRecords;
    List<Tutor> tutors;
    List<Subject> subjects;
    Scanner scanner = new Scanner(System.in);

    public SchoolRecordsController() {
        classRecords = new ClassRecords("Első A osztály", new Random(5));

        for (int i = 0; i < new Random().nextInt(100); i++) {
            classRecords.addStudent(new Student(Generator.getRandomName()));
        }
    }

    public void initSchool() {
        subjects = new ArrayList<>();
        subjects.add(new Subject("földrajz"));
        subjects.add(new Subject("matematika"));
        subjects.add(new Subject("biológia"));
        subjects.add(new Subject("zene"));
        subjects.add(new Subject("fizika"));
        subjects.add(new Subject("kémia"));

        tutors = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
            tutors.add(new Tutor(Generator.getRandomName(), Generator.getRandomSubjects(subjects, rnd.nextInt(subjects.size()))));
        }
    }

    //region Menu handling
    public void runMenu() {
        try {
            printMenu();
            int menuIndex = scanner.nextInt();
            scanner.nextLine();

            switch (menuIndex) {
                case 1:
                    printStudentNames();
                    break;
                case 2:
                    findStudentByNames();
                    break;
                case 3:
                    addNewStudent();
                    break;
                case 4:
                    removeStudentByName();
                    break;
                case 5:
                    studentRepetition();
                    break;
                case 6:
                    printClassAverageMarks();
                    break;
                case 7:
                    printClassAverageMarksBySubject();
                    break;
                case 8:
                    printStudyResultList();
                    break;
                case 9:
                    printStudyResult();
                    break;
                case 10:
                    printStudyResultBySubject();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Érvénytelen menüpont");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        runMenu();
    }

    private void printMenu() {
        System.out.println("---===MENU===--\n" +
                "1. Diákok nevének listázása\n" +
                "2. Diák név alapján keresése\n" +
                "3. Diák létrehozása\n" +
                "4. Diák név alapján törlése\n" +
                "5. Diák feleltetése\n" +
                "6. Osztályátlag kiszámolása\n" +
                "7. Tantárgyi átlag kiszámolása\n" +
                "8. Diákok átlagának megjelenítése\n" +
                "9. Diák átlagának kiírása\n" +
                "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "11. Kilépés");
    }

    //endregion


    //region Menu methods
    private void printStudentNames() {
        System.out.println("Diákok:\n" + classRecords.listStudentNames());
    }

    private void findStudentByNames() {
        System.out.println("Kérem a keresett diák nevét:");
        try {
            System.out.println("Találat: " + classRecords.findStudentByName(scanner.nextLine()).getName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addNewStudent() {
        System.out.println("Kérem az új diák nevét:");
        classRecords.addStudent(new Student(scanner.nextLine()));
    }

    private void removeStudentByName() {
        System.out.println("Kérem a törölni kívánt diák nevét:");
        classRecords.removeStudent(new Student(scanner.nextLine()));
    }

    //region Repetition
    private void studentRepetition() {
        Student student = classRecords.repetition();
        System.out.println("A kiválasztott diák:\n" + student.getName());

        Tutor tutor = getTutorFromConsole();

        Subject subject = getSubjectFromConsole();
        if (!tutor.tutorTeachingSubject(subject)) {
            System.out.println("A(z) " + tutor.getName() + " nem tanít ilyen tárgyat, kérem válasszon másikat.");
            System.out.println("Elérhető tantárgyak:\n" + getSubjectNames());
            subject = getSubjectFromConsole();
        }

        MarkType markType = getMarkFromConsole();

        student.grading(new Mark(markType, subject, tutor));
    }

    private Tutor getTutorFromConsole() {
        Tutor tutor = null;

        while (tutor == null) {
            System.out.println("Kérem adja meg a tanár nevét:");
            tutor = findTutor(scanner.nextLine());

            if (tutor == null) {
                System.out.println("Nem található ilyen nevű tanár.");
                System.out.println("Elérhető tanárok:\n" + getTutorNames());
            } else {
                return tutor;
            }
        }
        return null;
    }

    private String getTutorNames() {
        String names = "";
        for (Tutor item : tutors) {
            names += item.getName() + ",";
        }
        return names;
    }

    private String getSubjectNames() {
        String names = "";
        for (Subject item : subjects) {
            names += item.getSubjectName() + ",";
        }
        return names;
    }

    private Tutor findTutor(String name) {
        for (Tutor item : tutors) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    private Subject getSubjectFromConsole() {
        Subject subject = null;

        while (subject == null) {
            System.out.println("Kérem adja meg a tantárgy nevét:\n");
            String subjectName = scanner.nextLine();
            subject = findSubject(subjectName);

            if (subject == null) {
                System.out.println("Nem található ilyen tantárgy.");
                System.out.println("Elérhető tantárgyak:\n" + getSubjectNames());
            } else {
                return subject;
            }
        }
        return null;
    }

    private Subject findSubject(String subjectName) {
        for (Subject item : subjects) {
            if (item.getSubjectName().equalsIgnoreCase(subjectName)) {
                return item;
            }
        }
        return null;
    }

    private MarkType getMarkFromConsole() {
        MarkType markType = null;

        while (markType == null) {
            System.out.println("Kérem adja az osztályzatot (1-5, számmal megadva):\n");
            try {
                markType = getMarkTypeFromValue(scanner.nextInt());
                scanner.nextLine();
                return markType;
            } catch (Exception ex) {
                markType = null;
                System.out.println("Érvénytelen osztályzat");
            }
        }
        return null;
    }

    private MarkType getMarkTypeFromValue(int value) {
        for (MarkType item : MarkType.values()) {
            if (item.getValue() == value) {
                return item;
            }
        }
        return null;
    }
    //endregion

    private void printClassAverageMarks() {
        System.out.println("Az osztály átlaga: " + classRecords.calculateClassAverage());
    }

    private void printClassAverageMarksBySubject() {
        Subject subject = getSubjectFromConsole();

        System.out.println("Az osztály átlaga a " + subject.getSubjectName() +
                " nevű tantárgyból: " + classRecords.calculateClassAverageBySubject(subject));
    }

    private void printStudyResultList() {
        String studyResults = "";
        for (StudyResultByName item : classRecords.listStudyResults()) {
            studyResults += item.getStudentName() + " átlaga: " + item.getStudyAverage() + "\n";
        }
        System.out.println("Tanulói átlagok:\n" + studyResults);
    }

    private void printStudyResult() {
        System.out.println("Kérem a diák nevét:");
        Student student = null;

        while (student == null) {
            try {
                student = classRecords.findStudentByName(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Átlaga: " + student.calculateAverage());
    }

    private void printStudyResultBySubject() {
        System.out.println("Kérem a diák nevét:");
        Student student = null;

        while (student == null) {
            try {
                student = classRecords.findStudentByName(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        Subject subject = getSubjectFromConsole();
        System.out.println(student.getName() + " átlaga a " + subject.getSubjectName() + " nevű tárgyból: " + student.calculateSubjectAverage(subject));
    }
    //endregion

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();
        schoolRecordsController.runMenu();
    }
}
