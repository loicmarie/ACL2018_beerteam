package model;

public class Trap extends Position {
    private int damage;

    public Trap(int x, int y, int d) {
        super(x, y);
        damage = d;
    }

    public int getDamage(){
        return damage;
    }
}
