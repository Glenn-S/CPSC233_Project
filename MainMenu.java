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
    private final String GAMETITLE = "The Adventures of Montequilla";
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
    private final int WINWIDTH = 1440, WINHEIGHT = 800; // used to be 720

    // main menu stylings CONSTANTS
    private final String START = "START"; // label for the start button
    private final String RESUME = "RESUME"; // label for the resume button
    private final String STOP = "STOP"; // label for the exit button
    private final Font BTNSTYLE = new Font(24); // set the button stylings
    private final Font TITLESTYLE = new Font("Verdana", 42); // set the title stylings
    private final Font SYNOPSISSTYLE = new Font(18); // set the text stylings
    private final double GAP = 10.0; // set the button gap widths
    private final double BTNWIDTH = 150, BTNHEIGHT = 40; // set the width and height for the buttons
    // setup buttons for main
    private Button startBtn;
    private Button exitBtn;

    // return menu stylings
    private final String LOSEMESSAGE = "CONGRATULATIONS! YOU ARE THE WORST AT WINNING";
    private final String WINMESSAGE = "CONGRATULATIONS! YOU ARE THE BEST AT NOT LOSING";
    private final String RETURNMSG = "Press any key to return to the main menu";
    private final String TEMPMSG = "Press any key to quit";
    private final String MSGSTYLE = "-fx-font-size: 36; ";
    private final String PROMPTSTYLE = "-fx-font-size: 24; ";

    // game play Constants
    private String userMove = "";
    private GameLoop gamePlay = new GameLoop();
    // set up player


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
        //window.setMaximized(true);

        // main Scene
        main = new Scene(mainSceneContent()); // set the scene for main
        gamePlay.initialize(); // maybe pass player into initialize to add items

        // end screen
        end = new Scene(endSceneContent(true));
        end.setOnKeyTyped(e -> { // set key listener for any button to be pressed
            // need to reset the game parameters
            gamePlay = new GameLoop();
            gamePlay.initialize();
            //redraw the state
            root = gamePlay.drawState(gamePlay.getPlayer());
            game.setRoot(root); // refresh the page
            window.setScene(main);
        });

        // game Scene
        //System.out.println(this.player.getCoord()); // for test purposes
        game = new Scene(root); // set up the game state scene
        root = gamePlay.drawState(gamePlay.getPlayer()); // draw the initial game state
        game.setOnKeyPressed(this);
        game.setRoot(root);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!userMove.equals("")) {
                    if (!gamePlay.checkCollisions(gamePlay.getPlayer(), userMove)) { // if check collisions comes back false, move the player
                        gamePlay.updatePosition(gamePlay.getPlayer(), userMove);
                    }
                    root = gamePlay.drawState(gamePlay.getPlayer());
                    game.setRoot(root); // refresh the page
                    userMove = "";
                }

                gamePlay.checkGate(gamePlay.getPlayer()); // checks if enough keys have been collected and updates image if needed?
                if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                    boolean winLose = (gamePlay.checkWinState()) ? true : false;
                    // exit menu
                    end = new Scene(endSceneContent(winLose)); // set the scene for main
                    window.setScene(end);
                    //Platform.exit(); // add in exit message later
                }
            }
        };
        timer.start();
        System.out.println(gamePlay.getPlayer());

        // battleScene
        // add battle scene setups here



        // send the scene to the window to be displayed
        window.setScene(main);
        window.show();

    }

    /**
     * Purpose:
     */
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
            if (e.getCode().equals(KeyCode.ENTER)) {
                window.setScene(game);
            }
            if (e.getCode().equals(KeyCode.S) ||
                (e.getCode().equals(KeyCode.DOWN))) exitBtn.requestFocus();
        });
        return mainLayout;
    }

    /**
     * Purpose:
     */
    public VBox endSceneContent(boolean win) {
        // depending on the state change the text
        VBox endContent = new VBox();

        endContent.setAlignment(Pos.CENTER);
        endContent.setSpacing(GAP*2);

        // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF
        Label userMsg = new Label();
        if (win) userMsg.setText(WINMESSAGE);
        if (!win) userMsg.setText(LOSEMESSAGE);
        userMsg.setStyle(MSGSTYLE);

        Label prompt = new Label(RETURNMSG);
        prompt.setStyle(PROMPTSTYLE);
        endContent.getChildren().addAll(userMsg, prompt);

        return endContent;

    }

    /**
     * Purpsoe:
     */
    @Override
    public void handle(KeyEvent e) {
        userMove = "";
        if (e.getCode().equals(KeyCode.Q)) {
            startBtn.setText(START); // change the button text to say start in the main menu
            window.setScene(end); // go back to the main menu
        }
        if (e.getCode().equals(KeyCode.W)) this.userMove = "up";
        if (e.getCode().equals(KeyCode.S)) this.userMove = "down";
        if (e.getCode().equals(KeyCode.A)) this.userMove = "left";
        if (e.getCode().equals(KeyCode.D)) this.userMove = "right";
        if (e.getCode().equals(KeyCode.ESCAPE)) {
            startBtn.setText(RESUME); // change the button text to say resume in the main menu
            window.setScene(main); // go back to the main menu
        }
        if (true) {
            // check to see if enter was pressed near a chest
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
