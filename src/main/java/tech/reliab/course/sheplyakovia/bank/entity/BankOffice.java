package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@Builder
public class BankOffice implements Entity{
    /** Id банковского офиса */
    private int id;

    /** Название офиса */
    private String name;

    /** Адрес банковского офиса */
    private Address address;

    /** Статус */
    private WorkStatus status;

    /** Можно ли разместить банкомат? */
    private boolean placeAtmAvailable;

    /** Банкоматы */
    private ArrayList<BankAtm> bankAtms;



    /** Можно ли оформить кредит в данном офисе? */
    private boolean creditAvailable;

    /** Работает ли на выдачу денег? */
    private boolean extradition;

    /** Можно ли внести деньги? */
    private boolean introduction;

    /** Кол-во денег в банковском офисе */
    private long moneyAmount;

    /** Стоимость аренды банковского офиса */
    private int rentCost;

    /** Банк */
    private Bank bank;

    @Override
    public String toString() {
        return "BankOffice {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bank=" + bank.getName() +
                ", address=" + address +
                ", status=" + status +
                ", placeAtmAvailable=" + placeAtmAvailable +
                ", bankAtms count = " + bankAtms.size() +
                ", creditAvailable=" + creditAvailable +
                ", extradition=" + extradition +
                ", introduction=" + introduction +
                ", moneyAmount=" + moneyAmount +
                ", rentCost=" + rentCost +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "BankOffice";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankOffice that = (BankOffice) o;
        return id == that.id && placeAtmAvailable == that.placeAtmAvailable && creditAvailable == that.creditAvailable && extradition == that.extradition && introduction == that.introduction && moneyAmount == that.moneyAmount && rentCost == that.rentCost && Objects.equals(name, that.name) && Objects.equals(address, that.address) && status == that.status && Objects.equals(bankAtms, that.bankAtms) && Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, status, placeAtmAvailable, bankAtms, creditAvailable, extradition, introduction, moneyAmount, rentCost, bank);
    }
}
