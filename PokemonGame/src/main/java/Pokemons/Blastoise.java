package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Blastoise extends Wartortle {
    public Blastoise(String var1){
        super(var1, 49 );
        setStats(79, 83, 100, 85, 105, 78);
        setMove(new Magnitude(), new HydroPump());
        setType(Type.WATER);
    }
}