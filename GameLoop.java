import java.util.Scanner;

/**
 *
 */
public class GameLoop {
    private ArrayList<Sprite> terrain = new ArrayList<Sprite>();
    private ArrayList<Sprite> items = new ArrayList<Sprite>();
    private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    private int totalKeys; // total number of keys in the game
    private boolean winState;
    private boolean loseState;
    private Player player; // initialized value

    /*------------------------------- METHODS --------------------------------*/

    /**
     * Purpose: To initialize all of the instance variables for the current game
     * and set the arrays with the Sprites initialized.
     */
    private void initialize() {
        // not sure if this is the correct syntax
        this.terrain.addAll(); // list of objects eg this.terrain.addAll(Sprite(definitions for constructor, etc))
        this.items.addAll();
        this.enemy.addAll();
        this.totalKeys = 4;
        this.winState = false;
        this.loseState = false;
        this.player = new Player(); // maybe need to pass in the users choice for name or not?
    }

    /**
     * Purpose: To check and see if the players move will collide with an enemy
     * on the map.
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an enemy
     */
    private boolean checkEnemy(Player player, String move, ArrayList<Enemy> enemy) {
        // uses the center point of each object and checks using the xSize and ySize offset
        // check the if exists


        // *** need to finish ***



        return true;
    }

    /**
     * Purpose: To check and see if the players move will collide with an item
     * located on the map.
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an item on the map
     */
    private boolean checkItems(Player player, String move, ArrayList<Sprite> items) {
        // check ifexists value


        // *** need to finish ***



        return true;
    }

    /**
     * Purpose: To check and see if the players move will collide with a terrain
     * tile that cannot be crossed (ie. mountains).
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with a terrain tile that is un-crossable
     */
    private boolean checkTerrain(Player player, String move, ArrayList<Sprite> terrain) {
        // check ifexists value


        // *** need to finish ***



        return true;
    }

    /**
     * Purpose: To check and see if the players move will collide with an edge
     * of the map.
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an edge of the map
     */
    private boolean checkEdges(Player player, String move) {


        // *** need to finish ***



        return true;
    }

    /**
     * Purpose: To check and see if the player has obtained tall of the keys
     * necessary to unlock the gate to the final boss.
     * @param player an instance of the player class in the current game
     * @return a boolean value for if the player meets the condition to unlock
     */
    private boolean checkGate(Player player) {
        return (player.getKeyCount() == totalKeys-1) ? true : false;
    }

    /**
     *
     */
    /*private void updatePosition(Player player, String move) {
        // move will only be up, down, left, and right
        int xCoord = player.

        player.updatePosition();
        return;
    }*/

    /**
     *
     */
    private boolean engageBattle() {
        // calls an instance of the BattleLoop class to engage in combat
        return true;
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To retrieve the player instance for the current game
     * @return the instance of the player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Purpose: To retrieve the array list for the terrain objects
     * @return an array list containing the terrain objects
     */
    public ArrayList<Sprite> getTerrain() {
        return this.terrain;
    }

    /**
     * Purpose: To retrieve the array list for the item objects
     * @return an array list containing the item objects
     */
    public ArrayList<Sprite> getItem() {

    }

    /**
     * Purpose: To retrieve the array list for the enemy objects
     * @return an array list containing the enemy objects
     */
    public ArrayList<Enemy> getEnemy() {
        return this.enemy;
    }

    /**
     * Purpose: To set an instance of the player class for the current game
     * @param player an instance of the player class
     */
    public void setPlayer(Player newPlayer) {
        this.player = newPlayer;
    }

    /**
     * Purpose: To set a new terrain objects list for the current game
     * @param newTerrainList an array list of terrain objects
     */
    public void setTerrain(ArrayList<Sprite> newTerrainList) {
        this.terrain = newTerrainList;
    }

    /**
     * Purpose: To set a new item objects list for the current game
     * @param newItemList an array list of item objects
     */
    public void setItem(ArrayList<Sprite> newItemList) {
        this.items = newItemList;
    }

    /**
     * Purpose: To set a new enemy list for the current game
     * @param newEnemyList an array list of enemy objects
     */
    public void setEnemy(ArrayList<Enemy> newEnemyList) {
        this.enemy = newEnemyList;
    }

    /**
     * Purpose: To change the win state boolean value
     * @param value the new boolean value to set winState to
     */
    public void setWinState(boolean value) {
        this.winState = value;
    }

    /**
     * Purpose: To change the lose state boolean value
     * @param value the new boolean value to set loseState to
     */
    public void setLoseState(boolean value) {
        this.loseState = value;
    }

    /*--------------------------- PUBLIC METHODS -----------------------------*/
    /**
     *
     */
    public void drawState() {
        // this needs to print to standard out the map for the terminal version
        // perhaps a nested for loop to print out the array of arrays of locations
        return;
    }

    /**
     * Purpose: To check and see if the user has won the game
     * @return the win state condition flag
     */
    public boolean checkWinState() {
        return winState; // returns true if true else false
    }

    /**
     * Purpose: To check and see if the the user has lost the game
     * @return the lose state condition flag
     */
    public boolean checkLoseState() {
        return loseState; // returns true if true else false
    }

    /**
     * Purpose: To equip the player with an item when they come across one and
     * add it to their inventory.
     * @param player an instance of the player class
     * @param item the item that the user will add to their inventory
     * @throws ? not sure yet
     */
    public void pickUpItem(Player player, Sprite item) {
        if (((item instanceof Potion) || (item instanceof Weapon) ||
                (item instanceof Defense)) && (player != null)) {
            player.addItem(item); // can only take a poition, weapon or defensive item
        }
        else {
            // raise an error?
        }
        return;
    }

    /**
     * Purpose: To obtain the users input for moving around the game board
     * @return a string representation of the users directional choice
     */
    public String playerInput() {


        // *** need to finish ***


        // need to figure out how to interpret keyboard commands of arrow keys
        // maybe use WASD to make it consistent with modern RPG games
        Scanner scan = new Scanner(System.in);
        // check to make sure that the characters are the valid ones
        char input = scan.next();

        return "";
    }

    /**
     * Purpose: To check all possible collisions in the game and return true or
     * false depending.
     * @param player an instance of the player class
     * @param move a string representation of the users input
     * @return true if a collision was detected else false
     */
    public boolean checkCollisions(Player player, String move) {
        boolean collision = false;

        // check all collisions and if any are true
        if (checkEdges(player, move) || checkTerrain(player, move, terrain) ||
                checkEnemy(player, move, enemy) || checkItems(player, move, items)) {
            collision = (collision == false) ? true : collision; // if its false make it true else keep it what it was
        }
        return collision;
    }

}
