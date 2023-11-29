package Moves;

import ru.ifmo.se.pokemon.*;

public class LovelyKiss extends StatusMove {
    public LovelyKiss(){
        super(Type.NORMAL, 0, 0.75, 0, 1);
    }
    protected void applyOppEffects(Pokemon var1) {
        Effect.sleep(var1);
    }
    protected String describe() {
        return "зацеловал до смерти";
    }

}
