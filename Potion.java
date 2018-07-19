/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Potion extends Sprite {
    private int healthBoost; // associated strength of the potion

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
     */
    @Override
    public Potion() {
        super();
        this.healthBoost = 0;
    }

    /**
     * Purpose: constructor for Potion
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteSymbol the image to print representing the sprite
     * @param existence a value to determine whether the object exists or not
     * @param healthValue the integer value associated with the health strength
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    @Override
    public Potion(Location coordinate,
                  String title,
                  char spriteSymbol, // will become the sprite image class later
                  boolean existence,
                  int healthValue,
                  String[] spriteMessages) { // this might need to change to an ArrayList
        super(title, existence, spriteMessages, coordinate, spriteSymbol);
        this.healthBoost = healthValue;
    }

    /**
     * Purpose: copy constructor
     * @param potion an instance of the Potion class to copy
     */
    @Override
    public Potion(Potion potion) {
        // call constructor of super(s)
        super(potion.getName(), potion.getExists(), potion.getDialogue(), potion.getCoord(), potion.getSpriteImage());
        this.healthBoost = potion.getHealthBoost();
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To get the healing strenght of a potion
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
    	this.healthBoost = healthBoost;
    }

}
