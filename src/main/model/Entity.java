package model;

public abstract class Entity{

    public int life;
    public static Position position;
    public int strength;

    public Entity(int life, Position pos, int strength){
        this.life=life;
        this.strength=strength;
        Entity.position=pos;
    }

    public Entity(){}

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public Position getPosition() {
        return position;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setPosition(Position position) {
        Entity.position = position;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}