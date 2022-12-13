package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
public class CreditAccount {
    /** Id кредитного счета */
    private long id;

    /** Пользователь, за которым закреплен этот кредитный счет */
    private User user;

    /** Банка, где взят кредит */
    private Bank bank;

    /** Дата начала кредита */
    private LocalDate creditStart;

    /** Дата окончания кредита */
    private LocalDate creditEnd;

    /** Кол-во месяцев, на которые взят кредит */
    private int creditMonthCount;

    /** Сумма кредита */
    private long creditAmount;

    /** Ежемесячный платеж */
    private long monthPayment;

    /** Процентная ставка */
    private int interestRate;

    /** Сотрудник, который выдал кредит */
    private Employee creditor;

    /**
     * Платежный счет в банке с которого будет осуществляться погашение
     * данного кредита
     */
    private PaymentAccount paymentAccount;
}
