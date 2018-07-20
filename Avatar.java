import java.awt.Image;
public class Avatar extends Sprite{
/*Avatar is a subclass of Sprite 
 * 
 * 
 * @version 		20.41  19  July 2018
 * @author    		Yuhui  Yan
 * 
 *
	 *
	 * @param health       it's the health of an avator   as a type of integer
	 * @param defence	   it's the defence of an avator   as a type of integer
	 * @param attact       it's the attact of an avator   as a type of integer
	 */
	private int health;   // instance variables
	private int defence;
	private int attact;
	String move;
	
	public Avatar(Location coord,String name,Image SpriteImage,boolean Exists,String[] Dialogue,boolean overlapsWith) {
		super(coord,name,SpriteImage,Exists,Dialogue,overlapsWith);
	} // constructors 
	public Avatar() {
		
	}
	
	/*
	 * @param input         select the movement type of a avator  as a type of String
	 */	
	public void setMove(String input){// input word to set movement type
		if (input.toUpperCase() == "SLASH") {
			move = "Slash";
		}
		else if (input.toUpperCase() == "PARRY") {
			move = "Parry";
		}
		else if (input.toUpperCase()== "SWORD BOOMERANGE" ) {
			move = "Sword Boomerang";
		}
		else if (input.toUpperCase() == "POTION") {
			move = "Potion";
		}		
	}
	
	/*
	 * @return move         get the movement type of the avator as a type of String
	 */
	public String getMove() {   		//get movement type 
		return move;		
	}
	
	/*
	 * @param health        it's the health of an avator   as a type of integer
	 */		
	public void setHealth(int health) {//set health for the avatar
		this.health = health;
	}
	
	/*
	 * @param healthBoost   it's the health value that potion will added to the avatar   as a type of integer
	 */	
	public int UpdateHealth(Potions healthBoost) {//update health when using a potion
		this.health += Potions.healthBoost;
	}
	
	/*
	 * @return health       renew the health state of the avatar   as a  type of integer
	 */
	public int getHealth() {			//get health
		return health;
	}
	
	
	/*
	 * @param defence       it's the defence of an avator   as a type of integer
	 */	
	public void setDefence(int defence) {//set defence for the avatar
		this.defence = defence;
	}
	
	/*
	 * @param DefenceBoost   it's the defence value that a defence iteam will added to the avatar   as a type of integer
	 */	
	public void UpdateDefence(Defence DefenceBoost) {//update defence when carring some defence iteams.
		this.defence += Defence.DefenceBoost;
	}
	
	/*
	 * @return defence      renew the defence value of the avatar   as a  type of integer
	 */
	public int getDefence() {    		//get defence
		return defence;
	}
	
	/*
	 * @param attact        it's the attact of an avator   as a type of integer
	 */	
	public void setAttact(int attact) {//set attack for the avator
		this.attact = attact;
	}
	
	/*
	 * @param WeaponStrength   it's the attact value that a Weapon iteam will added to the avatar   as a type of integer
	 */	
	public void setAttack(Weapon WeaponStrength) {//update attack when carring some weapons
		this.attack += Weapon.WeaponStrength;
	}
	
	
	/*
	 * @return attact       renew the attact value of the avatar   as a  type of integer
	 */
	public int getAttact() {			//get attack
		return attact;
	}
	
}
