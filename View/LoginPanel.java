package View;
import Model.Hotel;


import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginPanel extends JPanel {

	/**
	 * shut up compiler
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passField;
	private JTextField userField;

	/**
	 * Create the panel.
	 */
	public LoginPanel(Hotel model) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 39, 94, 30, 0};
		gridBagLayout.rowHeights = new int[]{61, 29, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//login label
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 31));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		//email label
		JLabel lblUsername = new JLabel("E-mail:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 3;
		add(lblUsername, gbc_lblUsername);
		
		//username text field
		userField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		add(userField, gbc_textField_1);
		userField.setColumns(10);
		
		//password label
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);
		
		//password text field
		passField = new JPasswordField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		add(passField, gbc_textField);
		passField.setColumns(10);
		
		//submit button
		JButton btnSubmit = new JButton("Submit");
		//listener implemented to login
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == btnSubmit) {
					model.login(getUser(), getPass());
				}
			}
		});
		
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.fill = GridBagConstraints.BOTH;
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 5;
		add(btnSubmit, gbc_btnSubmit);

	}
	
	//returns string of what's in the username field
	public String getUser() {
		return userField.getText();
	}
	
	//returns string of what's in the password field
	//note: apparently getPassword() returns char[], so here's some dumb work around
	public String getPass() {
		StringBuilder temp = new StringBuilder();
		
		for (int i = 0; i < passField.getPassword().length; i++) {
			temp.append(Character.toString(passField.getPassword()[i]));
		}
		return temp.toString();
	}

}
