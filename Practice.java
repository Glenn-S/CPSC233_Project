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

import javafx.scene.shape.Circle;
import javafx.scene.shape.Box;

public class Practice extends Application implements EventHandler<KeyEvent> {
    final int WIDTH = 400;
    final int HEIGHT = 600;

    double ballRadius = 40;
    double ballX = 100;
    double ballY = 100;
    double xSpeed = 4;



    @Override
    public void start(Stage stage) {
        stage.setTitle("Game");

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        //Bouncing ball
        Circle circle = new Circle();
        circle.setCenterX(ballX);
        circle.setCenterY(ballY);
        circle.setRadius(ballRadius);
        circle.setFill(Color.BLUE);
        root.getChildren().add(circle);

        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();
        keyboardNode.setOnKeyPressed(this);

        root.getChildren().add(keyboardNode);

        stage.setScene(scene);
        stage.show();

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                ballX += xSpeed;

                if (ballX + ballRadius >= WIDTH) {
                    ballX = WIDTH - ballRadius;
                    xSpeed *= -1;
                }
                else if (ballX - ballRadius < 0) {
                    ballX = 0 + ballRadius;
                    xSpeed *= -1;
                }
                circle.setCenterX(ballX);
            }
        };
        animation.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent ke) {
        if (ke.getCode() == KeyCode.SPACE) {
            xSpeed *= -1;
        }
    }
}
