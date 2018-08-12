package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import sprite.Location;
import sprite.Avatar;
import sprite.Defence;
import sprite.Potion;
import sprite.Weapon;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class AvatarTest {

    @Test
    public void test_constructor(){
        Avatar a = new Avatar();
        Location l = new Location();
        a.setName("Eva");
        a.setExists(true);
        l.setxCoord(20);
        l.setyCoord(30);
        l.setxSize(100);
        l.setySize(50);
        a.setCoord(l);
        assertEquals("Eva",a.getName());
        assertEquals(true,a.getExists());
        assertEquals("((20, 30), (X Size: 100, Y Size: 50))",a.getCoord().toString());
    }

    @Test
    public void test_setHealthNegative() {
        Avatar a = new Avatar();
        a.setHealth(-100);
        assertEquals(0, a.getHealth());
    }

    @Test
    public void test_setHealth() {
        Avatar a = new Avatar();
        a.setHealth(200);
        assertEquals(200, a.getHealth());
    }

    @Test
    public void test_setDefenceNegative() {
      	Avatar a = new Avatar();
        a.setDefence(-100);
        assertEquals(0, a.getDefence());
    }

    @Test
    public void test_setDefence() {
      	Avatar a = new Avatar();
        a.setDefence(100);
        assertEquals(100, a.getDefence());
    }

    @Test
    public void test_setattackNegative() {
        Avatar a = new Avatar();
      	a.setAttack(-150);
        assertEquals(0, a.getAttack());
    }

    @Test
    public void test_setattack() {
        Avatar a = new Avatar();
      	a.setAttack(150);
        assertEquals(150, a.getAttack());
    }

    @Test
    public void test_setupdateHealth() {
        Avatar a = new Avatar();
      	Potion p = new Potion();
      	a.setHealth(200);
      	p.setHealthBoost(30);
      	a.updateHealth(p);
        assertEquals(230, a.getHealth());
    }

    @Test
    public void test_setupdatedefence() {
      	Avatar a = new Avatar();
      	Defence d = new Defence();
      	a.setDefence(130);
        d.setDefenceBoost(30);
        a.updateDefence(d);
        assertEquals(160, a.getDefence());
    }

    @Test
    public void test_setupdateattack() {
        Avatar a = new Avatar();
      	Weapon w = new Weapon();
      	a.setAttack(150);
        w.setWeaponBoost(100);
      	a.updateAttack(w);
        assertEquals(250, a.getAttack());
    }

    @Test
    public void test_toString() {
        Avatar a = new Avatar();
      	Defence d = new Defence();
      	Location l = new Location();
        d.setDefenceBoost(30);
      	a.setName("Eva");
      	a.setExists(true);
        l.setxCoord(20);
      	l.setyCoord(30);
      	l.setxSize(100);
        l.setySize(50);
      	a.setCoord(l);
      	a.setHealth(200);
        a.setAttack(150);
      	a.setDefence(130);
      	a.updateDefence(d);
        assertEquals("Name: Eva, Coord: ((20, 30), (X Size: 100, Y Size: 50)), Image: null, Char:  , Text: null, Exists: true, Health: 200, Attack: 150, Defence: 160, Moves: null", a.toString());
    }
}
