package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PaymentAccount {
    /** Id платёжного счета */
    private long id;

    /** Пользователь, за которым закреплен этот платежный счет */
    private User user;

    /** Банк, в котором открыт этот счет */
    private Bank bank;

    /** Сумма, которая лежит в данный момент на счету */
    private int moneyAmount;
}
