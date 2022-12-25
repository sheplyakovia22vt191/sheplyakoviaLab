package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.entity.Entity;

public class NotFoundException extends RuntimeException {
    private final int id;
    private final String entityName;

    /**
     * Ошибка, возникающая при отсутсвии объекта класса.
     *
     * @param id     Id объекта.
     * @param entityName Объект.
     */
    public NotFoundException(int id, String entityName) {
        this.id = id;
        this.entityName = entityName;
    }

    @Override
    public String getMessage() {
        return "Object " + entityName + " with id=" + id + " not found";
    }
}
