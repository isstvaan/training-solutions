public class Game {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Warrior 1", new Point(0, 0));
        Warrior warrior2 = new Warrior("Warrior 2", new Point(5, 10));

        System.out.println(warrior1);
        System.out.println(warrior2);

        int counter = 1;
        while (warrior1.distance(warrior2) > 0) {
            warrior1.move(warrior2);
            warrior2.move(warrior1);
            counter++;
            System.out.println("\n" + counter + " kör mozgások: ");
            System.out.println(warrior1);
            System.out.println(warrior2);
        }

        System.out.println("Indul a harc:");
        counter = 1;
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.attack(warrior2);
            warrior2.attack(warrior1);
            counter++;
            System.out.println("\n" + counter + " harc kör: ");
            System.out.println(warrior1);
            System.out.println(warrior2);
        }

        System.out.println("\nA gyöztes");
        System.out.println((warrior1.isAlive() ? warrior1.toString() : warrior2.toString()) + " nyerte a játékot");
    }
}
