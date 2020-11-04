package week;

public class WorkdayCalculatorMain {
    public static void main(String[] args) {
        WorkdayCalculator workdayCalculator = new WorkdayCalculator();

        System.out.println(workdayCalculator.dayTypes(Day.MONDAY, 7).toString());
        System.out.println(workdayCalculator.dayTypes(Day.TUESDAY, 7).toString());
        System.out.println(workdayCalculator.dayTypes(Day.WEDNESDAY, 7).toString());
        System.out.println(workdayCalculator.dayTypes(Day.THURSDAY, 7).toString());
        System.out.println(workdayCalculator.dayTypes(Day.FRIDAY, 7).toString());
        System.out.println(workdayCalculator.dayTypes(Day.SATURDAY, 7).toString());
        System.out.println(workdayCalculator.dayTypes(Day.SUNDAY, 7).toString());
    }
}
