import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import sprite.*;

public class PlayerTest {
	/**
	 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
	 */

	@Test
	public void test_key() {
		Player p = new Player();
		p.setKeyCount(2);
		assertEquals(2,p.getKeyCount());
	}

	@Test
	public void test_KeyNegative() {
		Player p = new Player();
		p.setKeyCount(-1);
		assertEquals(0,p.getKeyCount());
	}

	@Test
    public void test_ArrayItems() {
		Player p = new Player();
		Sprite n = new Sprite();

		 	ArrayList<Sprite> list = new ArrayList<Sprite>();

			list.add(n);
			p.setItems(list);

	   	assertEquals(list,p.getItems());
    }

	@Test
    public void test_toString() {
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
