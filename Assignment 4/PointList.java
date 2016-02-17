import java.awt.Color;

public class PointList {
	public enum Size {
		SMALL,
		MEDIUM,
		LARGE
	}
	private final int _x;
	private final int _y;
	private final Size _size;
	private final Color _color;
	
	public PointList(int x, int y, Size size, Color color) {
		_x = x;
		_y = y;
		_size = size;
		_color = color;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public Size getSize() {
		return _size;
	}
	
	public Color getColor(){
		return _color;
	}
}
