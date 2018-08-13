import static org.junit.Assert.*;
import org.junit.Test;
import sprite.*;
import gameMechanics.GameLoop;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoopTest {

    @Test
    public void testcheckenemyLeft() {
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
    	l2.setxCoord(35);
    	l2.setxSize(10);
    	l2.setyCoord(30);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(true,g.checkCollisions(p,move[0]));
    }

    @Test
    public void testcheckenemyLeftFalse() {
    	GameLoop g = new GameLoop();
    	Enemy e = new Enemy();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	e.setExists(true);
    	l1.setxCoord(0);
    	l1.setxSize(10);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(35);
    	l2.setxSize(10);
    	l2.setyCoord(30);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(false,g.checkCollisions(p,move[0]));
    }

    @Test
    public void testcheckenemyRight() {
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
    	l2.setxCoord(10);
    	l2.setxSize(10);
    	l2.setyCoord(30);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(true,g.checkCollisions(p,move[1]));
    }

    @Test
    public void testcheckenemyRightFalse() {
    	GameLoop g = new GameLoop();
    	Enemy e = new Enemy();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	e.setExists(true);
    	l1.setxCoord(80);
    	l1.setxSize(10);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(10);
    	l2.setxSize(10);
    	l2.setyCoord(30);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(false,g.checkCollisions(p,move[1]));
    }

    @Test
    public void testcheckenemyUp() {
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
    	l2.setxCoord(20);
    	l2.setxSize(10);
    	l2.setyCoord(15);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(true,g.checkCollisions(p,move[2]));
    }

    @Test
    public void testcheckenemyUpFalse() {
    	GameLoop g = new GameLoop();
    	Enemy e = new Enemy();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	e.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(20);
    	l2.setxSize(10);
    	l2.setyCoord(35);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(false,g.checkCollisions(p,move[2]));
    }

    @Test
    public void testcheckenemyDown() {
    	GameLoop g = new GameLoop();
    	Enemy e = new Enemy();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	e.setExists(true);
    	l1.setxCoord(35);
    	l1.setxSize(10);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(20);
    	l2.setxSize(10);
    	l2.setyCoord(5);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(false,g.checkCollisions(p,move[3]));
    }

    @Test
    public void testcheckenemyDownFalse() {
    	GameLoop g = new GameLoop();
    	Enemy e = new Enemy();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	e.setExists(true);
    	l1.setxCoord(35);
    	l1.setxSize(10);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(35);
    	l2.setxSize(35);
    	l2.setyCoord(5);
    	l2.setySize(10);
    	e.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(false,g.checkCollisions(p,move[3]));
    }

    @Test
    public void testcheckspriteLeft() {
    	GameLoop g = new GameLoop();
        Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(10);
    	l1.setyCoord(30);
    	l1.setySize(10);
    	p.setCoord(l1);
    	l2.setxCoord(19);
    	l2.setxSize(0);
    	l2.setyCoord(30);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(true,g.checkCollisions(p,move[0]));
    }

    @Test
    public void testcheckspriteLeftFalse() {
    	GameLoop g = new GameLoop();
        Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(15);
    	l2.setxSize(0);
    	l2.setyCoord(30);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
    	assertEquals(false,g.checkCollisions(p,move[0]));
    }

    @Test
    public void testcheckspriteRight() {
    	GameLoop g = new GameLoop();
        Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(21);
    	l2.setxSize(0);
    	l2.setyCoord(30);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(true,g.checkCollisions(p,move[1]));
    }

    @Test
    public void testcheckspriteRightFalse() {
    	GameLoop g = new GameLoop();
        Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(25);
    	l2.setxSize(0);
    	l2.setyCoord(30);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
		assertEquals(false,g.checkCollisions(p,move[1]));
    }

    @Test
    public void testcheckspriteUp() {
    	GameLoop g = new GameLoop();
        Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(20);
    	l2.setxSize(0);
    	l2.setyCoord(31);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(true,g.checkCollisions(p,move[2]));
    }

    @Test
    public void testcheckspriteUpFalse() {
    	GameLoop g = new GameLoop();
        Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(20);
    	l2.setxSize(0);
    	l2.setyCoord(35);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(false,g.checkCollisions(p,move[2]));
    }

    @Test
    public void testcheckspriteDown() {
    	GameLoop g = new GameLoop();
    	Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(20);
    	l2.setxSize(0);
    	l2.setyCoord(29);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(true,g.checkCollisions(p,move[3]));
    }

    @Test
    public void testcheckspriteDown() {
    	GameLoop g = new GameLoop();
    	Sprite s = new Sprite();
    	Player p  = new Player();
    	Location l1 = new Location();
    	Location l2 = new Location();
    	s.setExists(true);
    	l1.setxCoord(20);
    	l1.setxSize(0);
    	l1.setyCoord(30);
    	l1.setySize(0);
    	p.setCoord(l1);
    	l2.setxCoord(20);
    	l2.setxSize(0);
    	l2.setyCoord(25);
    	l2.setySize(0);
    	s.setCoord(l2);
    	String[] move = {"Left","Right","Up","Down"};
	  	assertEquals(false,g.checkCollisions(p,move[3]));
    }


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
