package model;

public abstract class Case {
    private boolean isWall;
    private Position position;

    public Case(Position pos, boolean w){
        position = pos;
        isWall = w;
    }

    public Position getPosition(){
        return position;
    }

    public boolean isWall(){
        return isWall;
    }
}
