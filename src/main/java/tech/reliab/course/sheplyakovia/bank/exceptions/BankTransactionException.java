package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.enums.BankTransaction;

public class BankTransactionException extends RuntimeException{
    private final long number;
    private final BankTransaction transactionType;

    BankTransactionException(String message, long number, BankTransaction transactionType) {
        super(message);
        this.number = number;
        this.transactionType = transactionType;
    }

    @Override
    public String getMessage() {
        return "Ошибка выполнения транзакции типа " +
                "\"" + transactionType.toString() + "\" номер " + number + ": " + super.getMessage();
    }
}
