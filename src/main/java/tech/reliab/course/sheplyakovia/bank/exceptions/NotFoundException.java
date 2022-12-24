package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.entity.Entity;

public class NotFoundException extends RuntimeException {
    private final int id;
    private final Entity entity;

    /**
     * Ошибка, возникающая при отсутсвии объекта класса.
     *
     * @param id     Id объекта.
     * @param entity Объект.
     */
    public NotFoundException(int id, Entity entity) {
        this.id = id;
        this.entity = entity;
    }

    @Override
    public String getMessage() {
        return "Object " + entity.getSimpleName() + " with id=" + id + " not found";
    }
}
