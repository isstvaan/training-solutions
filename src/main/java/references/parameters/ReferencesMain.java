package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1 = new Person("Béla", 20);
        Person person2 = new Person("Lali", 25);

        person1 = new Person("Sanyi", 30);

        person2 = person1;

        person2.setName("Karcsi");

        System.out.println(person1.getName());
        System.out.println(person2.getName());


        int tmp1 = 24;
        int tmp2 = tmp1;
        tmp2++;
        System.out.println("Tmp1: " + tmp1 + "\tTmp2: " + tmp2);

        Person person3 = new Person("Peti", 10);

        person1 = person3;
        System.out.println(person1.getName());
        System.out.println(person2.getName());
        System.out.println(person3.getName());

    }
}
