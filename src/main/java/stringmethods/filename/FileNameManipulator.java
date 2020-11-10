package stringmethods.filename;

public class FileNameManipulator {
    public char findLastCharacter(String str) {
        str = str.trim();
        if (!parameterIsValid(str)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return str.charAt(str.length() - 1);
    }

    public String findFileExtensions(String fileName) {
        fileName = fileName.trim();
        if (!parameterIsValid(fileName)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        if (fileName.indexOf('.') < 1) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return fileName.substring(fileName.lastIndexOf('.'));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        ext = ext.trim();
        fileName = fileName.trim();

        if (!parameterIsValid(ext) || !parameterIsValid(fileName)) {
            throw new IllegalArgumentException("Invalid parameter");
        }
        return ext.equals(findFileExtensions(fileName));
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        searchedFileName = searchedFileName.trim();
        actualFileName = actualFileName.trim();
        if (!parameterIsValid(searchedFileName) || !parameterIsValid(actualFileName)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        fileName = fileName.trim();
        if (!parameterIsValid(fileName)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        String ext = findFileExtensions(fileName);
        fileName.replace(ext, ext.toLowerCase());
        return fileName;
    }

    public String relaceStringPart(String fileName, String present, String target) {
        fileName = fileName.trim();
        present = present.trim();
        target = target.trim();

        if (!parameterIsValid(fileName) || !parameterIsValid(present) || !parameterIsValid(target)) {
            throw new IllegalArgumentException("Invalid parameter");
        }
        if (fileName.indexOf(present) >= 0) {

            return fileName.replace(present, target);
        }
        return fileName;
    }

    public boolean parameterIsValid(String parameter) {
        return parameter != null && !parameter.isEmpty();
    }
}
