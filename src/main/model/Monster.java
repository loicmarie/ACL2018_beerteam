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
      if (!game.isMonster(x, y-1) && !game.isWall(x, y-1) && !game.isTrap(x, y-1) && !game.isTeleporter(x, y-1)) cmds.add(Cmd.UP);
      if (!game.isMonster(x+1, y) && !game.isWall(x+1, y) && !game.isTrap(x+1, y) && !game.isTeleporter(x+1, y)) cmds.add(Cmd.RIGHT);
      if (!game.isMonster(x, y+1) && !game.isWall(x, y+1) && !game.isTrap(x, y+1) && !game.isTeleporter(x, y+1)) cmds.add(Cmd.DOWN);
      if (!game.isMonster(x-1, y) && !game.isWall(x-1, y) && !game.isTrap(x-1, y) && !game.isTeleporter(x-1, y)) cmds.add(Cmd.LEFT);

      Hero hero = game.getHero();
      ArrayList<Cmd> bestCmds = new ArrayList<Cmd>();
      for (Cmd cmd: cmds) {
        switch (cmd) {
          case UP:
            if (Math.abs((y-1)-hero.getY()) <= Math.abs(y-hero.getY()))
              bestCmds.add(cmd);
            break;
          case DOWN:
            if (Math.abs((y+1)-hero.getY()) <= Math.abs(y-hero.getY()))
              bestCmds.add(cmd);
            break;
          case LEFT:
            if (Math.abs((x-1)-hero.getX()) <= Math.abs(x-hero.getX()))
              bestCmds.add(cmd);
            break;
          case RIGHT:
            if (Math.abs((x+1)-hero.getX()) <= Math.abs(x-hero.getX()))
              bestCmds.add(cmd);
            break;
        }
      }
      Random randomGenerator = new Random();
      Cmd cmd;
      if (bestCmds.size() == 0) {
        int index = randomGenerator.nextInt(cmds.size());
        cmd = cmds.get(index);
      } else {
        int index = randomGenerator.nextInt(bestCmds.size());
        cmd = bestCmds.get(index);
      }
      return cmd;
    }

}
