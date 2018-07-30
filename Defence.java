import javafx.scene.image.Image;

/**
 * Purpose: To represent a defensive class of items for the users to own
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Defence extends Sprite {
    private int defenceBoost; // associated strenght of the defence item

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
     */
    public Defence() {
        super();
        this.defenceBoost = 0;
    }

    /**
     * Purpose: constructor for Defence
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteImage - image used to represent defence item
     * @param spriteSymbol the image to print representing the sprite
     * @param existence a value to determine whether the object exists or not
     * @param defenceValue the integer value associated with the items defence value
     * @param overlapsWith - True if player overlaps with defence item
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    public Defence(String title,
                   Location coordinate,
                   Image spriteImage,
                   char spriteSymbol, // will become the sprite image class later
                   String[] spriteMessages,
                   boolean existence,
                   boolean overlapsWith,
                   int defenceValue) { // this might need to change to an ArrayList
        super(title, coordinate, spriteImage, spriteSymbol, spriteMessages, existence, overlapsWith);
        this.defenceBoost = defenceValue;
    }

    /**
     * Purpose: copy constructor
     * @param item an instance of the Defence class to copy
     */
    public Defence(Defence item) {
        super(item.getName(), item.getCoord(), item.getSpriteImage(),
            item.getSpriteChar(), item.getDialogue(), item.getExists(), item.getOverlapsWith());
        this.defenceBoost = item.getDefenceBoost();
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To get the value of the defence items strength
     * @return the defenceBoost
     */
    public int getDefenceBoost() {
    	return this.defenceBoost;
    }

    /**
     * Purpose: To set the defence value of the item
     * @param defenceBoost the defenceBoost to set
     */
    public void setDefenceBoost(int defenceBoost) {
    	this.defenceBoost = defenceBoost;
    }

    /*------------------------------ METHODS ---------------------------------*/
    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        return super.toString() + ", Defence Boost: " + this.getDefenceBoost(); // for extension
    }

    /*------------------------------- TESTER ---------------------------------*/
    public static void main(String[] args) {
        // test
        Defence d1 = new Defence(); //default constructor test
        Defence d2 = new Defence("Dinner Plate", new Location(0,0,0,0), null, ' ', null, true, false, 100);
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
    }
}
