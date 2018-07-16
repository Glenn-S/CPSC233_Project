public class Weapon extends Sprite {
    private int weaponBoost;

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /*---------------------------- CONSTRUCTORS ------------------------------*/

    /**
     * Purpose: default constructor
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
     * Purpose: constructor
     * sprite symbol will change to image later
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
     * Purpose: copy constructor
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
}
