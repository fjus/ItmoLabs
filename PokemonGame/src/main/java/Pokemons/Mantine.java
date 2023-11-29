package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Mantine extends Pokemon {
    public Mantine(String var1){
        super(var1, 48);
        setStats(85, 40, 70, 80, 140, 70);
        setMove(new ThunderShock(), new HydroPump());
        setType(Type.WATER, Type.FLYING);

    }
}