package terminal;

import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;
import sprite.*;
import gameMechanics.*;

/**
 * Purpose: To drive the main game mechanics and prompt the user to start the
 * game.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainTerminal { // change this name to be the name of the game
    /**
     * Purpose: To drive the main menu and allow the user to either start or
     * exit the game. It also prints out a brief synopsis of the game.
     */
    public boolean mainMenu() {
        Console console = System.console();
        String input;
        String userPrompt = "\t\t\t\t\tWould you like to play y/n: ";
        String error = "\t\t\t\t\tInvalid input";
        boolean valid = false;

        // print out the main premise for the game
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\t\tThe Adventures of Montequilla\n");
        System.out.println("\t\tB-town is under attack by I can’t believe it’s not butter boy and\n" +
        "\t\this army of Margarine men. All sources of butter are destroyed in the town\n" +
        "\t\texcept for one. Your best friend Butter Bob Brown has been in his lab developing\n" +
        "\t\ta new 0 sodium butter. Realizing the applications for his process of removing\n" +
        "\t\tsodium, I can’t believe it’s not butter boy abducts him to his lair of oil.\n" +
        "\t\tAfter remembering something the town oracle spoke of in the past you see the\n" +
        "\t\tancient scriptures in the town describing a hero of legend who would save the\n" +
        "\t\tButter Industry from its competitors. Here you acquire the bronze butter knife\n" +
        "\t\tand styrofoam plate shield.  Now it’s up to you to assemble the holy\n" +
        "\t\ttriglyceride (combination of the 3 keys known as monoglycerides)\n" +
        "\t\tand rescue Butter Bob Brown to restore peace to the Butter Industry.\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if (console == null) return false; // check to make sure that the console was oppened properly
        do {
            input = console.readLine(userPrompt);
            if (input.toLowerCase().equals("y") || input.toLowerCase().equals("n")) {
                valid = true;
            }
            else System.out.println(error);
        } while (!valid);

        return input.equals("y") ? true : false;
    }

    /**
     * Purpose: To drive the main game loop of the game.
     *
     * @return true or false depending on whether they would or would not like
     * play again.
     */
    public boolean gameLoop() {
        boolean gameState = false;
        GameLoop gamePlay = new GameLoop();
        gamePlay.setTerminal(true); // to set the values to know terminal is in use
        // GameBoard gb = new GameBoard();
        String userMove;
        // draw the initialized state
        gamePlay.initialize();
        printLegend();
        gamePlay.refreshPrintArray(); // used to have player as a parameter
        System.out.println(gamePlay.getPlayer().getStats());
        System.out.println("Inventory: " + gamePlay.getPlayer().getInventory(true));
        gamePlay.drawState(gamePlay.getPlayer(), gamePlay.getPrintArray());

        // run through the game
        while (!gameState) { // keep playing unless the game has been lost or won
            userMove = gamePlay.playerInput();
            System.out.println("\n");

            if (!gamePlay.checkCollisions(gamePlay.getPlayer(), userMove)) { // if check collisions comes back false, move the player
                // pass the new x/y for the player
                gamePlay.updatePosition(gamePlay.getPlayer(), userMove); // if collision is not detected update player position
            }
            gamePlay.checkGate(gamePlay.getPlayer()); // checks if enough keys have been collected and updates image if needed?
            if (gamePlay.getPlayer().getKeyCount() == 4) {
                gamePlay.setWinState(true); // set the win state if the player has obtained every key
            }
            if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                gameState = true; // this is to terminate the game loop
                continue; // exit to the beginning of the loop to check this condition
            }

            printLegend();
            gamePlay.refreshPrintArray(); // used to have player as a parameter
            System.out.println(gamePlay.getPlayer().getStats());
            System.out.println("Inventory: " + gamePlay.getPlayer().getInventory(true));
            gamePlay.drawState(gamePlay.getPlayer(), gamePlay.getPrintArray());
        }
        // get the user input for playing again, this will go to the exit splash
        return returnMain();

    }

    /**
     * Purpose: To prompt the user about whether they would like to play the
     * game again.
     *
     * @return true if they do want to play again else false
     */
    private boolean returnMain() {
        Console console = System.console();
        String userPrompt = "Press enter to return to the main menu: ";

        if (console == null) return false; // check to make sure that the console was oppened properly
        console.readLine(userPrompt);
        System.out.println();
        return true;
    }

    /**
     * Purpose: To print out a legend for the meaning of all the symbols in the
     * game.
     */
    public void printLegend(){
        System.out.print("\n");
        System.out.println("Legend:");
		System.out.println("You                   x");
		System.out.println("Enemy                 +");
		System.out.println("Chest                 #");
		System.out.println("Vertical Edge         |");
		System.out.println("Horizontal Edge       -");
		System.out.println("Diagonal Edge         /");
		System.out.println("Mountain              m");
		System.out.println("River                 ~");
		System.out.println("Gate                  =");
        System.out.println("Tombstone             t");
	}

}
