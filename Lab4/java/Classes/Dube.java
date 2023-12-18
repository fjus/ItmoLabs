package Classes;

import Enums.Role;
import interfaces.ICanEarnALotOfMoney;
import interfaces.ICanSpeak;

public class Dube extends Billionaire implements ICanEarnALotOfMoney, ICanSpeak {


    public Dube(Role role, String name, int billions, String bredlamName, City city) throws ImpossibleRole {
        super(role, name, billions, bredlamName, city);
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
        Sector sector1 = new Sector("мебель", 100);
        System.out.println("Я зарабатываю, производя "+sector1.name+", мой доход: "+sector1.revenue+" миллионов пеннингов");
    }
    @Override
    public void speak() {
        System.out.println("Я Дубе");
    }

    @Override
    public String toString() {
        return "Dube{"+
                "name: "+super.getName()+" "+
                "wealth: "+super.getBillions()+" billions "+" "+
                "role: "+super.getRole()+" "+
                "bredlam: "+super.getBredlam()+" "+
                "city: "+super.getCity()+
                "}";
    }


}
