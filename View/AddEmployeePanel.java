package View;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class AddEmployeePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddEmployeePanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, this);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 6, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		add(lblLastName);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblEmailAddress, 6, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblEmailAddress, 0, SpringLayout.WEST, lblFirstName);
		add(lblEmailAddress);
		
		JLabel lblNewLabel = new JLabel("Phone Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblFirstName);
		add(lblNewLabel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 9, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblFirstName);
		springLayout.putConstraint(SpringLayout.EAST, textField, 321, SpringLayout.EAST, lblFirstName);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 15, SpringLayout.EAST, lblLastName);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -5, SpringLayout.NORTH, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxIsAdmin = new JCheckBox("Admin");
		chckbxIsAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, chckbxIsAdmin, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, chckbxIsAdmin, 0, SpringLayout.WEST, lblFirstName);
		add(chckbxIsAdmin);

	}
}
