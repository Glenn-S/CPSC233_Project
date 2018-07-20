import java.awt.Image;

/**
 * Avatar is a subclass of Sprite
 *
 *
 * @version 		20.41  19  July 2018
 * @author    		Yuhui  Yan
 *
 *
 *
 * @param health       it's the health of an avator   as a type of integer
 * @param defence	   it's the defence of an avator   as a type of integer
 * @param attack       it's the attact of an avator   as a type of integer
 */
public class Avatar extends Sprite {
	protected int health;   // instance variables
	protected int defense;
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
				  int defense,
				  int attack,
				  String[] moves) {
		super(title, coordinate, spriteImage, spriteSymbol, spriteMessages, existence, overlapsWith);
		this.health = health;
		this.defense = defense;
		this.attack = attack;
		this.moves = moves;
	}
	public Avatar() {
		super();
		this.health = 0;
		this.defense = 0;
		this.attack = 0;
		this.moves = null;
	}

	/*--------------------------- GETTER/SETTERS -----------------------------*/
// *** Set and get move needs to be fixed, can't be hard coded values ***
	/**
	 * @param input         select the movement type of a avator  as a type of String
	 */
	// this might need to also have an associated index value with it for the array
	public void setMove(String input){// input word to set movement type
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

	/**
	 * @return move         get the movement type of the avator as a type of String
	 */
	// this might need to also have an associated index value with it for the array
	public String getMove() {   		//get movement type
		return move;
	}

	/**
	 * @param health        it's the health of an avator   as a type of integer
	 */
	public void setHealth(int health) {//set health for the avatar
		this.health = health;
	}

	/**
	 * @return health       renew the health state of the avatar   as a  type of integer
	 */
	public int getHealth() {			//get health
		return this.health;
	}

	/**
	 * @param defence       it's the defence of an avator   as a type of integer
	 */
	public void setDefence(int defence) {//set defence for the avatar
		this.defence = defence;
	}

	/**
	 * @return defence      renew the defence value of the avatar   as a  type of integer
	 */
	public int getDefence() {    		//get defence
		return this.defence;
	}

	/**
	 * @param attack        it's the attact of an avator   as a type of integer
	 */
	public void setAttack(int attack) {//set attack for the avator
		this.attack = attack;
	}

	/**
	 * @return attack       renew the attact value of the avatar   as a  type of integer
	 */
	public int getAttack() {			//get attack
		return this.attack;
	}

	/*------------------------------ METHODS ---------------------------------*/
	/**
	 * @param healthBoost it's the health value that potion will added to the avatar   as a type of integer
	 */
	public int updateHealth(Potions healthBoost) {//update health when using a potion
		this.health += Potions.healthBoost;
	}

	/**
	 * @param WeaponStrength   it's the attack value that a Weapon iteam will added to the avatar   as a type of integer
	 */
	public void updateAttack(Weapon WeaponStrength) {//update attack when carring some weapons
		this.attack += Weapon.WeaponStrength;
	}

	/**
	 * @param DefenceBoost   it's the defence value that a defence iteam will added to the avatar   as a type of integer
	 */
	public void UpdateDefence(Defence DefenceBoost) {//update defence when carring some defence items.
		this.defence += Defence.DefenceBoost;
	}

	/**
     * Purpose: To print out a string representation of the class attributes
     * @return a string with all the attributes
     */
    @Override
    public String toString() {
        //String strRep = super.toString(); // when Sprite has its own to string method
        //strRep = strRep + ", " +  this.healthBoost; // when Sprite has its own method
        String strRep = this.getName() + ", " + this.getCoord() + ", " +
            this.getSpriteImage() + ", " + this.getSpriteChar() + ", " +
            this.getDialogue() + ", " + this.getExists() + ", " +
            this.getoverlapsWith();
        strRep = strRep + ", " + this.getHealth() + ", " +
			this.getAttack() + ", " + this.getDefence(); // for extension
        return strRep;
    }

	/*------------------------------- TESTER ---------------------------------*/
	public static void main(String[] args) {
		// Tests
		Avatar a1 = new Avatar();
		Avatar a2 = new Avatar("Avatar", null, null, 'x', null, true, false, 100, 50, 150, null);
		String storedVal = a1.get
	}

}
