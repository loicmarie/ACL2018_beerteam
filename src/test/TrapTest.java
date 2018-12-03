import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class TrapTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test5.txt");
    }

    @Test
    public void isTrap() {
      assertEquals(false, this.game.isTrap(2, 1));
      assertEquals(true, this.game.isTrap(3, 1));
    }

    @Test
    public void heroCollideTrapDead() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(false, this.game.getHero().isDead());
      this.game.evolve(Cmd.RIGHT);
      assertEquals(true, this.game.getHero().isDead());
    }

    @Test
    public void heroCollideTrapEnd() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(false, this.game.getHero().isDead());
      this.game.evolve(Cmd.RIGHT);
      assertEquals(true, this.game.isFinished());
    }

}
