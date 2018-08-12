package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import sprite.Location;
import sprite.Potion;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class PotionTest {

	@Test
    public void testName() {
    	Potion p = new Potion();
    	p.setName("smallpotion");
        assertEquals("smallpotion", p.getName());
    }

    @Test
    public void testDef() {
    	Potion p = new Potion();
    	p.setHealthBoost(40);
        assertEquals(40, p.getHealthBoost());
    }

    @Test
    public void test_toString() {
    	Potion p = new Potion();
    	Location l = new Location();
    	l.setxCoord(20);
    	l.setyCoord(30);
    	l.setxSize(0);
    	l.setySize(0);
    	p.setCoord(l);
    	p.setExists(true);
    	p.setName("smallpotion");
    	p.setHealthBoost(40);;
    	assertEquals("Name: smallpotion, Coord: ((20, 30), (X Size: 0, Y Size: 0)), Image: null, Char:  , Text: null, Exists: true, Health Boost: 40",p.toString());
    }
}
