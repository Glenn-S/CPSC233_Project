public class MainMenu { // change this name to be the name of the game

    /**
     *
     */
    public static void main(String[] args) {
        MainMenu game = new MainMenu();
        boolean playGame = true;
        boolean startGame = true;

        while (playGame) {
            // maybe change this and call menu from here
            while (startGame) {
                startGame = game.mainMenu();
            }

            playGame = game.gameLoop();
        }

    }

    /**
     *
     */
    public boolean mainMenu() {
        // prompt user for input until they return true
        return true;
    }

    /**
     *
     */
    public boolean gameLoop() {
        // run through the game
        return true;
    }


}
