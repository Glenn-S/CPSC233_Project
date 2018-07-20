package legitgame;

import java.awt.Image;

/**
 * moves[0] = weak attack = 15HP moves [1] = Strong attack = 40HP but takes 2
 * turns to work moves[2] = Parry has a 50% chance of not working otherwise
 * reduces damage to 0 moves[3] = Potion recovers 25HP engageBattle should have
 * an enemy as a parameter to check specifically which enemy is being fought.
 */
public class Enemy extends Avatar {

    private boolean key; // if true, enemy has a key. false if they do not have a key 
    private boolean hasPotion; // shows if enemy has any potions left 
    private Potion[] potions; // list of potions the enemy has 
/**
 * Default Constructor
 */
    public Enemy() {
        super();
        this.key = false;
        this.hasPotion = false;
        this.potions = null;

    }

    /**
     * Constructor for the class, likely to be used at game loop initialization
     * sets the initial health, defense, attack, and allowed moves for the enemy
     * also determines whether or not the enemy will have a key on them
     *
     * @param name
     * @param coord
     * @param spriteImage
     * @param spriteChar
     * @param dialogue
     * @param exists
     * @param overlapsWith
     * @param health - enemy health as an integer
     * @param defence - enemy defense value as an integer
     * @param attack - enemy attack value as an integer
     * @param moves - list of all possible enemy attacks
     * @param key - true if enemy has a key, false otherwise
     * @param hasPotion - true if enemy has at least one potion, false otherwise
     * @param potions
     */

    public Enemy(String name, Location coord, Image spriteImage, char spriteChar, String[] dialogue, boolean exists, boolean overlapsWith, int health, int defence, int attack, String[] moves, boolean key, boolean hasPotion, Potion[] potions) {
        super(name,
                coord,
                spriteImage,
                spriteChar, // will become the sprite image class later
                dialogue,
                exists,
                overlapsWith,
                health,
                defence,
                attack,
                moves); // invokes Avatar constructor
        this.key = key;
        this.hasPotion = hasPotion;
        this.potions = potions;
    }

    /**
     * Determines if the enemy has a key or not
     *
     * @return key - true if enemy has a key, false otherwise
     */
    public boolean getKey() {
        return this.key;
    }

    /**
     * Changes if the enemy has a key or not
     *
     * @param key - new state of the enemy's key
     */
    public void setKey(boolean key) {
        this.key = key;
    }

    /**
     * Decides what attack the enemy will use. This is accomplished by deciding
     * the most efficient way to reduce player health to 0 while keeping the
     * enemy's health as high as possible.
     *
     * @param player - Player playing the game
     * @return moves[] - the attack the enemy decides to use
     */
    public String attackLogic(Player player) {
        if (player.getHealth() <= 15) {
            return this.moves[0];
        } else if (player.getHealth() <= 40 && this.getHealth() > 30) {
            return this.moves[1];
        } else if (this.getHealth() <= 25 && this.hasPotion == true) {
            return this.moves[3];
        } else if (this.getHealth() <= 40 && this.hasPotion == false) {
            return this.moves[2];
        } else {
            return this.moves[0];
        }
    }

}
