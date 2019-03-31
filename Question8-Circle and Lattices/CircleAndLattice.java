import java.util.HashSet;
import java.util.Set;

interface Circle {
	void setRadius(int radius);
	int getRadius();
	void printIntegerLattices();
}

abstract class Circles implements Circle {
	private int radius;

	@Override
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return this.radius;
	}
}

public class CircleAndLattice extends Circles {
	
	@Override
	public void printIntegerLattices() {
		// TODO Auto-generated method stub
		printIntegerLatticePoints();
	}

	private void printIntegerLatticePoints() {
		int reqSum = (int) Math.pow(this.getRadius(), 2);
		Set<Integer> set = new HashSet<>();
		
		for(int i=1;i<this.getRadius();i++) {
			set.add((int)Math.pow(i, 2));
		}
		int num = 0;
		for(Integer i: set) {
			if(set.contains(reqSum-i)) {
				num++;
			}
		}
		// the same points with different signs will be in all 4 quadrants
		num  *= 4;
		
		// 4 points will lie on the x,y-axis
		System.out.println(num+4);
	}

	public static void main(String[] args) {
		Circle c = new CircleAndLattice();
		c.setRadius(5);
		c.printIntegerLattices();
	}
}
