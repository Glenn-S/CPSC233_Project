import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.animation.AnimationTimer;

/**
 * Purpose: To drive the main game mechanics and prompt the user to start the
 * game.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainMenu extends Application { // change this name to be the name of the game
    private final int HEIGHT = 4000;
    private final int LENGTH = 8000;
    private final String GAMETITLE = "The Adventures of Montequilla";

    private static Stage mainStage;

    /**
     * Purpose: The main game driver for The Adventures of Montequilla. this
     * will continue until the user selects quit.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        //Scene scene = new Scene(mainMenu(), HEIGHT, LENGTH);
        window.setScene(new Scene(mainMenu(), HEIGHT, LENGTH));
        window.setTitle(GAMETITLE);
        window.show();

        mainStage = window;


    }

    /**
     * Purpose: To drive the main menu and allow the user to either start or
     * exit the game. It also prints out a brief synopsis of the game.
     */
    public BorderPane mainMenu() {
        // Constants
        final String START = "START";
        final String STOP = "STOP";
        //String btnColour = "-fx-background-color: #FFFFFF; ";
        final String BTNSTYLE = "-fx-font-size: 24; -fx-border-width: 10; ";
        final double GAP = 10.0;
        final double BTNWIDTH = 150;
        final double BTNHEIGHT = 40;
        final String SYNOPSIS =
            "B-town is under attack by \"I can’t believe it\'s not butter\" boy and " +
            "his army of Margarine men. All sources of butter are destroyed in the town " +
            "except for one. Your best friend Butter Bob Brown has been in his lab developing " +
            "a new 0 sodium butter. Realizing the applications for his process of removing " +
            "sodium, \"I can’t believe it’s not butter\" boy abducts him to his lair of oil. " +
            "After remembering something the town oracle spoke of in the past you see the " +
            "ancient scriptures in the town describing a hero of legend who would save the " +
            "Butter Industry from its competitors. Here you acquire the bronze butter knife " +
            "and styrofoam plate shield.  Now it\'s up to you to assemble the holy" +
            "triglyceride (combination of the 3 \"keys\" known as monoglycerides)" +
            "and rescue Butter Bob Brown to restore peace to the Butter Industry.";
        final String GAMETITLE = "The Adventures of Montequilla";

        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: #FFFFF0; ");
        vb.setSpacing(GAP);

        // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF

        Button startBtn = new Button(START);
        Button exitBtn = new Button(STOP);
        startBtn.setStyle(BTNSTYLE); // set the CSS preferences
        exitBtn.setStyle(BTNSTYLE);
        startBtn.setPrefSize(BTNWIDTH, BTNHEIGHT);
        exitBtn.setPrefSize(BTNWIDTH, BTNHEIGHT);
        startBtn.setAlignment(Pos.CENTER);
        exitBtn.setAlignment(Pos.CENTER);

        Label synopsis = new Label(SYNOPSIS);
        synopsis.setPrefSize(800, 300);
        synopsis.setAlignment(Pos.CENTER);
        synopsis.setWrapText(true);
        Label title = new Label(GAMETITLE);
        title.setAlignment(Pos.CENTER);
        title.setStyle(BTNSTYLE);

        vb.getChildren().addAll(title, synopsis, startBtn, exitBtn);
        bp.setCenter(vb);

        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                Platform.exit();
            }
        });
        exitBtn.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                Platform.exit();
            }
            // hardcoded for now, if more buttons are added change this
            if (e.getCode().equals(KeyCode.W) || (e.getCode().equals(KeyCode.UP))) {
                startBtn.requestFocus();
            }
        });
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                startBtn.getScene().setRoot(gameLoop());
            }
        });

        startBtn.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                startBtn.getScene().setRoot(gameLoop());
            }
            // hardcoded for now, if more buttons are added change this
            if (e.getCode().equals(KeyCode.S) || (e.getCode().equals(KeyCode.DOWN))) {
                exitBtn.requestFocus();
            }
        });
        return bp;

    }

    /**
     * Purpose: To drive the main game loop of the game.
     * @return true or false depending on whether they would or would not like
     * play again.
     */
    public VBox gameLoop() {
        final String LOSEMESSAGE = "CONGRATULATIONS!, YOU ARE THE WORST AT WINNING";
        final String WINMESSAGE = "CONGRATULATIONS!, YOU ARE THE BEST AT NOT LOSING";
        final String RETURNMSG = "Press any key to return to the main menu";
        final String MSGSTYLE = "-fx-font-size: 36; ";
        final String PROMPTSTYLE = "-fx-font-size: 24; ";
        final double GAP = 20.0;

        boolean win = false;
        boolean gameState = true;
        GameLoop gamePlay = new GameLoop();

        FlowPane bp = new FlowPane();


        // need to implement a timer for the game loop itself

        // run through the game
        //while (!gameState) { // keep playing unless the game has been lost or won
            //userMove = gamePlay.playerInput();
/*
            if (!gamePlay.checkCollisions(player, userMove)) { // if check collisions comes back false, move the player
                // pass the new x/y for the player
                gamePlay.updatePosition(player, userMove); // if collision is not detected update player position
            }
            //gamePlay.checkGate(player); // checks if enough keys have been collected and updates image if needed?
            if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                gameState = true; // this is to terminate the game loop
                // set win in here?
                continue; // exit to the beginning of the loop to check this condition
            }

            //printLegend();
            //System.out.println("\n\n\n\n\n"); // add screen spacing
            //gamePlay.refreshPrintArray();
            //System.out.println("\n" + player.getStats());
            //System.out.println("Inventory: " + player.getInventory());
            gamePlay.drawState(player, gamePlay.getPrintArray());
*/
        //}
        // get the user input for playing again, this will go to the exit splash
        //mainStage.getScene().setRoot(returnMain(gameState));
        // change this to be when the user finishes the game
        /*Scene scene = mainStage.getScene();
        scene.setOnKeyTyped(e -> {
            scene.setRoot(returnMain(gameState));
        });*/

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(GAP);

        // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF

        Label userMsg = new Label();
        if (win) userMsg.setText(WINMESSAGE);
        if (!win) userMsg.setText(LOSEMESSAGE);
        userMsg.setStyle(MSGSTYLE);

        Label prompt = new Label(RETURNMSG);
        prompt.setStyle(PROMPTSTYLE);
        vb.getChildren().addAll(userMsg, prompt);

        Scene scene = mainStage.getScene();
        scene.setOnKeyTyped(e -> {
            scene.setRoot(mainMenu());
        });
        System.out.println("I printed");
        return vb;
    }

}


    /**
     * Purpose: To prompt the user about whether they would like to play the
     * game again.
     * @return true if they do want to play again else false
     */
