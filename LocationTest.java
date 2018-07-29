import static org.junit.Assert.*;
import org.junit.Test;

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
    public void test_xCoordsmall() {
    	Location l = new Location() ;
    	l.setxCoord(1);
    	l.setxCoord(-1);
        assertEquals("input a xcoord which is smaller than 0",1,l.getxCoord());
    }
    
    @Test
    public void test_xCoordlarge() {
    	Location l = new Location() ;
    	l.setxCoord(30);
    	l.setxCoord(84);
        assertEquals("input a xcoord which is bigger than 80",30,l.getxCoord());
    }
    
    @Test
    public void test_yCoordvalid() {
    	Location l = new Location() ;
    	l.setyCoord(20);
        assertEquals("input a valid xcoord",20,l.getyCoord());
    }

    
    @Test
    public void test_yCoordsmall() {
    	Location l = new Location() ;
    	l.setyCoord(1);
    	l.setyCoord(-1);
        assertEquals("input a xcoord which is smaller than 0",1,l.getyCoord());
    }
    
    @Test
    public void test_yCoordlarge() {
    	Location l = new Location() ;
    	l.setyCoord(30);
    	l.setyCoord(84);
        assertEquals("input a xcoord which is bigger than 80",30,l.getyCoord());
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
    	l.setxCoord(1);
    	l.setxCoord(-1);
        assertEquals("input a xcoord which is smaller than 0",1,l.getxCoord());
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
    	l.setyCoord(1);
    	l.setyCoord(-1);
        assertEquals("((" + l.getxCoord() + ", " + l.getyCoord() +"), (X Size: " + l.getxSize() + ", Y Size: " + l.getySize() + "))",1,l.getyCoord());
    }
   
}
