public class IntroControl {
    public int substractTenIfGreaterThanTen(int number) {
        return number <= 10 ? number : number - 10;
    }

    public String describeNumber(int number) {
        return number == 0 ? "Zero" : " Not zero";
    }

    public String greetingToJoe(String name) {
        return name.equals("Joe") ? "Hello Joe" : "";
    }

    public int calculateBonus(int sale) {
        return sale >= 1000000 ? (int) (sale * .1) : 0;
    }

    public int calculateConsumption(int prev, int next) {
        return prev <= next ? next - prev : 10000 - prev + next;
    }

    public String printNumbers(int max) {
        String retVal = "";
        for (int i = 0; i <= max; i++) {
            retVal += i + "\n";
        }
        return retVal;
    }

    public String printNumbersBetween(int min, int max) {
        String retVal = "";
        for (int i = (min <= max ? min : max); i <= (max > min ? max : min); i++) {
            retVal += i + "\n";
        }
        return retVal;
    }

    public String printNumbersBetweenAnyDirection(int a, int b) {
        String retVal = "";
        for (int i = (a < b ? a : b); i <= (a < b ? b : a); i++) {
            retVal += (a < b ? i : a - i) + "\n";
        }
        return retVal;
    }

    public String printOddNumbers(int max) {
        String retVal = "";
        for (int i = 1; i <= max; i = i + 2) {

            retVal += i + "\n";
        }

        return retVal;
    }
}
