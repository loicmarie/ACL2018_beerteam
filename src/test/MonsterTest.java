import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.*;

public class MonsterTest {

    private Game game;

    @Before
    public void createHero() {
      this.game = new LabyrinthGame("resources/test/test2.txt");
    }

    @Test
    public void isMonster() {
      assertEquals(false, this.game.isMonster(2, 1));
      assertEquals(true, this.game.isMonster(3, 1));
    }

    @Test
    public void heroCollideMonsterDead() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(true, this.game.getHero().isDead());
    }

    @Test
    public void heroCollideMonsterEnd() {
      this.game.evolve(Cmd.RIGHT);
      assertEquals(true, this.game.isFinished());
    }

}
