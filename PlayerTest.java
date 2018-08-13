import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import sprite.*;

public class PlayerTest {
	/**
	 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
	 */

	@Test
	public void testKey() {
		Player p = new Player();
		p.setKeyCount(2);
		assertEquals(2,p.getKeyCount());
	}

	@Test
	public void testKeytomany() {
		Player p = new Player();
		p.setKeyCount(4);
		assertEquals(null,p.getKeyCount());
	}

	@Test
	public void testKeyNegative() {
		Player p = new Player();
		p.setKeyCount(-1);
		assertEquals(null,p.getKeyCount());
	}

	@Test
    public void testArrayItems() {
		Player p = new Player();
	   	Sprite s = new Sprite();
	   	Location l = new Location();
	   	s.setName("smallpotion");
	   	l.setxCoord(30);
    	l.setyCoord(20);
		l.setxSize(0);
	   	l.setySize(0);
	   	s.setCoord(l);
	   	s.setExists(true);
	   	p.addItem(s);
	   	assertEquals("[Name: smallpotion, Coord: ((30, 20), (X Size: 0, Y Size: 0)), Image: null, Char:  , Text: null, Exists: true]",p.getCoord());
    }

	@Test
    public void testtoString() {
		Player p = new Player();
	   	Sprite s= new Sprite();
	   	Location l = new Location();
	   	l.setxCoord(30);
	   	l.setyCoord(20);
	   	l.setxSize(10);
		l.setySize(10);
	   	p.setHealth(200);
	   	p.setDefence(160);
	   	p.setAttack(150);
	   	p.setKeyCount(2);
	    p.addItem(s);
	   	p.setCoord(l);
	   	assertEquals("Name: , Coord: ((30, 20), (X Size: 10, Y Size: 10)), Image: null, Char:  , Text: null, Exists: true, Health: 200, Attack: 150, Defence: 160, Moves: null, Key Count: 2, Items: [Name: , Coord: ((0, 0), (X Size: 0, Y Size: 0)), Image: null, Char:  , Text: null, Exists: true]",p.toString());
	}
}
