package model;

public class Magic extends Case{
    private int effect;

    public Magic(Position position, boolean w, int e) {
        super(position, w);
        effect = e;
    }

    public int getEffect(){
        return effect;
    }
}
