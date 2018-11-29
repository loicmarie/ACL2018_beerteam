package model;

public class Magic extends Position {

    private int effect;

    public Magic(int x, int y, int e) {
        super(x, y);
        effect = e;
    }

    public int getEffect(){
        return effect;
    }
    
}
