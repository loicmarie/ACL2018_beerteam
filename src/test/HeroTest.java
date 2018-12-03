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
      assertEquals(3, this.game.getHero().getX());
      assertEquals(3, this.game.getHero().getY());
    }

    @Test
    public void moveUp() {
      this.game.evolve(Cmd.UP);
      assertEquals(3, this.game.getHero().getX());
      assertEquals(2, this.game.getHero().getY());
    }

    @Test
    public void moveRight() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(4, this.game.getHero().getX());
      assertEquals(3, this.game.getHero().getY());
    }

    @Test
    public void moveBottom() {
      this.game.evolve(Cmd.DOWN);
      assertEquals(3, this.game.getHero().getX());
      assertEquals(4, this.game.getHero().getY());
    }

    @Test
    public void moveLeft() {
      this.game.evolve(Cmd.LEFT);
      assertEquals(2, this.game.getHero().getX());
      assertEquals(3, this.game.getHero().getY());
    }

    @Test
    public void moveRightTwice() {
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.RIGHT);
      assertEquals(5, this.game.getHero().getX());
      assertEquals(3, this.game.getHero().getY());
    }

    @Test
    public void moveRightAndBottom() {
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.DOWN);
      assertEquals(4, this.game.getHero().getX());
      assertEquals(4, this.game.getHero().getY());
    }

}
