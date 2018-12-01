import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class HeroTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test1.txt");
    }

    @Test
    public void heroOnOriginPos() {
      assertEquals(this.game.getHero().getX(), 3);
      assertEquals(this.game.getHero().getY(), 3);
    }

    @Test
    public void moveUp() {
      this.game.evolve(Cmd.UP);
      assertEquals(this.game.getHero().getX(), 3);
      assertEquals(this.game.getHero().getY(), 2);
    }

    @Test
    public void moveRight() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(this.game.getHero().getX(), 4);
      assertEquals(this.game.getHero().getY(), 3);
    }

    @Test
    public void moveBottom() {
      this.game.evolve(Cmd.DOWN);
      assertEquals(this.game.getHero().getX(), 3);
      assertEquals(this.game.getHero().getY(), 4);
    }

    @Test
    public void moveLeft() {
      this.game.evolve(Cmd.LEFT);
      assertEquals(this.game.getHero().getX(), 2);
      assertEquals(this.game.getHero().getY(), 3);
    }

    @Test
    public void moveRightTwice() {
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.RIGHT);
      assertEquals(this.game.getHero().getX(), 5);
      assertEquals(this.game.getHero().getY(), 3);
    }

    @Test
    public void moveRightAndBottom() {
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.DOWN);
      assertEquals(this.game.getHero().getX(), 4);
      assertEquals(this.game.getHero().getY(), 4);
    }

}
