package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.entity.Entity;
import tech.reliab.course.sheplyakovia.bank.enums.CrudOperations;

public class CrudOperationException extends RuntimeException {
    private final CrudOperations operation;
    private final Entity entity;

    /**
     * Ошибка при выполнении метода.
     *
     * @param message   Сообщение ошибки.
     * @param entity    Сущность.
     * @param operation CRUD операция.
     */
    CrudOperationException(String message, Entity entity, CrudOperations operation) {
        super(message);
        this.entity = entity;
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Ошибка при выполнении метода \"" + operation.toString() + "\" над сущностью " + entity.getSimpleName() + ": " + super.getMessage();
    }
}
