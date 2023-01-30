package tech.reliab.course.sheplyakovia.bank.enums;

import java.util.Random;

public enum WorkStatus {
    WORKING("Working"),
    NOT_WORKING("Not working"),
    NO_MONEY("No money");

    private final String status;

    WorkStatus(String status) {
        this.status = status;
    }

    public static WorkStatus getRandomStatus() {
        Random random = new Random();

        WorkStatus[] values = values();
        return values[random.nextInt(values.length)];
    }

    public String getStatus() {
        return status;
    }
}
