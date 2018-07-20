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
	protected String title;
    protected Location coordinate;
    protected Image spriteImage;
    protected char spriteSymbol; // will become the sprite image class later
    protected String[] spriteMessages;
    protected boolean existence;
    protected boolean overlapsWith;

	//constructors
	public Sprite(String title,
                  Location coordinate,
                  Image spriteImage,
                  char spriteSymbol, // will become the sprite image class later
                  String[] spriteMessages,
                  boolean existence,
                  boolean overlapsWith) {
		this.name = name;
		this.coord= coord;
		this.spriteImage = SpriteImage;
		this.exists = Exists;
		this.dialogue = Dialogue;
		this.overlapsWith = overlapsWith;
	}

	public Sprite() {
		this.title = "";
	    this.coordinate = null;
	    this.spriteImage = null;
	    this.spriteSymbol = ' '; // will become the sprite image class later
	    this.spriteMessages = null;
	    this.existence = true; 
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
		return coord;
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
		return name;
	}


	public void setSpriteImage(){				//set the image

	}

	/**
	 * @return spriteImage - renew the spriteImage as a type of Image
	 */
	public Image getSpriteImage(){				//get the image
		return spriteImage;
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
		return exists;
	}
	/**
	 * @param dialog set dialogues as a type of String array
	 */
	public void setDialogue(String[] dialog){	//set the dialogue
		dialogue = dialog;
	}
	/**
	 * @return dialogue	- renew the dialogue we need as a String array
	 */
	public String[] getDialogue(){				//get the dialogue
		return dialogue;
	}

	/**
	 * @param overlapsWith true if the player is overlaps with an enemy, an
	 * item, an edge, or terrain as a type of boolean.
	 */
	public void setoverlapsWith(player player){//set if player is overlapswith enemy , terrain ,potions or edges
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

	/**
	 * @return overlapsWith - tell if the player is overlap with something or
	 * not , as a type of boolean
	 */
	public boolean getoverlapsWith(){	//get the overlapsWith
		return overlapsWith;
	}
}
