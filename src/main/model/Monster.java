package model;

import java.util.Random;
import java.util.ArrayList;

public class Monster extends Entity {

    public Monster(int x, int y) {
      super(x, y);
    }

    public Cmd getMove(Game game) {
      int x = this.getX(),
          y = this.getY();
      ArrayList<Cmd> cmds = new ArrayList<Cmd>();
      if (!game.isWall(x, y-1) && !game.isTrap(x, y-1)) cmds.add(Cmd.UP);
      if (!game.isWall(x+1, y) && !game.isTrap(x+1, y)) cmds.add(Cmd.RIGHT);
      if (!game.isWall(x, y+1) && !game.isTrap(x, y+1)) cmds.add(Cmd.DOWN);
      if (!game.isWall(x-1, y) && !game.isTrap(x-1, y)) cmds.add(Cmd.LEFT);
      Random randomGenerator = new Random();
      int index = randomGenerator.nextInt(cmds.size());
      return cmds.get(index);
    }

}
