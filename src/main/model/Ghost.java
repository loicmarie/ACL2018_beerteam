package model;

import java.util.Random;
import java.util.ArrayList;

public class Ghost extends Monster {

    public Ghost(int x, int y) {
      super(x, y);
    }

    public Cmd getMove(Game game) {
      int x = this.getX(),
          y = this.getY();
      ArrayList<Cmd> cmds = new ArrayList<Cmd>();
      if (!game.isTrap(x, y-1) && !game.isTeleporter(x, y-1) && y > 0) cmds.add(Cmd.UP);
      if (!game.isTrap(x+1, y) && !game.isTeleporter(x+1, y) && x < game.getWidth()-2) cmds.add(Cmd.RIGHT);
      if (!game.isTrap(x, y+1) && !game.isTeleporter(x, y+1) && y < game.getHeight()-2) cmds.add(Cmd.DOWN);
      if (!game.isTrap(x-1, y) && !game.isTeleporter(x-1, y) && x > 0) cmds.add(Cmd.LEFT);
      Random randomGenerator = new Random();
      int index = randomGenerator.nextInt(cmds.size());
      return cmds.get(index);
    }

}
