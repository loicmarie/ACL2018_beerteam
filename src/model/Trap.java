package model;

public class Trap extends Case {
    private int damage;

    public Trap(int x, int y, boolean w, int d) {
        super(x, y, w);
        damage = d;
    }

    public int getDamage(){
        return damage;
    }
}
