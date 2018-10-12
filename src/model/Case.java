package model;

public class Case {
    private int xPos;
    private int yPos;
    private boolean isWall;

    public Case(int x, int y, boolean w){
        xPos = x;
        yPos = y;
        isWall = w;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public boolean isWall(){
        return isWall;
    }
}
