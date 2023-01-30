package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.enums.BankTransaction;

public class BankTransactionException extends RuntimeException {
    private final BankTransaction transactionType;

    /**
     * Ошибка выполнения транзакции.
     *
     * @param message         Сообщение ошибки.
     * @param transactionType Вид транзакции.
     */
    public BankTransactionException(String message, BankTransaction transactionType) {
        super(message);
        this.transactionType = transactionType;
    }

    @Override
    public String getMessage() {
        return "Bank transaction exception " +
                "\"" + transactionType.toString() + "\". " + super.getMessage();
    }
}
