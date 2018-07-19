
import java.util.Scanner;

/**
* If a player has won a battle, the defeated enemy is removed from the game and replaced
* with a tombstone at the coordinates of the enemy.
* @param enemy - enemy in battle
* @param enemyList - list of all enemies in game, defeated enemy removed from here
* @param terrainList - list of all terrain objects in game, tombstone added here
*/
public class BattleLoop extends GameLoop {

    /**
     * If a player has won a battle, the defeated enemy is removed from the game
     * and replaced with a tombstone at the coordinates of the enemy.
     * @param enemy - enemy in battle
     * @param enemyList - list of all enemies in game, defeated enemy removed
     * from here
     * @param terrainList - list of all terrain objects in game, tombstone added
     * here
     */

    public void removeEnemy(Enemy enemy, ArrayList<Enemy> enemyList, ArrayList<Terrain>      terrainList) {
        enemyList.remove(enemy);
        terrainList.add(new Terrain());
    }

    /**
     * Checks the legality of the player's desired move, only conditions are if
     * the player's health is less than 75 and the player has a potion to use
     * for the use potion move.
     * @return true if legal, false otherwise
     */

    public boolean checkMove(String attack) {
        if (attack.equals(player.moves[3])) {
            if (player.getHealth() > 75 || player.hasPotion() == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the enemy's health = 0
     * @return true if the player has won, false otherwise
     * @override
     */

    public boolean checkWinState(Enemy e) {
        if (e.getHealth() == 0) {
            return true;
        }
        return false;

    }

    /**
     * Checks if the player's health = 0
     * @return true if the player has lost, false otherwise
     * @override
     */

    public boolean checkLoseState() {
        if (player.getHealth() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Interprets user inputs and returns the corresponding attack name
     * @return attack name
     * @override
     */

    public String playerInput() {
        System.out.println("Please select an attack from the following option");
        for (int i = 0; i < 4; i++) {
            System.out.println(player.moves[i]);
        }
        Scanner sc = new Scanner(System.in);
        String attack = sc.nextLine();
        if (attack != moves[0].ignoreCase() && attack != moves[1].ignoreCase() && attack != moves[2].ignoreCase() && attack != moves[3].ignoreCase()) {
            System.out.println("Error, invalid move entered. Please enter a valid move");
            attack = sc.nextLine();
        }
        return attack;

    }

    public void initialize() {
    }

    public void drawState() {
    }

}
