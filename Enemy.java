/**
* moves[0] = weak attack = 15HP
* moves [1] = Strong attack = 40HP but takes 2 turns to work
* moves[2] = Parry has a 50% chance of not working otherwise reduces damage to 0
* moves[3] = Potion recovers 25HP
* engageBattle should have an enemy as a parameter to check specifically which enemy is
* being fought.
*/


public class Enemy extends Avatar{
    private boolean key; // if true, enemy has a key. false if they do not have a key
    private boolean hasPotion; // shows if enemy has any potions left
    private Potion[] potions; // list of potions the enemy has

    /*---------------------------- CONSTRUCTORS ------------------------------*/
    /**
     * Constructor for the class, likely to be used at game loop initialization
     * sets the initial health, defence, attack, and allowed moves for the enemy
     * also determines whether or not the enemy will have a key on them
     * @param health - enemy health as an integer
     * @param defence - enemy defence value as an integer
     * @param attack - enemy attack value as an integer
     * @param moves - list of all possible enemy attacks
     * @param key - true if enemy has a key, false otherwise
     * @param key - true if enemy has a potion, false otherwise
     */
    public Enemy(int health, int defence, int attack, String[] moves, boolean key, boolean hasPotion){
        super(health, defence, attack, moves); // invokes Avatar constructor
        this.key = key;
        this.hasPotion = hasPotion;
    }

    /*-------------------------- GETTERS/SETTERS -----------------------------*/
    /**
     * Determines if the enemy has a key or not
     * @return key - true if enemy has a key, false otherwise
     */
    public boolean getKey(){
        return this.key;
    }

    /**
     * Changes if the enemy has a key or not
     * @param key - new state of the enemy's key
     * @return None
     */
    public void setKey(boolean key){
        this.key = key;
    }

    /*------------------------------- METHODS --------------------------------*/
    /**
     * Decides what attack the enemy will use. This is accomplished by deciding the most
     * efficient way to reduce player health to 0 while keeping the enemy's health as high as
     * possible.
     * @return moves[] - the attack the enemy decides to use
     */
    public String attackLogic(){
        if(player.getHealth() <= 15){
            return this.moves[0];
        } else if(player.getHealth()<=40 && this.getHealth() > 30){
            return this.moves[1];
        } else if(this.getHealth() <= 25 && this.hasPotion==true){
            return this.moves[3];
        } else if(this.getHealth()<=40 && this.hasPotion ==false){
            return this.moves[2];
        } else{
            return this.moves[0];
        }
    }

    /**
	 * Purpose: To print out a string representation of the class attributes
	 * @return a string with all the attributes
	 */
	@Override
	public String toString() {
		return "";
	}

    public static void main() {
        // Tests
        Enemy e1 = new Enemy();
        Enemy e2 = new Enemy();
        System.out.println();
        System.out.println();
    }


}
