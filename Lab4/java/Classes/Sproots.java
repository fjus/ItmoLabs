package Classes;

import Enums.Role;
import interfaces.ICanEarnALotOfMoney;
import interfaces.ICanSpeak;

public class Sproots extends Billionaire implements ICanSpeak, ICanEarnALotOfMoney {

    public Sproots(Role role, String name, int billions, String bredlanName, City city) throws ImpossibleRole {
        super(role, name, billions, bredlanName, city);
    }

    @Override
    public String toString() {
        return "Sproots{"+
                "name: "+super.getName()+" "+
                "wealth: "+super.getBillions()+" billions"+" "+
                "role: "+super.getRole()+" "+
                "bredlam: "+super.getBredlam()+" "+
                "city: "+super.getCity()+
                "}";
    }

    @Override
    public void earn() {
        class Sector{
            Sector(String name, int revenue){
                this.name=name;
                this.revenue=revenue;
            }
            public String name;
            public int revenue;
        }
        Sector sector1 = new Sector("чай", 150);
        System.out.println("Я зарабатываю, производя "+sector1.name+", мой доход: "+sector1.revenue+" миллионов пеннингов");
    }

    @Override
    public void speak() {
        System.out.println("Я Спрутс");
    }
}
