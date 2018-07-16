public class Potion extends Sprite {
    private int healthBoost;

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
     */
    @Override
    public Potion() {
        this.coord = null;
        this.name = null;
        this.spriteImage = 0;
        this.exists = false;
        this.dialogue = null;
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
        this.coord = coordinate;
        this.name = title;
        this.spriteImage = spriteSymbol;
        this.exists = existence;
        this.dialogue = spriteMessages;
        this.healthBoost = healthValue;
    }

    /**
     * Purpose: copy constructor
     * @param potion an instance of the Potion class to copy
     */
    @Override
    public Potion(Potion potion) {
        this.coord = potion.getCoord();
        this.name = potion.getName();
        this.spriteImage = potion.getSpriteImage();
        this.exists = potion.getExists();
        this.dialogue = potion.getDialogue();
        this.healthBoost = potion.getHealthBoost();
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * @return the healthBoost
     */
    public int getHealthBoost() {
    	return this.healthBoost;
    }

    /**
     * @param healthBoost the healthBoost to set
     */
    public void setHealthBoost(int healthBoost) {
    	this.healthBoost = healthBoost;
    }

}
