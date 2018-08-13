import static org.junit.Assert.*;
import org.junit.Test;
import sprite.*;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class SpriteTest {

    @Test
    public void test_setName() {
    	Sprite s = new Sprite();
    	s.setName("Chris");
    	assertEquals("Chris",s.getName());
    }

    @Test
    public void test_setCoord() {
    	Sprite s = new Sprite();
    	Location l = new Location();
    	l.setxCoord(20);
    	l.setyCoord(30);
    	l.setxSize(100);
    	l.setySize(50);
    	s.setCoord(l);
    	assertEquals("((20, 30), (X Size: 100, Y Size: 50))",s.getCoord().toString());
    }

    @Test
    public void test_setExistFalse() {
    	Sprite s = new Sprite();
    	s.setExists(false);
    	assertEquals(false,s.getExists());
    }

    @Test
    public void test_setExistTrue() {
    	Sprite s = new Sprite();
    	s.setExists(true);
    	assertEquals(true,s.getExists());
    }

    @Test
    public void test_toString() {
    	Sprite s = new Sprite();
    	Location l = new Location();
    	s.setName("Eva");
    	l.setxCoord(20);
    	l.setyCoord(30);
    	l.setxSize(100);
    	l.setySize(50);
    	s.setCoord(l);
    	s.setExists(true);
    	assertEquals("Name: Eva, Coord: ((20, 30), (X Size: 100, Y Size: 50)), Image: null, Char:  , Text: null, Exists: true",s.toString());
    }
}
