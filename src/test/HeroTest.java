import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Hero;
import model.Action;

public class HeroTest {

    private Hero hero;

    @Before
    public void createHero() {
      this.hero = new Hero(1, 1);
    }

    @Test
    public void heroOnOriginPos() {
      assertEquals(this.hero.position.getxPos(), 0);
      assertEquals(this.hero.position.getyPos(), 0);
    }

    @Test
    public void moveUp() {
      this.hero.move(Action.UP);
      assertEquals(this.hero.position.getxPos(), 0);
      assertEquals(this.hero.position.getyPos(), -1);
    }

    @Test
    public void moveRight() {
      this.hero.move(Action.RIGHT);
      assertEquals(this.hero.position.getxPos(), 1);
      assertEquals(this.hero.position.getyPos(), 0);
    }

    @Test
    public void moveBottom() {
      this.hero.move(Action.BOTTOM);
      assertEquals(this.hero.position.getxPos(), 0);
      assertEquals(this.hero.position.getyPos(), 1);
    }

    @Test
    public void moveLeft() {
      this.hero.move(Action.LEFT);
      assertEquals(this.hero.position.getxPos(), -1);
      assertEquals(this.hero.position.getyPos(), 0);
    }

    @Test
    public void moveRightTwice() {
      this.hero.move(Action.RIGHT);
      this.hero.move(Action.RIGHT);
      assertEquals(this.hero.position.getxPos(), 2);
      assertEquals(this.hero.position.getyPos(), 0);
    }

    @Test
    public void moveRightAndBottom() {
      this.hero.move(Action.RIGHT);
      this.hero.move(Action.BOTTOM);
      assertEquals(this.hero.position.getxPos(), 1);
      assertEquals(this.hero.position.getyPos(), 1);
    }

}
