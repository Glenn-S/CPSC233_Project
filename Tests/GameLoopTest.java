package Tests;

import static org.junit.Assert.*;


import org.junit.Test;

import Sprite.Enemy;
import Sprite.Player;
import Sprite.Location;
import Terminal.GameLoop;
/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoopTest {

    @Test
    public void testcheckenemy() {
    	GameLoop g = new GameLoop();
    	Enemy e = new Enemy();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	e.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(10);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(15);
    	l1.setxSize(10);
    	l1.setyCoord(25);
    	l1.setySize(10);
    	p.setCoord(l2);
        assertEquals();
    }
}
