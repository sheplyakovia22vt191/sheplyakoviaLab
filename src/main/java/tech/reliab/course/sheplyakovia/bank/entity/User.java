package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Builder
public class User implements Entity{

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
    private ArrayList<Bank> banks;

    /** Кредитные счета */
    private ArrayList<CreditAccount> creditAccounts;

    /** Платежные счета */
    private ArrayList<PaymentAccount> paymentAccounts;

    /** Кредитный рейтинг для банка */
    private int rate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fcs=" + fcs +
                ", birthday=" + birthday +
                ", workPlace='" + workPlace + '\'' +
                ", income=" + income +
                ", banks=" + banks +
                ", creditAccounts=" + creditAccounts +
                ", paymentAccounts=" + paymentAccounts +
                ", rate=" + rate +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "User";
    }
}