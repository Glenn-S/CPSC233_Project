
import java.util.ArrayList;
import java.util.Scanner;

/**
 * If a player has won a battle, the defeated enemy is removed from the game and
 * replaced with a tombstone at the coordinates of the enemy.
 *
 * @param enemy - enemy in battle
 * @param enemyList - list of all enemies in game, defeated enemy removed from
 * here
 * @param terrainList - list of all terrain objects in game, tombstone added
 * here
 */
public class BattleLoop extends GameLoop {

    private boolean usedParry = false; // keeps track if Parry was the attack
    private boolean enemyUsedParry = false; // keeps track if Parry was the attack

    /**
     * If a player has won a battle, the defeated enemy is removed from the game
     * and replaced with a tombstone at the coordinates of the enemy.
     *
     * @param enemy - enemy in battle
     * @param enemyList - list of all enemies in game, defeated enemy removed
     * from here
     * @param terrainList - list of all terrain objects in game, tombstone added
     * here
     */
    // public void removeEnemy(Enemy enemy, ArrayList<Enemy> enemyList, ArrayList<Terrain>      terrainList) {
    //  enemyList.remove(enemy);
    //terrainList.add(new Terrain());
    // }
    /**
     * Checks the legality of the player's desired move, only conditions are if
     * the player's health is less than 75 and the player has a potion to use
     * for the use potion move.
     *
     * @return true if legal, false otherwise
     */
    public boolean checkMove(String attack, Player player) {
        if (attack.equals(player.moves[3])) {
            ArrayList<Sprite> items = player.getItems();
            for (int i = 0; i < items.size(); i++) {
                if (player.getHealth() < 75 && player.getItems().get(i) instanceof Potion == true) {
                    return true;
                }

            }

        }
        return false;
    }

    /**
     * Checks if the enemy's health = 0
     *
     * @param e
     * @return true if the player has won, false otherwise
     * @override
     */
    public boolean checkWinState(Enemy e) {
        return e.getHealth() <= 0; // returns true if true else false
    }

    /**
     * Purpose: To get the value of the lose state variable
     *
     * @return the lose state condition flag
     */
    public boolean checkLoseState(Player player) {
        return player.getHealth() <= 0; // returns true if true else false
    }

    /**
     * Interprets user inputs and returns the corresponding attack name
     *
     * @param player
     * @return attack name
     * @override
     */
    public String playerInput(Player player) {
        System.out.println("Please select an attack from the following options by entering the number beside the attack.");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + ". " + player.moves[i]);
        }

        Scanner sc = new Scanner(System.in);
        int attack = sc.nextInt();
        if (attack > 3 || attack < 0) {
            System.out.println("Error, invalid move entered. Please enter a valid move");
            attack = sc.nextInt();
        } else if (attack == 3 && this.playerHasPotion(player) == false) {
            System.out.println("Error, No potions available. Please enter a different move");
            attack = sc.nextInt();
        }
        ArrayList<Sprite> temp = player.getItems();
        for (int i = 0; i < player.getItems().size(); i++) {
            if (temp.get(i) instanceof Potion) {
                if (attack == 3 && player.getHealth() > 100 - ((Potion) temp.get(i)).getHealthBoost()) {
                    System.out.println("Error, Health is too high for potion. Please enter a different move");
                    attack = sc.nextInt();
                }
            }
        }

        return player.moves[attack];

    }

    /**
     *
     * @param enemyUsedParry
     * @param damage
     * @param player
     * @param e
     */
    public void damageCalc(int damage, Enemy e) {
        if (this.enemyUsedParry) {
            if (Math.random() >= 0.5) {
                System.out.println("Parry success!");
            } else {
                System.out.println("Parry failed!");
                e.setHealth(e.getHealth() - damage);
            }
        } else {
            e.setHealth(e.getHealth() - damage);
        }
        if (e.getHealth() < 0) {
            e.setHealth(0);
        }
    }

    public void damageCalc(int damage, Player player) {
        if (this.usedParry) {
            if (Math.random() >= 0.5) {
                System.out.println("Parry success!");
            } else {
                System.out.println("Parry failed!");
                player.setHealth(player.getHealth() - damage);
            }
        } else {
            player.setHealth(player.getHealth() - damage);

        }
        if (player.getHealth() < 0) {
            player.setHealth(0);
        }
    }

    public void drawState(Player player, Enemy e) {
        System.out.println("Player Health: " + player.getHealth());
        System.out.println("Enemy Health: " + e.getHealth() + "\n");
    }

    public void setEnemyUsedParry(boolean eUP) {
        this.enemyUsedParry = eUP;
    }

    public void setUsedParry(boolean uP) {
        this.usedParry = uP;
    }

    public boolean getUsedParry() {
        return this.usedParry;
    }

    public boolean getEnemyUsedParry() {
        return this.enemyUsedParry;
    }

    public boolean playerHasPotion(Player player) {
        ArrayList<Sprite> temp = player.getItems();
        for (int i = 0; i < player.getItems().size(); i++) {
            if (temp.get(i) instanceof Potion) {
                return true;
            }
        }
        return false;

    }

    public void usePotion(Player player) {
        ArrayList<Sprite> temp = player.getItems();
        for (int i = 0; i < player.getItems().size(); i++) {
            if (temp.get(i) instanceof Potion) {
                player.updateHealth((Potion) temp.get(i));
                System.out.println("Health has been boosted by " + ((Potion) temp.get(i)).getHealthBoost() + "HP");
                player.removeItem(temp.get(i));
            }
        }
    }

    public void usePotion(Enemy e) {
        e.setHealth(e.getHealth() + e.getPotions().get(0).getHealthBoost());
        e.getPotions().remove(0);

    }
}
