package model;

public class Hero extends Entity {

    public void move(Action action){
    	int x = this.position.getxPos();
    	int y = this.position.getyPos();
        System.out.println(action);
    	switch(action) {
    		case UP:	 this.position.setyPos(y-1); break;
    		case RIGHT:	 this.position.setxPos(x+1); break;
    		case BOTTOM: this.position.setyPos(y+1); break;
    		case LEFT:	 this.position.setxPos(x-1); break;
        }
    }

    public Hero(int life, int strength){
        this.life=life;
        this.strength=strength;
        this.position=new Position(0,0); //pour l'instant, le héro commence en (0,0)
    }
}
