package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Wartortle extends Squirtle {
    public Wartortle(String var1, int var2){
        super(var1, var2 );
        setStats(59, 63, 80, 65, 80, 58);
        setMove(new ThunderShock(), new ThunderWave());
        setType(Type.WATER);
    }
}