package model;

public class Position {

    public int x;
    public int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int xPos) {
        this.x = xPos;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        return "(" + Integer.toString(x) +","+ Integer.toString(y) +")";

    }
}
