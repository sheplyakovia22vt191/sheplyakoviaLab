package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.entity.Entity;

public class ObjectAccessException extends RuntimeException {
    private final Entity entity;
    private final String reason;

    /**
     * Ошибка доступа к объекту.
     *
     * @param entity Объект.
     * @param reason Причина.
     */
    public ObjectAccessException(Entity entity, String reason) {
        this.entity = entity;
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return "Object accessE error \"" + entity.getSimpleName() + "\", reason " + reason;
    }
}
