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
import javafx.scene.text.Font;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.Parent;
import javafx.scene.image.Image;
/**
 * Purpose: To drive the main game mechanics and prompt the user to start the
 * game.
 * inspiration borrowed from:
 * https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainMenu extends Application { // change this name to be the name of the game
    private final int HEIGHT = 4000;
    private final int WIDTH = 8000;
    private final String GAMETITLE = "The Adventures of Montequilla";
    private String userMove = "";
    private Player player;

    private Pane root;

    //private double x = 40;
    //private double y = 40;

/*    @Override
    public void init() {
        // init resources
        // calls start after
    }
*/
    /**
     * Purpose: The main game driver for The Adventures of Montequilla. this
     * will continue until the user selects quit.
     * @param window a Stage class used to
     */
    @Override
    public void start(Stage window) throws Exception {
        GameLoop gamePlay = new GameLoop();
        String[] moves = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        player =  new Player("Montequilla", new Location(5, 38, 0, 0), new Image("Montequilla_BG.png"), 'x',
                                null, true, false, 100, 25, 25, moves);
        Weapon starterSword = new Weapon("Bronze Butterknife", null, null, ' ', null, true, false, 50);
        Defence starterShield = new Defence("Styrofoam Plate Shield", null, null, ' ', null, true, false, 50);
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 25);
        player.addItem(starterSword);
        player.updateAttack(starterSword);
        player.addItem(starterShield);
        player.updateDefence(starterShield);
        player.addItem(smallPotion);

        window.setScene(new Scene(display(gamePlay)));
        window.getScene().setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.W)) {
                userMove = "up";
                //y -= 5;
            }
            if (e.getCode().equals(KeyCode.S)) {
                userMove = "down";
                //y += 5;
            }
            if (e.getCode().equals(KeyCode.A)) {
                userMove = "left";
                //x -= 5;
            }
            if (e.getCode().equals(KeyCode.D)) {
                userMove = "right";
                //x += 5;
            }
            System.out.println(userMove);
        });
        window.show();
    }

    /**
     * Purpose: To create the content to fill each pane for an update.
     * @param gamePlay an instance of the GameLoop class
     */
    public Parent display(GameLoop gamePlay) {

        // set up the user
        root = new FlowPane();
        root.setPrefSize(WIDTH, HEIGHT);
        // was used for testing with a drawing
        //Canvas canvas = new Canvas(WIDTH, HEIGHT);
        //root.getChildren().add(canvas);
        //GraphicsContext gc = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!gamePlay.checkCollisions(player, userMove)) { // if check collisions comes back false, move the player
                    // pass the new x/y for the player
                    gamePlay.updatePosition(player, userMove); // if collision is not detected update player position
                }
                //gamePlay.checkGate(player); // checks if enough keys have been collected and updates image if needed?
                if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                    // add in exit message later
                    // if game is done
                    Platform.exit();
                }

                root = gamePlay.drawState(player);
            }
        };
        timer.start();
        return root;
    }

    /**
     * Purpose: To call the start sequence for the game loop
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Purpose: To drive the main menu and allow the user to either start or
     * exit the game. It also prints out a brief synopsis of the game.
     */
