package Classes;

import Enums.Role;
import interfaces.ICanEarnALotOfMoney;
import interfaces.ICanSpeak;

public class Sproots extends Billionaire implements ICanSpeak, ICanEarnALotOfMoney {

    public Sproots(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public String toString() {
        return "Sproots{"+
                "name: "+super.getName()+" "+
                "wealth: "+super.getBillions()+" billions "+" "+
                "role: "+super.getRole()+
                "}";
    }

    @Override
    public void earn() {
        System.out.println("Я зарабатываю, производя кофе, чай и ткани");
    }

    @Override
    public void speak() {
        System.out.println("Я Спрутс");
    }
}
