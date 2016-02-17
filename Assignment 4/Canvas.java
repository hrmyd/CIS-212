import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	protected final ArrayList<PointList> _points;
	private int _pointSize;
	private PointList.Size _currSize;
	private Color _currColor;
	
	public Canvas() {
		_points = new ArrayList<>();
		_currSize = PointList.Size.SMALL;
		_currColor = Color.CYAN;
		
		// when mouse is dragged 
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				_points.add(new PointList(e.getX(), e.getY(), 
							_currSize, _currColor));
				repaint();
			}
			
		});
		
		// when mouse is clicked
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_points.add(new PointList(e.getX(), e.getY(), 
						_currSize, _currColor));
			repaint();
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (PointList p: _points) {
			g.setColor(p.getColor());
			// set to where mouse clicked/dragged
			g.fillOval(p.getX() - _pointSize, p.getY() - _pointSize, _pointSize, _pointSize);
			switch(p.getSize()) {
			case SMALL:
				_pointSize = 8;
				break;
			case MEDIUM:
				_pointSize = 14;
				break;
			case LARGE:
				_pointSize = 20;
				break;
			}
		}
	}

	public void setSize(PointList.Size size){
		_currSize = size;
	}
	
	public void setColor(Color color){
		_currColor = color;
	}
}
