package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import sprite.Location;
import sprite.Weapon;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class WeaponTest {

	@Test
	public void testName() {
	   	Weapon w = new Weapon();
	   	w.setName("silversword");
	   	assertEquals("silversword", w.getName());
	}

	@Test
	public void testDef() {
		Weapon w = new Weapon();
	   	w.setWeaponBoost(40);
	   	assertEquals(40, w.getWeaponBoost());
	}

	@Test
	public void test_toString() {
	    Weapon w = new Weapon();
	   	Location l = new Location();
	   	l.setxCoord(20);
	   	l.setyCoord(30);
	   	l.setxSize(0);
	   	l.setySize(0);
	   	w.setCoord(l);
	   	w.setExists(true);
	   	w.setName("silversword");
	   	w.setWeaponBoost(40);
    	assertEquals("Name: silversword, Coord: ((20, 30), (X Size: 0, Y Size: 0)), Image: null, Char:  , Text: null, Exists: true, Weapon Boost: 40",w.toString());
    }
}
