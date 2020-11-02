import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> capsules = new ArrayList<>();

    public void addLast(String capsuleColor) {
        this.capsules.add(capsuleColor);
    }

    public void addFirst(String capsuleColor) {
        this.capsules.add(0, capsuleColor);
    }

    public void removeFirst() {
        this.capsules.remove(0);
    }

    public void removeLast() {
        this.capsules.remove(capsules.size() - 1);
    }

    public List<String> getColors() {
        return capsules;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();

        System.out.println("Capsules: " + capsules.getColors());

        capsules.addFirst("First1");
        capsules.addLast("Last");

        System.out.println("Capsules: " + capsules.getColors());
        capsules.addFirst("First0");
        System.out.println("Capsules: " + capsules.getColors());

        capsules.removeLast();
        System.out.println("Capsules: " + capsules.getColors());

        capsules.removeFirst();
        System.out.println("Capsules: " + capsules.getColors());

        List<String> capsulesTmp=capsules.getColors();
        System.out.println("CapsulesTmp: " + capsulesTmp);
        capsulesTmp.clear();

        System.out.println("CapsulesTmp: " +capsulesTmp);
        System.out.println("Capsules: " + capsules.getColors());

    }
}
