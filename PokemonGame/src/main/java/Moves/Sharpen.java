package Moves;

import ru.ifmo.se.pokemon.*;

public class Sharpen extends StatusMove {
    public Sharpen(){
        super(Type.NORMAL, 0, 1, 0, 1);
    }
    protected void applySelfEffects(Pokemon var1) {
        var1.setMod(Stat.ATTACK, 1);
    }
    protected String describe() {
        return "усиление";
    }

}