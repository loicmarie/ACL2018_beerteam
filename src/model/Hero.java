package model;

public class Hero extends Entity {

    public void move(String direction){
        if (direction.equals("L")){
           this.position=new Position(this.position.getxPos()-1, this.position.getyPos());
        }
        if (direction.equals("R")){
            this.position=new Position(this.position.getxPos()+1, this.position.getyPos());
        }
        if (direction.equals("D")){
            this.position=new Position(this.position.getxPos(), this.position.getyPos()+1);
        }
        if (direction.equals("U")){
            this.position=new Position(this.position.getxPos(), this.position.getyPos()-1);
        }
        else{
            this.position=this.position;
        }
    }

    public Hero(int life, int strength){
        this.life=life;
        this.strength=strength;
        this.position=new Position(0,0); //pour l'instant, le héro commence en (0,0)
    }
}
