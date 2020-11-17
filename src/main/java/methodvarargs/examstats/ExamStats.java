package methodvarargs.examstats;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        double currentLimit = maxPoints * (limitInPercent / 100f);
        int counter = 0;
        for (int item : results) {
            if (item >= currentLimit) {
                counter++;
            }
        }
        return counter;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        double currentLimit = maxPoints * (limitInPercent / 100f);
        int counter = 0;
        for (int item : results) {
            if (item < currentLimit) {
                return true;
            }
        }
        return false;
    }
}
