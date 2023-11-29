package Classes;

import Enums.Role;
import interfaces.ICanEarnALotOfMoney;

public class SprootsEarner extends Sproots implements ICanEarnALotOfMoney {
    public SprootsEarner(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public void earn() {
        System.out.println("Я зарабатываю, производя кофе, чай и ткани");
    }
}
