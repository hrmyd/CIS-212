import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
	
	private static double nextDouble() {
		double random = new Random().nextDouble();
		
		return 1 - random;
	}
	
	private static float calculateSum(ArrayList<Measurable> areas) {
		float areaSum = 0;
		
		// calculate sum of areas in array list
		for(Measurable area : areas) {
			areaSum += area.getArea();
		}
		return areaSum;
	}
	
	public static void main(String[] args){
		ArrayList<Measurable> shapes = new ArrayList<Measurable>();
		
		Rectangle rec = new Rectangle(nextDouble(), nextDouble());
		Box box = new Box(nextDouble(), nextDouble(), nextDouble());
		Circle circle = new Circle(nextDouble());
		Sphere sphere = new Sphere(nextDouble());
		
		// for populating array
		Measurable[] shapesPop = new Measurable[] {
				rec, box, circle, sphere
		};
		
		// populate array list with 1000 random instances of shape classes
		Random randShape = new Random();
		for(int i = 0; i < 1000; i++){
			int j = randShape.nextInt(4);
			shapes.add(shapesPop[j]);
		}
		
		// get frequency of each shape class in array
		int recCount = Collections.frequency(shapes, rec);
		int boxCount = Collections.frequency(shapes, box);
		int circleCount = Collections.frequency(shapes, circle);
		int sphereCount = Collections.frequency(shapes, sphere);
		
		System.out.println("rectangles: " + recCount + 
							" boxes: " + boxCount + " circles: " + circleCount +
							" spheres: " + sphereCount);
		System.out.println("sum: " + calculateSum(shapes));
		
	}
}
