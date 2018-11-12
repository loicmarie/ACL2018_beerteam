package model;

import Develop.Cmd;

public class Hero extends Entity {

    public static void move(Cmd commandeEnCours){
    	int x = Entity.position.getxPos();
    	int y = Entity.position.getyPos();
    	switch(commandeEnCours) {
    		case UP:	 Entity.position.setyPos(y-1); break;
    		case RIGHT:	 Entity.position.setxPos(x+1); break;
    		case DOWN: Entity.position.setyPos(y+1); break;
    		case LEFT:	 Entity.position.setxPos(x-1); break;
        }
    }

    public Hero(int life, int strength){
        this.life=life;
        this.strength=strength;
        Entity.position=new Position(0,0); //pour l'instant, le héro commence en (0,0)
    }
}
