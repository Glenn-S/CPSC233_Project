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
import javafx.scene.Node;

/**
 * Purpose: To drive the main game mechanics and prompt the user to start the
 * game.
 * inspiration borrowed from:
 * https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
 * http://www.java-gaming.org/topics/getting-started-with-javafx-game-programming-for-java-programmers/37201/view.html
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class MainMenu extends Application implements EventHandler<KeyEvent> { // change this name to be the name of the game
    private final String SYNOPSIS =
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
    private final String GAMETITLE = "The Adventures of Montequilla";
    private final int WIDTH = 4000, HEIGHT = 2000;
    private final int WINWIDTH = 1440, WINHEIGHT = 720;
    // main menu stylings
    private final String START = "START"; // label for the start button
    private final String STOP = "STOP"; // label for the exit button
    private final Font BTNSTYLE = new Font(24); // set the button stylings
    private final Font TITLESTYLE = new Font("Verdana", 42); // set the title stylings
    private final Font SYNOPSISSTYLE = new Font(18); // set the text stylings
    private final double GAP = 10.0; // set the button gap widths
    private final double BTNWIDTH = 150, BTNHEIGHT = 40; // set the width and height for the buttons
    private Button startBtn;
    private Button exitBtn;
    // game play Constants
    private String userMove = "";
    private GameLoop gamePlay;
    // set up player
    private String[] moves = {"Slash", "Butter Boomerang", "Parry", "Potion"};
    private Player player = new Player("Montequilla", new Location(3, 38, 0, 0),
        new Image("file:Smaller Images/Montequilla.png"), 'x', null, true,
        false, 100, 25, 25, moves);
    private Weapon starterSword =
        new Weapon("Bronze Butterknife", null, null, ' ', null, true, false, 50);
    private Defence starterShield =
        new Defence("Styrofoam Plate Shield", null, null, ' ', null, true, false, 50);
    private Potion smallPotion =
        new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 25);

    private Pane root = new Pane(); // for game play scenes
    private Stage window;
    private Scene main, game, end; // store scenes for each state



    // main scene elements

    /**
     * Purpose: The main game driver for The Adventures of Montequilla. this
     * will continue until the user selects quit.
     * @param window a Stage class used to
     */
    @Override
    public void start(Stage mainStage) throws Exception {
        window = mainStage; // keep the reference so that window may be accessed globally
        window.setWidth(WINWIDTH);
        window.setHeight(WINHEIGHT);

        // main Scene
        main = new Scene(mainSceneContent()); // set the scene for main

        // game Scene
        gamePlay = new GameLoop();
        gamePlay.initialize(); // maybe pass player into initialize to add items
        player.addItem(starterSword);
        player.updateAttack(starterSword);
        player.addItem(starterShield);
        player.updateDefence(starterShield);
        player.addItem(smallPotion);

        System.out.println(this.player.getCoord()); // for test purposes

        game = new Scene(root); // set up the game state scene
        root = gamePlay.drawState(player); // draw the initial game state
        game.setOnKeyPressed(this);
        game.setRoot(root);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!userMove.equals("")) {
                    if (!gamePlay.checkCollisions(player, userMove)) { // if check collisions comes back false, move the player
                        gamePlay.updatePosition(player, userMove);
                    }
                    root = gamePlay.drawState(player);
                    game.setRoot(root); // refresh the page
                    userMove = "";
                }

                gamePlay.checkGate(player); // checks if enough keys have been collected and updates image if needed?
                if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                    boolean state = (gamePlay.checkWinState()) ? true : false; //
                    // exit menu
                    end = new Scene(endSceneContent(state)); // set the scene for main
                    window.setScene(end);
                    //Platform.exit(); // add in exit message later
                }

            }
        };
        timer.start();


        // battleScene
        // add battle scene setups here



        // send the scene to the window to be displayed
        window.setScene(main);
        window.show();

    }

    public VBox mainSceneContent() {
        // mainMenu Layout
        VBox mainLayout = new VBox();
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #FFFF20; ");
        mainLayout.setSpacing(GAP);
        // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF
        // setting up buttons and labels for scene layout
        startBtn = new Button(START);
        exitBtn = new Button(STOP);
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
        title.setFont(TITLESTYLE);
        // add lagels and buttons to the layout
        mainLayout.getChildren().addAll(title, synopsis, startBtn, exitBtn);
        // all actions associated with this scene
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                Platform.exit();
            }
        });
        exitBtn.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) Platform.exit();
            if (e.getCode().equals(KeyCode.W) ||
                (e.getCode().equals(KeyCode.UP))) startBtn.requestFocus();
        });
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                window.setScene(game);
            }
        });
        startBtn.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) window.setScene(game);
            if (e.getCode().equals(KeyCode.S) ||
                (e.getCode().equals(KeyCode.DOWN))) exitBtn.requestFocus();
        });
        return mainLayout;
    }

    public void endSceneContent(boolean state) {
        // depending on the state change the text
    }

    /**
     *
     */
    @Override
    public void handle(KeyEvent e) {
        String userMove = "";

        if (e.getCode().equals(KeyCode.W)) this.userMove = "up";
        if (e.getCode().equals(KeyCode.S)) this.userMove = "down";
        if (e.getCode().equals(KeyCode.A)) this.userMove = "left";
        if (e.getCode().equals(KeyCode.D)) this.userMove = "right";
        if (e.getCode().equals(KeyCode.ESCAPE)) {
            startBtn.setText("RESUME"); // change the button text to say resume in the main menu
            window.setScene(main); // go back to the main menu
        }

        System.out.println(this.userMove); // for test purposes
    }

    /**
     *
     */
    public static void main(String[] args) {
        launch(args);
    }

}
