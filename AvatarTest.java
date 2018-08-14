import static org.junit.Assert.*;
import org.junit.Test;
import sprite.*;

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
        public void test_setAttackNegative() {
            Avatar a = new Avatar();

          	a.setAttack(-150);
            assertEquals(0, a.getAttack());
        }

        @Test
        public void test_setAttack() {
            Avatar a = new Avatar();
          	a.setAttack(150);
            assertEquals(150, a.getAttack());
        }

        @Test
        public void test_setUpdateHealth() {
            Avatar a = new Avatar();
          	Potion p = new Potion();
          	a.setHealth(200);
          	p.setHealthBoost(30);
          	a.updateHealth(p);
            assertEquals(230, a.getHealth());
        }

        @Test
        public void test_setUpdateDefence() {
          	Avatar a = new Avatar();
          	Defence d = new Defence();

            d.setDefenceBoost(30);
            a.updateDefence(d);
            assertEquals(55, a.getDefence());
        }

        @Test
        public void test_setUpdateAttack() {
            Avatar a = new Avatar();
          	Weapon w = new Weapon();

            w.setWeaponBoost(100);
          	a.updateAttack(w);
            assertEquals(125, a.getAttack());
        }

        @Test
        public void test_toString() {

            Avatar a = new Avatar("Eva",null, null,'+', null, true, false, 100, 100, 100, null);

            assertEquals("Name: Eva, Coord: null, Image: null, Char: +, Text: null, Exists: true, Health: 100, Attack: 100, Defence: 100, Moves: null", a.toString());
        }

}
