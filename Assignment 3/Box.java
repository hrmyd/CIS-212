
public class Box extends Rectangle{
	private double height;
	
	public Box(double l, double w, double h) {
		super(length, width);
		height = h;
	}
	
	@Override
	public double getArea() {
		return (2*length*width) + (2*length*height) + (2*width*height);
	}

}
