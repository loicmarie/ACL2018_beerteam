package model;

public class Trap extends Case {
    private int damage;

    public Trap(Position pos, boolean w, int d) {
        super(pos, w);
        damage = d;
    }

    public int getDamage(){
        return damage;
    }
}
