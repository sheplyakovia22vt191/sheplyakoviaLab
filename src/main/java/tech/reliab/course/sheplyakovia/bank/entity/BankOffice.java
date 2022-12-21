package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class BankOffice {
    /** Id банковского офиса */
    private long id;

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
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", status=" + status +
                ", placeAtmAvailable=" + placeAtmAvailable +
                ", bankAtms=" + bankAtms +
                ", creditAvailable=" + creditAvailable +
                ", extradition=" + extradition +
                ", introduction=" + introduction +
                ", moneyAmount=" + moneyAmount +
                ", rentCost=" + rentCost +
                ", bank=" + bank +
                '}';
    }
}
