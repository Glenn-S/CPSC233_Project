import java.awt.Image;

public class Sprite
{
	private Image SpriteImage;
	Sprite s = new Sprite();
	private String name;
	private boolean exists = true;
	private String[] dialogue;
	private boolean overlapsWith = false;
<<<<<<< HEAD
	private int xCoord;
	private int ySizemax;
	private int ySizemin;
	private int ySize;
	private int xSize;
	private int xSizemax;
	private int xSizemin;
	private int yCoord;

=======
	private Location Coord;
	
	
	public Sprite(Location coord,String name,Image SpriteImage,boolean Exists,String[] Dialogue,boolean overlapsWith) {
		
	}
>>>>>>> master
	public Sprite() {

	}
<<<<<<< HEAD


	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public int getxSize() {
		return xSize;
	}
	public void setxSize(int xSize) {
		this.xSizemax = this.xCoord + xSize;
		this.xSizemin = this.xCoord - xSize;
	}
	public int getySize() {
		return ySize;
	}
	public void setySize(int ySize) {
		this.ySizemax = this.yCoord + ySize;
		this.ySizemin = this.yCoord - ySize;
=======
	
	public void setCoord(int xcoord,int ycoord) {
		int xCoord = xcoord;
		int yCoord = ycoord;
	}
	
	public Location getCoord() {
		return Coord;
>>>>>>> master
	}

	public void setName(String setname){
		this.name = setname;
	}

	public String getName(){
		return name;
	}

	public void setSpriteImage(){

	}
	public Image getSpriteImage(){
		return SpriteImage;
	}

	public void setExists(boolean exist){
		this.exists  = exist;
	}
	public boolean getExists(){
		return exists;
	}

	public void setDialogue(String dialog){
		dialogue = dialog;
	}

	public String getDialogue(){
		return dialogue;
	}

	public void setoverlapsWith(player player){
		if (player.xCoord <= Enemy.xCoordmax && player.xCoord >= Enemy.xCoordmin && player.yCoord <= Enemy.yCoordmax && player.yCoord >= Enemy.yCoordmin){
			overlapsWith = true;
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
<<<<<<< HEAD
	}


=======
		}
		
	
>>>>>>> master
	public boolean getoverlapsWith(){
		return overlapsWith;
	}
}
