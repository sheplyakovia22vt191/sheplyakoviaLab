package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
public class CreditAccount implements Entity{
    /** Id кредитного счета */
    private int id;

    /** Пользователь, за которым закреплен этот кредитный счет */
    private User user;

    /** Банк, где взят кредит */
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

    @Override
    public String toString() {
        return "CreditAccount {" +
                "id=" + id +
                ", creditStart=" + creditStart +
                ", creditEnd=" + creditEnd +
                ", creditMonthCount=" + creditMonthCount +
                ", creditAmount=" + creditAmount +
                ", monthPayment=" + monthPayment +
                ", interestRate=" + interestRate +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "CreditAccount";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAccount that = (CreditAccount) o;
        return id == that.id && creditMonthCount == that.creditMonthCount && creditAmount == that.creditAmount && monthPayment == that.monthPayment && interestRate == that.interestRate && Objects.equals(user, that.user) && Objects.equals(bank, that.bank) && Objects.equals(creditStart, that.creditStart) && Objects.equals(creditEnd, that.creditEnd) && Objects.equals(creditor, that.creditor) && Objects.equals(paymentAccount, that.paymentAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, bank, creditStart, creditEnd, creditMonthCount, creditAmount, monthPayment, interestRate, creditor, paymentAccount);
    }
}
