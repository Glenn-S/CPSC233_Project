package sprite;

import javafx.scene.image.Image;

/**
 * Purpose: To represent an offensive class of weapons for the user to own
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Weapon extends Sprite {
    private int weaponBoost; // associated strength of the weapon

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor for Weapon
     */
    public Weapon() {
        super();
        this.weaponBoost = 0;
    }

    /**
     * Purpose: constructor for Weapon
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteImage the image to print representing the sprite
     * @param spriteSymbol the character symbol associated with the object
     * @param existence a value to determine whether the object exists or not
     * @param attackValue the integer value associated with the weapons strength
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    public Weapon(String title,
                  Location coordinate,
                  Image spriteImage,
                  char spriteSymbol, // will become the sprite image class later
                  String[] spriteMessages,
                  boolean existence,
                  boolean overlapsWith,
                  int attackValue) { // this might need to change to an ArrayList
        super(title, coordinate, spriteImage, spriteSymbol, spriteMessages, existence, overlapsWith);
        this.weaponBoost = attackValue;
    }
    /**
     * Purpose: constructor for Weapon for the terminal version
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteSymbol the character symbol associated with the object
     * @param existence a value to determine whether the object exists or not
     * @param attackValue the integer value associated with the weapons strength
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    public Weapon(String title,
                  Location coordinate,
                  char spriteSymbol, // will become the sprite image class later
                  String[] spriteMessages,
                  boolean existence,
                  boolean overlapsWith,
                  int attackValue) { // this might need to change to an ArrayList
        super(title, coordinate, null, spriteSymbol, spriteMessages, existence, overlapsWith);
        this.weaponBoost = attackValue;
    }

    /**
     * Purpose: copy constructor for Weapon
     * @param item an instance of the weapon class to copy
     */
    public Weapon(Weapon item) {
        // call supers constructor(s)
        super(item.getName(), item.getCoord(), item.getSpriteImage(),
            item.getSpriteChar(), item.getDialogue(), item.getExists(), item.getOverlapsWith());
        this.weaponBoost = item.getWeaponBoost();
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To get the value associated with the weapons attack strenght
     * @return the weaponBoost
     */
    public int getWeaponBoost() {
    	return this.weaponBoost;
    }

    /**
     * Purpose: To set the value of the weapons attack strength
     * @param weaponBoost the weaponBoost to set
     */
    public void setWeaponBoost(int weaponBoost) {
    	this.weaponBoost = weaponBoost;
    }

    /*------------------------------ METHODS ---------------------------------*/
    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        return super.toString() + ", Weapon Boost: " + this.getWeaponBoost(); // for extension
    }


    /*------------------------------- TESTER ---------------------------------*/
    public static void main(String[] args) {
        // test
        Weapon w1 = new Weapon(); //default constructor test
        Weapon w2 = new Weapon("Butter Knife", new Location(0,0,0,0), null, ' ', null, true, false, 200);
        System.out.println("w1: " + w1);
        System.out.println("w2: " + w2);
    }
}
