package exceptions.faults;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {
    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }

        List<String> errorLogs = new ArrayList<>();
        for (String item : lines) {
            String errorLogMessage = getErrorLOG(getProcessResult(item), item);
            if (!errorLogMessage.equals("")) {
                errorLogs.add(errorLogMessage);
            }
        }
        return errorLogs;
    }

    private ProcessingResult getProcessResult(String str) {
        String[] strSplitted = str.split(",");
        if (strSplitted.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }

        int lineNumber = getLineNumber(strSplitted[0]);
        if (lineNumber >= 0) {
            boolean isValidNumber = isValidNumber(strSplitted[1]);
            boolean isValidDate = isValidDate(strSplitted[2]);

            return !isValidNumber && !isValidDate ? ProcessingResult.VALUE_AND_DATE_ERROR :
                    !isValidNumber ? ProcessingResult.VALUE_ERROR :
                            !isValidDate ? ProcessingResult.DATE_ERROR :
                                    ProcessingResult.NO_ERROR;
        } else {
            return ProcessingResult.COMMENT;
        }
    }

    private String getErrorLOG(ProcessingResult result, String str) {
        switch (result) {
            case WORD_COUNT_ERROR:
            case VALUE_ERROR:
            case DATE_ERROR:
            case VALUE_AND_DATE_ERROR:
                return getLineNumber(str.substring(0, str.indexOf(','))) + "," + result.getCode();
        }
        return "";
    }

    private int getLineNumber(String numLineStr) {
        try {
            return Integer.parseInt(numLineStr);
        } catch (Exception ex) {
            return -1;
        }
    }

    private boolean isValidNumber(String numStr) {
        try {
            Double.parseDouble(numStr);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean isValidDate(String dateStr) {
        try {
            new SimpleDateFormat("yyyy.MM.dd.").parse(dateStr);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
