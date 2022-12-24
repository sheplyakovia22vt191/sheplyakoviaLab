package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;

@Getter
@Setter
@Builder
public class BankAtm implements Entity{
    /** Id банкомата */
    private int id;

    /** Имя банкомата */
    private String name;

    /** Адрес */
    private Address address;

    /** Статус */
    private WorkStatus status;

    /** Банк, которому принадлежит банкомат */
    private Bank bank;

    /** Расположение банкомата */
    private Address location;

    /** Обслуживающий сотрудник */
    private Employee servingEmployee;

    /** Работает ли на выдачу денег? */
    private boolean extradition;

    /** Можно ли внести деньги? */
    private boolean introduction;

    /** Кол-во денег в банкомате */
    private long moneyAmount;

    /** Стоимость обслуживания банкомата */
    private int maintenanceCost;

    @Override
    public String toString() {
        return "BankAtm {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", status=" + status +
                ", bank=" + bank.getName() +
                ", location=" + location +
                ", servingEmployee=" + servingEmployee +
                ", extradition=" + extradition +
                ", introduction=" + introduction +
                ", moneyAmount=" + moneyAmount +
                ", maintenanceCost=" + maintenanceCost +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "BankAtm";
    }
}
