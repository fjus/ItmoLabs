package Moves;

import ru.ifmo.se.pokemon.*;

public class MegaHorn extends PhysicalMove {
    public MegaHorn(){
        super(Type.BUG, 120, 0.85, 0, 1);
    }
    protected String describe(){
        return "насадил на рог";
    }
}
