package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Victebel extends Weepinbell {
    public Victebel(String var1){
        super(var1, 1 );
        setStats(80, 105, 65, 100, 70, 70);
        setMove(new LovelyKiss(), new ThunderWave());
        setType(Type.GRASS, Type.POISON);
    }
}
