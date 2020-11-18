package defaultconstructor.date;

public class SimpleDateFormatter {
    private CountryCode countryCode;

    public SimpleDateFormatter() {
        countryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(this.countryCode, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        switch (countryCode) {
            case HU:
                return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
            case EN:
                return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
            default:
                return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
        }
    }
}
