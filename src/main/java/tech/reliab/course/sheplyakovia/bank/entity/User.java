package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class User {

    /** Id клиента */
    private long id;

    /** ФИО */
    private FCs fcs;

    /** Дата рождения */
    private Date birthday;

    /** Место работы */
    private String workPlace;

    /** Ежемесячный доход */
    private int income;

    /** Банки, которыми он пользуется */
    private Bank banks;

    /** Кредитные счета */
    private CreditAccount creditAccounts;

    /** Платежные счета */
    private PaymentAccount paymentAccounts;

    /** Кредитный рейтинг для банка */
    private int rate;
}