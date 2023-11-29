import Pokemons.*;
import ru.ifmo.se.pokemon.Battle;



public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Goldeen p1 = new Goldeen("Голдин1");
        Mantine p2 = new Mantine("Мантин1");
        Victebel p3 = new Victebel("Виктебел1");
        Blastoise p4 = new Blastoise("Бластойс1");
        Wartortle p5 = new Wartortle("Вартертл1", 45);
        Lucario p6 = new Lucario("Лукарио1");
        b.addAlly(p1);
        b.addAlly(p3);
        b.addAlly(p5);
        b.addFoe(p2);
        b.addFoe(p4);
        b.addFoe(p6);
        b.go();
    }

}
