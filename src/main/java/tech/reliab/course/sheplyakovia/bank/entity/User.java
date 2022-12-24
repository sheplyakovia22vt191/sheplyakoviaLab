package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
public class User implements Entity{

    /** Id клиента */
    private int id;

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
        return "User {" +
                "id= " + id +
                ", fcs= " + fcs +
                ", birthday= " + birthday +
                ", workPlace= " + workPlace + '\'' +
                ", income= " + income +
                ", banks count = " + banks.size() +
                ", creditAccounts count =" + creditAccounts.size() +
                ", paymentAccounts count=" + paymentAccounts.size() +
                ", rate=" + rate +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "User";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && income == user.income && rate == user.rate && Objects.equals(fcs, user.fcs) && Objects.equals(birthday, user.birthday) && Objects.equals(workPlace, user.workPlace) && Objects.equals(banks, user.banks) && Objects.equals(creditAccounts, user.creditAccounts) && Objects.equals(paymentAccounts, user.paymentAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fcs, birthday, workPlace, income, banks, creditAccounts, paymentAccounts, rate);
    }
}