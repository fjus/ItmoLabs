package Moves;

import ru.ifmo.se.pokemon.*;

public class ThunderShock extends SpecialMove {
    public ThunderShock(){
        super(Type.ELECTRIC, 40, 1, 0, 1);
    }
    protected void applyOppDamage(Pokemon var1, double var2){
        if (!var1.hasType(Type.ELECTRIC)) {
            Effect e = new Effect().chance(0.1).condition(Status.PARALYZE).attack(0.75).turns(-1);
            e.stat(Stat.SPEED, -2);
            var1.setCondition(e);

        }
        var1.setMod(Stat.HP, (int)Math.round(var2));
    }
    protected String describe() {
        return "шокировал";
    }

}