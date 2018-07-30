
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: Handles all actions regarding the battle system in the game. This
 * includes choosing the user's move, keeping track of attack characteristics
 * calculating damage from battling and updating the health of the player and
 * enemies involved.
 *
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class BattleLoop extends GameLoop {

    private int bbCounter; // counter for Butter Boomerang
    private int mmCounter; // counter for Margarine Missile
    private char turn = 'P';
    private boolean usedParry = false; // keeps track if Parry was the attack
    private boolean enemyUsedParry = false; // keeps track if Parry was the attack

    String turnAttack; // attack used during the current turn

    /*-------------------------- GETTERS/SETTERS -----------------------------*/
    /**
     * Purpose: Change state of the usedParry variable for the enemy
     *
     * @param eUP - the desired state for the usedParry variable
     */
    public void setEnemyUsedParry(boolean eUP) {
        this.enemyUsedParry = eUP;
    }

    /**
     * Purpose: Change state of the usedParry variable for the player
     *
     * @param uP - the desired state for the usedParry variable
     */
    public void setUsedParry(boolean uP) {
        this.usedParry = uP;
    }

    /**
     * Purpose: Checks to see if the last move a player used was the Parry
     * attack
     *
     * @return - true if last attack used was Parry, false otherwise
     */
    public boolean getUsedParry() {
        return this.usedParry;
    }

    /**
     * Purpose: Checks to see if the last move an enemy used was the Parry
     * attack
     *
     * @return - true if last attack used was Parry, false otherwise
     */
    public boolean getEnemyUsedParry() {
        return this.enemyUsedParry;
    }
    /**
     * Purpose: Returns the number of turns that have passed since a use of the
     * Butter Boomerang attack.
     * @return - turn count between 0 and 2 (inclusive) after Butter Boomerang
     * has been selected as an attack
     */
    public int getBBCounter() {
        return this.bbCounter;
    }
    /**
     * Purpose: Updates the number of turns that have passed since a use of the
     * Butter Boomerang attack.
     * @param newCount - turns passed since last use of Butter Boomerang
     */
    public void setBBCounter(int newCount) {
        this.bbCounter = newCount;

    }
    /**
     * Purpose: Returns the number of turns that have passed since a use of the
     * Margarine Missile attack.
     * @return - turn count between 0 and 2 (inclusive) after Margarine Missile
     * has been selected as an attack
     */
    public int getMMCounter() {
        return this.mmCounter;
    }
    /**
     * Purpose: Updates the number of turns that have passed since a use of the
     * Margarine Missile attack.
     * @param newCount - turns passed since last use of Margarine Missile
     */
    public void setMMCounter(int newCount) {
        this.mmCounter = newCount;

    }
    /**
     * Purpose: Returns the selected attack of the player for the current turn
     * @return - attack the player wants to use as a String
     */
    public String getTurnAttack() {
        return this.turnAttack;
    }
    /**
     * Purpose: Sets the desired attack of the player for the current turn
     * @param newATK - attack to be used by the player this turn
     */
    public void setTurnAttack(String newATK) {
        this.turnAttack = newATK;

    }

    /*------------------------------- METHODS --------------------------------*/
    /**
     * Purpose:If a player has won a battle, the defeated enemy is removed from
     * the game and replaced with a tombstone at the coordinates of the enemy.
     *
     * @param enemy - enemy in battle
     * @param enemyList - list of all enemies in game, defeated enemy removed
     * from here
     * @param terrainList - list of all terrain objects in game, tombstone added
     * here
     */
    public void removeEnemy(Enemy enemy, ArrayList<Enemy> enemyList, ArrayList<Sprite> terrainList) {
        enemy.setExists(false);
        terrainList.add(new Sprite("tombstone", enemy.getCoord(), null, 't', null, true, false));
        enemyList.remove(enemy);
    }

    /**
     * Purpose: To check if the enemy has lost the game(their health has reached
     * 0).
     *
     * @param e - enemy whose health is checked
     * @return the win state condition
     */
    public boolean checkWinState(Enemy e) {
        return e.getHealth() <= 0; // returns true if true else false
    }

    /**
     * Purpose: To check if the player has lost the game(their health has
     * reached 0).
     *
     * @param player - player whose lose state is checked
     * @return the lose state condition
     */
    public boolean checkLoseState(Player player) {
        return player.getHealth() <= 0; // returns true if true else false
    }

    /**
     * Purpose: Interprets user inputs and returns the corresponding attack name
     * and legality of the attack. Text version only.
     *
     * @param player - player whose input is taken
     * @return attack name
     * @override
     */
    public String playerInput(Player player) {
        System.out.println("Please select an attack from the following options by entering the number beside the attack.");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + ". " + player.moves[i]);
        }

        Scanner sc = new Scanner(System.in);
        int attack = -1;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next(); // this is important!
            }
            attack = sc.nextInt();
        } while (attack < 0);

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
        sc.close();
        return player.moves[attack];

    }

    /**
     * Purpose: Calculates the damage done to the enemy by the user's most
     * recent attack.
     *
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
     *
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
     * For text version only.
     * @param player - player involved in battle
     * @param e - enemy involved in battle
     */
    public void drawState(Player player, Enemy e) {
        System.out.println("Player Health: " + player.getHealth());
        System.out.println("Enemy Health: " + e.getHealth() + "\n");
    }

    /**
     * Purpose: Output of enemy's selected attack. For GUI version of the game.
     *
     * @param eAttack - attack of enemy
     * @param player - player being attacked
     * @param e - enemy who is attacking
     */
    public void eAttackExecute(String eAttack, Player player, Enemy e) {
        switch (eAttack) {
            case "Slash":
                int damage = 15;
                this.damageCalc(damage, player);
                System.out.println("Enemy used " + eAttack);
                break;
            case "Margarine Missile":
                this.mmCounter = 1;
                System.out.println("Enemy used " + eAttack);
                break;
            case "Parry":
                this.setEnemyUsedParry(true);
                System.out.println("Enemy used " + eAttack);
                break;
            case "Potion":
                this.usePotion(e);
                System.out.println("Enemy used " + eAttack);
                break;
        }

    }

    /**
     * Purpose: Output of player's selected attack. For GUI version only.
     *
     * @param attack - desired attack of player
     * @param player - player who is attacking
     * @param e - enemy who is being attacked.
     */
    public void attackExecute(String attack, Player player, Enemy e) {
        switch (attack) {
            case "Slash":
                int damage = 15;
                this.damageCalc(damage, e);
                System.out.println("You used " + attack);
                break;
            case "Butter Boomerang":
                this.bbCounter = 1;
                System.out.println("You used " + attack);
                break;
            case "Parry":
                this.setUsedParry(true);
                System.out.println("You used " + attack);
                break;
            case "Potion":
                this.usePotion(player);
                System.out.println("You used " + attack);
                break;
        }

    }

    /**
     * Purpose: Checks to see if a player has a potion to use in battle
     *
     * @param player - player who is being checked for potion
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
     * Purpose:Use potion method that allows the player to use a potion during
     * battle
     *
     * @param player - the player who is to use the potion
     */
    public void usePotion(Player player) {
        ArrayList<Sprite> temp = player.getItems();
        for (int i = 0; i < player.getItems().size(); i++) {
            if (temp.get(i) instanceof Potion) {
                player.updateHealth((Potion) temp.get(i));
                System.out.println("Health has been boosted by " + ((Potion) temp.get(i)).getHealthBoost() + "HP");
                player.removeItem(temp.get(i));
                System.out.println("Removed");
            }
        }
    }

    public Potion validPotion(Player player) {
        Potion validP = null;
        ArrayList<Sprite> temp = player.getItems();
        for (int i = 0; i < player.getItems().size(); i++) {
            if (temp.get(i) instanceof Potion) {
                if (player.getHealth() < 100 - ((Potion) temp.get(i)).getHealthBoost()) {
                    validP = new Potion((Potion) temp.get(i));

                }
            }
        }
        return validP;
    }

    /**
     * Purpose: Allows enemy to use potion during battle
     *
     * @param e - enemy to use potion
     */
    public void usePotion(Enemy e) {
        e.setHealth(e.getHealth() + e.getPotions().get(0).getHealthBoost());
        e.getPotions().remove(0);

    }

    /**
     * Purpose: To test engage Battle and this class for text version only
     *
     * @param args
     */
    public static void main(String[] args) {
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
