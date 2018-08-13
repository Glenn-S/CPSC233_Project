import static org.junit.Assert.*;
import org.junit.Test;

import java.io.Console;
import terminal.*;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainMenuTest {
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
