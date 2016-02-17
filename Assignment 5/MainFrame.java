import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private final Phonebook _phonebook;
	private final JButton _selectionButton;
	private final JButton _mergeButton;
	private final JLabel _selectionLabel;
	private final JLabel _mergeLabel;
	
	public MainFrame() {
		super("Sorting Comparisons");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		_phonebook = new Phonebook();
		
		// create copy of list
		ArrayList<Entry> selectionPhonebook = new ArrayList<Entry>(_phonebook.addEntries());
			
		// selection sort label and button
		_selectionButton = new JButton("Selection Sort");
		_selectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(_phonebook.isSorted(_phonebook.selectionSort(selectionPhonebook)) == false){
					_selectionLabel.setText("error! not sorted");
				} else{
					long startTime = System.nanoTime();
					_phonebook.selectionSort(selectionPhonebook);
					_selectionLabel.setText(String.valueOf(_phonebook.elapsedTime(startTime)));
				}
			}
		});		
		
		_selectionLabel = new JLabel("time in sec");
		
		// create copy of list
		ArrayList<Entry> mergePhonebook = new ArrayList<Entry>(_phonebook.addEntries());
		
		// merge sort label and button
		_mergeButton = new JButton("Merge Sort");
		_mergeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_phonebook.isSorted(_phonebook.mergeSort(mergePhonebook)) == false){
					_mergeLabel.setText("error! not sorted");
				} else{
					long startTime = System.nanoTime();
					_phonebook.mergeSort(mergePhonebook);
					_mergeLabel.setText(String.valueOf(_phonebook.elapsedTime(startTime)));
				}
			}
		});
		
		_mergeLabel = new JLabel("time in sec");
		
		JPanel layoutPanel = new JPanel(new GridLayout(2, 4));
		layoutPanel.add(_selectionButton);
		layoutPanel.add(_selectionLabel);
		layoutPanel.add(_mergeButton);
		layoutPanel.add(_mergeLabel);
		
		
		add(layoutPanel);
		
		pack();
		
	}
}
