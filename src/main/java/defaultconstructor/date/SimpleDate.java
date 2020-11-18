package defaultconstructor.date;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (year < 1900) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }

        int maxDay = getMonthDays(year, month);
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonthDays(int year, int month) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        if (month == 2) {
            return isLeapYear ? 29 : 28;
        } else if (month == 4 ||
                month == 6 ||
                month == 9 ||
                month == 11) {
            return 30;
        }
        return 31;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
