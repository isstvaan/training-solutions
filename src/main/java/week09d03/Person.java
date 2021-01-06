package week09d03;

import java.util.Random;

public class Person {
    private final int age;
    private final String name;
    private Present present = Present.NONE;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setPresent() {
        if (age < 15) {
            present = Present.values()[new Random().nextInt(Present.values().length)];
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Present getPresent() {
        return present;
    }
}
