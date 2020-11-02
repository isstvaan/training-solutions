package person;

public class Person {
    private String name;
    private String identificationCard;
    private Address address;

    public Person() {
        name =
                identificationCard = "";
    }

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String personToString() {
        return "Name: " + name + " ID: " + identificationCard;
    }

    public void correctData(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public Address getAddress() {
        return address;
    }

    public void moveTo(Address address) {
        this.address = address;
    }
}
