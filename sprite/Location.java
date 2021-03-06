package sprite;

/**
 * Purpose: This is a class to get the location informations from the user
 * @version 20.41   19  July 2018
 *
 * Instance variables
 * xCoord the xCoordinate of an object on map
 * yCoord	the yCoordinate of an object on map
 * xSize the xSize of an object on map
 * ySzie the ySize of an object on map
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class Location {
	private int xCoord;
	private int yCoord;
	private int xSize;
	private int ySize;

	/*---------------------------- CONSTRUCTORS ------------------------------*/

	/**
	 * Purpose: to create a constructor for the location class that takes the
	 * x/y coordinates and the x and y dimensions.
	 */
	public Location(int xCoord,int yCoord,int xSize,int ySize) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.xSize = xSize;
		this.ySize = ySize;
	}

	/**
	 * Purpose: to create a default cosntructor for the location to be set to
	 * (0, 0, 0, 0).
	 */
	public Location() {
		this.xCoord = 0;
		this.yCoord = 0;
		this.xSize = 0;
		this.ySize = 0;
	}

	/**
	 * Purpose: Copy constructor
	 */
	public Location(Location copyLocation) {
		this.xCoord = copyLocation.getxCoord();
		this.yCoord = copyLocation.getyCoord();
		this.xSize = copyLocation.getxSize();
		this.ySize = copyLocation.getySize();
	}

	/*--------------------------- GETTER/SETTERS -----------------------------*/
	/**
	 * Purpose: To retrieve the x coordinate.
	 * @return xCoord renew xCoordinate of the object as a type of integer
	 */
	public int getxCoord() {
		return this.xCoord;
	}

	/**
	 * Purpose: to set the y coordinate value.
	 * @param xCoord It's the x Coordinate information of the object as a type
	 * of integer
	 */
	public void setxCoord(int xCoord) {
		if (xCoord < 80 && xCoord >= 0) {
			this.xCoord = xCoord;
		}
		else this.xCoord = 0; // set default value
	}

	/**
	 * Purpose: To retrieve the x coordinate.
	 * @return yCoord renew yCoordinate of the object as a type of integer
	 */
	public int getyCoord() {
		return this.yCoord;
	}

	/**
	 * Purpose: to set the y coordinate value.
	 * @param yCoord it's the y Coordinate information of the object  as a type
	 * of integer
	 */
	public void setyCoord(int yCoord) {
		if (yCoord >= 0 && yCoord < 40) {
			this.yCoord = yCoord;
		}
		else this.xCoord = 0; // set default value
	}

	/**
	 * Purpose: To retrieve the x values dimension.
	 * @return xSize renew the x Size of the object as a type of integer
	 */
	public int getxSize() {
		return this.xSize;
	}

	/**
	 * Purpose: To set the x values dimension.
	 * @param xSize it's the x Size information of the object  as a type of integer
	 */
	public void setxSize(int xSize) {
		if (xSize >= 0) {
			this.xSize = xSize;
		}
	}

	/**
	 * Purpose: To retrieve the y values dimension.
	 * @return ySize renew the y Size information of the object  as a type of integer
	 */
	public int getySize() {
		return this.ySize;
	}

	/**
	* Purpose: To set the y values dimension.
	 * @param ySize it's the y Size information of the object  as a type of integer
	 */
	public void setySize(int ySize) {
		if (ySize >= 0) {
			this.ySize = ySize;
		}
	}

	/*------------------------------- METHODS --------------------------------*/
	/**
	 * Purpose: To get the lower boundary of the y coordinate.
	 * @return lowerboudary return the lowerbounday for y value as a type of integer
	 */
	public int getLowerBoundary() {
		return this.yCoord + this.ySize;
	}

	/**
	 * Purpose: To get the upper boundary of the y coordinate.
	 * @return upperboudary return the upperbounday for y value as a type of integer
	 */
	public int getUpperBoundary() {
		return this.yCoord - this.ySize;
	}

	/**
	 * Purpose: To get the left boundary of the x coordinate.
	 * @return leftboudary return the leftbounday for x value as a type of integer
	 */
	public int getLeftBoundary() {
		return this.xCoord - this.xSize;
	}

	/**
	 * Purpose: To get the right boundary of the x coordinate.
	 * @return rightboudary return the rightbounday for x value as a type of integer
	 */

	public int getRightBoundary() {
		return this.xCoord + this.xSize;
	}

	/**
	 * Purpose: To return the adjusted value for the pixel amount of x for the
	 * GUI
	 * @return return the pixel set for x
	 */

	public int getPixelX(){
		return this.xCoord * 50; // old size 100
	}

	/**
	 * Purpose: To return the adjusted value for the pixel amount of y for the
	 * GUI
	 * @return return the pixel set for y
	 */
	public int getPixelY(){
		return this.yCoord * 50; // old size 100
	}

	/**
	 * Purpose: To return the adjusted value for the pixel amount of the
	 * horizontal distance for the GUI.
	 * @return return the pixel set for xsize
	 */

	public int getPixelXSize(){
		return this.xSize * 50; // old size 100
	}

	/**
	 * Purpose: To return the adjusted value for the pixel amount of the
	 * vertical distance for the GUI.
	 * @return return the pixel set for ysize
	 */
	public int getPixelYSize(){
		return this.ySize * 50; // old size 100
	}

	/**
	 * Purpose: To print out a string representation of the class attributes
	 * @return a string with all the attributes
	 */
	@Override
	public String toString() {
		return "((" + this.getxCoord() + ", " + this.getyCoord() +
			"), (X Size: " + this.xSize + ", Y Size: " + this.ySize + "))";
	}

}
