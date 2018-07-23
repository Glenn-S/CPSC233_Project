import java.awt.Image;

/**
 * Purpose: To represent a healing class of items for the user to own
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Potion extends Sprite {
    private int healthBoost; // associated strength of the potion

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
     */
    public Potion() {
        super();
        this.healthBoost = 0;
    }

    /**
     * Purpose: constructor for Potion
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteImage the image to print representing the sprite
     * @param spriteSymbol the character symbol associated with the object
     * @param existence a value to determine whether the object exists or not
     * @param healthValue the integer value associated with the health strength
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    public Potion(String title,
                  Location coordinate,
                  Image spriteImage,
                  char spriteSymbol, // will become the sprite image class later
                  String[] spriteMessages,
                  boolean existence,
                  boolean overlapsWith,
                  int healthValue) { // this might need to change to an ArrayList
        super(title, coordinate, spriteImage, spriteSymbol, spriteMessages, existence, overlapsWith);
        this.healthBoost = healthValue;
    }
    /**
     * Purpose: constructor for Potion for terminal version
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteSymbol the character symbol associated with the object
     * @param existence a value to determine whether the object exists or not
     * @param healthValue the integer value associated with the health strength
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    public Potion(String title,
                  Location coordinate,
                  char spriteSymbol, // will become the sprite image class later
                  String[] spriteMessages,
                  boolean existence,
                  boolean overlapsWith,
                  int healthValue) { // this might need to change to an ArrayList
        super(title, coordinate, null, spriteSymbol, spriteMessages, existence, overlapsWith);
        this.healthBoost = healthValue;
    }

    /**
     * Purpose: copy constructor
     * @param potion an instance of the Potion class to copy
     */
    public Potion(Potion potion) {
        // call constructor of super(s)
        super(potion.getName(), potion.getCoord(), potion.getSpriteImage(),
            potion.getSpriteChar(), potion.getDialogue(), potion.getExists(),
            potion.getOverlapsWith());
        this.healthBoost = potion.getHealthBoost();
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To get the healing strenght of a potion.
     * @return the healthBoost
     */
    public int getHealthBoost() {
    	return this.healthBoost;
    }

    /**
     * Purpose: To set the healing strenght of a potion
     * @param healthBoost the healthBoost to set
     */
    public void setHealthBoost(int healthBoost) {
    	this.healthBoost = healthBoost; // can be a positive or negative value for later expansion
    }

    /*------------------------------ METHODS ---------------------------------*/
    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        return super.toString() + ", Health Boost: " + this.getHealthBoost(); // for extension
    }

    /*------------------------------- TESTER ---------------------------------*/
    public static void main(String[] args) {
        // test
        Potion p1 = new Potion(); //default constructor test
        Potion p2 = new Potion("Medium Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 50);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }
}
