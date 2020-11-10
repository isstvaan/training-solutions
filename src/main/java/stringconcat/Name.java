package stringconcat;

public class Name {
    private Title title;
    private String familyName;
    private String middleName;
    private String givenName;

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (familyName == null || familyName.isEmpty()) {
            throw new IllegalArgumentException("familyName parameter is not valid!");
        }
        if (middleName == null || middleName.isEmpty()) {
            throw new IllegalArgumentException("middleName parameter is not valid!");
        }

        this.title = title;
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (familyName == null || familyName.isEmpty()) {
            throw new IllegalArgumentException("familyName parameter is not valid!");
        }
        if (middleName == null || middleName.isEmpty()) {
            throw new IllegalArgumentException("middleName parameter is not valid!");
        }

        this.title = title;
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        String nameString;

        if (title != null) {
            nameString = title.getStringValue();
            nameString = nameString.concat(" ");
            nameString = nameString.concat(givenName);
        } else {
            nameString = givenName;
        }
        nameString = nameString.concat(" ");
        if (!isEmpty(middleName)) {
            nameString = nameString.concat(middleName);
            nameString = nameString.concat(" ");
        }
        nameString = nameString.concat(familyName);

        return nameString;
    }

    public String concatNameHungarianStyle() {
        String nameString;

        nameString = familyName;

        if (title != null) {
            nameString = title.getStringValue() + " " + nameString;
        }

        nameString += " ";

        if (!isEmpty(middleName)) {
            nameString += middleName + " ";
        }
        nameString += givenName;

        return nameString;
    }

    public boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
