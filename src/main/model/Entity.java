package model;

public abstract class Entity extends Position {

    public int life;
    public int strength;

    public Entity(int x, int y, int life, int strength){
    	super(x, y);
        this.life=life;
        this.strength=strength;
    }

    public void move(Cmd commandeEnCours){
    	int x = this.getX();
    	int y = this.getY();
    	switch(commandeEnCours) {
    		case UP:	 this.setY(y-1); break;
    		case RIGHT:	 this.setX(x+1); break;
    		case DOWN:   this.setY(y+1); break;
    		case LEFT:	 this.setX(x-1); break;
        }
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
