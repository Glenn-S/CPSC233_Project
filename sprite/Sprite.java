package sprite;

import javafx.scene.image.Image;
/**
 * Purpose: It's the parent class of  Avator , Potion ,Weapon and Defence
 *
 * @version 		20.39   19  July 2018
 * instance variable
 * spriteImage image that represent an object on map as a type Image
 * name the name of the player/avatar/iteams  as a type String
 * exist it's true if the objecet is exit on the map  as a type boolean
 * dialogue	the dialogue between avatars    as a type of string array
 * overlapsWith it's true if the player is overlaps with an enemy,a iteam , edge or terrains as a type boolean
 * coord the location includes xCoordinate and yCoordinate  as a type of Location
 * s it's an object of Sprite      as a type of Sprite
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Sprite {
	protected String name;
    protected Location coord;
    protected Image spriteImage;
    protected char spriteChar; // will become the sprite image class later
    protected String[] dialogue;
    protected boolean exists;
    protected boolean overlapsWith;
	/*-------------------------Constructors---------------------------------------*/
	/**
	* Purpose: This is constructor initializes all the diferent instance Variables
	*
	* @param  name  This is a string, of the sprites name
	* @param  coord  This is a location object
	* @param  spriteImage  This will be used in version two. It is the image of a Sprite
	* @param  spriteChar  This is the char variable used to identify the sprite when
	* printed to the Terminal
	* @param  dialogue  This is a string array, filled with all the dialogue of the
	* Sprite
	* @param  exists  This is the boolean value, indicating whether or not the sprite
	* Exists
	* @param  overlapsWith  This is a boolean value, that indicates whther or not the
	* sprite is overlapping with another object
	*/
	public Sprite(String name,
                  Location coord,
                  Image spriteImage,
                  char spriteChar, // will become the sprite image class later
                  String[] dialogue,
                  boolean exists,
                  boolean overlapsWith) {
		this.name = name;
		this.coord= coord;
		this.spriteImage = spriteImage;
		this.spriteChar = spriteChar;
		this.exists = exists;
		this.dialogue = dialogue;
		this.overlapsWith = overlapsWith;
	}
	/**
	* Purpose: This is the default constructor for the sprite class. If a
	* sprite object is instantiated, without being passed any variables.
	* Then this is the method that is to be caled.
	*/
	public Sprite() {
		this.name = "";
	    this.coord = new Location();
	    this.spriteImage = null;
	    this.spriteChar = ' '; // will become the sprite image class later
	    this.dialogue = null;
	    this.exists = true;
	    this.overlapsWith = false;
	}

	/**
	 * Purpose: To create a copy of the item
	 */
	public Sprite(Sprite copySprite) {
		this.name = new String(copySprite.getName());
		this.coord = new Location(copySprite.getCoord());
	    this.spriteImage = copySprite.getSpriteImage(); // figure out how to protect image
	    this.spriteChar = copySprite.getSpriteChar(); // will become the sprite image class later
	    this.dialogue = copySprite.getDialogue();
	    this.exists = copySprite.getExists();
	    this.overlapsWith = copySprite.getOverlapsWith();
	}

	/*------------------------SETTERS/GETTER----------------------------------*/
	/**
	 * Purpose: To set the sprites location
	 * @param xCoord the xCoordinate of the sprite as a type of integer
	 * @param yCoord the yCoordinate of the Sprite as a type of integer
	 */
	public void setCoord(Location location) {
		if (location != null) {
			this.coord = location;
		}
	}

	/**
	 * Purpose: This is the getter for the sprites location variable
	 *
	 * @return coord 	it's the Location of the sprite as a type of integer
	 */
	public Location getCoord() {
		return this.coord;
	}

	/**
	 * Purpose: This is the setter for the sprites name variable
	 *
	 * @param setname   the name of the sprite  as a type of String
	 */
	public void setName(String setName) {
		this.name = setName;
	}

	/**
	 * Purpose: This is the getter for the sprites name
	 *
	 * @return name   the name of the sprite  as a type of String
	 */
	public String getName() {
		return new String(this.name);
	}

	/**
 	 * Purpose: This is the setter for the sprites Image
 	 *
 	 * @param  newSpriteImage  This is the new sprite Image
 	 */
	public void setSpriteImage(Image newSpriteImage) {
		this.spriteImage = newSpriteImage;
	}

	/**
	 * Purpose: This is the getter for the sprites image
	 *
	 * @return spriteImage - renew the spriteImage as a type of Image
	 */
	public Image getSpriteImage() {
		return this.spriteImage;
	}

	/**
	 * Purpose: This is the setter for the sprites exist variable
	 *
	 * @param exist the sate of iteams and enemis if they are exist
	 * as a type of boolean
	 */
	public void setExists(boolean exist) {
		this.exists  = exist;
	}

	/**
	 * Purpose: This is the getter for the sprites exists variable
	 *
	 * @return exists - renew the exist state of iteams and enemies
	 * as a type of boolean
	 */
	public boolean getExists() {
		return this.exists;
	}
	/**
	 * Purpose: This is the setter for the sprites dialogue array
	 *
	 * @param dialog set dialogues as a type of String array
	 */
	public void setDialogue(String[] dialogue) {
		this.dialogue = dialogue;
	}
	/**
	 * Purpose: This is the getter for the sprites dialogue array
	 *
	 * @return dialogue	- renew the dialogue we need as a String array
	 */
	public String[] getDialogue(){
		return this.dialogue;
	}

	/**
	 * @param overlapsWith true if the player is overlaps with an enemy, an
	 * item, an edge, or terrain as a type of boolean.
	 */
