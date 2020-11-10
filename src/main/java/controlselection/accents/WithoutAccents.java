package controlselection.accents;

public class WithoutAccents {

    public char WithoutAccents(char withoutAccentsChar) {
        switch (withoutAccentsChar) {
            case 'ö':
            case 'ő':
                return 'o';
            case 'ü':
            case 'ű':
            case 'ú':
                return 'u';
            case 'á':
                return 'a';
            case 'é':
                return 'e';
        }

        return withoutAccentsChar;
    }
}
