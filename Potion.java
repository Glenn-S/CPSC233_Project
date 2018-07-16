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
     * Purpose: constructor
     * sprite symbol will change to image later
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


}
