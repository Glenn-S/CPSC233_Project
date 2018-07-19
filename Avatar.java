import java.awt.Image;
//Avatar is a subclass of Sprite 
public class Avatar extends Sprite{
	private int health;   // instance variables
	private int defence;
	private int attact;
	String move;
	
	public Avatar(Location coord,String name,Image SpriteImage,boolean Exists,String[] Dialogue,boolean overlapsWith) {
		super(coord,name,SpriteImage,Exists,Dialogue,overlapsWith);
	} // constructors
	public Avatar() {
		
	}
	public void setMove(String input){// input word to set movement type
		if (input == "Slash" || input == "slash" || input == "SLASH") {
			move = "Slash";
		}
		else if (input == "Parry" || input == "parry" || input == "PARRY") {
			move = "Parry";
		}
		else if (input == "Sword Boomerang" || input == "word boomerange" || input == "SWORD BOOMERANGE") {
			move = "Sword Boomerang";
		}
		else if (input == "Potion" || input == "potion" || input == "POTION") {
			move = "Potion";
		}		
	}
	
	public String getMove() {   		//get movement type 
		return move;		
	}
		
	public void setHealth(int health) {//set health for the avatar
		this.health = health;
	}
	public int UpdateHealth(Potions healthBoost) {//update health when using a potion
		this.health += Potions.healthBoost;
	}
	public int getHealth() {			//get health
		return health;
	}
	public void setDefence(int defence) {//set defence for the avatar
		this.defence = defence;
	}
	public void UpdateDefence(Defence DefenceBoost) {//update defence when carring some defence iteams.
		this.defence += Defence.DefenceBoost;
	}
	public int getDefence() {    		//get defence
		return defence;
	}
	public void setAttact(int attact) {//set attack for the avator
		this.attact = attact;
	}
	public void setAttack(Weapon WeaponStrength) {//update attack when carring some weapons
		this.attack += Weapon.WeaponStrength;
	}
	public int getAttact() {			//get attack
		return attact;
	}
	
}
