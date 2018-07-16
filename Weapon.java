/**
 *
 */
public class Weapon extends Sprite {
    private int weaponBoost; // associated strength of the weapon

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor for Weapon
     */
    @Override
    public Weapon() {
        this.coord = null;
        this.name = null;
        this.spriteImage = 0;
        this.exists = false;
        this.dialogue = null;
        this.weaponBoost = 0;
    }

    /**
     * Purpose: constructor for Weapon
     * sprite symbol will change to image later
     * @param coordinate the location for the sprite to exist in the game
     * @param title the name associated with the sprite
     * @param spriteSymbol the image to print representing the sprite
     * @param existence a value to determine whether the object exists or not
     * @param attackValue the integer value associated with the weapons strength
     * @param spriteMessages the list of messages that the sprite has for interactions
     */
    @Override
    public Weapon(Location coordinate,
                  String title,
                  char spriteSymbol, // will become the sprite image class later
                  boolean existence,
                  int attackValue,
                  String[] spriteMessages) { // this might need to change to an ArrayList
        this.coord = coordinate;
        this.name = title;
        this.spriteImage = spriteSymbol;
        this.exists = existence;
        this.dialogue = spriteMessages;
        this.weaponBoost = attackValue;
    }

    /**
     * Purpose: copy constructor for Weapon
     * @param item an instance of the weapon class to copy
     */
    @Override
    public Weapon(Weapon item) {
        this.coord = item.getCoord();
        this.name = item.getName();
        this.spriteImage = item.getSpriteImage();
        this.exists = item.getExists();
        this.dialogue = item.getDialogue();
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
}
