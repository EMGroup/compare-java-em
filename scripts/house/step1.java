## Program

public class House {
	public int houseX;
	public int houseY;

	public int floorHeight;
	public int floors;
	public int houseWidth = 200;

	public House(int x, int y) {
		houseX = x;
		houseY = y;
	}

	public int roofHeight() {
		return houseWidth * 0.5;
	}

	public Shape[] drawables() {
		int roofX = houseX;
		int roofY = houseY + roofHeight;
		Shape roof = new Triangle(
			roofX, houseY, roofHeight, houseWidth);
		int blockHeight = floorHeight * floors;
		Shape houseBlock = new Rectangle(
			houseX, roofY, houseWidth, blockHeight);

		Shape[] result = {houseBlock, roof};
		return result;
	}
}

###Use and Reuse

public class MyProgram {
public static void main() {

####Case 1
Shape[] myhouse = (new House(100,100)).drawables();

####Case 2
House myhouse_inst = new House(100,100);
myhouse_inst.floors = 4;
myhouse = myhouse_inst.drawables();

####Case 3
class MyHouse extends House {
	public MyHouse(int x, int y) {
		super(x,y);
	}

	public int roofHeight() {
		return 10;
	}
}
myhouse = (new MyHouse(100,100)).drawables();

####Case 4
#Not possible without a new drawables method

####Case 5
#Not possible without a new drawables method

####Case 6
#Can be done but if houseWidth or floorHeight are changed after construction
# it will fail unless explicitely maintained or a new setter method
# is introduced. Such a new setter won't work in a polymorphic case.

class MyHouse extends House {
	public MyHouse(int x, int y) {
		super(x,y);
		updateFloors();
	}

	public int roofHeight() {
		return 10;
	}

	protected void updateFloors() {
		floors = Math.ceil(houseWidth / floorHeight);
	}

	public void setHouseWidth(int value) {
		houseWidth = value;
		updateFloors();
	}

	public void setFloorHeight(int value) {
		floorHeight = value;
		updateFloors();
	}
}
myhouse = (new MyHouse(100,100)).drawables();

}
}

####Case 7
#Not possible without a new drawables method


