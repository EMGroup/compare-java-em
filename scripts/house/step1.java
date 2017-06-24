## Program

public class House {
	public int houseX;
	public int houseY;

	public int floorHeight;
	public int floors;
	public int houseWidth = 200;

	House(int x, int y) {
		houseX = x;
		houseY = y;
	}

	int roofHeight() {
		return houseWidth * 0.5;
	}

	Shape[] drawables() {
		int roofX = houseX;
		int roofY = houseY + roofHeight;
		Shape roof = new Triangle(
			roofX, roofY, roofHeight, houseWidth);
		int blockHeight = floorHeight * floors;
		Shape houseBlock = new Rectangle(
			houseX, roofY, houseWidth, blockHeight);

		Shape[] result = {houseBlock, roof};
		return result;
	}
}

###Use and Reuse
####Case 1
myhouse = (new House(100,100)).drawables();

####Case 2
myhouse_inst = new House(100,100);
myhouse_inst.floors = 4;
myhouse = myhouse_inst.drawables();

####Case 3
class MyHouse extends House {
	MyHouse(int x, int y) {
		super(x,y);
	}

	int roofHeight() {
		return 10;
	}
}
myhouse = (new MyHouse(100,100)).drawables();

####Case 4
#Not possible without a new drawables method

