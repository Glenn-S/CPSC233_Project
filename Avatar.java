import java.awt.Image;

public class Avatar extends Sprite{
	private int health;
	private int defence;
	private int attact;
	String move;

	public Avatar(Location coord,String name,Image SpriteImage,boolean Exists,String[] Dialogue,boolean overlapsWith) {
		super(coord,name,SpriteImage,Exists,Dialogue,overlapsWith);
	}
	public Avatar() {

	}
	public void setMove(String input){
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

	public String getMove() {
		return move;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	public int UpdateHealth(Potions healthBoost) {
		this.health += Potions.healthBoost;
	}
	public int getHealth() {
		return health;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public void UpdateDefence(Defence DefenceBoost) {
		this.defence += Defence.DefenceBoost;
	}
	public int getDefence() {
		return defence;
	}
	public void setAttact(int attact) {
		this.attact = attact;
	}
	public void setAttack(Weapon WeaponStrength) {
		this.attack += Weapon.WeaponStrength;
	}
	public int getAttact() {
		return attact;
	}

}
