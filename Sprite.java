import java.awt.Image;
/**
 * it's the parent class of  Avator , Potion ,Weapon and Defence
 *
 * @version 		20.39   19  July 2018
 * @author    		Yuhui  Yan
 *
 *
 *instance variable
 * spriteImage   image that represent an object on map as a type Image
 * name  		the name of the player/avatar/iteams  as a type String
 * exist			it's true if the objecet is exit on the map  as a type boolean
 * dialogue		the dialogue between avatars    as a type of string array
 * overlapsWith  it's true if the player is overlaps with an enemy,a iteam , edge or terrains as a type boolean
 * coord			the location includes xCoordinate and yCoordinate  as a type of Location
 * s				it's an object of Sprite      as a type of Sprite
 */
public class Sprite {
	protected String name;
    protected Location coord;
    protected Image spriteImage;
    protected char spriteChar; // will become the sprite image class later
    protected String[] dialogue;
    protected boolean exists;
    protected boolean overlapsWith;

	//constructors
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

	public Sprite() {
		this.name = "";
	    this.coord = null;
	    this.spriteImage = null;
	    this.spriteChar = ' '; // will become the sprite image class later
	    this.dialogue = null;
	    this.exists = true;
	    this.overlapsWith = false;
	}

	/**
	 * @param xcoord the xCoordinate of the sprite as a type of integer
	 * @param ycoord the yCoordinate of the Sprite as a type of integer
	 */
	public void setCoord(int xcoord,int ycoord) { //set xCoord and yCoord
		int xCoord = xcoord;
		int yCoord = ycoord;
	}

	/**
	 * @return coord 	it's the Location of the sprite as a type of integer
	 */
	public Location getCoord() {				//set xCoord and yCoord as a type Location
		return this.coord;
	}

	/**
	 * @param setname   the name of the sprite  as a type of String
	 */
	public void setName(String setname){		//set the name
		this.name = setname;
	}

	/**
	 * @return name   the name of the sprite  as a type of String
	 */
	public String getName(){					//get the name
		return this.name;
	}


	public void setSpriteImage(){				//set the image

	}

	/**
	 * @return spriteImage - renew the spriteImage as a type of Image
	 */
	public Image getSpriteImage(){				//get the image
		return this.spriteImage;
	}

	/**
	 * @param exist the sate of iteams and enemis if they are exist
	 * as a type of boolean
	 */
	public void setExists(boolean exist){		//set the exist state of iteams and enemies.
		this.exists  = exist;
	}

	/**
	 * @return exists - renew the exist state of iteams and enemies
	 * as a type of boolean
	 */
	public boolean getExists(){					//get the exist state
		return this.exists;
	}
	/**
	 * @param dialog set dialogues as a type of String array
	 */
	public void setDialogue(String[] dialogue){	//set the dialogue
		this.dialogue = dialogue;
	}
	/**
	 * @return dialogue	- renew the dialogue we need as a String array
	 */
	public String[] getDialogue(){				//get the dialogue
		return this.dialogue;
	}

	/**
	 * @param overlapsWith true if the player is overlaps with an enemy, an
	 * item, an edge, or terrain as a type of boolean.
	 */
/*	public void setoverlapsWith(Player player){//set if player is overlapswith enemy , terrain ,potions or edges
		if (player.xCoord <= Enemy.xCoor + Enemy.xSize && player.xCoord >= Enemy.xCoor - Enemy.xSize && player.yCoord <= Enemy.yCoord + Enemy.ySize && player.yCoord >= Enemy.yCoord - Enemy.ySize){
			overlapsWith = true;//it returns true if the player is in an area of rectangle with x range [xcood - xsize, xccord + xsize] and y range [ycoord - ysize , ycoord + ysize]
		}
		else if(player.xCoord == Terrain.xCoord && player.yCoord == Terrain.yCoord ) {
			overlapsWith = true;//it returns true if the player is ate the same position of a terrain
		}
		else if(player.xCoord == Edges.xCoord && player.yCoord == Edges.yCoord) {
			overlapsWith = true;//it returns true if the player is ate the same position of the edge
		}
		else if (player.Location == Iteam.Location && player.yCoord == Iteam.yCoord ) {
			overlapsWith = true;//it returns true if the player is ate the same position of an iteam
		}
		overlapsWith = false;
		}//it returns false if none of above is true
*/
	/**
	 * @return overlapsWith - tell if the player is overlap with something or
	 * not , as a type of boolean
	 */
	public boolean getoverlapsWith(){	//get the overlapsWith
		return this.overlapsWith;
	}

	/**
	 * @return the spriteChar
	 */
	public char getSpriteChar() {
		return this.spriteChar;
	}
	/**
	 * @param spriteChar the spriteChar to set
	 */
	public void setSpriteChar(char spriteChar) {
		this.spriteChar = spriteChar;
	}

	public static void main(String[] args) {
		// Tests
	}
}
