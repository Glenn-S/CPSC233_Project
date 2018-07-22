/**
 * This is a class to get the location informations from the user
 *
 *
 * @version 20.41   19  July 2018
 * @author Yuhui  Yan
 *
 * Instance variables
 * xCoord the xCoordinate of an object on map   as a type of integer
 * yCoord	the yCoordinate of an object on map   as a type of integer
 * xSize the xSize of an object on map   as a type of integer
 * ySzie the ySize of an object on map   as a type of integer
 */
public class Location {

	private int xCoord;
	private int yCoord;
	private int xSize;
	private int ySize;
	private int lowerboudary;
	private int upperboundary;
	private int leftboundary;
	private int rightboundary;

	/*---------------------------- CONSTRUCTORS ------------------------------*/
	public Location(int xCoord,int yCoord,int xSize,int ySize) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public Location() {
		this.xCoord = 0;
		this.yCoord = 0;
		this.xSize = 0;
		this.ySize = 0;
	}

	/*--------------------------- GETTER/SETTERS -----------------------------*/
	/**
	 * @return xCoord renew xCoordinate of the object    as a type of integer
	 */
	public int getxCoord() { 				//getter for xCoord
		return this.xCoord;
	}
	/**
	 * @param xCoord it's the x Coordinate information of the object  as a type of integer
	 */
	public void setxCoord(int xCoord) {    //setter for xCoord
		if (xCoord < 200 && xCoord >= 0) { // range of map is from 0-199 (200 in total)
		this.xCoord = xCoord;
		}
		else this.xCoord = 0; // set default value
	}

	/**
	 * @return yCoord renew yCoordinate of the object    as a type of integer
	 */
	public int getyCoord() {				//getter for yCoord
		return this.yCoord;
	}

	/**
	 * @param yCoord it's the y Coordinate information of the object  as a type of integer
	 */
	public void setyCoord(int yCoord) {    //setter for yCoord
		if (yCoord >= 0 && yCoord < 40) { // range of map is from 0-39 (40 in total)
			this.yCoord = yCoord;
		}
		else this.xCoord = 0; // set default value
	}

	/**
	 * @return xSize renew the x Size of the object  as a type of integer
	 */
	public int getxSize() {	//getter for xSize
		return this.xSize;
	}
	/**
	 * @param xSize it's the x Size information of the object  as a type of integer
	 */
	public void setxSize(int xSize) {		//setter for xSize
		if (xSize >= 0) { // make sure the value is positive
			this.xSize = xSize;
		}

	}

	/**
	 * @return ySize renew the y Size information of the object  as a type of integer
	 */
	public int getySize() {					//getter for ySize
		return this.ySize;
	}
	/**
	 * @param ySize it's the y Size information of the object  as a type of integer
	 */
	public void setySize(int ySize) {		//setter for ySize
		if (ySize >= 0) { // make sure the value is positive
			this.ySize = ySize;
		}
	}
	/**
	 * @return lowerboudary return the lowerbounday for y value as a type of integer
	 */
	public int getLowerboudary() {
		return lowerboudary;
	}

	/**
	 * @param ySize it's the y Size information of the object  as a type of integer
	 * @param yCoord	it's the y Coordinate information of the object  as a type of integer
	 */
	public void setLowerboudary(int ySize, int yCoord) {
		lowerboudary = yCoord - ySize;
	}
	/**
	 * @return upperboudary return the upperbounday for y value as a type of integer
	 */
	public int getUpperboundary() {
		return upperboundary;
	}
	/**
	 * @param ySize it's the y Size information of the object  as a type of integer
	 * @param yCoord	it's the y Coordinate information of the object  as a type of integer
	 */
	public void setUpperboundary(int ySize, int yCoord) {
		upperboundary = yCoord + ySize;
	}
	/**
	 * @return leftboudary return the leftbounday for x value as a type of integer
	 */
	public int getLeftboundary() {
		return leftboundary;
	}
	/**
	 * @param xSize it's the x Size information of the object  as a type of integer
	 * @param xCoord	it's the x Coordinate information of the object  as a type of integer
	 */
	public void setLeftboundary(int xSize, int xCoord) {
		this.leftboundary = xCoord - xSize;
	}
	/**
	 * @return rightboudary return the rightbounday for x value as a type of integer
	 */
	public int getRightboundary() {
		return rightboundary;
	}

	/**
	 * @param xSize it's the x Size information of the object  as a type of integer
	 * @param xCoord it's the x Coordinate information of the object  as a type of integer
	 */
	public void setRightboundary(int xSize, int xCoord) {
		this.rightboundary = xCoord + xSize;
	}


	/*------------------------------- METHODS --------------------------------*/

// *** maybe it would be useful to create a left, right, top, and bottom bound method to eliminate some work ***

	/**
	 * Purpose: To print out a string representation of the class attributes
	 * @return a string with all the attributes
	 */
	@Override
	public String toString() {
		String strRep = this.getxCoord()+","+this.getyCoord+","+this.getxSize+","+
		this.getySize;
		return strRep;
	}

	public static void main(String[] args) {
		// Tests
		Location l1 = new Location(); // test the default constructor
		Location l2 = new Location(199, 39, 1, 2);
		String strl1 = "(" + l1.getxCoord() + ", " + l1.getyCoord() + ")";
		String strl2 = "(" + l2.getxCoord() + ", " + l2.getyCoord() + ")";
		System.out.println("l1: " + strl1);
		System.out.println("l2: " + strl2);
	}
}
