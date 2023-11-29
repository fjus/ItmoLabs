package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Lucario extends Rioulu {
    public Lucario(String var1){
        super(var1, 30 );
        setStats(70, 110, 70, 115, 70, 90);
        setMove(new ThunderShock(), new HydroPump(), new Sharpen());
        setType(Type.FIGHTING, Type.STEEL);
    }

}