package week10d01;

import java.io.*;

public class HikingFile {

    public MaxClimbValue getPlusElevation(InputStream stream) {
        int rise = 0;
        int descent = 0;
        int prevState = -1;
        try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                if (prevState > 0) {
                    int tmp = getDifferenceFromHiking(prevState, getHikingValueFromString(line));
                    if (tmp > 0) {
                        rise += tmp;
                    } else {
                        descent += Math.abs(tmp);
                    }
                }
                prevState = getHikingValueFromString(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
        return new MaxClimbValue(rise, descent);
    }

    private int getHikingValueFromString(String str) {
        String[] splittedStr = str.split(" ");
        try {
            return Integer.parseInt(splittedStr[2]);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("Invalid data format");
        }
    }

    private int getDifferenceFromHiking(int prevValue, int currentValue) {
        return currentValue - prevValue;
    }

    public static void main(String[] args){
        HikingFile hikingFile = new HikingFile();
        System.out.println(hikingFile.getPlusElevation(HikingFile.class.getResourceAsStream("/gps.txt")));
    }

}
