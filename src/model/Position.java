package model;

public class Position {

    public int xPos;
    public int yPos;

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Position(int x, int y){
        this.xPos=x;
        this.yPos=y;
    }

    public String toString(){
        return "(" + Integer.toString(getxPos()) +","+ Integer.toString(getyPos()) +")";

    }
}
