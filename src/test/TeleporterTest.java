import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class TeleporterTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test4.txt");
    }

    @Test
    public void isTeleporter() {
      assertEquals(true, this.game.isTeleporter(2, 1));
      assertEquals(false, this.game.isTeleporter(3, 1));
      assertEquals(true, this.game.isTeleporter(4, 1));
    }

    @Test
    public void heroCollideTeleporter() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(4, this.game.getHero().getX());
      assertEquals(1, this.game.getHero().getY());
    }

    @Test
    public void heroCollideTwoTeleporters() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(4, this.game.getHero().getX());
      assertEquals(1, this.game.getHero().getY());
      this.game.evolve(Cmd.RIGHT);
      this.game.evolve(Cmd.LEFT);
      assertEquals(2, this.game.getHero().getX());
      assertEquals(1, this.game.getHero().getY());
    }

}
