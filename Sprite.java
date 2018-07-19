import java.awt.Image;

public class Sprite
{
	private Image SpriteImage;
	Sprite s = new Sprite();
	private String name;
	private boolean exists = true;
	private String[] dialogue;
	private boolean overlapsWith = false;
	private Location Coord;


	public Sprite(Location coord,String name,Image SpriteImage,boolean Exists,String[] Dialogue,boolean overlapsWith) {

	}
	public Sprite() {

	}

	public void setCoord(int xcoord,int ycoord) {
		int xCoord = xcoord;
		int yCoord = ycoord;
	}

	public Location getCoord() {
		return Coord;
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
		}


	public boolean getoverlapsWith(){
		return overlapsWith;
	}
}
