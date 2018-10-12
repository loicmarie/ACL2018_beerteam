package model;

public class Hero extends Entity {

    public Position move(String direction){
        if (direction=="L"){
            return new Position(this.position.getxPos()-1, this.position.getyPos());
        }
        if (direction=="R"){
            return new Position(this.position.getxPos()+1, this.position.getyPos());
        }
        if (direction=="D"){
            return new Position(this.position.getxPos(), this.position.getyPos()-1);
        }
        if (direction=="U"){
            return new Position(this.position.getxPos(), this.position.getyPos()+1);
        }
        else{
            return this.position;
        }
    }

    public Hero(int life, int strength){
        this.life=life;
        this.strength=strength;
        this.position=new Position(0,0); //pour l'instant, le héro commence en (0,0)
    }
}
