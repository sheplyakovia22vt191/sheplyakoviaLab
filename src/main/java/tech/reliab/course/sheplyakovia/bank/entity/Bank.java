package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Bank {
    /** Id банка */
    private long id;

    /** Имя банка */
    private String name;

    /** Кол-во офисов */
    private int officeCount;

    /** Кол-во банкоматов */
    private int atmCount;

    /** Кол-во сотрудников */
    private int employeeCount;

    /** Кол-во клиентов */
    private int clientCount;

    /** Рейтинг банка */
    private int rate; //

    /** Всего денег в банке */
    private long moneyAmount;

    /** Процентная ставка */
    private int interestRate;
}