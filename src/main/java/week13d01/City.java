package week13d01;

import java.util.Objects;

public class City{
    private final String zipCode;
    private final String name;
    private final String cityPart;

    public City(String zipCode, String name, String cityPart) {
        this.zipCode = zipCode;
        this.name = name;
        this.cityPart = cityPart;
    }

    public static City fromCSVString(String fullString) {
        String[] splittedStr = fullString.split(";");
        return new City(splittedStr[0], splittedStr[1], splittedStr.length > 2 ? splittedStr[2] : "");
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getCityPart() {
        return cityPart;
    }

    @Override
    public String toString() {
        return "City{" +
                "zipCode=" + zipCode +
                ", name='" + name + '\'' +
                '}';
    }

}