/*	public void setOverlapsWith(Sprite sprite){//set if player is overlapswith enemy , terrain ,potions or edges
		if (sprite.xCoord <= Enemy.xCoord + Enemy.xSize && sprite.xCoord >= Enemy.xCoord - Enemy.xSize && sprite.yCoord <= Enemy.yCoord + Enemy.ySize && sprtie.yCoord >= Enemy.yCoord - Enemy.ySize){
			overlapsWith = true;//it returns true if the player is in an area of rectangle with x range [xcood - xsize, xccord + xsize] and y range [ycoord - ysize , ycoord + ysize]
		}
		else if(sprite.xCoord == Terrain.xCoord && sprite.yCoord == Terrain.yCoord ) {
			overlapsWith = true;//it returns true if the player is ate the same position of a terrain
		}
		else if(sprite.xCoord == Edges.xCoord && sprite.yCoord == Edges.yCoord) {
			overlapsWith = true;//it returns true if the player is ate the same position of the edge
		}
		else if (sprite.Location == Iteam.Location && sprite.yCoord == Item.yCoord ) {
			overlapsWith = true;//it returns true if the player is ate the same position of an iteam
		}
		overlapsWith = false;
		}//it returns false if none of above is true
*/
	/**
	 * Purpose: This is the getter for the sprites overlap varibale
	 *
	 * @return overlapsWith - tell if the player is overlap with something or
	 * not , as a type of boolean
	 */
	public boolean getOverlapsWith() {	//get the overlapsWith
		return this.overlapsWith;
	} //(remove overlapswith for now.)

	/**
	 * Purpose: This is the getter for the sprites character varibale
	 *
	 * @return the spriteChar
	 */
	public char getSpriteChar() {
		return this.spriteChar;
	}
	/**
	 * Purpose: This is the setter for the sprites character variable
	 *
	 * @param spriteChar the spriteChar to set
	 */
	public void setSpriteChar(char spriteChar) {
		this.spriteChar = spriteChar;
	}

	/**
	 * Purpose: To print out a string representation of the class attributes
	 *
	 * @return a string with all the attributes
	 */
	public String toString() {
		String strRep = "Name: " + this.getName() + ", Coord: " +
			this.getCoord() + ", Image: " + this.getSpriteImage() + ", Char: " +
			this.getSpriteChar() + ", Text: " + this.getDialogue() + ", Exists: " +
			this.getExists() ;
		return strRep;
	}
}
