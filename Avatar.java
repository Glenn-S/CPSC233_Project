

import java.awt.Image;

/**
 * Purpose: This class represents all living/actionable sprites in the game
 * Each sprite has a list of attacks, and a baseline attack,defence and health
 * value as well as all fields inherited from the Sprite class.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Avatar extends Sprite {

    protected int health;   // health of the avatar as an integer
    protected int defence;  // defence stat of the avatar as an integer
    protected int attack;  // attack stat of the avatar as an integer
    protected gString[] moves;        // list of attack the avatar has

    /*---------------------------- CONSTRUCTORS ------------------------------*/
    public Avatar(String name,
                  Location coord,
                  Image spriteImage,
                  char spriteChar, // will become the sprite image class later
                  String[] dialogue,
                  boolean exists,
                  boolean overlapsWith,
                  int health,
                  int defence,
                  int attack,
                  String[] moves) {
        super(name, coord, spriteImage, spriteChar, dialogue, exists, overlapsWith);
        this.health = health;
        this.defence = defence;
        this.attack = attack;
        this.moves = moves;
    }

    /**
     * Purpose: default constructor. Calls default constructor from the Sprite
     * class and initializes any remaining primitive fields to 0 and objects
     * to null.
     */
    public Avatar() {
        super();
        this.health = 0;
        this.defence = 0;
        this.attack = 0;
        this.moves = null;
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/

    /**
     * @param input select the movement type of a avatar as a type of String
     */
    // this might need to also have an associated index value with it for the array
/*	public void setMoves(String input){// input word to set movement type
		if (input.toUpperCase() == "SLASH") {
			move = "Slash";
		}
		else if (input.toUpperCase() == "PARRY") {
			move = "Parry";
		}
		else if (input.toUpperCase()== "SWORD BOOMERANG" ) {
			move = "Sword Boomerang";
		}
		else if (input.toUpperCase() == "POTION") {
			move = "Potion";
		}
	}
     */
    /**
     * Purpose: Returns the array of the avatar's attacks
     * @return move get the movement type of the avatar as a type of String
     */
    // this might need to also have an associated index value with it for the array
    public String[] getMoves() {   		//get movement type
        return this.moves;
    }

    /**
     * Purpose: set's avatar's move set to the desired attacks
     * @param moves - new move set for the avatar
     */
    // this might need to also have an associated index value with it for the array
    public void setMoves(String[] moves) {   		//get movement type
        this.moves = moves;
    }

    /**
     * Purpose: Set's the health of the avatar to the desired health
     * @param health it's the health of an avatar as a type of integer
     */
    public void setHealth(int health) {//set health for the avatar
        this.health = health;
    }

    /**
     * Purpose: Retrieves the current health of the avatar.
     * @return health renew the health state of the avatar as a type of integer
     */
    public int getHealth() {			//get health
        return this.health;
    }

    /**
     * Purpose: Returns all information about an avatar
     * @return String of all variables of the avatar
     */
    public String getStats() {
		return "Name: " + this.name + "\nHealth: " + this.health +
            "\nAttack: " + this.attack + "\nDefence: " + this.defence;
	}

    /**
     * Purpose: Changes defence of the avatar to the desired defence.
     * @param defence it's the defence of an avatar as a type of integer
     */
    public void setDefence(int defence) {//set defence for the avatar
        this.defence = defence;
    }

    /**
     * Purpose: Returns the current defence of the avatar
     * @return defence renew the defence value of the avatar as a type of
     * integer
     */
    public int getDefence() {    		//get defence
        return this.defence;
    }

    /**
     * Purpose: Changes the baseline attack value of the avatar to the desired
     * value
     * @param attack it's the attack of an avatar as a type of integer
     */
    public void setAttack(int attack) {//set attack for the avator
        this.attack = attack;
    }

    /**
     * Purpose: Returns the current baseline attack value of the avatar
     * @return attack renew the attack value of the avatar as a type of integer
     */
    public int getAttack() {			//get attack
        return this.attack;
    }

    /*------------------------------ METHODS ---------------------------------*/
    /**
     * Purpose: Increases characters health as the result of using a potion
     * @param healthBoost it's the  potion that will add health to the
     * avatar.
     */
    public void updateHealth(Potion healthBoost) {//update health when using a potion
        this.health += healthBoost.getHealthBoost();
    }

    /**
     * Purpose: Updates baseline attack value from acquiring a weapon item.
     * @param weaponStrength it's the attack value that a Weapon iteam will
     * added to the avatar as a type of integer
     */
    public void updateAttack(Weapon weaponStrength) {//update attack when carring some weapons
        this.attack += weaponStrength.getWeaponBoost();
    }

    /**
     * Purpose: Updates baseline defence value from acquiring a defence item.
     * @param defenceBoost it's the defence value that a defence iteam will
     * added to the avatar as a type of integer
     */
    public void updateDefence(Defence defenceBoost) {//update defence when carring some defence items.
        this.defence += defenceBoost.getDefenceBoost();
    }

    /**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        return super.toString() + ", Health: " + this.getHealth() + ", Attack: " +
            this.getAttack() + ", Defence: " + this.getDefence() + ", Moves: " +
            this.getMoves(); // for extension
    }

    /*------------------------------- TESTER ---------------------------------*/
    public static void main(String[] args) {
        // Tests
        Avatar a1 = new Avatar();
        Avatar a2 = new Avatar("Avatar", new Location(0,0,0,0), null, 'x', null, true, false, 100, 50, 150, null);
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2);
    }

}
