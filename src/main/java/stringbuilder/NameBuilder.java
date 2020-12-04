package stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Invalid parameter! Firt name and given name can't be empty.");
        }

        StringBuilder nameBulder = new StringBuilder();

        if (title != null) {
            nameBulder.append(title.getStringValue()).append(" ").append(givenName).append(" ");
        } else {
            nameBulder.append(givenName).append(" ");
        }
        if (!isEmpty(middleName)) {
            nameBulder.append(middleName).append(" ");
        }
        nameBulder.append(familyName);

        return nameBulder.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder nameBulder = new StringBuilder();

        if (title != null) {
            nameBulder.append(title.getStringValue()).append(" ").append(familyName).append(" ");
        } else {
            nameBulder.append(familyName).append(" ");
        }

        if (!isEmpty(middleName)) {
            nameBulder.append(middleName).append(" ");
        }

        nameBulder.append(givenName);

        return nameBulder.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        if (isEmpty(name) || title == null) {
            throw new IllegalArgumentException("Invalid parameter! Name and title can't be empty.");
        }

        StringBuilder titleBuilder = new StringBuilder(name);

        int index = titleBuilder.indexOf(where);
        if (index < 0) {
            throw new IllegalArgumentException("Invalid parameter! Where parameter is not valid.");
        }
        titleBuilder.insert(index + 1, (title.getStringValue() + " "));
        return titleBuilder.toString();
    }

    public String deleteNamePart(String name, String delete) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Invalid parameter! Name can't be empty.");
        }

        StringBuilder nameBuilder = new StringBuilder(name);
        int deleteIndex = nameBuilder.indexOf(delete);

        return nameBuilder.delete(deleteIndex, deleteIndex + delete.length()).toString();
    }


    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
