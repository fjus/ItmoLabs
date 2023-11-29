package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Goldeen extends Pokemon {
    public Goldeen(String var1){
        super(var1, 45 );
        setStats(45, 67, 60, 35, 50, 63);
        setMove(new JumpKick(), new TakeDown(), new MegaHorn(), new ThunderWave());
        setType(Type.WATER);
    }

}
