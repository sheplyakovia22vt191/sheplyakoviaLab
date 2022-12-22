package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.enums.CrudOperations;

public class CrudOperationException extends RuntimeException{
    private final CrudOperations operation;
    private final String className;

    CrudOperationException(String message,String className, CrudOperations operation) {
        super(message);
        this.className = className;
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Ошибка при выполнении метода \"" + operation.toString() + "\" над сущностью " + className + ": " + super.getMessage();
    }
}
