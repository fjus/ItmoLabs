import Classes.*;
import Enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Story {
    public static void main(String[] args) {
        Dube dube = new Dube(Role.VILLAIN, "Dube", 3);
        Sproots sproots1 = new Sproots(Role.VILLAIN, "Sproots", 5);
        Sproots sproots2 = new Sproots(Role.VILLAIN, "Dube", 3);
        Neznayka neznayka = new Neznayka(Role.HERO, "Neznayka");
        Julio julio = new Julio(Role.NEUTRAL_CHARACTER, "Julio");
        Migo migo = new Migo(Role.NEUTRAL_CHARACTER, "Migo");
        Kozlik kozlik = new Kozlik(Role.HERO, "Kozlik");

        System.out.println(dube);
        dube.speak();
        dube.earn();

        System.out.println(sproots1);
        sproots1.speak();
        sproots1.earn();

        System.out.println(dube.equals(sproots2));

        System.out.println(neznayka);
        neznayka.speak();

        System.out.println(kozlik);
        kozlik.speak();

        System.out.println(julio);
        julio.speak();

        System.out.println(migo);
        migo.speak();

    }
    
}
