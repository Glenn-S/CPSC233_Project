/**
* weak attack = 15HP
* Strong attack = 40HP but takes 2 turns to work
* Parry has a 50% chance of not working otherwise reduces damage to 0
* Potion recovers 25HP
* engageBattle should have an enemy as a parameter to check specifically which enemy is 
* being fought.
*/


public class Enemy extends Avatar{
private boolean key; // if true, enemy has a key. false if they do not have a key 

/**
* Constructor for the class, likely to be used at game loop initialization
* sets the initial health, defence, attack, and allowed moves for the enemy 
* also determines whether or not the enemy will have a key on them 
* @param health - enemy health as an integer
* @param defence - enemy defence value as an integer
* @param attack - enemy attack value as an integer
* @param moves - list of all possible enemy attacks
* @param key - true if enemy has a key, false otherwise
*/

public Enemy(int health, int defence, int attack, String[] moves, boolean key){
super(health, defence, attack, moves); // invokes Avatar constructor
this.key = key;
}

/**
* Determines if the enemy has a key or not
* @return key - true if enemy has a key, false otherwise
*/

public boolean getKey(){
return this.key
}

/**
* Changes if the enemy has a key or not
* @param key - new state of the enemy's key 
* @return None
*/

public void setKey(boolean key){
this.key = key;
}

/**
* Decides what attack the enemy will use. This is accomplished by deciding the most 
* efficient way to reduce player health to 0 while keeping the enemy's health as high as 
* possible.
* @param e - enemy in battle 
* @return e.moves[] - the attack the enemy decides to use
*/
public String attackLogic(Enemy e){
if(player.getHealth() <= 15){
return e.moves[0];
} else if(player.getHealth()<=40 && e.getHealth() > 30){
return e.moves[1];
} else if(e.getHealth() <= 25 && e.hasPotion()==true){
return e.moves[3];
} else if(e.getHealth()<=40 && e.hasPotion() ==false){
return e.moves[2];
} else{
return e.moves[0];
}
}


}


