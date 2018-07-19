
/*
 * Instance variables
 */
public class Location {	
	private int xCoord;
	private int yCoord;
	private int xSize;
	private int ySize;
	
	public int getxCoord() { 				//getter for xCoord
		return xCoord;
	}

	public void setxCoord(int xcoord) {    //setter for xCoord
		if (xcoord <= 200 && xcoord >= 0) {
		this.xCoord = xcoord;
		}
	}
	public int getyCoord() {				//getter for yCoord
		return yCoord;
	}
	
	public void setyCoord(int ycoord) {    //setter for yCoord
		if (ycoord >= 0 && ycoord <= 40) {
			this.yCoord = yCoord;
		}
	}
	public int getxSize() {	//getter for xSize
		return xSize;
	}
	public void setxSize(int xsize) {		//setter for xSize
		this.xSize = xsize;
	}
	public int getySize() {					//getter for ySize
		return ySize;
	}
	public void setySize(int ysize) {		//setter for ySize
		this.ySize = ysize;
	}
}
