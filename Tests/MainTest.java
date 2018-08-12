package Tests;

import static org.junit.Assert.*;

import java.io.Console;

import sprite.Player;
import sprite.Enemy;
import org.junit.Test;
import sprite.Sprite;
import Main;
import terminal.GameLoop;
/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainTest {
	@Test
	public void testgetKeyT(){
		Player p = new Player();
		Enemy e = new Enemy();
		Main m = new Main();
		p.setKeyCount(1);
		e.setKey(true);
		e.setName("Not Boss");
		m.battle().endBattle(e,p){
			b.checkWinState(e) = true;
		}
		assertEquals(2,p.getKeyCount());
	}

	public void testgetKeyF(){
		Player p = new Player();
		Enemy e = new Enemy();
		Main m = new Main();
		p.setKeyCount(1);
		e.setKey(false);
		e.setName("Not Boss");
		m.battle().endBattle(e,p){
			b.checkWinState(e) = true;
		}
		assertEquals(1,p.getKeyCount());
	}

	@Test
	public void testmainmenuY() {
		MainMenu g = new MainMenu() ;
		Console c = System.console();
		String input = "\t\t\t\t\tWould you like to play y/n: ";
		c.readLine(input);
		input = "y";
		assertEquals(true,g.mainMenu());
	}

	@Test
	public void testmainmenuN() {
		MainMenu g = new MainMenu() ;
		Console c = System.console();
		String input = "\t\t\t\t\tWould you like to play y/n: ";
		c.readLine(input);
		input = "n";
		assertEquals(false,g.mainMenu());
	}

	@Test
	public void testmainmenuinvalid() {
		MainMenu g = new MainMenu() ;
		Console c = System.console();
		String error = "\t\t\t\t\tInvalid input";
		String input = "\t\t\t\t\tWould you like to play y/n: ";
		c.readLine(input);
		input = "s";
		assertEquals(error,g.mainMenu());
	}

	@Test
	public void testgameloop() {
		MainMenu m = new MainMenu() ;
		GameLoop g = new GameLoop();
		Console c = System.console();
		String error = "\t\t\t\t\tInvalid input";
		String input = "\t\t\t\t\tWould you like to play y/n: ";
		c.readLine(input);
		input = "s";
		assertEquals(error,m.gameLoop());
	}
}
