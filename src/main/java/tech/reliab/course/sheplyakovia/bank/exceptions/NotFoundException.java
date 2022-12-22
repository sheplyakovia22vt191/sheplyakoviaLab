package tech.reliab.course.sheplyakovia.bank.exceptions;

import tech.reliab.course.sheplyakovia.bank.entity.Entity;

public class NotFoundException extends RuntimeException{
    private final int id;
    private final Entity entityClass;
    public NotFoundException(int id, Entity entityClass) {
        this.id = id;
        this.entityClass = entityClass;
    }

    @Override
    public String getMessage() {
        return "Объект класса " + entityClass.getSimpleName() + " с id=" + id + " не найден";
    }
}
