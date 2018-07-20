import java.awt.Image;

public class Sprite
{ // I reordered so that it made sense by class type and for printing order
	protected String name;
	protected Location coord;
	protected Image spriteImage;
	protected char spriteChar;
	protected String[] dialogue;
	protected boolean exists = true;
	protected boolean overlapsWith = false;

	//constructors
	public Sprite(String name, Location coord, Image spriteImage, char spriteChar,
			String[] dialogue, boolean exists, boolean overlapsWith) {
		this.name = name;
		this.coord = coord;
		this.spriteImage = spriteImage;
		this.spriteChar = spriteChar;
		this.dialogue = dialogue;
		this.exists = exists;
		this.overlapsWith = overlapsWith;
	}
	public Sprite() { // set default values
		this.name = "";
		this.coord = new Location();
		this.spriteImage = null; // change once we know what to do with it
		this.spriteChar = 0;
		this.dialogue = null; // until we know what to do with it
		this.exists = false;
		this.overlapsWith = false;
	}

	public void setCoord(int xcoord,int ycoord) { //set xCoord and yCoord
		int xCoord = xcoord;
		int yCoord = ycoord;
	}

	public Location getCoord() {				//set xCoord and yCoord as a type Location
		return coord;
	}

	public void setName(String setname){
		this.name = setname;
	}

	public String getName(){					//get the name
		return name;
	}

	public void setSpriteImage(){				//set the image

	}
	public Image getSpriteImage(){				//get the image
		return spriteImage;
	}

	public void setExists(boolean exist){		//set the exist state of iteams and enemies.
		this.exists  = exist;
	}
	public boolean getExists(){
		return exists;
	}

	public void setDialogue(String[] dialog){
		dialogue = dialog;
	}

	public String[] getDialogue(){				//get the dialogue
		return dialogue;
	}
/*
	public void setOverlapsWith(Player player){//set if player is overlapswith enemy , terrain ,potions or edges
		if (player.xCoord <= Enemy.xCoor + Enemy.xSize && player.xCoord >= Enemy.xCoor - Enemy.xSize && player.yCoord <= Enemy.yCoord + Enemy.ySize && player.yCoord >= Enemy.yCoord - Enemy.ySize){
			overlapsWith = true;//it returns true if the player is in an area of rectangle with x range [xcood - xsize, xccord + xsize] and y range [ycoord - ysize , ycoord + ysize]
		}
		else if(player.xCoord == Terrain.xCoord && player.yCoord == Terrain.yCoord ) {
			overlapsWith = true;
		}
		else if(player.xCoord == Edges.xCoord && player.yCoord == Edges.yCoord) {
			overlapsWith = true;
		}
		else if (player.Location == Iteam.Location && player.yCoord == Iteam.yCoord ) {
			overlapsWith = true;
		}
		overlapsWith = false;

		}//it returns false if none of above is true
*/

	public boolean getoverlapsWith(){	//get the overlapsWith
		return overlapsWith;
	}

	public void setSpriteChar(char spriteChar) {
		this.spriteChar = spriteChar;
	}

	public char getSpriteChar() {
		return spriteChar;
	}
}
