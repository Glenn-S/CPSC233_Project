package Tests;

import static org.junit.Assert.assertEquals;
import Terminal.BattleLoop;
import Sprite.Enemy;
import Sprite.Player;
import org.junit.Test;
/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class BattleLoopTest {

	@Test
	public void testEuseParry() {
		BattleLoop b = new BattleLoop();
		b.setEnemyUsedParry(true);
	assertEquals(true,b.getEnemyUsedParry());
	}
	
	@Test
	public void testENotuseParry() {
		BattleLoop b = new BattleLoop();
		b.setEnemyUsedParry(false);
	assertEquals(false,b.getEnemyUsedParry());
	}
	
	@Test
	public void testPuseParry() {
		BattleLoop b = new BattleLoop();
		b.setUsedParry(true);
	assertEquals(true,b.getUsedParry());
	}
	
	@Test
	public void testPNotuseParry() {
		BattleLoop b = new BattleLoop();
		b.setUsedParry(false);
	assertEquals(false,b.getUsedParry());
	}
	
	@Test
	public void testWinstateF() {
		BattleLoop b = new BattleLoop();
		Enemy e = new Enemy();
		e.setHealth(20);
	assertEquals(false,b.checkWinState(e));
	}
	
	@Test
	public void testWinstateT() {
		BattleLoop b = new BattleLoop();
		Enemy e = new Enemy();
		e.setHealth(0);
	assertEquals(true,b.checkWinState(e));
	}
	
	@Test
	public void testLoseStateF() {
		BattleLoop b = new BattleLoop();
		Player p = new Player();
		p.setHealth(20);
	assertEquals(false,b.checkLoseState(p));
	}
	
	@Test
	public void testLoseStateT() {
		BattleLoop b = new BattleLoop();
		Player p = new Player();
		p.setHealth(0);
	assertEquals(true,b.checkLoseState(p));
	}
}
