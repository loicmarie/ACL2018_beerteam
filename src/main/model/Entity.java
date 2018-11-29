package model;

public abstract class Entity extends Position {

    private boolean isDead;

    public Entity(int x, int y){
    	super(x, y);
      this.isDead = false;
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

    public boolean isDead() {
      return this.isDead;
    }

    public void setDead() {
      this.isDead = true;
    }
}
