package Moves;


import ru.ifmo.se.pokemon.*;

public class JumpKick extends PhysicalMove {
    public JumpKick(){
        super(Type.FIGHTING, 100, 0.95, 0, 1);

    }
    public void applySelfDamage(Pokemon var1, double var2){
        var1.setMod(Stat.HP, ((int)(var1.getStat(Stat.HP)))/2);
    }
    protected String describe() {
        return "ударил в прыжке";
    }

}
