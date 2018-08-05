package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Sprite.Location;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class LocationTest {

    @Test
    public void test_xCoordvalid() {
    	Location l = new Location() ;
    	l.setxCoord(20);
        assertEquals("input a valid xcoord",20,l.getxCoord());
    }
  
    
    @Test
    public void test_yCoordvalid() {
    	Location l = new Location() ;
    	l.setyCoord(20);
        assertEquals("input a valid xcoord",20,l.getyCoord());
    }

    
    
    @Test
    public void test_Xsizevalid() {
    	Location l = new Location() ;
    	l.setxCoord(20);
        assertEquals("input a valid xcoord",20,l.getxCoord());
    }

    
    @Test
    public void test_xSizesmall() {
    	Location l = new Location() ;
    	l.setxSize(1);
    	l.setxSize(-1);
        assertEquals("input a xcoordsize which is smaller than 0",1,l.getxCoord());
    }
   

    @Test
    public void test_ySizevalid() {
    	Location l = new Location() ;
    	l.setyCoord(20);
        assertEquals("input a valid xcoord",20,l.getyCoord());
    }

    
    @Test
    public void test_ySizesmall() {
    	Location l = new Location() ;
    	l.setySize(1);
    	l.setySize(-1);
        assertEquals("input a ycoordsize which is smaller than 0",1,l.getyCoord());
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
