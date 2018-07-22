
import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoop {

    private ArrayList<Sprite> terrain;
    private ArrayList<Sprite> items;
    private ArrayList<Enemy> enemy;
    private int totalKeys; // total number of keys in the game
    private boolean winState;
    private boolean loseState;

    /*---------------------------- CONSTRUCTORS ------------------------------*/
    public GameLoop() {
        this.terrain = new ArrayList<Sprite>();
        this.items = new ArrayList<Sprite>();
        this.enemy = new ArrayList<Enemy>();
        this.totalKeys = 4; // default value
        this.winState = false;
        this.loseState = false;
    }

    public GameLoop(ArrayList<Sprite> terrain, ArrayList<Sprite> items,
            ArrayList<Enemy> enemy, int totalKeys) {
        this.terrain = (terrain != null) ? terrain : new ArrayList<Sprite>();
        this.items = (items != null) ? items : new ArrayList<Sprite>();
        this.enemy = (enemy != null) ? enemy : new ArrayList<Enemy>();
        this.totalKeys = (totalKeys > 0) ? totalKeys : 4;
        this.winState = false;
        this.loseState = false;
    }

    /*------------------------------- METHODS --------------------------------*/
    /**
     * Purpose: To initialize all of the instance variables for the current game
     * and set the arrays with the Sprites initialized.
     */
    private void initialize() { // get rid of
        //this might not even be necessary?
        // not sure if this is the correct syntax
        //this.terrain.addAll(); // list of objects eg this.terrain.addAll(Sprite(definitions for constructor, etc))
        //this.items.addAll();
        //this.enemy.addAll();
        this.totalKeys = 4;
        this.winState = false;
        this.loseState = false;
        //this.player = new Player(); // maybe need to pass in the users choice for name or not?
    }

    /**
     * Purpose: To check and see if the players move will collide with an enemy
     * on the map.
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an enemy
     */
    /*
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
     */
    /**
     * Purpose: To check and see if the players move will collide with a terrain
     * tile that cannot be crossed (ie. mountains).
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with a terrain tile that is
     * un-crossable
     */
    /*
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
     */
    /**
     * Purpose: To check and see if the players move will collide with an edge
     * of the map.
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an edge of the map
     */
    /*    private boolean checkEdges(Player player, String move) {
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
     */
    /**
     * Purpose: To check and see if the player has obtained tall of the keys
     * necessary to unlock the gate to the final boss.
     *
     * @param player an instance of the player class in the current game
     * @return a boolean value for if the player meets the condition to unlock
     */
    private boolean checkGate(Player player) {
        // also update images
        return (player.getKeyCount() == totalKeys - 1) ? true : false;
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
     * @param e - Enemy who is battling the player. should be found by the
     * collision detection
     */
    private void engageBattle(Enemy enemy) {
        BattleLoop b = new BattleLoop();
        int i = 0;
        Player player = new Player();
        String attacks[] = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        player.setMoves(attacks);
        player.setHealth(100);
        Enemy e = new Enemy();
        String eAttacks[] = {"Slash", "Margarine Missile", "Parry", "Potion"};
        e.setHealth(100);
        e.setMoves(eAttacks);
        ArrayList<Potion> arrayList = new ArrayList<>();
        Potion p = new Potion();
        Potion q = new Potion();
        q.setHealthBoost(25);
        ArrayList<Sprite> pl = new ArrayList<>();
        pl.add(q);
        player.setItems(pl);
        p.setHealthBoost(25);
        arrayList.add(p);
        e.setPotions(arrayList);
        int bbCounter = 0;  // keeps track of turns for Butter boomerang attack
        int mmCounter = 0;  // keeps track of turns for Margarine missile attack
        int damage;
        while (i == 0) {
            if (bbCounter == 0) {
                String attack = b.playerInput(player);
                switch (attack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, e);
                        break;
                    case "Butter Boomerang":
                        bbCounter = 1;
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
                b.damageCalc(damage, e);
                bbCounter = 0;
            }
            if (b.getEnemyUsedParry()) {
                b.setEnemyUsedParry(false);
            }
            if (b.checkWinState(e) == true) {
                b.drawState(player, e);
                System.out.println("You Win!");
                break;
            }
            if (mmCounter == 1) {
                mmCounter = 2;
//                if (b.getUsedParry()) {
//                    b.setUsedParry(false);
//                }
            }
            //  b.drawState(player, e);
            if (mmCounter == 0) {
                String eAttack = e.attackLogic(player);
                switch (eAttack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, player);
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Margarine Missile":
                        mmCounter = 1;
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Parry":
                        b.setEnemyUsedParry(true);
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Potion":
                        b.usePotion(e);
                        System.out.println("Enemy used " + eAttack);
                        break;
                }
            } else if (mmCounter == 2) {
                damage = 40;
                b.damageCalc(damage, player);
                mmCounter = 0;
            }
            if (b.getUsedParry()) {
                b.setUsedParry(false);
            }
            if (b.checkLoseState(player) == true) {
                b.drawState(player, e);
                System.out.println("You lose");
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

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To retrieve the array list for the terrain objects
     *
     * @return an array list containing the terrain objects
     */
    public ArrayList<Sprite> getTerrain() {
        return new ArrayList<Sprite>(this.terrain); //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the item objects
     *
     * @return an array list containing the item objects
     */
    public ArrayList<Sprite> getItem() {
        return new ArrayList<Sprite>(this.items); //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the enemy objects
     *
     * @return an array list containing the enemy objects
     */
    public ArrayList<Enemy> getEnemy() {
        return new ArrayList<Enemy>(this.enemy); //create copy of the list
    }

    /**
     * Purpose: To retrieve the number of keys in the game
     *
     * @return the totalKeys
     */
    public int getTotalKeys() {
        return totalKeys;
    }

    /**
     * Purpose: To get the value of the win state variable
     *
     * @return the win state condition flag
     */
    public boolean checkWinState() {
        return winState; // returns true if true else false
    }

    /**
     * Purpose: To get the value of the lose state variable
     *
     * @return the lose state condition flag
     */
    public boolean checkLoseState() {
        return loseState; // returns true if true else false
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

    /*--------------------------- PUBLIC METHODS -----------------------------*/
    /**
     * player is needed since it is not of this class
     */
    /*    public void drawState(Player player) {
        // this needs to print to standard out the map for the terminal version
        // perhaps a nested for loop to print out the array of arrays of locations
        return;
    }
     */
    /**
     * Purpose: To equip the player with an item when they come across one and
     * add it to their inventory.
     *
     * @param player an instance of the player class
     * @param item the item that the user will add to their inventory
     * @throws ? not sure yet
     */
    /*    public void pickUpItem(Player player, Sprite item) {
        if (((item instanceof Potion) || (item instanceof Weapon) ||
                (item instanceof Defence)) && (player != null)) {
            player.addItem(item); // can only take a poition, weapon or defensive item
        }
        else {
            // raise an error?
        }
        return;
    }
     */
    /**
     * Purpose: To obtain the users input for moving around the game board
     *
     * @return a string representation of the users directional choice
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
     * Purpose: To check all possible collisions in the game and return true or
     * false depending.
     *
     * @param player an instance of the player class
     * @param move a string representation of the users input
     * @return false if a collision was detected else true
     */
    public boolean checkCollisions(Player player, String move) {
        boolean collision = true;

        // check all collisions and if any are false
//        if (!checkEdges(player, move) || !checkTerrain(player, move, terrain) ||
//                !checkEnemy(player, move, enemy) || !checkItems(player, move, items)) {
//            collision = (collision == true) ? false : collision; // if its false make it true else keep it what it was
//        }
        return collision;
    }

    /**
     * Purpose: To allow the ability to test methods
     */
    public static void main(String[] args) {
        // for testing methods
        GameLoop gl = new GameLoop();
        Player p1 = new Player("Montequilla", new Location(0, 0, 0, 0), null, 'x',
                null, true, false, 100, 50, 50, null);
        System.out.println(p1);
    }
}
