package Classes;

import Enums.Role;
import interfaces.ICanEarnALotOfMoney;

public class DubeEarner extends Dube implements ICanEarnALotOfMoney {

    public DubeEarner(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public void earn() {
        System.out.println("Я зарабатываю, производя мебель");
    }
}
