public class BattleLoop extends GameLoop{

/**
* If a player has won a battle, the defeated enemy is removed from the game and replaced 
* with a tombstone at the coordinates of the enemy.
* @param enemy - enemy in battle
* @param enemyList - list of all enemies in game, defeated enemy removed from here
* @param terrainList - list of all terrain objects in game, tombstone added here
*
public void removeEnemy(Enemy enemy,ArrayList<Enemy> enemyList,ArrayList<Terrain> terrainList){}
/**
* Check's the legality of the player's desired move
* @return true if legal, false otherwise
*
public boolean checkMove(){return false;}
@override
/**
* Check's if the enemy's health = 0
* @return true if the player has won, false otherwise
*
public boolean checkWinState(){return false;}
@override
/**
* Check's if the player's health = 0
* @return true if the player has lost, false otherwise
*
public boolean checkLoseState(){return false;}
@override
/**
* Interprets user inputs and returns the corresponding attack name
* @return attack name
*
public String playerInput(){return "";}

public void initialize(){}
public void drawState(){}

}