import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Note note = new Note();

        System.out.println("Kérem adja meg a jegyzet nevét:");
        note.setName(scanner.nextLine());

        System.out.println("Kérem adja meg a jegyzet témáját:");
        note.setTopic(scanner.nextLine());

        System.out.println("Kérem adja meg a jegyzet tartalmát:");
        note.setText(scanner.nextLine());


        System.out.println("A megadott jegyzet:"+note.getNoteText());
    }
}
