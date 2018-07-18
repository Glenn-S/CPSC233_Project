import java.util.Scanner;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoop {
    private ArrayList<Sprite> terrain = new ArrayList<Sprite>();
    private ArrayList<Sprite> items = new ArrayList<Sprite>();
    private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    private int totalKeys; // total number of keys in the game
    private boolean winState;
    private boolean loseState;


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
    private boolean check(Player player, String move, ArrayList<Enemy> enemy) {
        int playerLeft, playerRight, playerUp, playerDown;
        int objLeft, objRight, objUp, objDown;
        // this gets me the instance of the players location
        playerLeft = player.getCoord().getxCoord() - player.getCoord().getxSize();
        playerRight = player.getCoord().getxCoord() + player.getCoord().getxSize();
        playerUp = player.getCoord().getyCoord() - player.getCoord().getySize();
        playerDown = palyer.getCoord().getyCoord() + player.getCoord().getySize();

        if (!enemy.isEmpty() && (player != null)) { // check to make sure move is valid
            for (int i = 0; i < enemy.length(); i++) {
                objLeft = enemy.get(i).getCoord().getxCoord() - enemy.getCoord().getxSize();
                objRight = enemy.get(i).getCoord().getxCoord() + enemy.getCoord().getxSize();
                objUp = enemy.get(i).getCoord().getyCoord() - enemy.getCoord().getySize();
                objDown = enemy.get(i).getCoord().getyCoord() + enemy.getCoord().getySize();

                if ((playerRight == objLeft) || (playerLeft == objRight) ||
                        (playerUp == objDown) || (playerDown == objUp)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Purpose: To check and see if the players move will collide with a terrain
     * tile that cannot be crossed (ie. mountains).
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with a terrain tile that is un-crossable
     */
    private boolean check(Player player, String move, ArrayList<Sprite> obj) {
        int playerLeft, playerRight, playerUp, playerDown;
        int objLeft, objRight, objUp, objDown;
        // this gets me the instance of the players location
        // check if player is valid and not null
        playerLeft = player.getCoord().getxCoord() - player.getCoord().getxSize();
        playerRight = player.getCoord().getxCoord() + player.getCoord().getxSize();
        playerUp = player.getCoord().getyCoord() - player.getCoord().getySize();
        playerDown = palyer.getCoord().getyCoord() + player.getCoord().getySize();

        switch (move) {
            case "left":
                playerLeft -= 1;
                playerRight -= 1; // compensate for movement
                break;
            case "right":
                playerRight += 1;
                playerLeft += 1; // compensate for movement
                break;
            case "up":
                playerUp -= 1;
                playerDown -= 1; // compensate for movement
                break;
            case "down":
                playerDown += 1;
                playerUp += 1; // compensate for movement
                break;
            default:
                // need an error message of some kind
        }

        if (!obj.isEmpty()) { // check to make sure move is valid
            for (int i = 0; i < obj.length(); i++) {
                objLeft = obj.get(i).getCoord().getxCoord() - obj.getCoord().getxSize();
                objRight = obj.get(i).getCoord().getxCoord() + obj.getCoord().getxSize();
                objUp = obj.get(i).getCoord().getyCoord() - obj.getCoord().getySize();
                objDown = obj.get(i).getCoord().getyCoord() + obj.getCoord().getySize();

                if ((playerRight == objLeft) || (playerLeft == objRight) ||
                        (playerUp == objDown) || (playerDown == objUp)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Purpose: To check and see if the players move will collide with an edge
     * of the map.
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an edge of the map
     */
    private boolean checkEdges(Player player, String move) {
        int playerLeft, playerRight, playerUp, playerDown;
        int objLeft, objRight, objUp, objDown;
        // this gets me the instance of the players location
        playerLeft = player.getCoord().getxCoord() - player.getCoord().getxSize();
        playerRight = player.getCoord().getxCoord() + player.getCoord().getxSize();
        playerUp = player.getCoord().getyCoord() - player.getCoord().getySize();
        playerDown = palyer.getCoord().getyCoord() + player.getCoord().getySize();

        if (!items.isEmpty() && (player != null) && ) { // check to make sure move is valid

        }
        return false;
    }

    /**
     * Purpose: To check and see if the player has obtained tall of the keys
     * necessary to unlock the gate to the final boss.
     * @param player an instance of the player class in the current game
     * @return a boolean value for if the player meets the condition to unlock
     */
    private boolean checkGate(Player player) {
        // also update images
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


        // *** need to finish ***



        return true;
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
	
	/**
	 * Purpose: To set/load the terrain array
	 */
	 private void setTerrainArray() {
		 
		 int index1 =0;
		 int index2 =0
		 
		terrain.add(Sprite(00, "border", '-', true, dialogue)); 
		terrain.add(Sprite(01, "border", '-', true, dialogue));
		terrain.add(Sprite(02, "border", '-', true, dialogue));
		terrain.add(Sprite(03, "border", '-', true, dialogue));
		terrain.add(Sprite(04, "border", '-', true, dialogue));
		terrain.add(Sprite(05, "border", '-', true, dialogue));
		terrain.add(Sprite(06, "border", '-', true, dialogue));
		terrain.add(Sprite(07, "border", '-', true, dialogue));
		terrain.add(Sprite(08, "border", '-', true, dialogue));
		terrain.add(Sprite(09, "border", '-', true, dialogue));
		 
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
     * player is needed since it is not of this class
     */
    public void drawState(Player player) {
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
     * @return false if a collision was detected else true
     */
    public boolean checkCollisions(Player player, String move) {
        boolean collision = true;

        // check all collisions and if any are false
        if (!checkEdges(player, move) || !checkTerrain(player, move, terrain) ||
                !checkEnemy(player, move, enemy) || !checkItems(player, move, items)) {
            collision = (collision == true) ? false : collision; // if its false make it true else keep it what it was
        }
        return collision;
    }

}
