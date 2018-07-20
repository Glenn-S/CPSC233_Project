import java.util.*;
public class Player extends Avatar {
	private int keyCount; //Initialized to zero in the constructor, player is supposed to start with no keys
	private ArrayList <Sprite> items = new ArrayList <Sprite>(); //arraylist of items playe is holding currently
	//private int currency = 0; //Currency is currrently commented out for version one. Initialized to zero as player doesn't start with any money

	/*---------------------------- CONSTRUCTORS ------------------------------*/

	/**
	 *Purpose: This is the default constructor, only called if no variables are passed as parameters
	 */
	public Player()
	{
		super();
 		this.keyCount = 0;
		this.items[] = null;
		//this.currency = 0;
	}


	/**
	 * Purpose: This is the constructor that is called, when this exact set of values is passed
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
	public Player(int health, int defence, int attack, String[] moves, Location coordinates, String name, Image spriteImages, boolean exists, String[] dialogue)
	{
		this.health = health;
		this.defence = defence;
		this.attack = attack;
		this.moves = moves;
		this.coordinates = coordinates;
		this.name = name;
		this.spriteImage = spriteImage;
		this.exists = exists;
		this.dialogue = dialogue;
		this.keyCount = 0;
		this.items[] = null;
		//this.currency = 0;
	}


	/**
	 * Purpose: This is the copy constructor, it sets the values of the calling object to the same as the object being passed in the parameter
	 *
	 * @param  p  This is a player object, its values are then copied to the calling object
	 */
	Public Player(Player p)
	{
		this.health = p.health;
		this.defence = p.defence;
		this.attack = p.attack;
		this.moves = p.moves;
		this.coordinates = p.coordinates;
		this.name = p.name;
		this.spriteImage = p.spriteImage;
		this.exists = p.exists;
		this.dialogue = p.dialogue;
		this.keyCount = 0;
		this.items[] = null;
	}	//this.currency = 0;


	/*------------------------------- METHODS --------------------------------*/

