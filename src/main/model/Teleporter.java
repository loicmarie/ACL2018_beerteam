package model;

public class Teleporter extends Position {

    private int tX;
    private int tY;

    public Teleporter(int x, int y, int tX, int tY) {
        super(x, y);
        this.tX = tX;
        this.tY = tY;
    }

    public Position getNextPosition() {
      return new Position(this.tX, this.tY);
    }

}
