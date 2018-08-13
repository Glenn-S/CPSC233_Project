import static org.junit.Assert.*;
import org.junit.Test;
import sprite.*;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class DefenseTest {

    @Test
    public void testName() {
    	Defence d = new Defence();
    	d.setName("smallpotion");
    	assertEquals("smallpotion", d.getName());
    }

    @Test
    public void testDef() {
    	Defence d = new Defence();
    	d.setDefenceBoost(20);
    	assertEquals(20, d.getDefenceBoost());
    }

    @Test
    public void test_toString() {
    	Defence d = new Defence();
    	Location l = new Location();
    	l.setxCoord(20);
    	l.setyCoord(30);
    	l.setxSize(0);
    	l.setySize(0);
    	d.setCoord(l);
    	d.setExists(true);
    	d.setName("smallpotion");
    	d.setDefenceBoost(20);
    	assertEquals("Name: smallpotion, Coord: ((20, 30), (X Size: 0, Y Size: 0)), Image: null, Char:  , Text: null, Exists: true, Defence Boost: 20",d.toString());
    }

}
