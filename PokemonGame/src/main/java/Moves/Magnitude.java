package Moves;

import ru.ifmo.se.pokemon.*;


public class Magnitude extends PhysicalMove {
    public Magnitude(){
        super(Type.GROUND, (int)((Math.random()*140)+10), 1, 0, 1);
    }
    protected String describe() {
        return "земная дрожь";
    }
}



