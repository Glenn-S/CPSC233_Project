import java.util.Scanner;
import java.io.Console;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainMenu { // change this name to be the name of the game

    /**
     * Purpose: The main game driver
     */
    public static void main(String[] args) {
        MainMenu game = new MainMenu();
        boolean playGame = true;
        String exitMsg = "Thanks for playing!";

        while (playGame) { // loop until false is selected
            playGame = game.mainMenu();
            if (playGame == false) continue;
            game.gameLoop(); // instantiates a new instance of the game
        }
        System.out.println(exitMsg); // exit splash screen

    }

    /**
     * Purpose: To drive the main menu and allow the user to either start or
     * exit the game.
     */
    public boolean mainMenu() {
        Console console = System.console();
        String input;
        String userPrompt = "Would you like to play y/n: ";
        String error = "Invalid input";
        boolean valid = false;

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
     * @return true or false depending on whether they would or would not like
     * play again
     */
    public boolean gameLoop() {
        boolean gameState = false;
        GameLoop gamePlay = new GameLoop();
        //Player player = new Player(); // initialized value
        String userMove;

        // run through the game
        while (!gameState) { // keep playing unless the game has been lost or won
            userMove = gamePlay.playerInput();
            gameState = true;
            /*
            if (checkCollisions(player, userMove)){
                // pass the new x/y for the player
                player.updatePosition(); // if collision is not detected update player position
            }
            gamePlay.checkGate(); // checks if enough keys have been collected and updates image if needed?
            if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                gameState = false; // this is to terminate the game loop
                continue; // exit to the beginning of the loop to check this condition
            }
            gamePlay.drawState(); // redraw the game board with the updated coordinates
            */
        }

        // get the user input for playing again, this will go to exit splash
        return returnMain();
    }

    /**
     * Purpose: To prompt the user about whether they would like to play the
     * game again.
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

}
