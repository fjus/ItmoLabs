package Moves;

import ru.ifmo.se.pokemon.*;

public final class TakeDown extends PhysicalMove {
    public TakeDown(){
        super(Type.NORMAL, 90, 0.85, 0, 1);

    }
    public void applySelfDamage(Pokemon var1, double var2){
        var1.setMod(Stat.HP, ((int)Math.round(var2))/4);
    }

    protected String describe() {
        return "протаранил";
    }

}