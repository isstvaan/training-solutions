package month;

public class DayInMonth {
    public int getMonthDays(int year, String month) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        switch (month.toLowerCase()) {
            case "februar":
            case "február":
                return isLeapYear ? 29 : 28;
            case "aprilis":
            case "április":
            case "junius":
            case "június":
            case "szeptember":
            case "november":
                return 30;
            case "januar":
            case "január":
            case "marcius":
            case "március":
            case "majus":
            case "május":
            case "julius":
            case "július":
            case "augusztus":
            case "oktober":
            case "október":
            case "december":
                return 31;

            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}
