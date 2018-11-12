package model;

public class Hero extends Entity {

    public void move(Cmd commandeEnCours){
    	int x = this.position.getxPos();
    	int y = this.position.getyPos();
    	switch(commandeEnCours) {
    		case UP:	 this.position.setyPos(y-1); break;
    		case RIGHT:	 this.position.setxPos(x+1); break;
    		case DOWN: this.position.setyPos(y+1); break;
    		case LEFT:	 this.position.setxPos(x-1); break;
        }
    }

    public Hero(int life, int strength){
        super(life, new Position(0,0), strength); //pour l'instant, le héro commence en (0,0)
    }
}
