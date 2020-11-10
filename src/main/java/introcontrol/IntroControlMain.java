package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();
        System.out.println(introControl.substractTenIfGreaterThanTen(5));
        System.out.println(introControl.substractTenIfGreaterThanTen(15));
        System.out.println(introControl.substractTenIfGreaterThanTen(25));
        System.out.println(introControl.substractTenIfGreaterThanTen(0));
        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.calculateBonus(1000000));
        System.out.println(introControl.calculateConsumption(11000, 12000));
        System.out.println(introControl.calculateConsumption(12000, 11000));

        System.out.println(introControl.calculateConsumption(9900, 11000));
        System.out.println(introControl.calculateConsumption(11000, 9900));
        System.out.println(introControl.calculateConsumption(9999, 10001));


        System.out.println(introControl.printNumbers(100));
        System.out.println(introControl.printNumbersBetween(50, 100));
        System.out.println(introControl.printNumbersBetween(100, 50));

        System.out.println(introControl.printNumbersBetweenAnyDirection(0, 10));
        System.out.println(introControl.printNumbersBetweenAnyDirection(10, 0));

        System.out.println(introControl.printOddNumbers(13));

    }
}
