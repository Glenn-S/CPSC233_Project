public class Defense extends Sprite {
    private int defenseBoost;

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
     * Purpose: constructor
     * sprite symbol will change to image later
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
}
