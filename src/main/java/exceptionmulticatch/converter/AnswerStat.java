package exceptionmulticatch.converter;

public class AnswerStat {
    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String values) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(values);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException("", e);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] answersArray = convert(answers);
        double counter = 0;
        for (boolean item : answersArray) {
            counter = item ? ++counter : counter;
        }
        return (int) Math.round((counter / answersArray.length) * 100);
    }

}
