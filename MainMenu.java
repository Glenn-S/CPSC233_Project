import java.util.Scanner;

/**
 *
 */
public class MainMenu { // change this name to be the name of the game

    /**
     * Purpose: The main game driver
     */
    public static void main(String[] args) {
        MainMenu game = new MainMenu();
        boolean playGame = true;
        boolean startGame = true;

        while (playGame) {
            while (startGame) {
                startGame = game.mainMenu();
            }
            playGame = game.gameLoop(); // instantiates a new instance of the game
        }
        // maybe print out an exit splash screen?
    }

    /**
     * Purpose: To drive the main menu and allow the user to either start or
     * exit the game.
     */
    public boolean mainMenu() {
        boolean input = false;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        // prompt user for input until they return true
        return input;
    }

    /**
     * Purpose: To drive the main game loop of the game.
     * @return true or false depending on whether they would or would not like
     * play again
     */
    public boolean gameLoop() {
        boolean gameState = false;
        GameLoop gamePlay = new GameLoop();
        Player player = new Player(); // initialized value
        String userMove;

        // run through the game
        while (!gameState) { // keep playing unless the game has been lost or won
            userMove = gamePlay.playerInput();
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
        }

        // get the user input for playing again, this will go to exit splash
        return playAgain();
    }

    /**
     * Purpose: To prompt the user about whether they would like to play the
     * game again.
     * @return true if they do want to play again else false
     */
    private boolean playAgain() {
        Scanner scan = new Scanner(System.in);
        boolean input = false;
        System.out.println(); // user prompt
        // maybe this can be used to encapsulate it
        return input;
    }

}
