package sprite;

import java.util.*;
import javafx.scene.image.Image;

/**
 * Purpose: To represent a player and their attributes and moves in the game.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Player extends Avatar {
	private int keyCount; //Initialized to zero in the constructor, player is supposed to start with no keys
	private ArrayList<Sprite> items; //arraylist of items player is holding currently
	private final int velocity = 5; // move at five pixels a time
	//private int currency = 0; //Currency is currrently commented out for version one. Initialized to zero as player doesn't start with any money

	/*---------------------------- CONSTRUCTORS ------------------------------*/

	/**
	 * Purpose: This is the default constructor, only called if no variables are passed as parameters
	 */
	public Player() {
		super();
 		this.keyCount = 0;
		this.items = new ArrayList<Sprite>();
		//this.currency = 0;
	}

	/**
	 * Purpose: This is the constructor that is called, when this exact set of
	 * values is passed
	 *
	 * @param  health  This variable is an integer amount, and represents how much health the player has left
	 * @param  defence This variable is an integer amount, and represents the players defence stat
	 * @param  attack  This variable is an integer amount, and represents the players attack stat
	 * @param  moves  This is a string array, it holds the names of the moves that the player is able to use
	 * @param  coordinates  This variable is of the location type, it holds the players X and Y coordinates
	 * @param  name  This is a String variable that holds the name of the player
	 * @param  spriteImages  This is a Image, in the console version it will just be a character, in the terminal version it will be a sprite image
	 * @param  exists  This is a boolean value, stating whether or not the player exists
	 * @param  dialogue  This is a string array holding the different dialogue options for the player
	 */
	public Player(String name,
	 							Location coordinates,
								Image spriteImage,
							 	char spriteChar,
								String[] dialogue,
							 	boolean exists,
							 	boolean overlapsWith,
							 	int health,
								int defence,
							 	int attack,
							 	String[] moves) {
		super(name,
		 			coordinates,
					spriteImage,
					spriteChar,
				 	dialogue,
				 	exists,
					overlapsWith,
				 	health,
				 	defence,
					attack,
					moves);
		this.keyCount = 0;
		this.items = new ArrayList<Sprite>();
		//this.currency = 0; // for later expansion
	}

	/**
	 * Purpose: This is the copy constructor, it sets the values of the calling
	 * object to the same as the object being passed in the parameter
	 *
	 * @param  p  This is a player object, its values are then copied to the calling object
	 */
	public Player(Player p) {
		super(p.getName(),
		 			p.getCoord(),
				 	p.getSpriteImage(),
					p.getSpriteChar(),
					p.getDialogue(),
					p.getExists(),
					p.getOverlapsWith(),
					p.getHealth(),
					p.getDefence(),
					p.getAttack(),
					p.getMoves()); // I believe this works for copying an class
		this.keyCount = p.getKeyCount();
		this.items = p.getItems();
		//this.currency = 0;
	}


	/*------------------------------- METHODS --------------------------------*/

	/**
	 * Purpose: This function is used to edit update the players position, on the map. This function calls the set x coordinate, and
	 * set y coordinate functions from the location class. It calls these functions through the calling players coordinate variable,
	 * which is of type Location
	 *
	 * @param  x  This variable is the new x coordinate that the calling player will be moved to.
	 * @param  y  This variable is the new y coordinate that the calling player will be moved to.
	 */

	// *** perhaps this should move into Sprite since it could be used for all ***
	public void updatePosition(int x, int y) {
		this.coord.setxCoord(x);
		this.coord.setyCoord(y);

		// *** in order for this to work, the coordinates need to be in pixel values now ***
	}

	/*
	/**
	 * Purpose: This function sets the new value of currency, if the player were to lose or gain some currency.
	 * If the player loses currency then a negative amount of loseOrGainOfCurrency must be passed in the parameter
	 *
	 * @param  loseOrGainOfCurrency  This is the amount of currency that the calling player, ether loses or gains.
	 * If the calling player loses currency, then this variable must be a negative integer.
	 */
	 /*
	public void updateCurrency(int loseOrGainOfCurrency) {
		this.currency =  this.currency	+ loseOrGainOfCurrency;
	}
	*/

	/**
	 * Purpose: This method adds a new item to the calling players item array
	 *
	 * @param  newItem  This is a new item that is going to be added to the players item array
	 */
	public void addItem(Sprite newItem) {
		this.items.add(newItem); // can add any thing of parent class type Sprite
	}

	/**
	 * Purpose: This method removes an item in the calling players item array
	 *
	 * @param  itemToRemove  This parameter is of the item type, it is the item that is to be
	 *removed from the players item array
	 */
	public void removeItem(Sprite itemToRemove) {
		int index = 0;

		while(index < this.items.size())
		{
			if(this.items.get(index) == itemToRemove)
				this.items.remove(index);

			index++;
		}
	}

	/**
	 * Purpose: This method is to be called when wanting to edit, or change an item in the calling
	 * players item array
	 *
	 * @param  itemToEdit  This parameter is used to distinguish which item in the calling players item array
	 *is needing to be edited
	 */
	/*
	public void editItem(Sprite itemToEdit) {

	}
	*/

	/*-------------------------- GETTERS/SETTERS -----------------------------*/

	/**
	 * Purpose: This method returns the calling players key count
	 *
	 * @return  this.keyCount  This is the calling players key count, it is a integer variable
	 */
	public int getKeyCount() {
		return this.keyCount;
	}

	/**
	 * Purpose: This method is used to set the key count of the calling player
	 *
	 * @param  newKeyCount  This paramter is the new key count that will replace the calling players key count
	 */
	public void setKeyCount(int newKeyCount) {
		this.keyCount = newKeyCount;
	}

	/**
	 * Purpose: This method returns the calling players item array
	 * commented out the copy of the arraylist, exception is thrown
	 * in main if a copy of the arraylist is returned
	 *
	 * @return  this.items[]  This is the calling players item array, it is an array of collectibles
	 */
	public ArrayList<Sprite> getItems() {
	/*	ArrayList<Sprite> copyList = new ArrayList<Sprite>();
		for (int i = 0; i < this.items.size(); i++) {
			copyList.set(i, new Sprite(this.items.get(i)));
		}*/
		return this.items;
	}

	/**
	 * Purpose: This method is used to set the item array of the calling player
	 *
	 * @param  newItems  This paramter is the new items array that will replace the calling players current item array
	 */
	public void setItems(ArrayList<Sprite> newItems) {
		this.items = newItems;
	}

	/**
	 * Purpose: This method is used to get the images of the items in the players Inventory
	 *
	 * @return  itemInventoryImage  This is an array list of images, the images represent the
	 * items which are in the calling players items array
	 */
	public ArrayList<Image> getInventory() {
		ArrayList<Image> itemInventoryImage = new ArrayList<Image>();

		for(int index = 0; index < this.items.size(); index++) {
			itemInventoryImage.add(this.items.get(index).getSpriteImage());
		}
		return itemInventoryImage;
	}

	/**
	 * Purpose: To crete a string representation of the players items.
	 *
	 * @param terminal a boolean value to determine if the gui version is in use
	 */
	public String getInventory(boolean terminal) {
		int potionCnt = 0;

		if (terminal == true) {
			String sword = "";
			String shield = "";
			String smallPotion = "Small Potion";
			int smallPotionCnt = 0;
			String mediumPotion = "Medium Potion";
			int mediumPotionCnt = 0;
			String largePotion = "Large Potion";
			int largePotionCnt = 0;
			String inventory;

			for (int i = 0; i < this.items.size(); i++) {
				if (this.items.get(i) instanceof Weapon) {
					sword = this.items.get(i).getName();
				}
				if (this.items.get(i) instanceof Defence) {
					shield = this.items.get(i).getName();
				}
				if (this.items.get(i) instanceof Potion) {
					if (this.items.get(i).getName().equals("Small Potion")) {
						smallPotionCnt++;
					}
					else if (this.items.get(i).getName().equals("Medium Potion")) {
						mediumPotionCnt++;
					}
					else if (this.items.get(i).getName().equals("Large Potion")) {
						largePotionCnt++;
					}
				}
			}
			inventory = sword + ", " + shield;
			if (smallPotionCnt > 0) {
				inventory = inventory + ", " + smallPotion + " x" + smallPotionCnt;
			}
			if (mediumPotionCnt > 0) {
				inventory = inventory + ", " + mediumPotion + " x" + mediumPotionCnt;
			}
			if (largePotionCnt > 0) {
				inventory = inventory + ", " + largePotion + " x" + largePotionCnt;
			}
			inventory = inventory + "\n" + "Number of keys: " + this.keyCount;

			return inventory;
		}
		else return "";
	}

	/**
	 * Purpose: This method returns the calling players currency value
	 *
	 * @return  this.currency  This is the calling players currency value, it is of the intger type
	 */
	/*
	public int getCurrency() {
		return this.currency;
	}

	/**
	 * Purpose: This method is used to set the currency value of the calling player
	 *
	 * @param  newCurrency  This paramter is the new currency amount that will replace the calling players current currency variable
	 */
	/*
	public void setCurrency(int newCurrency) {
		this.currency = newCurrency;
	}
	*/

	/**
	 * Purpose: To print out a string representation of the class attributes
	 * @return a string with all the attributes
	 */
	@Override
	public String toString() {
		return super.toString() + ", Key Count: " + this.getKeyCount() +
			", Items: " + this.getItems(); // for extension
	}

}
