
public class Sphere extends Circle{
	
	public Sphere(double r) {
		super(radius);	 
	}
	
	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
}
