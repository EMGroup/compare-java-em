## Program

public class House {
	private int houseX;
	private int houseY;

	public House(int x, int y) {
		houseX = x;
		houseY = y;
	}

	public int roofHeight() {
		return houseWidth * 0.5;
	}

	public Shape houseBlock() {
		return new Rectangle(houseX, roofY(),
			houseWidth(), blockHeight());
	}

	public Shape roof() {
		return new Triangle(roofX(), houseY,
			roofHeight(), houseWidth());
	}

	public int blockHeight() {
		return floorHeight * floors;
	}

	public int roofY() {
		return houseY + roofHeight();
	}

	public int roofX() {
		return houseX;
	}

	public int houseWidth() {
		return 200;
	}

	public int floors() {
		return 2;
	}

	public int floorHeight() {
		return 40;
	}

	public Shape[] drawables() {
		Shape[] result = {houseBlock(), roof()};
		return result;
	}
}

###Use and Reuse

public class MyProgram {
public static void main() {

####Case 1
Shape[] myhouse = (new House(100,100)).drawables();

####Case 2
class MyHouse extends House {
	public MyHouse(int x, int y) {
		super(x,y);
	}

	public int floors() {
		return 4;
	}
}
myhouse = (new MyHouse(100,100)).drawables();

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
class MyHouse extends House {
	public MyHouse(int x, int y) {
		super(x,y);
	}

	public int roof() {
		return new Triangle(roofX() - 50, houseY,
			roofHeight(), houseWidth() + 100);
	}
}
myhouse = (new MyHouse(100,100)).drawables();

####Case 5
#Not possible to modify original class, would have to ensure all use of House
# actually used `MyHouse` as defined in case 4. Might not be possible to make
# third party code that uses `House` use `MyHouse` instead unless `MyHouse` can be
# dependency injected.

####Case 6
#Would have to ensure all use of House actually used MyHouse instead. See case 5.

class MyHouse extends House {
	public MyHouse(int x, int y) {
		super(x,y);
	}

	public int floors() {
		return Math.ceil(houseWidth() / floorHeight());
	}
}
myhouse = (new MyHouse(100,100)).drawables();

}
}

####Case 7
# Would have to modify the class to do dependency injection

