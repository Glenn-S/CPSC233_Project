
public class Location {	
	private int xCoord;
	private int yCoord;
	private int xSize;
	private int xSizemax;
	private int xSizemin;
	private int ySize;
	private int ySizemax;
	private int ySizemin;
	
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
	}
}
