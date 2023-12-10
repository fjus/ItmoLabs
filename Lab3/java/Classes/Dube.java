package Classes;

import Enums.Role;
import interfaces.ICanEarnALotOfMoney;
import interfaces.ICanSpeak;

public class Dube extends Billionaire implements ICanEarnALotOfMoney, ICanSpeak {


    public Dube(Role role, String name, int billions) {
        super(role, name, billions);
    }
    @Override
    public void earn() {
        System.out.println("Я зарабатываю, производя мебель");
    }
    @Override
    public void speak() {
        System.out.println("Я Дубе");
    }

    @Override
    public String toString() {
        return "Dube{"+
                "name: "+super.getName()+" "+
                "wealth: "+super.getBillions()+" billions"+" "+
                "role: "+super.getRole()+
                "}";
    }

}
