import Classes.*;
import Enums.Role;
import interfaces.ICanEarnALotOfMoney;

import java.util.ArrayList;
import java.util.List;

public class Story {
    public static void main(String[] args) throws ImpossibleRole {
        try {
            MoonShortie.City city1 = new MoonShortie.City("Грабенберг", "Здесь живут богачи луны");
            MoonShortie.City city2 = new MoonShortie.City("Давилон", "Столица луны");
            MoonShortie.City city3 = new MoonShortie.City("Сан-Комарик", "Приморский город");
            Dube dube = new Dube(Role.VILLAIN, "Dube", 2, "Мебельный бредлам", city1);
            Sproots sproots = new Sproots(Role.VILLAIN, "Sproots", 5, "Тканевый бредлам", city1);
            Neznayka neznayka = new Neznayka(Role.HERO, "Neznayka");
            Julio julio = new Julio(Role.NEUTRAL_CHARACTER, "Julio", city2);
            Migo migo = new Migo(Role.NEUTRAL_CHARACTER, "Migo", city2);
            Kozlik kozlik = new Kozlik(Role.HERO, "Kozlik", city3);

            ICanEarnALotOfMoney earner1 = new ICanEarnALotOfMoney() {
                @Override
                public void earn() {
                    System.out.println("Я зарабатываю деньги, производя макароны");
                }
            };
            ICanEarnALotOfMoney earner2 = new ICanEarnALotOfMoney() {
                @Override
                public void earn() {
                    System.out.println("Я зарабатываю деньги, производя табак");
                }
            };


            System.out.println(dube);
            dube.speak();
            dube.earn();

            System.out.println(sproots);
            sproots.speak();
            sproots.earn();


            System.out.println(neznayka);
            neznayka.speak();

            System.out.println(kozlik);
            kozlik.speak();

            System.out.println(julio);
            julio.speak();

            System.out.println(migo);
            migo.speak();
        } catch (ImpossibleRole e){
            System.out.println("One of the character has impossible role");
            throw e;
        }

    }
    
}
