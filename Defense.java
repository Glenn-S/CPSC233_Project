import java.awt.Image;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Defense extends Sprite {
    private int defenseBoost; // associated strenght of the defense item

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
     */
    public Defense() {
        super();
        this.defenseBoost = 0;
    }

    /**
     * Purpose: constructor for Defense
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteSymbol the image to print representing the sprite
     * @param existence a value to determine whether the object exists or not
     * @param defenseValue the integer value associated with the items defense value
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    public Defense(String title,
                   Location coordinate,
                   Image spriteImage,
                   char spriteSymbol, // will become the sprite image class later
                   String[] spriteMessages,
                   boolean existence,
                   boolean overlapsWith,
                   int defenseValue) { // this might need to change to an ArrayList
        super(title, coordinate, spriteImage, spriteSymbol, spriteMessages, existence, overlapsWith);
        this.defenseBoost = defenseValue;
    }

    /**
     * Purpose: copy constructor
     * @param item an instance of the Defense class to copy
     */
    public Defense(Defense item) {
        super(item.getName(), item.getCoord(), item.getSpriteImage(),
            item.getSpriteChar(), item.getDialogue(), item.getExists(),
            item.getoverlapsWith());
        this.defenseBoost = item.getDefenseBoost();
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To get the value of the defence items strength
     * @return the defenseBoost
     */
    public int getDefenseBoost() {
    	return this.defenseBoost;
    }

    /**
     * Purpose: To set the defense value of the item
     * @param weaponBoost the weaponBoost to set
     */
    public void setDefenseBoost(int defenceBoost) {
    	this.defenseBoost = defenceBoost;
    }

    /*------------------------------ METHODS ---------------------------------*/
    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        //String strRep = super.toString(); // when Sprite has its own to string method
        //strRep = strRep + ", " +  this.healthBoost; // when Sprite has its own method
        String strRep = this.getName() + ", " + this.getCoord() + ", " +
            this.getSpriteImage() + ", " + this.getSpriteChar() + ", " +
            this.getDialogue() + ", " + this.getExists() + ", " +
            this.getoverlapsWith();
        strRep = strRep + ", " + this.getDefenseBoost(); // for extension
        return strRep;
    }

    /*------------------------------- TESTER ---------------------------------*/
    public static void main(String[] args) {
        // test
        Defense d1 = new Defense(); //default constructor test
        Defense d2 = new Defense("Dinner Plate", null, null, ' ', null, true, false, 100);
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
    }
}