	/**
	 * Purpose: This function is used to edit update the players position, on the map. This function calls the set x coordinate, and
	 * set y coordinate functions from the location class. It calls these functions through the calling players coordinate variable,
	 * which is of type Location
	 *
	 * @param  x  This variable is the new x coordinate that the calling player will be moved to.
	 * @param  y  This variable is the new y coordinate that the calling player will be moved to.
	 */
	public void updatePosition(int x, int y)
	{
		this.coordinates.setxCoord(x);
		this.coordinates.setyCoord(y);
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
	public void updateCurrency(int loseOrGainOfCurrency)
	{
		this.currency =  this.currency	+ loseOrGainOfCurrency;
	}
	*/

	/**
	 * Purpose: This method adds a new item to the calling players item array
	 *
	 * @param  newItem  This is a new item that is going to be added to the players item array
	 */
	public void addItem(Sprite newItem)
	{
		this.items.add(newItem);
	}

	/**
	 * Purpose: This method removes an item in the calling players item array
	 *
	 * @param  itemToRemove  This parameter is of the item type, it is the item that is to be
	 *removed from the players item array
	 */
	public void removeItem(Sprite itemToRemove)
	{
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
	public void editItem(Sprite itemToEdit)
	{




	}
	*/
	/*--------------------------- GETTERS/SETTERS -----------------------------*/

	/**
	 * Purpose: This method is used to get the calling players health, if needed
	 *
	 * @return  this.health  This is a integer value, representing the amount of health the calling player
	 * has left
	 */
	public int getHealth()
	{
		return this.health;
	}


	/**
	 * Purpose: This method sets the calling players health. If the calling players health is to decrease, then a negative
	 * amount of healthChange must be passed in the parameter
	 *
	 * @param  healthChange  This is the amount that the calling players health will be changed by. If the calling player
	 * is to lose health, then a negative amount of healthChange must be passed in the parameter
	 */
	public void setHealth(int healthChange)
	{
		this.health = this.health + healthChange;
	}



	/**
	 * Purpose: This method is used to get the calling players Defence stat, if needed
	 *
	 * @return  this.defence  This is a integer value, representing the Defense stat of the calling player
	 */
	public int getDefence()
	{
		return this.defence;
	}

	/**
	 * Purpose: This method sets the calling players Defence stat. If the calling players Defense stat is to decrease, then a negative
	 * amount of defenceChange must be passed in the parameter
	 *
	 * @param  defenceChange  This is the amount that the calling players defense stat will be changed by. If the calling player
	 * is to lose defence, then a negative amount of defenceChange must be passed in the parameter
	 */
	public void setDefence(int defenceChange)
	{
		this.defence = this.defence + defenceChange;
	}

	/**
	 * Purpose: This method is used to get the calling players attack stat, if needed
	 *
	 * @return  this.attack  This is a integer value, representing the attack stat of the calling player
	 */
	public int getAttack()
	{
		return this.attack;
	}

	/**
	 * Purpose: This method sets the calling players attack stat. If the calling players attack stat is to decrease, then a negative
	 * amount of attackChange must be passed in the parameter
	 *
	 * @param  attackChange  This is the amount that the calling players attack stat will be changed by. If the calling player
	 * is to lose attack, then a negative amount of attackChange must be passed in the parameter
	 */
	public void setattack(int attackChange)
	{
		this.attack = this.attack + attackChange;
	}

	/**
	 * Purpose: This method is used to get the string array of theh players moves
	 *
	 * @return  this.moves[]  This is the string array of the players moves
	 */
	public string[] getMoves()
	{
		return this.moves;
	}

	/**
	 * Purpose: This method sets a players moves, if they were to change, it does this by setting the calling players moves array to be the
	 * the same as the moves array passed in the parameter
	 *
	 * @param  newMoves  This parameter is a string array, with the players new moves
	 */
	public void setMoves(String[] newMoves)
	{
		this.moves = newMoves;
	}

	/**
	 * Purpose: This method return the calling players coordinates
	 *
	 * @return  this.coordinates  This is the calling players coordinates, it is of the Location type
	 */
	public Location getCoordinates()
	{
		return this.coordinates;
	}

	/**
	 * Purpose: This method is used to set the coordinates of the calling player
	 *
	 * @param  newCoordinates  This paramter is the new set of coordinats that will change the calling players position
	 */
	public void setCoordinates(Location newCoordinates)
	{
		this.coordinates = newCoordinates;
	}

	/**
	 * Purpose: This method returns the calling players name
	 *
	 * @return  this.name  This is the calling players name, it is a string value
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Purpose: This method is used to set the name of the calling player
	 *
	 * @param  newName  This paramter is the new name that will change the calling players name variable
	 */
	public void setName(String newName)
	{
		this.name = newName;
	}

	/**
	 * Purpose: This method returns the calling players sprite image
	 *
	 * @return  this.spriteImage  This is the calling players sprite image, it is of the Image class
	 */
	public Image getSpriteImage()
	{
		return this.spriteImage;
	}

	/**
	 * Purpose: This method is used to set the sprite image of the calling player
	 *
	 * @param  newSpriteImage  This paramter is the new sprite image that will replace the calling players sprite image variable
	 */
	public void setSpriteImage(Image newSpriteImage)
	{
		this.spriteImage = newSpriteImage;
	}

	/**
	 * Purpose: This method returns the calling players exist variable
	 *
	 * @return  this.exists  This is the calling players new exist variable, it is a boolean value
	 */
	public boolean getExists()
	{
		return this.exists;
	}

	/**
	 * Purpose: This method is used to set the exists variable of the calling player
	 *
	 * @param  newExists  This paramter is the new exists value that will replace the calling players exists variable
	 */
	public void setExists(boolean newExists)
	{
		this.exists = newExists;
	}

	/**
	 * Purpose: This method returns the calling players dialogue array
	 *
	 * @return  this.dialogue  This is the calling players dialogue array, it is a string array
	 */
	public String[] getDialogue()
	{
		return this.dialogue;
	}

	/**
	 * Purpose: This method is used to set the dialogue array of the calling player
	 *
	 * @param  newDialogue  This paramter is the new dialogue array that will replace the calling players dialogue array
	 */
	public void setDialogue(String[] newDialogue)
	{
		this.dialogue = newDialogue;
	}

	/**
	 * Purpose: This method returns the calling players key count
	 *
	 * @return  this.keyCount  This is the calling players key count, it is a integer variable
	 */
	public int getKeyCount()
	{
		return this.keyCount;
	}

	/**
	 * Purpose: This method is used to set the key count of the calling player
	 *
	 * @param  newKeyCount  This paramter is the new key count that will replace the calling players key count
	 */
	public void setKeyCount(int newKeyCount)
	{
		this.keyCount = newKeyCount;
	}

	/**
	 * Purpose: This method returns the calling players item array
	 *
	 * @return  this.items[]  This is the calling players item array, it is an array of collectibles
	 */
	public Sprite[] getItems()
	{
		return this.items;
	}

	/**
	 * Purpose: This method is used to set the item array of the calling player
	 *
	 * @param  newItems  This paramter is the new items array that will replace the calling players current item array
	 */
	public void setItems(Sprite newItems)
	{
		this.items = newItems;
	}

	/**
	 * Purpose: This method returns the calling players currency value
	 *
	 * @return  this.currency  This is the calling players currency value, it is of the intger type
	 */
	/*
	public int getCurrency()
	{
		return this.currency;
	}

	/**
	 * Purpose: This method is used to set the currency value of the calling player
	 *
	 * @param  newCurrency  This paramter is the new currency amount that will replace the calling players current currency variable
	 */
	/*
	public void setCurrency(int newCurrency)
	{
		this.currency = newCurrency;
	}
	*/


}
