package View;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class RoomInfo extends JPanel {

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
		
	// Constructing the panel now.
	public RoomInfo() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -10, SpringLayout.EAST, this);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, 0, SpringLayout.SOUTH, btnEdit);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, -6, SpringLayout.WEST, btnEdit);
		add(btnDelete);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, btnEdit);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, btnEdit);
		add(textArea);

	}
}
