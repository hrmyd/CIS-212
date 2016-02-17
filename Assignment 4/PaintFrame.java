import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private final Canvas _canvas;
	private final JButton _largeButton;
	private final JButton _medButton;
	private final JButton _smallButton;
	private final JButton _blackButton;
	private final JButton _cyanButton;
	private final JButton _orangeButton;
	private final JButton _grayButton;
	private final JButton _clearButton;
	
	public PaintFrame() {
		super("Paint some stuff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		_canvas = new Canvas();
		add(_canvas, BorderLayout.CENTER);
		
		_largeButton = new JButton("Large");
		_largeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setSize(PointList.Size.LARGE);
			}
		});
		
		_medButton = new JButton("Medium");
		_medButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setSize(PointList.Size.MEDIUM);
			}
		});
		
		_smallButton = new JButton("Small");
		_smallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setSize(PointList.Size.SMALL);
			}
		});
		
		_clearButton = new JButton("Clear");
		_clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas._points.clear();
				repaint();
			}
		});
		
		// make size panel
		JPanel sizeButtonPanel = new JPanel(new GridLayout(4, 1));
		sizeButtonPanel.add(_smallButton);
		sizeButtonPanel.add(_medButton);
		sizeButtonPanel.add(_largeButton);
		sizeButtonPanel.add(_clearButton);
		
		add(sizeButtonPanel, BorderLayout.EAST);
		
		_blackButton = new JButton("Black");
		_blackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setColor(Color.BLACK);
			}
		});
		
		_orangeButton = new JButton("Orange");
		_orangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setColor(Color.ORANGE);
			}
		});
		
		_grayButton = new JButton("Gray");
		_grayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setColor(Color.GRAY);
			}
		});
		
		_cyanButton = new JButton("Cyan");
		_cyanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				_canvas.setColor(Color.CYAN);
			}
		});
		
		JPanel colorButtonPanel = new JPanel (new GridLayout(4, 1));
		colorButtonPanel.add(_blackButton);
		colorButtonPanel.add(_orangeButton);
		colorButtonPanel.add(_grayButton);
		colorButtonPanel.add(_cyanButton);
		
		add(colorButtonPanel, BorderLayout.WEST);
		
		setSize(750, 700);
	}
}
