package model;

public class Teleporter extends Case{
    private int teleportX;
    private int teleportY;

    public Teleporter(int x, int y, boolean w, int tX, int tY) {
        super(x, y, w);
        teleportX = tX;
        teleportY = tY;
    }

    private int getTeleportX(){
        return teleportX;
    }

    private int getTeleportY(){
        return teleportY;
    }
}
