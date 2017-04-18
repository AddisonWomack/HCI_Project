package View;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JButton;

public class AdminEmployeePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminEmployeePanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JList list = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, list, 236, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, list, 440, SpringLayout.WEST, this);
		add(list);
		
		JButton btnAdd = new JButton("Add");
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAdd, 54, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, 115, SpringLayout.WEST, this);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 6, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 58, SpringLayout.EAST, btnAdd);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, 0, SpringLayout.SOUTH, btnAdd);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, 163, SpringLayout.EAST, btnAdd);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 6, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, -115, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, 0, SpringLayout.SOUTH, btnAdd);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, -10, SpringLayout.EAST, this);
		add(btnDelete);

	}
}
