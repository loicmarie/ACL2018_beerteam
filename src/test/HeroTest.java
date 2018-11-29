import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Hero;
import model.Cmd;

public class HeroTest {

    private Hero hero;

    @Before
    public void createHero() {
      this.hero = new Hero(1, 1);
    }

    @Test
    public void heroOnOriginPos() {
      assertEquals(this.hero.getX(), 1);
      assertEquals(this.hero.getY(), 1);
    }

    @Test
    public void moveUp() {
      this.hero.move(Cmd.UP);
      assertEquals(this.hero.getX(), 1);
      assertEquals(this.hero.getY(), 0);
    }

    @Test
    public void moveRight() {
      this.hero.move(Cmd.RIGHT);
      assertEquals(this.hero.getX(), 2);
      assertEquals(this.hero.getY(), 1);
    }

    @Test
    public void moveBottom() {
      this.hero.move(Cmd.DOWN);
      assertEquals(this.hero.getX(), 1);
      assertEquals(this.hero.getY(), 2);
    }

    @Test
    public void moveLeft() {
      this.hero.move(Cmd.LEFT);
      assertEquals(this.hero.getX(), 0);
      assertEquals(this.hero.getY(), 1);
    }

    @Test
    public void moveRightTwice() {
      this.hero.move(Cmd.RIGHT);
      this.hero.move(Cmd.RIGHT);
      assertEquals(this.hero.getX(), 3);
      assertEquals(this.hero.getY(), 1);
    }

    @Test
    public void moveRightAndBottom() {
      this.hero.move(Cmd.RIGHT);
      this.hero.move(Cmd.DOWN);
      assertEquals(this.hero.getX(), 2);
      assertEquals(this.hero.getY(), 2);
    }

}
