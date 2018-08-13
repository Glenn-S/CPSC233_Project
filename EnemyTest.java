import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sprite.*;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */

public class EnemyTest {
	@Test
	public void testhaskey() {
		Enemy e = new Enemy();
		e.setKey(true);
		assertEquals(true,e.getKey());
	}

	@Test
	public void testdoesnthavekey() {
		Enemy e = new Enemy();
		e.setKey(false);
		assertEquals(false,e.getKey());
	}

	@Test
	public void testAttack1() {
		Enemy e = new Enemy();
		e.setHealth(35);
		String[] moves = {"a","b","c","d"};
		e.setMoves(moves);
		assertEquals("b" , e.getMoves());
	}
}
