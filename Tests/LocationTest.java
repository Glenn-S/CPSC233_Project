package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Sprite.Location;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class LocationTest {


		@Test
		public void test_xCoordnegative() {
			Location l = new Location() ;
			l.setxCoord(-1);
				assertEquals("input a valid xcoord",0,l.getxCoord());
		}
    @Test
    public void test_xCoordvalid() {
    	Location l = new Location() ;
    	l.setxCoord(20);
        assertEquals("input a valid xcoord",20,l.getxCoord());
    }

		@Test
    public void test_xCoordtoolarge() {
    	Location l = new Location() ;
    	l.setxCoord(81);
        assertEquals("input a valid xcoord",0,l.getxCoord());
    }

		@Test
    public void test_yCoordnegative() {
    	Location l = new Location() ;
    	l.setyCoord(-1);
        assertEquals("input a valid xcoord",0,l.getyCoord());
    }

    @Test
    public void test_yCoordvalid() {
    	Location l = new Location() ;
    	l.setyCoord(20);
        assertEquals("input a valid xcoord",20,l.getyCoord());
    }

		@Test
    public void test_yCoordtoolarge() {
    	Location l = new Location() ;
    	l.setyCoord(41);
        assertEquals("input a valid xcoord",0,l.getyCoord());
    }

		@Test
    public void test_Xsizenegative() {
    	Location l = new Location() ;
    	l.setxSize(-1);
        assertEquals("input a valid xcoord",0,l.getxSize());
    }

    @Test
    public void test_Xsize() {
    	Location l = new Location() ;
    	l.setxSize(20);
        assertEquals("input a valid xcoord",20,l.getxSize());
    }

		@Test
    public void test_ySizeNegative() {
    	Location l = new Location() ;
    	l.setySize(-1);
        assertEquals("input a valid xcoord",0,l.getySize());
    }

    @Test
    public void test_ySize() {
    	Location l = new Location() ;
    	l.setySize(20);
        assertEquals("input a valid xcoord",20,l.getySize());
    }

    @Test
    public void test_toString() {
    	Location l = new Location();
    	l.setxCoord(20);
    	l.setyCoord(30);
    	l.setxSize(100);
    	l.setySize(50);
        assertEquals("((20, 30), (X Size: 100, Y Size: 50))",l.toString());
    }
}
