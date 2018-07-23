

import java.awt.Image;

/**
 * @version 20.41 19 July 2018
 * health it's the health of an avator as a type of integer
 * defence it's the defence of an avator as a type of integer
 * attack it's the attact of an avator as a type of integer
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Avatar extends Sprite {

    protected int health;   // instance variables
    protected int defence;
    protected int attack;
    String[] moves;

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

    public Avatar() {
        super();
        this.health = 0;
        this.defence = 0;
        this.attack = 0;
        this.moves = null;
    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
// *** Set and get move needs to be fixed, can't be hard coded values ***
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
     * @return move get the movement type of the avatar as a type of String
     */
    // this might need to also have an associated index value with it for the array
    public String[] getMoves() {   		//get movement type
        return this.moves;
    }

    /**
     * @param moves - new move set for the avatar
     */
    // this might need to also have an associated index value with it for the array
    public void setMoves(String[] moves) {   		//get movement type
        this.moves = moves;
    }

    /**
     * @param health it's the health of an avatar as a type of integer
     */
    public void setHealth(int health) {//set health for the avatar
        this.health = health;
    }

    /**
     * @return health renew the health state of the avatar as a type of integer
     */
    public int getHealth() {			//get health
        return this.health;
    }

    /**
     *
     */
    public String getStats() {
		return "Name: " + this.name + "\nHealth: " + this.health +
            "\nAttack: " + this.attack + "\nDefence: " + this.defence;
	}

    /**
     * @param defence it's the defence of an avatar as a type of integer
     */
    public void setDefence(int defence) {//set defence for the avatar
        this.defence = defence;
    }

    /**
     * @return defence renew the defence value of the avatar as a type of
     * integer
     */
    public int getDefence() {    		//get defence
        return this.defence;
    }

    /**
     * @param attack it's the attack of an avatar as a type of integer
     */
    public void setAttack(int attack) {//set attack for the avator
        this.attack = attack;
    }

    /**
     * @return attack renew the attack value of the avatar as a type of integer
     */
    public int getAttack() {			//get attack
        return this.attack;
    }

    /*------------------------------ METHODS ---------------------------------*/
    /**
     * @param healthBoost it's the health value that potion will added to the
     * avatar as a type of integer
     */
    public void updateHealth(Potion healthBoost) {//update health when using a potion
        this.health += healthBoost.getHealthBoost();
    }

    /**
     * @param WeaponStrength it's the attack value that a Weapon iteam will
     * added to the avatar as a type of integer
     */
    public void updateAttack(Weapon weaponStrength) {//update attack when carring some weapons
        this.attack += weaponStrength.getWeaponBoost();
    }

    /**
     * @param DefenceBoost it's the defence value that a defence iteam will
     * added to the avatar as a type of integer
     */
    public void updateDefence(Defence defenceBoost) {//update defence when carring some defence items.
        this.defence += defenceBoost.getDefenceBoost();
    }

    /**
     * Purpose: To print out a string representation of the class attributes
     *
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
