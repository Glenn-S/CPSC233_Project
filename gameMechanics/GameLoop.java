package gameMechanics;

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
import javafx.scene.image.ImageView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import sprite.*;

/**
 * Purpose: to run the underlying mechanics of the game loop.
 *
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoop {

    private int boardHeight = 40, boardLength = 80;
    private ArrayList<Sprite> terrain;
    private ArrayList<Sprite> items;
    private ArrayList<Enemy> enemy;
    private char[][] printArray = new char[boardHeight][boardLength]; //[40][80]
    private int totalKeys; // total number of keys in the game
    private boolean winState;
    private boolean loseState;
    private Player player;
    private boolean terminal;

    /*---------------------------- CONSTRUCTORS ------------------------------*/
    /**
     * Purpose: To create a default constructor for the GameLoop class.
     */
    public GameLoop() {
        this.terrain = new ArrayList<Sprite>();
        this.items = new ArrayList<Sprite>();
        this.enemy = new ArrayList<Enemy>();
        this.totalKeys = 4; // default value
        this.winState = false;
        this.loseState = false;
    }

    /**
     * Purpose: To create a constructor to allow the user to set the arrays and
     * the number of keys in the game.
     *
     * @param terrain a list of all the terrain elements
     * @param items a list of all the items in the game
     * @param enemy a list of all the enemies in the game
     * @param totalKeys the total number of keys for the game
     */
    public GameLoop(ArrayList<Sprite> terrain, ArrayList<Sprite> items,
            ArrayList<Enemy> enemy, int totalKeys) {
        this.terrain = (terrain != null) ? terrain : new ArrayList<Sprite>();
        this.items = (items != null) ? items : new ArrayList<Sprite>();
        this.enemy = (enemy != null) ? enemy : new ArrayList<Enemy>();
        this.totalKeys = (totalKeys > 0) ? totalKeys : 4;
        this.winState = false;
        this.loseState = false;
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To retrieve the array list for the terrain objects
     * Can not create a new arraylist to be returned because then we
     * are not able to place the tombstone image onto the map, after an
     * enemy has been defeated
     *
     *
     * @return an array list containing the terrain objects
     */
    public ArrayList<Sprite> getTerrain() {

    /* ArrayList<Sprite> copyList = new ArrayList<Sprite>();
  		for (int i = 0; i < this.terrain.size(); i++) {
  			copyList.set(i, new Sprite(this.terrain.get(i)));
  		}
      return copyList;
        */
        return this.terrain;
    }

    /**
     * Purpose: To retrieve the array list for the item objects
     *  commented out the copy of the arraylist, exception is thrown
  	 * in main if a copy of the arraylist is returned
     *
     * @return an array list containing the item objects
     */
    public ArrayList<Sprite> getItem() {
      /*
    ArrayList<Sprite> copyList = new ArrayList<Sprite>();
    		for (int i = 0; i < this.items.size(); i++) {
    			copyList.set(i, new Sprite(this.items.get(i)));
    		}
    return copyList;
    */
    return this.items;
  }

    /**
     * Purpose: To retrieve the array list for the enemy objects
     * If a new arrayList is created, and returned then we are not
     * able to remove the enemies image off the map when a battle
     * is finished
     * @return an array list containing the enemy objects
     */
    public ArrayList<Enemy> getEnemy() {

    /*  ArrayList<Enemy> copyList = new ArrayList<Enemy>();
    		for (int i = 0; i < this.enemy.size(); i++) {
    			copyList.set(i, new Enemy(this.enemy.get(i)));
    		}
        return copyList;
*/
  return this.enemy;
    }

    /**
     * Purpose: To retrieve the number of keys in the game
     *
     * @return the totalKeys
     */
    public int getTotalKeys() {
        return this.totalKeys;
    }

    /**
     * Purpose: To get the value of the win state variable
     *
     * @return the win state condition flag
     */
    public boolean checkWinState() {
        return this.winState; // returns true if true else false
    }

    /**
     * Purpose: To get the value of the lose state variable
     *
     * @return the lose state condition flag
     */
    public boolean checkLoseState() {
        return this.loseState; // returns true if true else false
    }

    /**
     * Purpose: To return the player currently in the game
     *
     * @return the player
     */
    public Player getPlayer() {
        return new Player(player);
    }

    /**
     * Purpose: To set a new terrain objects list for the current game
     *
     * @param newTerrainList an array list of terrain objects
     */
    public void setTerrain(ArrayList<Sprite> newTerrainList) {
        if (newTerrainList != null) {
            this.terrain = newTerrainList;
        }
    }

    /**
     * Purpose: To set a new item objects list for the current game
     *
     * @param newItemList an array list of item objects
     */
    public void setItem(ArrayList<Sprite> newItemList) {
        if (newItemList != null) {
            this.items = newItemList;
        }
    }

    /**
     * Purpose: To set a new enemy list for the current game
     *
     * @param newEnemyList an array list of enemy objects
     */
    public void setEnemy(ArrayList<Enemy> newEnemyList) {
        if (newEnemyList != null) {
            this.enemy = newEnemyList;
        }
    }

    /**
     * Purpose: To change the win state boolean value
     *
     * @param value the new boolean value to set winState to
     */
    public void setWinState(boolean value) {
        this.winState = value;
    }

    /**
     * Purpose: To change the lose state boolean value
     *
     * @param value the new boolean value to set loseState to
     */
    public void setLoseState(boolean value) {
        this.loseState = value;
    }

    /**
     * Purpose: To set the print array with a new array of elements to print
     *
     * @param printArray the printArray to set
     */
    /*
    public void setPrintArray(char[][] printArray) {
        this.printArray = printArray;
    }
     */

    /**
     * Purpose: to set the player for the current game.
     *
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = new Player(player);
    }

    /**
     * Purpose: to return the print array for the terminal version
     *
     * @return the printArray
     */

    public char[][] getPrintArray() {
        return printArray;
    }

    /**
     * Purpose: To return whether the terminal version is in use or not
     *
     * @return the value of whether the terminal is in use for this game
     */
    public boolean getTerminal() {
        return this.terminal;
    }
    /**
     * Purpose: To set the terminal field for knowing if the terminal version is
     * in use.
     *
     * @param value a value to set for whether the terminal is in use or not
     */
    public void setTerminal(boolean value) {
        this.terminal = value;
    }

    /*------------------------------- METHODS --------------------------------*/
    /**
     * Purpose: To initialize all of the arrays that contain objects in the game
     * and the player for the game
     */
    public void initialize() {
        GameBoard gb = new GameBoard();
        gb.createItemArray(this.items);
        gb.createTerrainArray(this.terrain);
        gb.createEnemyArray(this.enemy);

        // setup the player
        String[] moves = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        this.setPlayer(new Player("Montequilla", new Location(3, 38, 0, 0),
                new Image("file:Images/Montequilla.png"), 'x', null, true,
                false, 100, 25, 25, moves));
        Weapon starterSword = new Weapon("Bronze Butterknife", null, new Image("file:Images/Bronze butterknife.png"), ' ', null, true, false, 50);
        Defence starterShield = new Defence("Styrofoam Plate Shield", null, new Image("file:Images/bronzeShield.png"), ' ', null, true, false, 50);
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), new Image("file:Images/Small potion.png"), ' ', null, true, false, 25);

        player.addItem(starterSword);
        System.out.println("*** " + starterSword.getName() + " has been added to your pack ***");
        player.updateAttack(starterSword);
        player.addItem(starterShield);
        System.out.println("*** " + starterShield.getName() + " has been added to your pack ***");
        player.updateDefence(starterShield);
        player.addItem(smallPotion);
        System.out.println("*** " + smallPotion.getName() + " has been added to your pack ***");
    }

    /**
     * Purpose: To check and see if the players move will collide with an enemy
     * on the map.
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an enemy
     */
    private boolean checkEnemies(Player player, String move, ArrayList<Enemy> enemy) {
        boolean result = false;

        if ((player != null) && (enemy != null)) { // this could be a try and except statement?
            for (int i = 0; i < enemy.size(); i++) {
                if (!enemy.get(i).getExists()) {
                    continue; // go to the next item since this object doesn't exist
                }
                switch (move) { // check the tile adjacent
                    case "up":
                        if ((player.getCoord().getUpperBoundary() - 1 == enemy.get(i).getCoord().getLowerBoundary())
                                && (player.getCoord().getLeftBoundary() >= enemy.get(i).getCoord().getLeftBoundary())
                                && (player.getCoord().getRightBoundary() <= enemy.get(i).getCoord().getRightBoundary())) {
                            if (this.getTerminal() == true) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy for terminal version
                            }
                            result = true;
                        }
                        break;
                    case "down":
                        if (player.getCoord().getLowerBoundary() + 1 == enemy.get(i).getCoord().getUpperBoundary()
                                && (player.getCoord().getLeftBoundary() >= enemy.get(i).getCoord().getLeftBoundary())
                                && (player.getCoord().getRightBoundary() <= enemy.get(i).getCoord().getRightBoundary())) {
                            if (this.getTerminal() == true) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy for terminal version
                            }
                            result = true;
                        }
                        break;
                    case "left":
                        if (player.getCoord().getLeftBoundary() - 1 == enemy.get(i).getCoord().getRightBoundary()
                                && (player.getCoord().getUpperBoundary() >= enemy.get(i).getCoord().getUpperBoundary())
                                && (player.getCoord().getLowerBoundary() <= enemy.get(i).getCoord().getLowerBoundary())) {
                            if (this.getTerminal() == true) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy for terminal version
                            }
                            result = true;
                        }
                        break;
                    case "right":
                        if (player.getCoord().getRightBoundary() + 1 == enemy.get(i).getCoord().getLeftBoundary()
                                && (player.getCoord().getUpperBoundary() >= enemy.get(i).getCoord().getUpperBoundary())
                                && (player.getCoord().getLowerBoundary() <= enemy.get(i).getCoord().getLowerBoundary())) {
                            if (this.getTerminal() == true) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy for terminal version
                            }
                            result = true;
                        }
                        break;
                }
            }
        }
        return result;
    }

    /**
     * Purpose: To To check and see if the players move will collide with an
     * enemy on the map. This method overloads the original checkEnemies and
     * instead returns an enemy.
     *
     * @return an enemy that was obtained from seraching the list
     */
    public Enemy checkEnemies(String move, Player player , ArrayList<Enemy> enemy) {
        if ((player != null) && (enemy != null)) { // this could be a try and except statement?
            for (int i = 0; i < enemy.size(); i++) {
                if (!enemy.get(i).getExists()) {
                    continue; // go to the next item since this object doesn't exist
                }
                switch (move) { // check the tile adjacent
                    case "up":
                        if ((player.getCoord().getUpperBoundary() - 1 == enemy.get(i).getCoord().getLowerBoundary())
                                && (player.getCoord().getLeftBoundary() >= enemy.get(i).getCoord().getLeftBoundary())
                                && (player.getCoord().getRightBoundary() <= enemy.get(i).getCoord().getRightBoundary())) {
                                  //return enemy.get(i);
                                  return new Enemy(enemy.get(i));
                                  /*No enemy copy constructor as of yet, can not test*/
                        }
                        break;
                    case "down":
                        if (player.getCoord().getLowerBoundary() + 1 == enemy.get(i).getCoord().getUpperBoundary()
                                && (player.getCoord().getLeftBoundary() >= enemy.get(i).getCoord().getLeftBoundary())
                                && (player.getCoord().getRightBoundary() <= enemy.get(i).getCoord().getRightBoundary())) {
                            //return enemy.get(i);
                            return new Enemy(enemy.get(i));
                            /*No enemy copy constructor as of yet, can not test*/
                        }
                        break;
                    case "left":
                        if (player.getCoord().getLeftBoundary() - 1 == enemy.get(i).getCoord().getRightBoundary()
                                && (player.getCoord().getUpperBoundary() >= enemy.get(i).getCoord().getUpperBoundary())
                                && (player.getCoord().getLowerBoundary() <= enemy.get(i).getCoord().getLowerBoundary())) {
                            //return enemy.get(i);
                            return new Enemy(enemy.get(i));
                            /*No enemy copy constructor as of yet, can not test*/
                        }
                        break;
                    case "right":
                        if (player.getCoord().getRightBoundary() + 1 == enemy.get(i).getCoord().getLeftBoundary()
                                && (player.getCoord().getUpperBoundary() >= enemy.get(i).getCoord().getUpperBoundary())
                                && (player.getCoord().getLowerBoundary() <= enemy.get(i).getCoord().getLowerBoundary())) {
                            //return enemy.get(i);
                            return new Enemy(enemy.get(i));
                            /*No enemy copy constructor as of yet, can not test*/
                        }
                        break;
                }
            }
        }
        return null;
    }

    /**
     * Purpose: To check and see if the players move will collide with a terrain
     * tile that cannot be crossed (ie. mountains).
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with a terrain tile that is
     * un-crossable
     */
     private boolean checkSprites(Player player, String move, ArrayList<Sprite> obj) { // for checking terrain and items
        boolean result = false;

        if ((player != null) && (obj != null)) { // this could be a try and except statement?
            for (int i = 0; i < obj.size(); i++) {
                if (!obj.get(i).getExists()) {
                    continue; // go to the next item since this object doesn't exist
                }
                switch (move) { // evaluate each adjacent tile for collisions
                    case "up":
                            if ((player.getCoord().getUpperBoundary() - 1 == obj.get(i).getCoord().getLowerBoundary())
                                    && (player.getCoord().getLeftBoundary() >= obj.get(i).getCoord().getLeftBoundary())
                                    && (player.getCoord().getRightBoundary() <= obj.get(i).getCoord().getRightBoundary())) {
                                this.checkItemType(obj, i);
                                result = true;
                            }
                            break;

                    case "down":
                        if (player.getCoord().getLowerBoundary() + 1 == obj.get(i).getCoord().getUpperBoundary() &&
                                (player.getCoord().getLeftBoundary() >= obj.get(i).getCoord().getLeftBoundary()) &&
                                (player.getCoord().getRightBoundary() <= obj.get(i).getCoord().getRightBoundary())) {
                            this.checkItemType(obj, i);
                            result = true;
                        }
                        break;
                    case "left":
                        if (player.getCoord().getLeftBoundary() - 1 == obj.get(i).getCoord().getRightBoundary() &&
                                (player.getCoord().getUpperBoundary() >= obj.get(i).getCoord().getUpperBoundary()) &&
                                (player.getCoord().getLowerBoundary() <= obj.get(i).getCoord().getLowerBoundary())) {
                            this.checkItemType(obj, i);
                            result = true;
                        }
                        break;
                    case "right":
                        if (player.getCoord().getRightBoundary() + 1 == obj.get(i).getCoord().getLeftBoundary() &&
                                (player.getCoord().getUpperBoundary() >= obj.get(i).getCoord().getUpperBoundary()) &&
                                (player.getCoord().getLowerBoundary() <= obj.get(i).getCoord().getLowerBoundary())) {
                            this.checkItemType(obj, i);
                            result = true;
                        }
                        break;
                }
            }
        }
        return result;
    }

    /**
     * Purpose: To determine if the item can be picked up and if so, if it is a
     * weapon or shield, remove the old one and replace it with the new. This
     * only happens if the item is better than the one they currently own.
     * @param obj
     * @param index
     */
    private void checkItemType(ArrayList<Sprite> obj, int index) {
        if ((obj.get(index) instanceof Potion) ||
                (obj.get(index) instanceof Defence) ||
                (obj.get(index) instanceof Weapon)) {

            if (obj.get(index) instanceof Potion) {
                pickUpItem(player, obj.get(index));
            }
            if (obj.get(index) instanceof Weapon) {
                ArrayList<Sprite> newItemList = player.getItems();
                for (int i = 0; i < newItemList.size(); i++) {
                    if ((newItemList.get(i) instanceof Weapon) &&
                        (((Weapon)newItemList.get(i)).getWeaponBoost() < ((Weapon)obj.get(index)).getWeaponBoost())){
                        //newItemList.set(i, obj.get(index))
                        player.updateAttack((Weapon)obj.get(index));
                        newItemList.set(i, (Weapon)obj.get(index));
                    }
                }
                player.setItems(newItemList);
            }
            if (obj.get(index) instanceof Defence) {
                ArrayList<Sprite> newItemList = player.getItems();
                // remove the old shield
                for (int i = 0; i < newItemList.size(); i++) {
                    if ((newItemList.get(i) instanceof Defence) &&
                        (((Defence)newItemList.get(i)).getDefenceBoost() < ((Defence)obj.get(index)).getDefenceBoost())){
                        //newItemList.set(i, obj.get(index))
                        player.updateDefence((Defence)obj.get(index));
                        newItemList.set(i, (Defence)obj.get(index));
                    }
                }
                player.setItems(newItemList);
            }
            System.out.println("\n\n*** " + obj.get(index).getName() + " has been added to your pack ***\n"); // for terminal version

            obj.remove(obj.get(index)); // remove the object from the array
            // open the chest after an item has been picked up
            obj.get(index).setSpriteImage(new Image("file:Images/chest2.png"));
            System.out.println(player.getInventory(true)); // for testing
        }
    }

    /**
     * Purpose: To check and see if the players move will collide with an edge
     * of the map.
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an edge of the map
     */
    private boolean checkEdges(Player player, String move) {
        boolean result = false;

        if (player != null) { // this could be a try and except statement?
            switch (move) {
                case "up":
                    if (player.getCoord().getUpperBoundary() - 1 == 0) result = true;
                    break;
                case "down":
                    if (player.getCoord().getLowerBoundary() + 1 == this.boardHeight - 1) result = true;
                    break;
                case "left":
                    if (player.getCoord().getLeftBoundary() - 1 == 0) result = true;
                    break;
                case "right":
                    if (player.getCoord().getRightBoundary() + 1 == this.boardLength - 1) result = true;
                    break;
            }
        }
        return result;
    }

    /**
     * Purpose: To check and see if the player has obtained tall of the keys
     * necessary to unlock the gate to the final boss.
     *
     * @param player an instance of the player class in the current game
     * @return a boolean value for if the player meets the condition to unlock
     */
    public boolean checkGate(Player player) {
        boolean gateOpen = (player.getKeyCount() == totalKeys - 1) ? true : false;
        if (gateOpen) {
            updateGate(); // if it is open, delete the previous gate
        }
        return gateOpen;
    }

    /**
     * Purpose: To update all of the gate images if needed. For now it will just
     * remove the gates from the terrain list.
     */
    public void updateGate() {
        for (int i = 0; i < terrain.size(); i++) {
            if (terrain.get(i).getName().equals("gate")) {
                //System.out.println("Gate, index " + i + " in the terrain array");
                terrain.remove(i); // remove the element from the terrain list
                i--;
                //terrain.get(i).setExists(false);
                //terrain.get(i).setSpriteChar(' ');
            }
        }
        // silently get rid of the gate
/*        for (int i = 0; i < terrain.size(); i++) {
            if (terrain.get(i).getName().equals("gate")) {
                System.out.println("Error, index " + i + " in the terrain array");
            }
        }
*/
    }

    /**
     * Purpose: To take the move entered by the user and, given that the move is
     * valid from a prior check, adjust the players coordinates appropriately.
     *
     * @param player an instance of a player who is controlled by the user
     * @param move a string representation of the move being performed
     */
    public void updatePosition(Player player, String move) {
        switch (move) {
            case "up":
                player.updatePosition(player.getCoord().getxCoord(), player.getCoord().getyCoord() - 1);
                break;
            case "down":
                player.updatePosition(player.getCoord().getxCoord(), player.getCoord().getyCoord() + 1);
                break;
            case "left":
                player.updatePosition(player.getCoord().getxCoord() - 1, player.getCoord().getyCoord());
                break;
            case "right":
                player.updatePosition(player.getCoord().getxCoord() + 1, player.getCoord().getyCoord());
                break;
        }
    }


    /**
     * Purpose: This method adds the images from the terrain, items, and enemy
     * arraylists to a gridpane. This grid pane is then put onto a flow pane
     * which is then returned
     *
     * @param player This is the player that is playing the game. Their image
     * has to be added to the grid pane, as they are not a part of any arraylist
     * @return a pane to set the window with for the games current state while
     * in play
     */
    public Pane drawState(Player player) {
        //Scene scene = new Scene(new Group());
        VBox root = new VBox();
        Group group = new Group();
        Canvas foreground = new Canvas(4000, 2000); // old values 8000x4000
        GraphicsContext gc = foreground.getGraphicsContext2D();

        ImageView backing = new ImageView(new Image("file:Images/background.png"));
        ScrollPane scrollPane = new ScrollPane();
        // go through each list and draw the images to the scene
        for (int i = 0; i < getEnemy().size(); i++) {
            gc.drawImage(enemy.get(i).getSpriteImage(), enemy.get(i).getCoord().getPixelX(), enemy.get(i).getCoord().getPixelY());
        }
        for (int i = 0; i < getTerrain().size(); i++) {
            gc.drawImage(terrain.get(i).getSpriteImage(), terrain.get(i).getCoord().getPixelX(), terrain.get(i).getCoord().getPixelY());
        }
        for (int i = 0; i < getItem().size(); i++) {
            if (items.get(i).getName().equals("Chest")){
                gc.drawImage(items.get(i).getSpriteImage(), items.get(i).getCoord().getPixelX(), items.get(i).getCoord().getPixelY());
            }
        }
        // draw the player
        gc.drawImage(player.getSpriteImage(), player.getCoord().getPixelX(), player.getCoord().getPixelY());
        group.getChildren().addAll(backing, foreground);
        // turn off the scroll bars so that they aren't visible

        scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setContent(group);
        // set the scroll to follow the player as they move relative to the viewable area
        if (player.getCoord().getxCoord() < 15) scrollPane.setHvalue(0.0);
        else scrollPane.setHvalue(((double)player.getCoord().getxCoord() - 14)/50);
        // set for vertical view following
        if (player.getCoord().getyCoord() > 39-6) scrollPane.setVvalue(1.0);
        else scrollPane.setVvalue(((double)player.getCoord().getyCoord() - 6)/28);


        HBox itemsStrip = new HBox();
        VBox itemContainer;
        ImageView item;
        int smallPotionCount = 0;
        int mediumPotionCount = 0;
        int largePotionCount = 0;
        Label smallPotionCnt = new Label();
        Label mediumPotionCnt = new Label();
        Label largePotionCnt = new Label();

        // maybe break up into a new method?
        // go through the users items and add them to the status bar
        for (int i = 0; i < this.getPlayer().getItems().size(); i++) {
            item = new ImageView(this.getPlayer().getItems().get(i).getSpriteImage());
            itemContainer = new VBox();

            switch (this.getPlayer().getItems().get(i).getName()) {
                case "Small Potion":
                    smallPotionCount++;
                    if (smallPotionCount == 1) {
                        itemContainer.setPadding(new Insets(10));
                        itemContainer.setPrefWidth(165);
                        smallPotionCnt.setText("x" + smallPotionCount);
                        itemContainer.getChildren().addAll(
                            new Label(this.getPlayer().getItems().get(i).getName()), item, smallPotionCnt);
                    }
                    else if (smallPotionCount > 1) smallPotionCnt.setText("x" + smallPotionCount);
                    break;

                case "Medium Potion":
                    mediumPotionCount++;
                    if (mediumPotionCount == 1) {
                        itemContainer.setPadding(new Insets(10));
                        itemContainer.setPrefWidth(165);
                        mediumPotionCnt.setText("x" + mediumPotionCount);
                        itemContainer.getChildren().addAll(
                            new Label(this.getPlayer().getItems().get(i).getName()), item, mediumPotionCnt);
                    }
                    else if (mediumPotionCount > 1) mediumPotionCnt.setText("x" + mediumPotionCount);
                    break;

                case "Large Potion":
                    largePotionCount++;
                    if (largePotionCount == 1) {
                        itemContainer.setPadding(new Insets(10));
                        itemContainer.setPrefWidth(165);
                        largePotionCnt.setText("x" + largePotionCount);
                        itemContainer.getChildren().addAll(
                            new Label(this.getPlayer().getItems().get(i).getName()), item, largePotionCnt);
                    }
                    else if (largePotionCount > 1) largePotionCnt.setText("x" + largePotionCount);
                    break;
                default:
                    itemContainer.setPadding(new Insets(10));
                    itemContainer.setPrefWidth(165);
                    itemContainer.getChildren().addAll(
                        new Label(this.getPlayer().getItems().get(i).getName()), item);

            }

            itemsStrip.getChildren().addAll(itemContainer);
        }

        HBox keyContainer = new HBox();
        for (int j = 0; j < this.getPlayer().getKeyCount(); j++) {
            keyContainer.getChildren().add(new ImageView(new Image("file:Images/Normal key.png")));
        }
        itemsStrip.getChildren().add(keyContainer);

        HBox playerStats = new HBox();
        playerStats.setSpacing(10);
        playerStats.setPadding(new Insets(10));
        Label statsName = new Label(this.getPlayer().getName());
        Label statsKeys = new Label("Keys: " + this.getPlayer().getKeyCount());
        Label statsHealth = new Label("Health: " + this.getPlayer().getHealth());
        Label statsAttack = new Label("Attack: " + this.getPlayer().getAttack());
        Label statsDefence = new Label("Defence: " + this.getPlayer().getDefence());
        //research from https://www.tutorialspoint.com/javafx/javafx_text.htm
        statsName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        statsKeys.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        statsHealth.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        statsAttack.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        statsDefence.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        playerStats.getChildren().addAll(statsName,
                                         statsKeys,
                                         statsHealth,
                                         statsAttack,
                                         statsDefence);
        VBox windowContainer = new VBox();
        windowContainer.getChildren().addAll(scrollPane, playerStats, itemsStrip);
        root.getChildren().add(windowContainer); // used to be scrollPane
        return root;
    }

    /**
     * Purpose: To equip the player with an item when they come across one and
     * add it to their inventory.
     *
     * @param player an instance of the player class
     * @param item the item that the user will add to their inventory
     */
    public void pickUpItem(Player player, Sprite item) {
        if (player != null && item != null) {
            player.addItem(item); // add the item to the players inventory
        }
        return;
    }

    /**
     * Purpose: To check all possible collisions in the game and return true or
     * false depending.
     *
     * @param player an instance of the player class
     * @param move a string representation of the users input
     * @return true if a collision was detected else false
     */
    public boolean checkCollisions(Player player, String move) {
        // check all collisions and if any are false
        // System.out.println("me:" + player.getCoord()); // for debugging purposes
        if (checkEdges(player, move) || checkEnemies(player, move, this.enemy)
                || checkSprites(player, move, this.terrain) || checkSprites(player, move, this.items)) {
            return true;
        } else {
            return false;
        }
    }

    /**************************************************************************/
    // TERMINAL METHODS

    /**
     * Purpose: To obtain the users input for moving around the game board
     *
     * @return a string representation of the users directional choice
     * deprecated for the gui version, it is not in use now
     */
    public String playerInput() {
        Console console = System.console();
        String input;
        String userPrompt = "Please make a move (wasd): ";
        String error = "Invalid input";
        boolean valid = false;

        if (console == null) {
            return null;
        }
        do {
            input = console.readLine(userPrompt);
            if (input.toLowerCase().equals("w") || input.toLowerCase().equals("a")
                    || input.toLowerCase().equals("s") || input.toLowerCase().equals("d")) {
                valid = true;
            } else {
                System.out.println(error);
            }
        } while (!valid);
        // convert characters into representative symbols
        switch (input) {
            case "w":
                input = "up";
                break;
            case "a":
                input = "left";
                break;
            case "s":
                input = "down";
                break;
            case "d":
                input = "right";
                break;
        }
        return input;
    }

    /**
     * Purpose: This method prints out the border to the screen for terminal
     *
     * @param player This is the player that is playing the game. Their char
     * image has to be added to the print array before the array can be printed
     *
     * @param printArray This is the 2-D array of chars that will be printed out
     * to the screen
     */
    public void drawState(Player player, char[][] printArray) {
        int colTemp;
        int rowTemp;

        colTemp = player.getCoord().getxCoord();
        rowTemp = player.getCoord().getyCoord();
        printArray[rowTemp][colTemp] = player.getSpriteChar();

        for (int i = 0; i < printArray.length; i++) {
            for (int j = 0; j < printArray[0].length; j++) {
                System.out.print(printArray[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * Purpose: This method creates the 2-D array of characters, that will
     * then be printed out onto the screen. It finds the column and row of each
     * point in the terrain, enemy, and item array lists. Then puts the correct
     * character into the the corresponding column, and row in the 2-D array.
     * The 2-D array will not be filled completely because there are parts of the
     * map that are empty. Used for the terminal version.
     *
     * @param items This is the item arraylist
     * @param enemy This is the enemy arrayList
     * @param terrain This is the enemy ArrayList
     */
     public void refreshPrintArray() {
        int rowTemp;
        int columnTemp;

        // empty the array
        for (int i = 0; i < this.printArray.length; i++) {
            for (int j = 0; j < this.printArray[0].length; j++) {
                this.printArray[i][j] = ' ';
            }
        }

        for (int index = 0; index < this.items.size(); index++) {
            rowTemp = this.items.get(index).getCoord().getyCoord();
            columnTemp = this.items.get(index).getCoord().getxCoord();
            if (this.items.get(index).getSpriteChar() != ' ') {
                this.printArray[rowTemp][columnTemp] = this.items.get(index).getSpriteChar();
            }
        }

        for (int index = 0; index < this.terrain.size(); index++) {
            rowTemp = this.terrain.get(index).getCoord().getyCoord();
            columnTemp = this.terrain.get(index).getCoord().getxCoord();
            if (this.terrain.get(index).getSpriteChar() != ' ') {
                this.printArray[rowTemp][columnTemp] = this.terrain.get(index).getSpriteChar();
            }
        }

        for (int index = 0; index < this.enemy.size(); index++) {
            rowTemp = this.enemy.get(index).getCoord().getyCoord();
            columnTemp = this.enemy.get(index).getCoord().getxCoord();
            if (this.enemy.get(index).getSpriteChar() != ' ') {
                this.printArray[rowTemp][columnTemp] = this.enemy.get(index).getSpriteChar();
            }
        }
    }

    /**
     * Purpose: To print out a string representation of the class attributes
     *
     * @return a string with all the attributes
     */
    public String toString() {
        return "Terrain: " + this.terrain + ", Items: " + this.items + ", Enemies: "
                + this.enemy + ", Total Keys: " + this.totalKeys + ", Win State: "
                + this.winState + ", Lose State: " + this.loseState;
    }

    /**
     * Purpose: To run the battle mechanics for the game loop portion of the
     * game.
     *
     * @param e - Enemy who is battling the player. should be found by the
     * collision detection
     */
    public void engageBattle(Player player, Enemy e) {
        BattleLoop b = new BattleLoop();
        int i = 0;
        int bbCounter = 0;  // keeps track of turns for Butter boomerang attack
        int mmCounter = 0;  // keeps track of turns for Margarine missile attack
        int damage;
        while (i == 0) {
            if (bbCounter == 0) {
                String attack = b.playerInput(player);
                System.out.println("You used " + attack);
                switch (attack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, e,player);
                        break;
                    case "Butter Boomerang":
                        bbCounter = 1;
                        System.out.println("Powering up!");
                        break;
                    case "Parry":
                        b.setUsedParry(true);
                        break;
                    case "Potion":
                        b.usePotion(player);
                        break;
                }
            } else if (bbCounter == 2) {
                damage = 40;
                b.damageCalc(damage, e,player);
                bbCounter = 0;
            }
            if (b.getEnemyUsedParry()) {
                b.setEnemyUsedParry(false);
            }
            if (b.checkWinState(e) == true) {
                b.drawState(player, e);
                System.out.println("You Win!");
                player.setHealth(100);
                if (e.getKey()) {
                    this.player.setKeyCount(player.getKeyCount() + 1);
                    System.out.println("You have obtained a key from defeating this enemy!");
                    e.setKey(false);
                }
                b.removeEnemy(e, enemy, terrain);
                break;
            }
            if (mmCounter == 1) {
                mmCounter = 2;
//                        if (b.getUsedParry()) {
//                        b.setUsedParry(false);
//                  }
            }
            b.drawState(player, e);
            if (mmCounter == 0) {
                String eAttack = e.attackLogic(player);
                System.out.println("Enemy used " + eAttack);
                switch (eAttack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, player,e);

                        break;
                    case "Margarine Missile":
                        mmCounter = 1;
                        System.out.println("Powering up!");
                        break;
                    case "Parry":
                        b.setEnemyUsedParry(true);

                        break;
                    case "Potion":
                        b.usePotion(e);

                        break;
                }
            } else if (mmCounter == 2) {
                damage = 40;
                b.damageCalc(damage, player,e);
                mmCounter = 0;
            }
            if (b.getUsedParry()) {
                b.setUsedParry(false);
            }
            if (b.checkLoseState(player) == true) {
                b.drawState(player, e);
                System.out.println("You lose");
                this.setLoseState(true);
                break;
            }
            if (bbCounter == 1) {
                bbCounter = 2;
    //                if (b.getEnemyUsedParry()) {
    //                    b.setEnemyUsedParry(false);
    //                }
            }
            b.drawState(player, e);
        }
    }
}