/*   public void mainMenu(Stage window) {
       // Constants
       final String START = "START";
       final String STOP = "STOP";
       //String btnColour = "-fx-background-color: #FFFFFF; ";
       final Font BTNSTYLE = new Font(24);
       final Font TITLESTYLE = new Font("Verdana", 42);
       final Font SYNOPSISSTYLE = new Font(18);
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

       VBox vb = new VBox();
       vb.setAlignment(Pos.CENTER);
       vb.setStyle("-fx-background-color: #FFFF20; ");
       vb.setSpacing(GAP);

       // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF

       Button startBtn = new Button(START);
       Button exitBtn = new Button(STOP);
       startBtn.setFont(BTNSTYLE); // set the CSS preferences
       exitBtn.setFont(BTNSTYLE);
       startBtn.setPrefSize(BTNWIDTH, BTNHEIGHT);
       exitBtn.setPrefSize(BTNWIDTH, BTNHEIGHT);
       startBtn.setAlignment(Pos.CENTER);
       exitBtn.setAlignment(Pos.CENTER);

       Label synopsis = new Label(SYNOPSIS);
       synopsis.setPrefSize(800, 300);
       synopsis.setAlignment(Pos.CENTER);
       synopsis.setWrapText(true);
       synopsis.setFont(SYNOPSISSTYLE);
       Label title = new Label(GAMETITLE);
       title.setAlignment(Pos.CENTER);
       //title.setStyle(TITLESTYLE);
       title.setFont(TITLESTYLE);

       vb.getChildren().addAll(title, synopsis, startBtn, exitBtn);
       //bp.setCenter(vb);

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
               gameLoop(window);
           }
       });

       startBtn.setOnKeyPressed(e -> {
           if (e.getCode().equals(KeyCode.ENTER)) {
               gameLoop(window);
           }
           // hardcoded for now, if more buttons are added change this
           if (e.getCode().equals(KeyCode.S) || (e.getCode().equals(KeyCode.DOWN))) {
               exitBtn.requestFocus();
           }
       });

       //Group root = new Group();
       Scene scene = new Scene(vb, WIDTH, HEIGHT);
       window.setScene(scene);
       window.show();

    }
*/

    /**
     * Purpose: To drive the main game loop of the game.
     * @return true or false depending on whether they would or would not like
     * play again.
     */
/*    public void gameLoop(Stage window) {
        boolean gameState = false;
        GameLoop gamePlay = new GameLoop();
        // set up the user
        String[] moves = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        Player player =  new Player("Montequilla", new Location(5, 38, 0, 0), null, 'x',
                                null, true, false, 100, 25, 25, moves);
        Weapon starterSword = new Weapon("Bronze Butterknife", null, null, ' ', null, true, false, 50);
        Defence starterShield = new Defence("Styrofoam Plate Shield", null, null, ' ', null, true, false, 50);
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 25);
        player.addItem(starterSword);
        player.updateAttack(starterSword);
        player.addItem(starterShield);
        player.updateDefence(starterShield);
        player.addItem(smallPotion);

        boolean win = false;

        GridPane vb = new GridPane();
        Scene scene = new Scene(vb, WIDTH, HEIGHT);
        window.setScene(scene);

        AnimationTimer timer = new AnimationTimer() {
            // this is called at a rate of 60 frames per second
            @Override
            public void handle(long now) {
                window.getScene().setOnKeyPressed(e -> {
                    //user input
                    if (e.getCode().equals(KeyCode.W)) {
                        userMove = "up";
                    }
                    if (e.getCode().equals(KeyCode.S)) {
                        userMove = "down";
                    }
                    if (e.getCode().equals(KeyCode.A)) {
                        userMove = "left";
                    }
                    if (e.getCode().equals(KeyCode.D)) {
                        userMove = "right";
                    }
                    System.out.println(userMove);*/
/*
                    //update
                    if (!gamePlay.checkCollisions(player, userMove)) { // if check collisions comes back false, move the player
                        // pass the new x/y for the player
                        gamePlay.updatePosition(player, userMove); // if collision is not detected update player position
                    }
                    //gamePlay.checkGate(player); // checks if enough keys have been collected and updates image if needed?
                    if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                        // add in exit message later
                        Platform.exit();
                    }
                    //render (draw)
                    gamePlay.drawState(player, gamePlay.getPrintArray());
*/
                    //sync
/*                });
            }
        };
        timer.start();
        window.show();
    }
*/

    /**
     * Purpose: To prompt the user about whether they would like to play the
     * game again.
     * @return true if they do want to play again else false
     */
/*    private void returnMain(Stage window, boolean win) {
        final String LOSEMESSAGE = "CONGRATULATIONS!, YOU ARE THE WORST AT WINNING";
        final String WINMESSAGE = "CONGRATULATIONS!, YOU ARE THE BEST AT NOT LOSING";
        final String RETURNMSG = "Press any key to return to the main menu";
        final String TEMPMSG = "Press any key to quit";
        final String MSGSTYLE = "-fx-font-size: 36; ";
        final String PROMPTSTYLE = "-fx-font-size: 24; ";
        final double GAP = 20.0;

        System.out.println("IM HERE");
        VBox vb = new VBox();
        Scene scene = new Scene(vb, WIDTH, HEIGHT);
        window.setScene(scene);
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

        scene.setOnKeyTyped(e -> {
            //mainMenu(window);
            Platform.exit();
        });
        window.show();
    }
*/


}



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
