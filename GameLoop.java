import java.util.Scanner;

public class GameLoop {
    ArrayList<Sprite> terrain = new ArrayList<Sprite>();
    ArrayList<Sprite> items = new ArrayList<Sprite>();
    ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    int totalKeys; // total number of keys in the game
    boolean winState;
    boolean loseState;
    Player player; // initialized value

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
        return;
    }

    /**
     *
     */
    public void checkWinState() {
        return;
    }

    /**
     *
     */
    public void checkLoseState() {
        return;
    }

    /**
     *
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
     *
     */
    public String playerInput() {
        //Scanner scan = new Scanner(System.in);
        // need to figure out how to interpret keyboard commands of arrow keys

        return "";
    }

    /**
     *
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
