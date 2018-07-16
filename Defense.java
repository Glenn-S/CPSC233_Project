/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Defense extends Sprite {
    private int defenseBoost; // associated strenght of the defense item

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
     */
    @Override
    public Defense() {
        this.coord = null;
        this.name = null;
        this.spriteImage = 0;
        this.exists = false;
        this.dialogue = null;
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
    @Override
    public Defense(Location coordinate,
                  String title,
                  char spriteSymbol, // will become the sprite image class later
                  boolean existence,
                  int defenseValue,
                  String[] spriteMessages) { // this might need to change to an ArrayList
        this.coord = coordinate;
        this.name = title;
        this.spriteImage = spriteSymbol;
        this.exists = existence;
        this.dialogue = spriteMessages;
        this.defenseBoost = defenseValue;
    }

    /**
     * Purpose: copy constructor
     * @param item an instance of the Defense class to copy
     */
    @Override
    public Defense(Defense item) {
        this.coord = item.getCoord();
        this.name = item.getName();
        this.spriteImage = item.getSpriteImage();
        this.exists = item.getExists();
        this.dialogue = item.getDialogue();
        this.defenseBoost = item.getDefenceBoost();
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
    public void setWeaponBoost(int weaponBoost) {
    	this.weaponBoost = weaponBoost;
    }
}
