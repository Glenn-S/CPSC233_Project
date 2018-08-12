package sprite;

import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * Purpose: This class contains all information relevant to the enemies in the
 * game. This includes the all information from the Sprite class and it's
 * parent class, the Avatar class. On top of this it includes information about
 * what potions the enemy has, whether or not it is holding a key and how it
 * will decide to attack.
 * moves[0] = Slash = 15HP
 * moves [1] = Margarine Missile = 40HP but takes 2 turns to work
 * moves[2] = Parry has a 50% chance of not working otherwise reduces
 * damage from most recent attack to 0
 * moves[3] = Potion recovers HP
 * engageBattle should have
 * an enemy as a parameter to check specifically which enemy is being fought.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Enemy extends Avatar {

    private boolean key; // if true, enemy has a key. false if they do not have a key
    private ArrayList<Potion> potions; // list of potions the enemy has


    /*---------------------------- CONSTRUCTORS ------------------------------*/
    /**
     * Purpose: Default Constructor
     */
    public Enemy() {
        super();
        this.key = false;
        this.potions = null;

    }

    /**
     * Purpose: Constructor for the class, likely to be used at game loop initialization
     * sets the initial health, defense, attack, and allowed moves for the enemy
     * also determines whether or not the enemy will have a key on them
     * @param name - name of the enemy
     * @param coord - position of enemy on the map
     * @param spriteImage - enemy representation in GUI
     * @param spriteChar - enemy representation in terminal
     * @param dialogue - all the things an enemy can say as a string array
     * @param exists - true if enemy exists on the map
     * @param overlapsWith - true if player overlaps with the enemy
     * @param health - enemy health as an integer
     * @param defence - enemy defense value as an integer
     * @param attack - enemy attack value as an integer
     * @param moves - list of all possible enemy attacks
     * @param key - true if enemy has a key, false otherwise
     * @param potions
     */
    public Enemy(String name,
                 Location coord,
                 Image spriteImage,
                 char spriteChar,
                 String[] dialogue,
                 boolean exists,
                 boolean overlapsWith,
                 int health,
                 int defence,
                 int attack,
                 String[] moves,
                 boolean key,
                 ArrayList<Potion> potions) {
        super(name,
              coord,
              spriteImage,
              spriteChar, // will become the sprite image class later
              dialogue,
              exists,
              overlapsWith,
              health,
              defence,                attack,
              moves); // invokes Avatar constructor
        this.key = key;
        this.potions = potions;
    }
        /**
     * Purpose: Copy Constructor for the class,
     * sets all fields of the new enemy to those of the existing enemy
     * @param fromCopy - Enemy to get information from
     */
        public Enemy(Enemy fromCopy) {
        super(fromCopy.getName(),
              fromCopy.getCoord(),
              fromCopy.getSpriteImage(),
              fromCopy.getSpriteChar(), // will become the sprite image class later
              fromCopy.getDialogue(),
              fromCopy.getExists(),
              fromCopy.getOverlapsWith(),
              fromCopy.getHealth(),
              fromCopy.getDefence(),                fromCopy.attack,
              fromCopy.getMoves()); // invokes Avatar constructor
        this.key = fromCopy.getKey();
        this.potions = fromCopy.getPotions();
    }

    /*-------------------------- GETTERS/SETTERS -----------------------------*/
    /**
     * Purpose: Determines if the enemy has a key or not
     * @return key - true if enemy has a key, false otherwise
     */
    public boolean getKey() {
        return this.key;
    }
    /**
     * Purpose: Changes if the enemy has a key or not
     * @param key - new state of the enemy's key
     */
    public void setKey(boolean key) {
        this.key = key;
    }
    /**
     * Purpose: Returns if the enemy has potions
     * @return - true if enemy possesses potions, false otherwise
     */
    public boolean hasPotion() {
        if(this.potions.isEmpty())
            return false;
        return true ;
    }
    /**
     * Purpose: Returns the enemy's potions
     * @return - the list of potions the enemy currently in possession of
     */
    public ArrayList<Potion> getPotions() {
        return this.potions; //fix privacy leaks
    }

    /**
     * Purpose: Replaces the previous potions of the enemy with new ones
     * @param p - new potion list to be set to
     */
    public void setPotions(ArrayList<Potion> p) {
        this.potions = p; //fix privacy leaks
    }

    /*------------------------------- METHODS --------------------------------*/


    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        String info = super.toString() + ", " + this.hasPotion() + ", " + this.key + ", " + this.potions;
        return info;
    }

    public static void main() {
        // Tests
        Player p = new Player();
        String[] moves = {"Weak attack", "Strong attack", "Parry", "Potion"};
        Enemy e1 = new Enemy();
        e1.setMoves(moves);
        p.setHealth(100);
        e1.setHealth(10);
        System.out.print(e1.hasPotion());
        Enemy e2 = new Enemy();
        //System.out.println(e1.attackLogic(p));
        System.out.println(e2);
    }
}
