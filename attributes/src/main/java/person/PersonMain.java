package person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Béla", "ABCDEF");

        System.out.println(person.personToString());
        System.out.println(person.getAddress());

        person.moveTo(new Address("California", "Cupertino", "1 Infinite Loop", "95014"));

        System.out.println(person.getAddress().addressToString());

        person.correctData("Sanyi", "123456");
        System.out.println(person.personToString());

        person.getAddress().correctData("Magyarország", "Üszögpusta", "Barlang 2", "1234");

        System.out.println(person.getAddress().addressToString());

        person.moveTo(new Address("California", "Cupertino", "1 Infinite Loop", "95014"));

        System.out.println(person.getAddress().addressToString());
    }
}
