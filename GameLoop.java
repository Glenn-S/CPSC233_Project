import java.util.Scanner;

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
     *
     */
    private void initialize() {
        // not sure if this is the correct syntax
        terrain.addAll(); // list of objects
        items.addAll();
        enemy.addAll();
        this.totalKeys = 4;
        this.winState = false;
        this.loseState = false;
        this.player = new Player(); // maybe need to pass in the users choice for name or not?
    }

    /**
     *
     */
    private boolean checkEnemy(Player player, String move, ArrayList<Enemy> enemy) {
        // uses the center point of each object and checks using the xSize and ySize offset
        return true;
    }

    /**
     *
     */
    private boolean checkItems(Player player, String move, ArrayList<Sprite> items) {
        return true;
    }

    /**
     *
     */
    private boolean checkTerrain(Player player, String move, ArrayList<Sprite> terrain) {
        return true;
    }

    /**
     *
     */
    private boolean checkEdges(Player player, String move) {
        return true;
    }

    /**
     *
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
        return true;
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/

    /**
     *
     */
    public Player getPlayer() {

    }

    /**
     *
     */
    public ArrayList<Sprite> getTerrain() {

    }

    /**
     *
     */
    public ArrayList<Sprite> getItem() {

    }

    /**
     *
     */
    public ArrayList<Enemy> getEnemy() {

    }

    /**
     *
     */
    public boolean getWinState() {

    }

    /**
     *
     */
    public boolean getLoseState() {

    }

    /**
     *
     */
    public void setPlayer(Player player) {

    }

    /**
     *
     */
    public void setTerrain(ArrayList<Sprite> newTerrainList) {

    }

    /**
     *
     */
    public void setItem(ArrayList<Sprite> newItemList) {

    }

    /**
     *
     */
    public void setEnemy(ArrayList<Enemy> newEnemyList) {

    }

    /**
     *
     */
    public void setWinState(boolean value) {

    }

    /**
     *
     */
    public void setLoseState(boolean value) {

    }
    /*--------------------------- PUBLIC METHODS -----------------------------*/

    /**
     *
     */
    public void drawState() {
        // this needs to print to standard out the map for the terminal version
        return;
    }

    /**
     *
     */
    public boolean checkWinState() {
        return winState; // returns true if true else false
    }

    /**
     * Purpose: To check and see if the
     */
    public boolean checkLoseState() {
        return loseState; // returns true if true else false
    }

    /**
     * Purpose: To equip the player with an item when they come across one and
     * add it to their inventory.
     * @param player - an instance of the player class
     * @param item - the item that the user will add to their inventory
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
     * @return - a string representation of the users directional choice
     */
    public String playerInput() {
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
     * @param player - an instance of the player class
     * @param move - a string representation of the users input
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
