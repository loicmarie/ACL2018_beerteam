package model;

public class Magic extends Case{
    private int effect;

    public Magic(int x, int y, boolean w, int e) {
        super(x, y, w);
        effect = e;
    }

    public int getEffect(){
        return effect;
    }
}