/*    private VBox returnMain(boolean win) {
        final String LOSEMESSAGE = "CONGRATULATIONS!, YOU ARE THE WORST AT WINNING";
        final String WINMESSAGE = "CONGRATULATIONS!, YOU ARE THE BEST AT NOT LOSING";
        final String RETURNMSG = "Press any key to return to the main menu";
        final String MSGSTYLE = "-fx-font-size: 36; ";
        final String PROMPTSTYLE = "-fx-font-size: 24; ";
        final double GAP = 20.0;

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(GAP);

        // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF

        Label userMsg = new Label();
        if (win) userMsg.setText(WINMESSAGE);
        if (!win) userMsg.setText(LOSEMESSAGE);
        userMsg.setStyle(MSGSTYLE);

        Label prompt = new Label(RETURNMSG);
        prompt.setStyle(PROMPTSTYLE);
        vb.getChildren().addAll(userMsg, prompt);

        Scene scene = mainStage.getScene();
        scene.setOnKeyTyped(e -> {
            scene.setRoot(mainMenu());
        });
        System.out.println("I printed");
        return vb;
    }
*/



    /**
     * Purpose: To drive the main game loop of the game.
     * @return true or false depending on whether they would or would not like
     * play again.
     */
/*    public boolean bameLoop(Stage win) {
        boolean gameState = false;
        GameLoop gamePlay = new GameLoop();
        // GameBoard gb = new GameBoard();
        String userMove;
        // set up the user
        String[] moves = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        Player player =  new Player("Montequilla", new Location(5, 38, 0, 0), null, 'x',
                                null, true, false, 100, 25, 25, moves);
        Weapon starterSword = new Weapon("Bronze Butterknife", null, null, ' ', null, true, false, 50);
        Defence starterShield = new Defence("Styrofoam Plate Shield", null, null, ' ', null, true, false, 50);
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 25);
        player.addItem(starterSword);
        System.out.println("*** " + starterSword.getName() + " has been added to your pack ***");
        player.updateAttack(starterSword);
        player.addItem(starterShield);
        System.out.println("*** " + starterShield.getName() + " has been added to your pack ***");
        player.updateDefence(starterShield);
        player.addItem(smallPotion);
        System.out.println("*** " + smallPotion.getName() + " has been added to your pack ***");
        // draw the initialized state
        gamePlay.initialize();
        //printLegend();
        System.out.println("\n\n\n\n"); // add screen spacing
        gamePlay.refreshPrintArray();
        System.out.println("\n" + player.getStats());
        System.out.println("Inventory: " + player.getInventory());
        gamePlay.drawState(player, gamePlay.getPrintArray());

        // run through the game
        while (!gameState) { // keep playing unless the game has been lost or won
            userMove = gamePlay.playerInput();
            System.out.println("\n\n\n\n");

            if (!gamePlay.checkCollisions(player, userMove)) { // if check collisions comes back false, move the player
                // pass the new x/y for the player
                gamePlay.updatePosition(player, userMove); // if collision is not detected update player position
            }
            //gamePlay.checkGate(player); // checks if enough keys have been collected and updates image if needed?
            if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                gameState = true; // this is to terminate the game loop
                continue; // exit to the beginning of the loop to check this condition
            }

            //printLegend();
            System.out.println("\n\n\n\n\n"); // add screen spacing
            gamePlay.refreshPrintArray();
            System.out.println("\n" + player.getStats());
            System.out.println("Inventory: " + player.getInventory());
            gamePlay.drawState(player, gamePlay.getPrintArray());
        }
        // get the user input for playing again, this will go to the exit splash
        return returnMain();
    }
*/
    /**
     * Purpose: To prompt the user about whether they would like to play the
     * game again.
     * @return true if they do want to play again else false
     */
