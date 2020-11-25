package exceptionclass.bank2;

public class InvalidBankOperationException extends RuntimeException {
    private ErrorCode errorCode;

    public InvalidBankOperationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
