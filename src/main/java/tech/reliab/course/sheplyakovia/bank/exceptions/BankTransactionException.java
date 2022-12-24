package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.enums.BankTransaction;

public class BankTransactionException extends RuntimeException {
    private final long number;
    private final BankTransaction transactionType;

    /**
     * Ошибка выполнения транзакции.
     *
     * @param message         Сообщение ошибки.
     * @param number          Номер.
     * @param transactionType Вид транзакции.
     */
    BankTransactionException(String message, long number, BankTransaction transactionType) {
        super(message);
        this.number = number;
        this.transactionType = transactionType;
    }

    @Override
    public String getMessage() {
        return "Bank transaction exception " +
                "\"" + transactionType.toString() + "\" № " + number + ": " + super.getMessage();
    }
}
