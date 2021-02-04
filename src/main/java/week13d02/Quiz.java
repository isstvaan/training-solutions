package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private char[] answers;
    private Map<String, List<String>> results;

    public void loadDatasFromFile(BufferedReader reader) {
        results = new HashMap<>();
        String line;
        try (reader) {
            answers = reader.readLine().toCharArray();
            while ((line = reader.readLine()) != null) {
                addNewResultToResults(line);
            }
        } catch (IOException ex) {
            throw new IllegalStateException("File read error", ex);
        }
    }

    private void addNewResultToResults(String str) {
        String[] splittedStr = str.split(" ");
        if (!results.containsKey(splittedStr[0])) {
            results.put(splittedStr[0], new ArrayList<>());
        }
        results.get(splittedStr[0]).add(splittedStr[1]);
    }

    public boolean isGoodAnswer(String code, int index) {
        if (results.containsKey(code) && results.get(code).size() > index) {
            return results.get(code).get(index).charAt(0) == answers[index];
        }
        return false;
    }

    public String getMaxPassUserCode() {
        String retVal = "";
        int maxPass = 0;
        for (Map.Entry<String, List<String>> item : results.entrySet()) {
            int passes = getPassAnswearsCount(item.getValue());
            if (maxPass < passes) {
                retVal = item.getKey();
                maxPass = passes;
            }
        }

        return retVal;
    }

    private int getUserScore(List<String> answersList) {
        int score = 0;
        for (int i = 0; i < answersList.size() && i < answers.length; i++) {
            if (answersList.get(i).charAt(0) == answers[i]) {
                score += (i + 1);
            } else {
                if (answersList.get(i).toUpperCase().charAt(0) != 'X') {
                    score -= 2;
                }
            }
        }
        return score;
    }

    public String getWinner() {
        int maxScore = 0;
        String retVal = "";
        for (Map.Entry<String, List<String>> item : results.entrySet()) {
            int userScore = getUserScore(item.getValue());
            if (maxScore < userScore) {
                retVal = item.getKey();
                maxScore = userScore;
            }
        }
        return retVal;
    }

    private int getPassAnswearsCount(List<String> list) {
        int result = 0;
        for (String item : list) {
            if (item.toUpperCase().contains("X")) {
                result++;
            }
        }
        return result;
    }
}
