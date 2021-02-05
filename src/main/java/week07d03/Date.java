package week07d03;

public class Date {
    public static final int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] DAYS_OF_MONTH_LEAP_YEAR = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int year;
    private final int month;
    private final int day;


    public Date(int year, int month, int day) {
        isValidDatas(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private void isValidDatas(int year, int month, int day) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("wrong month");
        }
        if (leapYear(year)) {
            if (day < 1 || day > DAYS_OF_MONTH_LEAP_YEAR[month - 1]) {
                throw new IllegalArgumentException("wrong day");
            }

        } else {
            if (day < 1 || day > DAYS_OF_MONTH[month - 1]) {
                throw new IllegalArgumentException("wrong day");
            }
        }
    }

    private boolean leapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
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

    public Date withYear(int year) {
        return new Date(year, this.month, this.day);
    }

    public Date withMonth(int month) {
        return new Date(this.year, month, this.day);
    }

    public Date withDay(int day) {
        return new Date(this.year, this.month, day);
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }
}
