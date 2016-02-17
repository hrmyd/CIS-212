
public class Circle implements Measurable{
	static double radius;
	
	public Circle(double r) {
		radius = r;
	}
	
	@Override
	public double getArea(){
		return 2 * Math.PI * Math.pow(radius, 2);
	}
}
