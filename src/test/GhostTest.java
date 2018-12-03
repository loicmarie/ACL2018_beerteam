import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class GhostTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test3.txt");
    }

    @Test
    public void heroCollideGhostDead() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(true, this.game.getHero().isDead());
    }

    @Test
    public void heroCollideGhostEnd() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(true, this.game.isFinished());
    }

}
