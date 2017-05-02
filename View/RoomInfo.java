package View;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import Model.Listener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;

public class RoomInfo extends JPanel implements Listener {

	/**
	 * Create by Michael on 4/3/2017.
	 */
	
	// Do the thing. Get the info.
	
	// Utilizing Swing in order to display the text and buttons
	String roomNum;						// The room number
	String occupancy;					// Current occupancy status
	String floorNum;					// Which floor it is on
	String handicapAccess;				// Handicap Accessible
	String smoking;						// Smoking or non-smoking
	String bedNum;						// How many beds
	private JList<String> list;
	JTextArea textArea;
		
	// Constructing the panel now.
	public RoomInfo(JList<String> list) {
		this.list = list;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 290, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 440, SpringLayout.WEST, this);
		add(textArea);

	}

	@Override
	public void updated() {
		textArea.setText(list.getSelectedValue());
	}
}
