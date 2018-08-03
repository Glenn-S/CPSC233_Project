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
 * http://www.java-gaming.org/topics/getting-started-with-javafx-game-programming-for-java-programmers/37201/view.html
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Main2 extends Application implements EventHandler<KeyEvent> { // change this name to be the name of the game
    private final int HEIGHT = 4000;
    private final int WIDTH = 8000;
    private final String GAMETITLE = "The Adventures of Montequilla";
    private String userMove = "";
    private GameLoop gamePlay;
    //private Scene scene;
    private Player player;

    private Pane root = new Pane();

    /**
     * Purpose: The main game driver for The Adventures of Montequilla. this
     * will continue until the user selects quit.
     * @param window a Stage class used to
     */
    @Override
    public void start(Stage window) throws Exception {
        gamePlay = new GameLoop();
        gamePlay.initialize();
        String[] moves = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        player =  new Player("Montequilla", new Location(1, 1, 0, 0), new Image("file:Images/Montequilla.png"), 'x',
                                null, true, false, 100, 25, 25, moves);
        Weapon starterSword = new Weapon("Bronze Butterknife", null, null, ' ', null, true, false, 50);
        Defence starterShield = new Defence("Styrofoam Plate Shield", null, null, ' ', null, true, false, 50);
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 25);
        player.addItem(starterSword);
        player.updateAttack(starterSword);
        player.addItem(starterShield);
        player.updateDefence(starterShield);
        player.addItem(smallPotion);

        System.out.println(this.player.getCoord());
        window.setWidth(1440);
        window.setHeight(720);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(this);

        root = gamePlay.drawState(player);

        scene.setRoot(root);
        window.setScene(scene);
        window.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!userMove.equals("")) {
                    if (!gamePlay.checkCollisions(player, userMove)) { // if check collisions comes back false, move the player
                        gamePlay.updatePosition(player, userMove);
                    }
                    root = gamePlay.drawState(player);
                    scene.setRoot(root); // refresh the page
                    userMove = "";
                }

                gamePlay.checkGate(player); // checks if enough keys have been collected and updates image if needed?
                if (gamePlay.checkWinState() || gamePlay.checkLoseState()){
                    // if game is done
                    Platform.exit(); // add in exit message later
                }

            }
        };
        timer.start();

    }

    @Override
    public void handle(KeyEvent e) {
        String userMove = "";

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

        //System.out.println(this.userMove);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
