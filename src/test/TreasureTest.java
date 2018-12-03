import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class TreasureTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test6.txt");
    }

    @Test
    public void isTreasure() {
      assertEquals(false, this.game.isTreasure(2, 1));
      assertEquals(true, this.game.isTreasure(3, 1));
    }

    @Test
    public void heroCollideTreasure() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(false, this.game.getHero().isDead());
      assertEquals(false, this.game.isFinished());
      this.game.evolve(Cmd.RIGHT);
      assertEquals(false, this.game.getHero().isDead());
      assertEquals(true, this.game.isFinished());
    }

}
