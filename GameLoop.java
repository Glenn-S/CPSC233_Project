
import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoop {
    private int boardHeight = 40, boardLength = 200; // move these later
    private ArrayList<Sprite> terrain;
    private ArrayList<Sprite> items;
    private ArrayList<Enemy> enemy;
    private char[][] printArray = new char[boardHeight][boardLength]; //[40][200]
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
     *
     */
    public void initialize() {
        GameBoard gb = new GameBoard();
        gb.createItemArray(this.items);
        gb.createTerrainArray(this.terrain);
        gb.createEnemyArray(this.enemy);
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
            for (int i = 0; i < enemy.size(); i++) { // should I get it to exit if any are true or just finish?
                if (!enemy.get(i).getExists()) continue; // go to the next item since this object doesn't exist
                switch (move) {
                    case "up":
                        if ((player.getCoord().getUpperBoundary()-1 == enemy.get(i).getCoord().getLowerBoundary()) &&
                            (player.getCoord().getLeftBoundary() >= enemy.get(i).getCoord().getLeftBoundary()) &&
                            (player.getCoord().getRightBoundary() <= enemy.get(i).getCoord().getRightBoundary())) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy
                                result = true;
                            }
                        break;
                    case "down":
                        if (player.getCoord().getLowerBoundary()+1 == enemy.get(i).getCoord().getUpperBoundary() &&
                            (player.getCoord().getLeftBoundary() >= enemy.get(i).getCoord().getLeftBoundary()) &&
                            (player.getCoord().getRightBoundary() <= enemy.get(i).getCoord().getRightBoundary())) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy
                                result = true;
                            }
                        break;
                    case "left":
                        if (player.getCoord().getLeftBoundary()-1 == enemy.get(i).getCoord().getRightBoundary() &&
                            (player.getCoord().getUpperBoundary() >= enemy.get(i).getCoord().getUpperBoundary()) &&
                            (player.getCoord().getLowerBoundary() <= enemy.get(i).getCoord().getLowerBoundary())) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy
                                result = true;
                            }
                        break;
                    case "right":
                        if (player.getCoord().getRightBoundary()+1 == enemy.get(i).getCoord().getLeftBoundary() &&
                            (player.getCoord().getUpperBoundary() >= enemy.get(i).getCoord().getUpperBoundary()) &&
                            (player.getCoord().getLowerBoundary() <= enemy.get(i).getCoord().getLowerBoundary())) {
                                engageBattle(player, enemy.get(i)); // begin battle against enemy
                                result = true;
                            }
                        break;
                }
            }
        }
        return result;
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
            for (int i = 0; i < obj.size(); i++) { // should I get it to exit if any are true or just finish?
                if (!obj.get(i).getExists()) continue; // go to the next item since this object doesn't exist
                switch (move) {
                    case "up":
                        if ((player.getCoord().getUpperBoundary()-1 == obj.get(i).getCoord().getLowerBoundary()) &&
                            (player.getCoord().getLeftBoundary() >= obj.get(i).getCoord().getLeftBoundary()) &&
                            (player.getCoord().getRightBoundary() <= obj.get(i).getCoord().getRightBoundary())) {
                                result = true;
                            }
                        break;
                    case "down":
                        if (player.getCoord().getLowerBoundary()+1 == obj.get(i).getCoord().getUpperBoundary() &&
                            (player.getCoord().getLeftBoundary() >= obj.get(i).getCoord().getLeftBoundary()) &&
                            (player.getCoord().getRightBoundary() <= obj.get(i).getCoord().getRightBoundary())) {
                                result = true;
                            }
                        break;
                    case "left":
                        if (player.getCoord().getLeftBoundary()-1 == obj.get(i).getCoord().getRightBoundary() &&
                            (player.getCoord().getUpperBoundary() >= obj.get(i).getCoord().getUpperBoundary()) &&
                            (player.getCoord().getLowerBoundary() <= obj.get(i).getCoord().getLowerBoundary())) result = true;
                        break;
                    case "right":
                        if (player.getCoord().getRightBoundary()+1 == obj.get(i).getCoord().getLeftBoundary() &&
                            (player.getCoord().getUpperBoundary() >= obj.get(i).getCoord().getUpperBoundary()) &&
                            (player.getCoord().getLowerBoundary() <= obj.get(i).getCoord().getLowerBoundary())) result = true;
                        break;
                }
            }
        }
        return result;
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
                    if (player.getCoord().getUpperBoundary()-1 == 0) result = true; // remove these hard coded values later
                    break;
                case "down":
                    if (player.getCoord().getLowerBoundary()+1 == this.boardHeight-1) result = true; // adjust for edge now
                    break;
                case "left":
                    if (player.getCoord().getLeftBoundary()-1 == 0) result = true;
                    break;
                case "right":
                    if (player.getCoord().getRightBoundary()+1 == this.boardLength-1) result = true; // adjust for edge now
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
        // also update images
        return (player.getKeyCount() == totalKeys - 1) ? true : false;
    }

    /**
     *
     */
    public void updatePosition(Player player, String move) {
        // move will only be up, down, left, and right
        // assumes coordinates have been checked
        switch (move) {
            case "up":
                player.updatePosition(player.getCoord().getxCoord(), player.getCoord().getyCoord()-1);
                break;
            case "down":
                player.updatePosition(player.getCoord().getxCoord(), player.getCoord().getyCoord()+1);
                break;
            case "left":
                player.updatePosition(player.getCoord().getxCoord()-1, player.getCoord().getyCoord());
                break;
            case "right":
                player.updatePosition(player.getCoord().getxCoord()+1, player.getCoord().getyCoord());
                break;
        }
    }

    /**
     * @param e - Enemy who is battling the player. should be found by the
     * collision detection
     */
    private void engageBattle(Player player,Enemy e) {
        BattleLoop b = new BattleLoop();
        int i = 0;
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
              b.drawState(player, e);
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
            b.drawState(player,e);

        }

    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To retrieve the array list for the terrain objects
     *
     * @return an array list containing the terrain objects
     */
    public ArrayList<Sprite> getTerrain() {
        return this.terrain; //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the item objects
     *
     * @return an array list containing the item objects
     */
    public ArrayList<Sprite> getItem() {
        return this.items; //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the enemy objects
     *
     * @return an array list containing the enemy objects
     */
    public ArrayList<Enemy> getEnemy() {
        return this.enemy; //create copy of the list
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
     * @return the printArray
     */
    public char[][] getPrintArray() {
    	return printArray;
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
     * Purpose:
     * @param printArray the printArray to set
     */
    public void setPrintArray(char[][] printArray) {
    	this.printArray = printArray;
    }

    /*--------------------------- PUBLIC METHODS -----------------------------*/
    /**
     * Purpose: This function creates the 2-D array of characters, that will then be printed out onto
     * the screen. It finds the column and row of each point in the terrain, enemy, and item array
     * lists. Then puts the correct character into the the corresponding column, and row in the
     * 2-D array. The 2-D array will not be filled completely because there is parts of the map that
     * is empty.
     *
     * @param  items  This is the item arraylist
     * @param  enemy  This is the enemy arrayList
     * @param  terrain  This is the enemy ArrayList
     */
    public void refreshPrintArray () {
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
     * Purpose: This function prints out the border to the screen
     *
     * @param  player  This is the player that is playing the game.
     * Their char image has to be added to the print array before
     * the array can be printed
     *
     * @param  printArray  This is the 2-D array of chars that will
     * be printed out to the screen
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
     * Purpose: To equip the player with an item when they come across one and
     * add it to their inventory.
     *
     * @param player an instance of the player class
     * @param item the item that the user will add to their inventory
     * @throws ? not sure yet
     */
    public void pickUpItem(Player player, Sprite item) {
        if (player != null && item != null) {
            player.addItem(item); // add the item to the players inventory
        }
        return;
    }

    /**
     * Purpose: To obtain the users input for moving around the game board
     * @return a string representation of the users directional choice
     */
    public String playerInput() {
        Console console = System.console();
        String input;
        String userPrompt = "Please make a move (wasd): ";
        String error = "Invalid input";
        boolean valid = false;

        if (console == null) return null;
        do {
            input = console.readLine(userPrompt);
            if (input.toLowerCase().equals("w") || input.toLowerCase().equals("a") ||
                    input.toLowerCase().equals("s") || input.toLowerCase().equals("d")) {
                valid = true;
            }
            else System.out.println(error);
        } while (!valid);
        // convert characters into representative symbols
        switch (input) {
            case "w": input = "up"; break;
            case "a": input = "left"; break;
            case "s": input = "down"; break;
            case "d": input = "right"; break;
        }
        return input;
    }

    /**
     * Purpose: To check all possible collisions in the game and return true or
     * false depending.
     * @param player an instance of the player class
     * @param move a string representation of the users input
     * @return true if a collision was detected else false
     */
    public boolean checkCollisions(Player player, String move) {
        // check all collisions and if any are false
        System.out.println("me:" + player.getCoord()); // for debugging purposes
        if (checkEdges(player, move) || checkEnemies(player, move, this.enemy) ||
                checkSprites(player, move, this.terrain) || checkSprites(player, move, this.items)) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        return "Terrain: " + this.terrain + ", Items: " + this.items + ", Enemies: " +
            this.enemy + ", Total Keys: " + this.totalKeys + ", Win State: " +
            this.winState + ", Lose State: " + this.loseState;
    }

    /**
     * Purpose: To allow the ability to test methods
     */
    public static void main(String[] args) {
        // for testing methods

        // check constructor
        GameLoop gl = new GameLoop();
        GameLoop gl2 = new GameLoop(new ArrayList<Sprite>(), new ArrayList<Sprite>(),
                                    new ArrayList<Enemy>(), 3);
        // print the toString representation of this object
        System.out.println("\nGL: " + gl);
        System.out.println("GL2: " + gl2);

        String[] moves = {"Weak attack", "Strong attack", "Parry", "Potion"};
        Player p1 =  new Player("Montequilla", new Location(0, 0, 0, 0), null, 'x',
                                null, true, false, 100, 50, 50, null);
        Player p2 =  new Player("Burro", new Location(39, 39, 0, 0), null, 'x',
                                null, true, false, 100, 50, 50, moves);
        System.out.println("\nPlayer 1: " + p1);
        System.out.println("Player 2: " + p2);
        // check gate method
        System.out.println("\nGate Check: " + gl.checkGate(p1));
        // check update position
        System.out.println("\nPlayer 2 coordinates before: " + p2.getCoord());
        gl.updatePosition(p2, "up");
        System.out.println("Player 2 coordinates after moving up: " + p2.getCoord());
        gl.updatePosition(p2, "left");
        System.out.println("Player 2 coordinates after moving left: " + p2.getCoord());
        gl.updatePosition(p2, "down");
        System.out.println("Player 2 coordinates after moving down: " + p2.getCoord());
        gl.updatePosition(p2, "right");
        System.out.println("Player 2 coordinates after moving right: " + p2.getCoord());

        // check GETTERS
        // check the getters for the arrays later
        System.out.println("\nTotal keys in game: " + gl.getTotalKeys());
        System.out.println("Check win state: " + gl.checkWinState());
        System.out.println("Check lose state: " + gl.checkLoseState());

        // check SETTERS
        // add some testing?

        // check playerInput
        String input = gl.playerInput();
        System.out.println("\nYou inputed: " + input);

        // check the check border top left corner
        System.out.println("\np2: " + p1.getCoord());
        System.out.println("move up check    (0, 0): " + gl.checkEdges(p1, "up")); // I expect true
        System.out.println("move left check  (0, 0): " + gl.checkEdges(p1, "left")); // I expect true
        System.out.println("move down check  (0, 0): " + gl.checkEdges(p1, "down")); // I expect false
        System.out.println("move right check (0, 0): " + gl.checkEdges(p1, "right")); // I expect false
        // check the check border bottom right corner
        System.out.println("\np2: " + p2.getCoord());
        p2.setCoord(new Location(199, 39, 0, 0));
        System.out.println("p2: " + p2.getCoord());
        System.out.println("move up check    (39, 199): " + gl.checkEdges(p2, "up")); // I expect false
        System.out.println("move left check  (39, 199): " + gl.checkEdges(p2, "left")); // I expect false
        System.out.println("move down check  (39, 199): " + gl.checkEdges(p2, "down")); // I expect true
        System.out.println("move right check (39, 199): " + gl.checkEdges(p2, "right")); // I expect true
        // test with a width and height
        System.out.println("\np2: " + p2.getCoord());
        p2.setCoord(new Location(197, 36, 1, 2));
        System.out.println("\np2: " + p2.getCoord());
        System.out.println("move up check    (39, 199): " + gl.checkEdges(p2, "up")); // I expect false
        System.out.println("move left check  (39, 199): " + gl.checkEdges(p2, "left")); // I expect false
        System.out.println("move down check  (39, 199): " + gl.checkEdges(p2, "down")); // I expect false
        System.out.println("move right check (39, 199): " + gl.checkEdges(p2, "right")); // I expect false
        // test with a width and height
        System.out.println("\np2: " + p2.getCoord());
        p2.setCoord(new Location(198, 37, 1, 2));
        System.out.println("p2: " + p2.getCoord());
        System.out.println("move up check    (39, 199): " + gl.checkEdges(p2, "up")); // I expect false
        System.out.println("move left check  (39, 199): " + gl.checkEdges(p2, "left")); // I expect false
        System.out.println("move down check  (39, 199): " + gl.checkEdges(p2, "down")); // I expect true
        System.out.println("move right check (39, 199): " + gl.checkEdges(p2, "right")); // I expect true

        // check for player and obstacles
        ArrayList<Enemy> eList = new ArrayList();
        Enemy e1 = new Enemy("Enemy", new Location(2, 1, 0, 0), null, '*', null, true, false, 100, 100, 100, null, false, null);
        Enemy e2 = new Enemy("Enemy2", new Location(1, 2, 0, 0), null, '*', null, false, false, 100, 100, 100, null, false, null);
        p2.setCoord(new Location(1, 1, 0, 0));
        System.out.println("\np2: " + p2.getCoord());
        System.out.println("e1: " + e1.getCoord());
        System.out.println("e1: " + e2.getCoord());
        eList.add(e1);
        eList.add(e2);
        System.out.println("\nEnemy Tests");
        System.out.println("move right check (1, 1): " + gl.checkEnemies(p2, "right", eList)); // I expect true
        System.out.println("move down check (1, 1): " + gl.checkEnemies(p2, "down", eList)); // I expect false
        // check the terrain list checking
        ArrayList<Sprite> tList = new ArrayList<Sprite>();
        Sprite t1 = new Sprite("Mountain", new Location(2, 1, 0, 0), null, '^', null, true, false);
        Sprite t2 = new Sprite("River", new Location(2, 2, 0, 0), null, '^', null, true, false);
        tList.add(t1);
        tList.add(t2);
        System.out.println("\nTerrain Tests");
        System.out.println("move right check (1, 1): " + gl.checkSprites(p2, "right", tList)); // I expect true
        System.out.println("move down check (1, 1): " + gl.checkSprites(p2, "down", tList)); // I expect false
        // check the item list checking
        ArrayList<Sprite> iList = new ArrayList<Sprite>();
        Potion i1 = new Potion("Small Potion", new Location(3, 1, 0, 0), null, '^', null, true, false, 100);
        Defence i2 = new Defence("Shield", new Location(2, 2, 0, 0), null, '^', null, true, false, 100);
        Weapon i3 = new Weapon("Sword", new Location(1, 2, 0, 0), null, '^', null, true, false, 100);
        iList.add(i1);
        iList.add(i2);
        iList.add(i3);

        System.out.println("\nItems Tests");
        for (int i = 0; i < iList.size(); i++) {
            if (i == 0) System.out.print("(");
            System.out.print(iList.get(i).getName());
            if (i < iList.size()-1) System.out.print(", ");
            if (i == iList.size()-1) System.out.print(")\n");
        }
        System.out.println("move right check (1, 1): " + gl.checkSprites(p2, "right", iList)); // I expect false
        System.out.println("move down check (1, 1): " + gl.checkSprites(p2, "down", iList)); // I expect true

        // check the check collisions methods
        // setup the arrays to contain the elements
        gl.setTerrain(tList);
        gl.setItem(iList);
        gl.setEnemy(eList);
        // print enemies
        System.out.println("\nPrint Enemies");
        for (int i = 0; i < gl.getEnemy().size(); i++) {
            if (i == 0) System.out.print("(");
            System.out.print(gl.getEnemy().get(i).getName());
            if (i < gl.getEnemy().size()-1) System.out.print(", ");
            if (i == gl.getEnemy().size()-1) System.out.print(")\n");
        }
        // print terrain
        System.out.println("\nPrint Terrain");
        for (int i = 0; i < gl.getTerrain().size(); i++) {
            if (i == 0) System.out.print("(");
            System.out.print(gl.getTerrain().get(i).getName());
            if (i < gl.getTerrain().size()-1) System.out.print(", ");
            if (i == gl.getTerrain().size()-1) System.out.print(")\n");
        }
        // print items
        System.out.println("\nPrint Items");
        for (int i = 0; i < gl.getItem().size(); i++) {
            if (i == 0) System.out.print("(");
            System.out.print(gl.getItem().get(i).getName());
            if (i < gl.getItem().size()-1) System.out.print(", ");
            if (i == gl.getItem().size()-1) System.out.print(")\n");
        }

        p1.setCoord(new Location(3, 2, 0, 0));
        System.out.println("\nCheck checkCollisions p1 (3, 2)");
        System.out.println("p1 move left: " + gl.checkCollisions(p1, "left")); // should be true
        System.out.println("p1 move up: " + gl.checkCollisions(p1, "up")); // should be true
        System.out.println("p1 move down: " + gl.checkCollisions(p1, "down")); // should be false
        System.out.println("p1 move right: " + gl.checkCollisions(p1, "right")); // should be false
        p2.setCoord(new Location(3, 0, 0, 0));
        System.out.println("\nCheck checkCollisions p2 (3, 0)");
        System.out.println("p2 move left: " + gl.checkCollisions(p2, "left")); // should be false
        System.out.println("p2 move up: " + gl.checkCollisions(p2, "up")); // should be true
        System.out.println("p2 move down: " + gl.checkCollisions(p2, "down")); // should be true
        System.out.println("p2 move right: " + gl.checkCollisions(p2, "right")); // should be false

        Player p3 = new Player("Montequilla", new Location(0, 0, 0, 0), null, 'x',
                                null, true, false, 100, 50, 50, null);
        gl.pickUpItem(p3, i1);
        gl.pickUpItem(p3, i3);
        ArrayList<Sprite> playerItems = p3.getItems();
        System.out.println("\nPlayer Item: " + playerItems.get(0).getName());

        // drawState has been tested out in GameBoard
    }
}
