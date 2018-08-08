package gameMechanics;

import static java.awt.SystemColor.text;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Skin;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import sprite.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nathan
 */
public class BattleGUI {

    private ProgressBar enemyHealth = new ProgressBar(1.0f);
    private ProgressBar playerHealth = new ProgressBar(1.0f);
    private int damage = 0;
    private BattleLoop b;
    private StackPane root;
    private GridPane attacks;
    private TextArea log;
    private ImageView margM;
    private ImageView monte;
    private Button potion;

    public BattleGUI(Player player) {
        this.b = new BattleLoop();
        this.root = new StackPane();
        Image bkgrnd = new Image("Images/Battle Background.png");
        ImageView i1 = new ImageView(bkgrnd);
        this.margM = new ImageView("Images/Margarine Men_BG.png");
        this.monte = new ImageView("Images/Montequilla_BG.png");
        this.playerHealth.setPrefSize(225, 25);
        this.enemyHealth.setPrefSize(225, 25);
        i1.setFitHeight(960);
        i1.setFitWidth(1440);
        margM.setFitHeight(400);
        margM.setFitWidth(400);
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
        ap.getChildren().add(this.margM);
        ap.getChildren().add(this.monte);
        AnchorPane.setLeftAnchor(this.margM, 150.0);
        AnchorPane.setTopAnchor(this.margM, 150.0);
        AnchorPane.setRightAnchor(this.monte, 250.0);
        AnchorPane.setBottomAnchor(this.monte, 40.0);
        AnchorPane.setTopAnchor(this.enemyHealth, 165.0);
        AnchorPane.setLeftAnchor(this.enemyHealth, 250.0);
        AnchorPane.setTopAnchor(this.playerHealth, 250.0);
        AnchorPane.setRightAnchor(this.playerHealth, 300.0);
        AnchorPane.setBottomAnchor(this.attacks, 0.0);
        AnchorPane.setRightAnchor(this.attacks, 0.0);
        AnchorPane.setBottomAnchor(this.log, 0.0);
        AnchorPane.setLeftAnchor(this.log, 0.0);
        this.root.getChildren().add(i1);
        this.root.getChildren().add(ap);
        Scene scene = new Scene(this.root, 8000, 4000);

        scene.getStylesheets().add("textareafix.css");
        Stage battleStage = new Stage();
        battleStage.setTitle("Battle!");
        battleStage.setScene(scene);
        battleStage.requestFocus();
        battleStage.show();
    }

    public void battle(Player player, Enemy e, ArrayList<Enemy> enemy, ArrayList<Sprite> terrain) {
        root.setOnKeyReleased(new EventHandler<KeyEvent>() {
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
                            b.damageCalc(damage, e,player);
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
                            margM.setRotate(90);
                            attacks.setVisible(false);
                            enemyHealth.setVisible(false);
                            player.setHealth(100);
                            if (e.getKey()) {
                                player.setKeyCount(player.getKeyCount() + 1);
                                log.appendText("\nYou have obtained a key from defeating this enemy!");
                                e.setKey(false);
                            }
                            log.appendText("\nPlayer key count: " + player.getKeyCount());
                            b.removeEnemy(e, enemy, terrain);

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
                                b.damageCalc(damage, player,e);
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

        }
        );
    }

}
