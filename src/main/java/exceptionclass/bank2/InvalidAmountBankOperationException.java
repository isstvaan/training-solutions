package exceptionclass.bank2;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {
    public InvalidAmountBankOperationException(String message) {
        super(message, ErrorCode.INVALID_AMOUNT);
    }
}