/*    private boolean neturnMain() {
        Console console = System.console();
        String userPrompt = "Press enter to return to the main menu: ";

        if (console == null) return false; // check to make sure that the console was oppened properly
        console.readLine(userPrompt);
        System.out.println();
        return true;
    }
*/

/**
 * Purpose: To drive the main menu and allow the user to either start or
 * exit the game. It also prints out a brief synopsis of the game.
 */
/*    public boolean mainMenu() {
    Console console = System.console();
    String input;
    String userPrompt = "\t\t\t\t\tWould you like to play y/n: ";
    String error = "\t\t\t\t\tInvalid input";
    boolean valid = false;

    // print out the main premise for the game
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\t\t\t\t\tThe Adventures of Montequilla\n");
    System.out.println("\t\tB-town is under attack by \"I can’t believe it\'s not butter\" boy and\n" +
    "\t\this army of Margarine men. All sources of butter are destroyed in the town\n" +
    "\t\texcept for one. Your best friend Butter Bob Brown has been in his lab developing\n" +
    "\t\ta new 0 sodium butter. Realizing the applications for his process of removing\n" +
    "\t\tsodium, \"I can’t believe it’s not butter\" boy abducts him to his lair of oil.\n" +
    "\t\tAfter remembering something the town oracle spoke of in the past you see the\n" +
    "\t\tancient scriptures in the town describing a hero of legend who would save the\n" +
    "\t\tButter Industry from its competitors. Here you acquire the bronze butter knife\n" +
    "\t\tand styrofoam plate shield.  Now it\'s up to you to assemble the holy\n" +
    "\t\ttriglyceride (combination of the 3 \"keys\" known as monoglycerides)\n" +
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
*/

//MainMenu game = new MainMenu();
//boolean playGame = true;
//String exitMsg = "Thanks for playing!";

/*
while (playGame) { // loop until false is selected
    playGame = game.mainMenu();
    if (playGame == false) continue;
    game.gameLoop(); // instantiates a new instance of the game
}
System.out.println(exitMsg); // exit splash screen
*/

    /**
     * Purpose: To print out a legend for the meaning of all the symbols in the
     * game.
     */
/*    public void printLegend(){
		System.out.println("You                   *");
		System.out.println("Enemy                 +");
		System.out.println("Chest                 #");
		System.out.println("Vertical Edge         |");
		System.out.println("Horizontal Edge       -");
		System.out.println("Diagonal Edge         /");
	}
*/
