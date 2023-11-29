package Moves;

import ru.ifmo.se.pokemon.*;
public class HydroPump extends SpecialMove {
    public HydroPump(){
        super(Type.WATER, 110, 0.8, 0, 1);
    }
    protected String describe() {
        return "атаковал напором воды";
    }
}