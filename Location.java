public class Location {	
/*This is a class to get the location informations from the user
 *
 *
 * @version 		20.41   19  July 2018
 * @author    		Yuhui  Yan
 * 
 * Instance variables
 * @param xCoord         the xCoordinate of an object on map   as a type of integer
 * @param yCoord		 the yCoordinate of an object on map   as a type of integer
 * @param xSize			 the xSize of an object on map   as a type of integer
 * @param ySzie			 the ySize of an object on map   as a type of integer
 */
	private int xCoord;
	private int yCoord;
	private int xSize;
	private int ySize;
	
	public Location(int xCoord,int yCoord,int xSize,int ySize) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	/*
	 * @return xCoord    renew xCoordinate of the object    as a type of integer
	 */
	public int getxCoord() { 				//getter for xCoord
		return xCoord;
	}
	/*
	 * @param xCoord     it's the x Coordinate information of the object  as a type of integer
	 */	
	public void setxCoord(int xcoord) {    //setter for xCoord
		if (xcoord <= 200 && xcoord >= 0) {
		this.xCoord = xcoord;
		}
	}
	
	/*
	 * @return yCoord    renew yCoordinate of the object    as a type of integer
	 */
	public int getyCoord() {				//getter for yCoord
		return yCoord;
	}
	
	/*
	 * @param yCoord     it's the y Coordinate information of the object  as a type of integer
	 */	
	public void setyCoord(int ycoord) {    //setter for yCoord
		if (ycoord >= 0 && ycoord <= 40) {
			this.yCoord = yCoord;
		}
	}
	
	/*
	 * @return xSize     renew the x Size of the object  as a type of integer
	 */
	public int getxSize() {	//getter for xSize
		return xSize;
	}
	/*
	 * @param xSize      it's the x Size information of the object  as a type of integer
	 */	
	public void setxSize(int xsize) {		//setter for xSize
		this.xSize = xsize;
	}
	
	/*
	 * @return ySize     renew the y Size information of the object  as a type of integer
	 */
	public int getySize() {					//getter for ySize
		return ySize;
	}
	/*
	 * @param ySize       it's the y Size information of the object  as a type of integer
	 */	
	public void setySize(int ysize) {		//setter for ySize
		this.ySize = ysize;
	}
}
