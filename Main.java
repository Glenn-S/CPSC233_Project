
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import sprite.*;
import gameMechanics.*;
import terminal.*;

/**
 * Purpose: To drive the main game mechanics and prompt the user to start the
 * game. inspiration borrowed from:
 * https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
 * http://www.java-gaming.org/topics/getting-started-with-javafx-game-programming-for-java-programmers/37201/view.html
 *
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Main extends Application implements EventHandler<KeyEvent> { // change this name to be the name of the game

    private final String GAMETITLE = "The Adventures of Montequilla";
    private final String SYNOPSIS
            = "B-town is under attack by \"I can’t believe it\'s not butter\" boy and "
            + "his army of Margarine men. All sources of butter are destroyed in the town "
            + "except for one. Your best friend Butter Bob Brown has been in his lab developing "
            + "a new 0 sodium butter. Realizing the applications for his process of removing "
            + "sodium, \"I can’t believe it’s not butter\" boy abducts him to his lair of oil. "
            + "After remembering something the town oracle spoke of in the past you see the "
            + "ancient scriptures in the town describing a hero of legend who would save the "
            + "Butter Industry from its competitors. Here you acquire the bronze butter knife "
            + "and styrofoam plate shield.  Now it\'s up to you to assemble the holy"
            + "triglyceride (combination of the 3 \"keys\" known as monoglycerides)"
            + "and rescue Butter Bob Brown to restore peace to the Butter Industry.";
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
    private int frameCounter = 0;
    private final int VELOCITY = 15;
    // set up player

    private Pane root = new Pane(); // for game play scenes
    private Stage window;
    private Scene main, game, end, battle; // store scenes for each state

    // battle scene elements
    private ProgressBar enemyHealth;
    private ProgressBar playerHealth;
    private int damage = 0;
    private BattleLoop b;
    private StackPane bRoot;
    private GridPane attacks;
    private TextArea log;
    private ImageView enemyBG;
    private ImageView monte;
    private Button potion;
    // main scene elements

    /**
     * Purpose: The main game driver for The Adventures of Montequilla. this
     * will continue until the user selects quit.
     *
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
                if (frameCounter++ % VELOCITY == 0) { // adjust the frame rate speed to slow down the player
                    if (!userMove.equals("")) {
                        if (!gamePlay.checkCollisions(gamePlay.getPlayer(), userMove)) { // if check collisions comes back false, move the player
                            gamePlay.updatePosition(gamePlay.getPlayer(), userMove);
                        } else if (gamePlay.checkEnemies(userMove, gamePlay.getPlayer(), gamePlay.getEnemy()) != null) {
                            Enemy collidedEnemy = gamePlay.checkEnemies(userMove, gamePlay.getPlayer(), gamePlay.getEnemy());
                            // battle scene setup
                            battle = new Scene(battleSceneContent(gamePlay.getPlayer(), collidedEnemy));
                            battle.getStylesheets().add("BattleGUI.css");
                            window.setScene(battle);
                            battle(gamePlay.getPlayer(), collidedEnemy, gamePlay.getEnemy(), gamePlay.getTerrain(), battle);

                        }
                        root = gamePlay.drawState(gamePlay.getPlayer());

                        game.setRoot(root); // refresh the page
                        userMove = "";
                    }

                    gamePlay.checkGate(gamePlay.getPlayer()); // checks if enough keys have been collected and updates image if needed?
                    if (gamePlay.checkWinState() || gamePlay.checkLoseState()) {
                        boolean winLose = (gamePlay.checkWinState()) ? true : false;
                        // exit menu
                        end = new Scene(endSceneContent(winLose)); // set the scene for main
                        window.setScene(end);
                        //Platform.exit(); // add in exit message later
                    }

                }

            }
        };
        timer.start();
        System.out.println(gamePlay.getPlayer());

        /**
         * 2. Make attack and defense relevant 3. make boss battle work 4. make
         * boss background 5. battle animations
         */
        // add battle scene setups here
        // send the scene to the window to be displayed
        window.setScene(main);
        window.show();

    }

    /**
     * Purpose:
     */
    public StackPane battleSceneContent(Player player, Enemy e) {
        this.b = new BattleLoop();
        this.bRoot = new StackPane();
        Image bkgrnd = new Image("Images/Battle Background.png");
        ImageView i1 = new ImageView(bkgrnd);
        if (e.getName().equals("Boss")) {
            this.enemyBG = new ImageView("Images/I can't believe it's not butter boy_BG.png");
        } else {
            this.enemyBG = new ImageView("Images/Margarine Men_BG.png");
        }

        this.monte = new ImageView("Images/Montequilla_BG.png");
        this.enemyHealth = new ProgressBar(1.0f);
        this.playerHealth = new ProgressBar(1.0f);
        this.playerHealth.setPrefSize(225, 25);
        this.enemyHealth.setPrefSize(225, 25);
        this.playerHealth.setVisible(true);
        this.enemyHealth.setVisible(true);
        i1.setFitHeight(960);
        i1.setFitWidth(1440);
        enemyBG.setFitHeight(400);
        enemyBG.setFitWidth(400);
        monte.setFitHeight(500);
        monte.setFitWidth(500);
        this.log = new TextArea("Select an attack to initiate battle!"
                + "\n(W)(A)(S)(D) = up/down/left/right"
                + "\n(ENTER) = Use highlighted attack");
        log.setPrefSize(300, 240);
        log.setEditable(false);
        this.attacks = new GridPane();
        attacks.setPrefWidth(150);
        attacks.setPrefHeight(120);
        Button slash = new Button("Slash");
        Button bb = new Button("Butter Boomerang");
        Button parry = new Button("Parry");
        this.potion = new Button("Potion");

        slash.setMinSize(attacks.getPrefWidth(), attacks.getPrefHeight());
        bb.setMinSize(attacks.getPrefWidth(), attacks.getPrefHeight());
        parry.setMinSize(attacks.getPrefWidth(), attacks.getPrefHeight());
        this.potion.setMinSize(attacks.getPrefWidth(), attacks.getPrefHeight());
        this.attacks.add(slash, 0, 0);
        this.attacks.add(bb, 1, 0);
        this.attacks.add(parry, 0, 1);
        this.attacks.add(this.potion, 1, 1);
        if (!this.b.playerHasPotion(player) || this.b.validPotion(player) == null) {
            this.potion.setDisable(true);
        }
        AnchorPane ap = new AnchorPane(this.enemyHealth, this.playerHealth, attacks);
        ap.getChildren().add(this.log);
        ap.getChildren().add(this.enemyBG);
        ap.getChildren().add(this.monte);
        AnchorPane.setLeftAnchor(this.enemyBG, 150.0);
        AnchorPane.setTopAnchor(this.enemyBG, 150.0);
        AnchorPane.setRightAnchor(this.monte, 250.0);
        AnchorPane.setBottomAnchor(this.monte, 40.0);
        if (e.getName().equals("Boss")) {
            AnchorPane.setTopAnchor(this.enemyHealth, 275.0);
            AnchorPane.setLeftAnchor(this.enemyHealth, 225.0);

        } else {
            AnchorPane.setTopAnchor(this.enemyHealth, 165.0);
            AnchorPane.setLeftAnchor(this.enemyHealth, 250.0);
        }
        AnchorPane.setTopAnchor(this.playerHealth, 250.0);
        AnchorPane.setRightAnchor(this.playerHealth, 300.0);
        AnchorPane.setBottomAnchor(this.attacks, 0.0);
        AnchorPane.setRightAnchor(this.attacks, 0.0);
        AnchorPane.setBottomAnchor(this.log, 0.0);
        AnchorPane.setLeftAnchor(this.log, 0.0);
        this.bRoot.getChildren().add(i1);
        this.bRoot.getChildren().add(ap);
        return bRoot;
    }

    /**
     * Purpose:
     *
     * @param player
     * @param e
     * @param enemy
     * @param terrain
     * @param battle
     */
    public void battle(Player player, Enemy e, ArrayList<Enemy> enemy, ArrayList<Sprite> terrain, Scene battle) {
        battle.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                this.moveLeftRight(event);
                this.moveupDown(event);
                if (event.getCode() == KeyCode.ENTER) {
                    if (b.checkLoseState(player) || b.checkWinState(e)) {
                        b.setTurnAttack("");
                    }
                    if (!(b.getTurnAttack().equals(""))) {
                        if (b.getBBCounter() == 0) {
                            log.appendText("\nYou used " + b.getTurnAttack());

                            int eH = e.getHealth();
                            b.attackExecute(b.getTurnAttack(), player, e);
                            if (b.getEnemyUsedParry()) {
                                if (e.getHealth() == eH) {
                                    log.appendText("\nEnemy Parry Success!");
                                } else {
                                    log.appendText("\nEnemy Parry Failed!");
                                }

                            }
                        } else if (b.getBBCounter() == 2) {
                            log.appendText("\nBoomerang Fired!");
                            damage = 40;
                            int eH = e.getHealth();
                            b.damageCalc(damage, e, player);
                            if (b.getEnemyUsedParry()) {
                                if (e.getHealth() == eH) {
                                    log.appendText("\nEnemy Parry Success!");
                                } else {
                                    log.appendText("\nEnemy Parry Failed!");
                                }

                            }
                            b.setBBCounter(0);
                        }
                        if (b.getEnemyUsedParry()) {
                            b.setEnemyUsedParry(false);
                        }
                        if (b.checkWinState(e) == true) {
                            this.drawState(player, e);
                            log.appendText("\nYou Win!");
                            enemyBG.setRotate(90);
                            attacks.setVisible(false);
                            enemyHealth.setVisible(false);
                            player.setHealth(100);
                            if (e.getKey()) {
                                player.setKeyCount(player.getKeyCount() + 1);
                                gamePlay.setPlayer(player);
                                log.appendText("\nYou have obtained a key from defeating this enemy!");
                                e.setKey(false);
                            }

                            if (e.getName().equals("Boss")) {
                                end = new Scene(endSceneContent(true)); // set the scene for main
                                end.setOnKeyTyped(e -> { // set key listener for any button to be pressed
                                    // need to reset the game parameters
                                    gamePlay = new GameLoop();
                                    gamePlay.initialize();
                                    //redraw the state
                                    root = gamePlay.drawState(gamePlay.getPlayer());
                                    game.setRoot(root); // refresh the page
                                    window.setScene(main);
                                });
                                window.setScene(end);

                            } else {
                                log.appendText("\nPlayer key count: " + player.getKeyCount());
                                b.removeEnemy(e, enemy, terrain);
                                root = gamePlay.drawState(gamePlay.getPlayer());
                                game.setRoot(root);
                                window.setScene(game);

                            }

                        } else {
                            if (b.getMMCounter() == 1) {
                                log.appendText("\nMargarine Missile Powering Up!");
                                b.setMMCounter(2);
                            }
                            this.drawState(player, e);
                            if (b.getMMCounter() == 0) {
                                String eAttack = e.attackLogic(player);
                                log.appendText("\nEnemy used " + eAttack);
                                int pH = player.getHealth();
                                b.eAttackExecute(eAttack, player, e);
                                if (b.getUsedParry()) {
                                    if (player.getHealth() == pH) {
                                        log.appendText("\nPlayer Parry Success!");
                                    } else {
                                        log.appendText("\nPlayer Parry Failed!");
                                    }

                                }
                            } else if (b.getMMCounter() == 2) {
                                damage = 40;
                                int pH = player.getHealth();
                                b.damageCalc(damage, player, e);
                                log.appendText("\nMissile Fired!");
                                if (b.getUsedParry()) {
                                    if (player.getHealth() == pH) {
                                        log.appendText("\nPlayer Parry Success!");
                                    } else {
                                        log.appendText("\nPlayer Parry Failed!");
                                    }

                                }
                                b.setMMCounter(0);
                            }
                            if (b.getUsedParry()) {
                                b.setUsedParry(false);
                            }
                            if (b.checkLoseState(player) == true) {
                                this.drawState(player, e);
                                log.appendText("\nYou Lose!");
                                monte.setRotate(90);
                                attacks.setVisible(false);
                                playerHealth.setVisible(false);
                                end = new Scene(endSceneContent(false)); // set the scene for main
                                end.setOnKeyTyped(e -> { // set key listener for any button to be pressed
                                    // need to reset the game parameters
                                    gamePlay = new GameLoop();
                                    gamePlay.initialize();
                                    //redraw the state
                                    root = gamePlay.drawState(gamePlay.getPlayer());
                                    game.setRoot(root); // refresh the page
                                    window.setScene(main);
                                });
                                window.setScene(end);
                            }
                            if (b.getBBCounter() == 1) {
                                log.appendText("\nButter Boomerang Powering Up!");
                                log.appendText("\nPress ENTER to fire");
                                b.setBBCounter(2);
                            }
                            this.drawState(player, e);

                        }
                    }

                }

            }

            private void drawState(Player player, Enemy e) {
                playerHealth.setProgress((double) player.getHealth() / 100);
                enemyHealth.setProgress((double) e.getHealth() / 100);
                if (b.playerHasPotion(player) && b.validPotion(player) != null) {
                    potion.setDisable(false);
                } else if (b.getTurnAttack().equals("Potion") && (!b.playerHasPotion(player) || b.validPotion(player) == null)) {
                    potion.setDisable(true);
                    attacks.getChildren().get(0).requestFocus();
                }
            }

            private void moveLeftRight(KeyEvent event) {
                int leftRight = 0; // if 1, move right if -1 move left
                if (event.getCode() == KeyCode.A) {
                    leftRight = -1;
//                    b.setTurnAttack("Butter Boomerang");
                } else if (event.getCode() == KeyCode.D) {
                    leftRight = 1;
                }
                for (int i = 0; i < attacks.getChildren().size(); i++) {
                    if (attacks.getChildren().get(i).isFocused()) {

                        int newRow = GridPane.getRowIndex(attacks.getChildren().get(i));
                        int newCol = GridPane.getColumnIndex(attacks.getChildren().get(i));

                        for (int j = 0; j < attacks.getChildren().size(); j++) {
                            if (GridPane.getRowIndex(attacks.getChildren().get(j)) == newRow && GridPane.getColumnIndex(attacks.getChildren().get(j)) == newCol + leftRight) {
                                attacks.getChildren().get(j).requestFocus();
                                b.setTurnAttack(((Button) attacks.getChildren().get(j)).getText());
                            }
                        }
                    }
                }
            }

            private void moveupDown(KeyEvent event) {
                int upDown = 0;
                if (event.getCode() == KeyCode.W) {
//                    b.setTurnAttack("Slash");
                    upDown = -1;
                } else if (event.getCode() == KeyCode.S) {
                    upDown = 1;
                }
                for (int i = 0; i < attacks.getChildren().size(); i++) {
                    if (attacks.getChildren().get(i).isFocused()) {

                        int newRow = GridPane.getRowIndex(attacks.getChildren().get(i));
                        int newCol = GridPane.getColumnIndex(attacks.getChildren().get(i));

                        for (int j = 0; j < attacks.getChildren().size(); j++) {
                            if (GridPane.getRowIndex(attacks.getChildren().get(j)) == (newRow + upDown) && GridPane.getColumnIndex(attacks.getChildren().get(j)) == newCol) {
                                attacks.getChildren().get(j).requestFocus();
                                b.setTurnAttack(((Button) attacks.getChildren().get(j)).getText());
                            }
                        }
                    }
                }
            }
        });
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
            if (e.getCode().equals(KeyCode.ENTER)) {
                Platform.exit();
            }
            if (e.getCode().equals(KeyCode.W)
                    || (e.getCode().equals(KeyCode.UP))) {
                startBtn.requestFocus();
            }
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
            if (e.getCode().equals(KeyCode.S)
                    || (e.getCode().equals(KeyCode.DOWN))) {
                exitBtn.requestFocus();
            }
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
        endContent.setSpacing(GAP * 2);

        // GO BACK AND CITE HOW I KNOW HOW TO DO SOME OF THIS STUFF
        Label userMsg = new Label();
        if (win) {
            userMsg.setText(WINMESSAGE);
        }
        if (!win) {
            userMsg.setText(LOSEMESSAGE);
        }
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
        /* backdoor for testing
        if (e.getCode().equals(KeyCode.Q)) {
            startBtn.setText(START); // change the button text to say start in the main menu
            window.setScene(end); // go back to the main menu
        }
         */
        if (e.getCode().equals(KeyCode.W)) {
            this.userMove = "up";
        }
        if (e.getCode().equals(KeyCode.S)) {
            this.userMove = "down";
        }
        if (e.getCode().equals(KeyCode.A)) {
            this.userMove = "left";
        }
        if (e.getCode().equals(KeyCode.D)) {
            this.userMove = "right";
        }
        if (e.getCode().equals(KeyCode.ESCAPE)) {
            startBtn.setText(RESUME); // change the button text to say resume in the main menu
            window.setScene(main); // go back to the main menu
        }

        System.out.println(this.userMove); // for test purposes
    }

    /**
     * Purpose:
     */
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("terminal")) {
            MainTerminal game = new MainTerminal();
            boolean playGame = true;
            String exitMsg = "Thanks for playing!";

            while (playGame) { // loop until false is selected
                playGame = game.mainMenu();
                if (playGame == false) {
                    continue;
                }
                game.gameLoop(); // instantiates a new instance of the game
            }
            System.out.println(exitMsg); // exit splash screen
            System.exit(0); // terminate the program
        } else if (args.length == 0) {
            launch(args);
        }

    }

}
