
public class Rectangle implements Measurable{
	static double length;
	static double width;

	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}
	
	@Override
	public double getArea() {
		return length * width;
	}
}
