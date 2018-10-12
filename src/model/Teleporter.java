package model;

public class Teleporter extends Case{
    private Position teleportPosition;

    public Teleporter(Position position, boolean w, int tX, int tY) {
        super(position, w);
        position = teleportPosition;
    }

    private Position getTeleportPosition(){
        return teleportPosition;
    }
}
