


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: Handles all actions regarding the battle system in the game.
 * This includes choosing the user's move, keeping track of attack
 * characteristics calculating damage from battling and updating the health of
 * the player and enemies involved.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class BattleLoop extends GameLoop {

    private boolean usedParry = false; // keeps track if Parry was the attack
    private boolean enemyUsedParry = false; // keeps track if Parry was the attack
    /**
     * Purpose: Change state of the usedParry variable for the enemy
     * @param uP - the desired state for the usedParry variable
     */

    /*-------------------------- GETTERS/SETTERS -----------------------------*/
    public void setEnemyUsedParry(boolean eUP) {
        this.enemyUsedParry = eUP;
    }
    /**
     * Purpose: Change state of the usedParry variable for the player
     * @param uP - the desired state for the usedParry variable
     */
    public void setUsedParry(boolean uP) {
        this.usedParry = uP;
    }
    /**
     * Purpose: Checks to see if the last move a player used was the Parry attack
     * @return - true if last attack used was Parry, false otherwise
     */
    public boolean getUsedParry() {
        return this.usedParry;
    }
    /**
     * Purpose: Checks to see if the last move an enemy used was the Parry attack
     * @return - true if last attack used was Parry, false otherwise
     */
    public boolean getEnemyUsedParry() {
        return this.enemyUsedParry;
    }

    /*------------------------------- METHODS --------------------------------*/
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
     public void removeEnemy(Enemy enemy, ArrayList<Enemy> enemyList, ArrayList<Sprite> terrainList) {
      enemy.setExists(false);
      terrainList.add(new Sprite("tombstone",enemy.getCoord(),null,'T',null,true,false));
      enemyList.remove(enemy);

     }

     /**
     * Purpose: To check if the enemy has lost the game(their health has
     * reached 0).
     * @return the win state condition
     */
    public boolean checkWinState(Enemy e) {
        return e.getHealth() <= 0; // returns true if true else false
    }

    /**
     * Purpose: To check if the player has lost the game(their health has
     * reached 0).
     * @return the lose state condition
     */
    public boolean checkLoseState(Player player) {
        return player.getHealth() <= 0; // returns true if true else false
    }

    /**
     * Purpose: Interprets user inputs and returns the corresponding attack name
     * and legality of the attack.
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
     * Purpose: Calculates the damage done to the enemy by the user's most
     * recent attack.
     * @param damage - integer value of damage received
     * @param e - enemy who is taking the damage
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
    /**
     * Purpose: Calculates the damage done to the player by the enemy's most
     * recent attack.
     * @param damage - integer value of damage received
     * @param player - player who is taking the damage
     */
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
    /**
     * Purpose: To update the player and enemy's health after each move
     * @param player - player involved in battle
     * @param e - enemy involved in battle
     */
    public void drawState(Player player, Enemy e) {
        System.out.println("Player Health: " + player.getHealth());
        System.out.println("Enemy Health: " + e.getHealth() + "\n");
    }


    /**
     * Purpose: Checks to see if a player has a potion to use in battle
     * @param player
     * @return - true if player has a potion, false otherwise
     */
    public boolean playerHasPotion(Player player) {
        ArrayList<Sprite> temp = player.getItems();
        for (int i = 0; i < player.getItems().size(); i++) {
            if (temp.get(i) instanceof Potion) {
                return true;
            }
        }
        return false;

    }

    /**
     * Purpose:Use potion method that allows the player to use a potion during battle
     * @param player - the player who is to use the potion
     */
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

    /**
     * Purpose: Allows enemy to use potion during battle
     * @param e - enemy to use potion
     */
    public void usePotion(Enemy e) {
        e.setHealth(e.getHealth() + e.getPotions().get(0).getHealthBoost());
        e.getPotions().remove(0);

    }

    /**
     * Purpose: To test engage Battle and this class
     * @param args
     */
    public static void main(String[] args){
     BattleLoop b = new BattleLoop();
        int i = 0;
        Player player = new Player();
        String attacks[] = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        player.setMoves(attacks);
        player.setHealth(100);
        Enemy e = new Enemy();
        String eAttacks[] = {"Slash", "Margarine Missile", "Parry", "Potion"};
        e.setHealth(100);
        e.setMoves(eAttacks);
        ArrayList<Potion> arrayList = new ArrayList<>();
        Potion p = new Potion();
        Potion q = new Potion();
        q.setHealthBoost(25);
        ArrayList<Sprite> pl = new ArrayList<>();
        pl.add(q);
player.setItems(pl);
        p.setHealthBoost(25);
        arrayList.add(p);
        e.setPotions(arrayList);
        int bbCounter = 0;  // keeps track of turns for Butter boomerang attack
        int mmCounter = 0;  // keeps track of turns for Margarine missile attack
        int damage;
        while (i == 0) {
            if (bbCounter == 0) {
                String attack = b.playerInput(player);
                switch (attack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, e);
                        break;
                    case "Butter Boomerang":
                        bbCounter = 1;
                        break;
                    case "Parry":
                        b.setUsedParry(true);
                        break;
                    case "Potion":
                        b.usePotion(player);
                        break;
                }
            } else if (bbCounter == 2) {
                damage = 40;
                b.damageCalc(damage, e);
                bbCounter = 0;
            }
            if (b.getEnemyUsedParry()) {
                b.setEnemyUsedParry(false);
            }
            if (b.checkWinState(e) == true) {
                b.drawState(player, e);
                System.out.println("You Win!");
                break;
            }
            if (mmCounter == 1) {
                mmCounter = 2;
//                if (b.getUsedParry()) {
//                    b.setUsedParry(false);
//                }
            }
            //  b.drawState(player, e);
            if (mmCounter == 0) {
                String eAttack = e.attackLogic(player);
                switch (eAttack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, player);
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Margarine Missile":
                        mmCounter = 1;
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Parry":
                        b.setEnemyUsedParry(true);
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Potion":
                        b.usePotion(e);
                        System.out.println("Enemy used " + eAttack);
                        break;
                }
            } else if (mmCounter == 2) {
                damage = 40;
                b.damageCalc(damage, player);
                mmCounter = 0;
            }
            if (b.getUsedParry()) {
                b.setUsedParry(false);
            }
            if (b.checkLoseState(player) == true) {
                b.drawState(player, e);
                System.out.println("You lose");
                break;
            }
            if (bbCounter == 1) {
                bbCounter = 2;
//                if (b.getEnemyUsedParry()) {
//                    b.setEnemyUsedParry(false);
//                }
            }
            b.drawState(player, e);

        }
    }
}
