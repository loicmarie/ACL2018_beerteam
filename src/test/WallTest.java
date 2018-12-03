import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class WallTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test1.txt");
    }

    @Test
    public void isWall() {
      assertEquals(false, this.game.isWall(1, 1));
      assertEquals(true, this.game.isWall(0, 0));
    }

    @Test
    public void moveToWallUp() {
      this.game.evolve(Cmd.UP);
      this.game.evolve(Cmd.UP);
      this.game.evolve(Cmd.UP);
      assertEquals(3, this.game.getHero().getX());
      assertEquals(1, this.game.getHero().getY());
    }

    @Test
    public void moveToWallRight() {
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.RIGHT);
      assertEquals(5, this.game.getHero().getX());
      assertEquals(3, this.game.getHero().getY());
    }

    @Test
    public void moveToWallBottom() {
      this.game.evolve(Cmd.DOWN);
      this.game.evolve(Cmd.DOWN);
      this.game.evolve(Cmd.DOWN);
      assertEquals(3, this.game.getHero().getX());
      assertEquals(5, this.game.getHero().getY());
    }

    @Test
    public void moveToWallLeft() {
      this.game.evolve(Cmd.LEFT);
      this.game.evolve(Cmd.LEFT);
      this.game.evolve(Cmd.LEFT);
      assertEquals(1, this.game.getHero().getX());
      assertEquals(3, this.game.getHero().getY());
    }

}
