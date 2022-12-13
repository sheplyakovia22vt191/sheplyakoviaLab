package tech.reliab.course.sheplyakovia.bank.enums;

import java.util.Random;

public enum WorkStatus {
    WORKING("Работает"),
    NOT_WORKING("Не работает"),
    NO_MONEY("Нет денег");

    private String status;

    WorkStatus(String status) {
        this.status = status;
    }

    public static WorkStatus getRandomStatus() {
        Random random = new Random();

        WorkStatus[] values = values();
        return values[random.nextInt(values.length)];
    }
}
