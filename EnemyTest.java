import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sprite.*;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */

public class EnemyTest {
	@Test
	public void testHasKey() {
		Enemy e = new Enemy();
		e.setKey(true);
		assertEquals(true,e.getKey());
	}

	@Test
	public void testDoesntHaveKey() {
		Enemy e = new Enemy();
		e.setKey(false);
		assertEquals(false,e.getKey());
	}

	@Test
	public void testAttack1() {
		Enemy e = new Enemy();

		e.setMoves(null);
		assertEquals(null, e.getMoves());
	}
}
