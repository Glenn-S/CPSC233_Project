import java.awt.Image;
//it's the parent class of  Avator , Potion ,Weapon and Defence
public class Sprite
{	//instance variables
	private Image spriteImage;
	private String name;
	private boolean exists = true;
	private String[] dialogue;
	private boolean overlapsWith = false;
	private Location coord;
<<<<<<< HEAD


	public Sprite(Location coord,String name,Image spriteImage,boolean exists,String[] dialogue,boolean overlapsWith) {

=======
	Sprite s = new Sprite();
	
	//constructors
	public Sprite(Location coord,String name,Image SpriteImage,boolean Exists,String[] Dialogue,boolean overlapsWith) {
		this.name = name;
		this.coord= coord;
		this.spriteImage = SpriteImage;
		this.exists = Exists;
		this.dialogue = Dialogue;
		this.overlapsWith = overlapsWith;
>>>>>>> master
	}
	public Sprite() {
		
	}
	
	public void setCoord(int xcoord,int ycoord) { //set xCoord and yCoord
		int xCoord = xcoord;
		int yCoord = ycoord;
	}
	
	public Location getCoord() {				//set xCoord and yCoord as a type Location
		return coord;
	}

	public void setName(String setname){		//set the name
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
	public boolean getExists(){					//get the exist state
		return exists;
	}

	public void setDialogue(String[] dialog){	//set the dialogue
		dialogue = dialog;
	}
	
	public String[] getDialogue(){				//get the dialogue
		return dialogue;
	}
<<<<<<< HEAD

	public void setOverlapsWith(player player){
		if (player.xCoord <= Enemy.xCoordmax && player.xCoord >= Enemy.xCoordmin && player.yCoord <= Enemy.yCoordmax && player.yCoord >= Enemy.yCoordmin){
			overlapsWith = true;
=======
	
	public void setoverlapsWith(player player){//set if player is overlapswith enemy , terrain ,potions or edges
		if (player.xCoord <= Enemy.xCoor + Enemy.xSize && player.xCoord >= Enemy.xCoor - Enemy.xSize && player.yCoord <= Enemy.yCoord + Enemy.ySize && player.yCoord >= Enemy.yCoord - Enemy.ySize){
			overlapsWith = true;//it returns true if the player is in an area of rectangle with x range [xcood - xsize, xccord + xsize] and y range [ycoord - ysize , ycoord + ysize]
>>>>>>> master
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
<<<<<<< HEAD
		}


	public boolean getOverlapsWith(){
=======
		}//it returns false if none of above is true
		
	
	public boolean getoverlapsWith(){	//get the overlapsWith
>>>>>>> master
		return overlapsWith;
	}		
}