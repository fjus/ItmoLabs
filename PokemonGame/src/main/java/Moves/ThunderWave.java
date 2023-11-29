package Moves;

import ru.ifmo.se.pokemon.*;

public class ThunderWave extends StatusMove {
    public ThunderWave(){
        super(Type.ELECTRIC, 0, 1, 0, 1);
    }
    protected void applyOppEffects(Pokemon var1){
        if (!var1.hasType(Type.ELECTRIC)) {
            Effect e = new Effect().chance(1).condition(Status.PARALYZE).attack(0.75).turns(-1);
            e.stat(Stat.SPEED, -2);
            var1.setCondition(e);
        }
    }
    protected String describe() {
        return "использовал грозовую волну";
    }

}
