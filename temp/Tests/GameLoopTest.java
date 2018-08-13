import static org.junit.Assert.*;
import org.junit.Test;
import sprite.*;
import gameMechanics.GameLoop;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoopTest {

    @Test
    public void testgate3Keys(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setKeyCount(3);
    	assertEquals(true,g.checkGate(p));
    }

    @Test
    public void testgate1Keys(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setKeyCount(1);
    	assertEquals(false,g.checkGate(p));
    }

    @Test
    public void testgate2Keys(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setKeyCount(2);
    	assertEquals(false,g.checkGate(p));
    }

    @Test
    public void testgateNoKey(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setKeyCount(0);
    	assertEquals(false,g.checkGate(p));
    }

    @Test
    public void testWinstatetrue(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setKeyCount(4);
    	assertEquals(true,g.checkWinState());
    }

    @Test
    public void testWinstatefalse(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setKeyCount(3);
    	assertEquals(false,g.checkWinState());
    }

    @Test
    public void testlosestate1(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setHealth(0);
    	assertEquals(true,g.checkLoseState());
    }

    @Test
    public void testPlayerInputInvalid(){
      GameLoop g = new GameLoop();
      Console console = System.console();
      String input;
      console = null;
      input = "q";
      assertEquals(null,g.playerInput());
    }

    @Test
    public void testPlayerInputW(){
      GameLoop g = new GameLoop();
      Console console = System.console();
      String input;
      console = null;
      input = "W";
      assertEquals("w",g.playerInput());
    }

    @Test
    public void testPlayerInputa(){
      GameLoop g = new GameLoop();
      Console console = System.console();
      String input;
      console = null;
      input = "a";
      assertEquals("a",g.playerInput());
    }

    @Test
    public void testPlayerInputS(){
      GameLoop g = new GameLoop();
      Console console = System.console();
      String input;
      console = null;
      input = "S";
      assertEquals("s",g.playerInput());
    }

    @Test
    public void testPlayerInputd(){
      GameLoop g = new GameLoop();
      Console console = System.console();
      String input;
      console = null;
      input = "d";
      assertEquals("d",g.playerInput());
    }

    @Test
    public void testlosestate2(){
    	GameLoop g = new GameLoop();
    	Player p = new Player();
    	p.setHealth(100);
    	assertEquals(false,g.checkLoseState());
    }
}
