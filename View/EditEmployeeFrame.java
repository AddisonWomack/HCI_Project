package View;

import Model.Employee;
import Model.Hotel;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEmployeeFrame extends JFrame {
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField EMailField;
	private JTextField phoneNumberField;
	private Hotel model;
	private Employee targetEmployee;

	/**
	 * Create the panel.
	 */
	public EditEmployeeFrame(Hotel model, Employee targetEmployee) {

		this.model = model;
		this.targetEmployee = targetEmployee;

		JPanel contentPane = new JPanel();

		setName("Edit Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);


		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		contentPane.setName("Edit Employee");
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, this);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 6, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		contentPane.add(lblLastName);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblEmailAddress, 6, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblEmailAddress, 0, SpringLayout.WEST, lblFirstName);
		contentPane.add(lblEmailAddress);
		
		JLabel lblNewLabel = new JLabel("Phone Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblFirstName);
		contentPane.add(lblNewLabel);
		
		firstNameField = new JTextField(targetEmployee.getFirstName());
		springLayout.putConstraint(SpringLayout.NORTH, firstNameField, 9, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, firstNameField, 6, SpringLayout.EAST, lblFirstName);
		springLayout.putConstraint(SpringLayout.EAST, firstNameField, 321, SpringLayout.EAST, lblFirstName);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField(targetEmployee.getLastName());
		springLayout.putConstraint(SpringLayout.WEST, lastNameField, 15, SpringLayout.EAST, lblLastName);
		springLayout.putConstraint(SpringLayout.SOUTH, lastNameField, -5, SpringLayout.NORTH, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.EAST, lastNameField, 0, SpringLayout.EAST, firstNameField);
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);
		
		EMailField = new JTextField(targetEmployee.getEMailAddress());
		springLayout.putConstraint(SpringLayout.NORTH, EMailField, 0, SpringLayout.NORTH, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.WEST, EMailField, 6, SpringLayout.EAST, lblEmailAddress);
		springLayout.putConstraint(SpringLayout.EAST, EMailField, 0, SpringLayout.EAST, firstNameField);
		contentPane.add(EMailField);
		EMailField.setColumns(10);
		
		phoneNumberField = new JTextField(targetEmployee.getPhoneNumber());
		springLayout.putConstraint(SpringLayout.NORTH, phoneNumberField, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, phoneNumberField, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, phoneNumberField, 0, SpringLayout.EAST, firstNameField);
		contentPane.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		
		JCheckBox chckbxIsAdmin = new JCheckBox("Admin", targetEmployee.isAdmin());
		chckbxIsAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, chckbxIsAdmin, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, chckbxIsAdmin, 0, SpringLayout.WEST, lblFirstName);
		contentPane.add(chckbxIsAdmin);

		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma",Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, chckbxIsAdmin );
		contentPane.add(submitButton);

		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.updateEmployee(targetEmployee.getEMailAddress(),
						firstNameField.getText(), lastNameField.getText(),
						EMailField.getText(), phoneNumberField.getText(), chckbxIsAdmin.isSelected());
				dispose();
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, cancelButton, 6,SpringLayout.SOUTH, chckbxIsAdmin);
		springLayout.putConstraint(SpringLayout.WEST, cancelButton, 6, SpringLayout.EAST, submitButton);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.setVisible(true);
	}
}
