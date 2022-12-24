package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@Builder
public class PaymentAccount implements Entity{
    /** Id платёжного счета */
    private int id;

    /** Пользователь, за которым закреплен этот платежный счет */
    private User user;

    /** Банк, в котором открыт этот счет */
    private Bank bank;

    /** Сумма, которая лежит в данный момент на счету */
    private int moneyAmount;

    @Override
    public String toString() {
        return "PaymentAccount {" +
                "id=" + id +
                ", moneyAmount=" + moneyAmount +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "PaymentAccount";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentAccount that = (PaymentAccount) o;
        return id == that.id && moneyAmount == that.moneyAmount && Objects.equals(user, that.user) && Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, bank, moneyAmount);
    }
}
