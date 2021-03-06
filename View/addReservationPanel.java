package View;

import Model.Guest;
import Model.Hotel;
import Model.Listener;
import Model.RoomLayout;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class addReservationPanel extends JPanel {

	private Hotel model;

	private JTextField day1;
	private JTextField month1;
	private JTextField year1;
	private JTextField day2;
	private JTextField month2;
	private JTextField year2;
	private JLabel lblAddReservation;
	private JLabel lblGuestName;
	private JLabel lblGuestEmail;
	private JLabel lblifNewGuest;
	private JLabel lblGuestPhoneNumber;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblRequestedLayout;
	private JComboBox<RoomLayout> comboBox;
	
	public JDatePickerImpl startdatePicker;
	public JDatePickerImpl enddatePicker;
	JDatePanelImpl startdatePanel;
	JDatePanelImpl enddatePanel;
	UtilDateModel startutilModel = new UtilDateModel();
	UtilDateModel endutilModel = new UtilDateModel();

	/**
	 * Create the panel.
	 */
	public addReservationPanel(Hotel model) {

		this.model = model;

		setName("Add Reservation");

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		// adds datepicker functionality
		startdatePanel = new JDatePanelImpl(startutilModel, p);
		startdatePicker = new JDatePickerImpl(startdatePanel, new DateLabelFormatter());
		startdatePicker.setBackground(Color.WHITE);

		enddatePanel = new JDatePanelImpl(endutilModel, p);
		enddatePicker = new JDatePickerImpl(enddatePanel, new DateLabelFormatter());
		enddatePicker.setBackground(Color.WHITE);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblAddReservation = new JLabel("Add Reservation");
		lblAddReservation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAddReservation = new GridBagConstraints();
		gbc_lblAddReservation.gridheight = 2;
		gbc_lblAddReservation.gridwidth = 4;
		gbc_lblAddReservation.insets = new Insets(0, 0, 5, 0);
		gbc_lblAddReservation.gridx = 0;
		gbc_lblAddReservation.gridy = 0;
		add(lblAddReservation, gbc_lblAddReservation);
		
		JLabel lblStartDateddmmyyyy = new JLabel("Start Date (DD/MM/YYYY)");
		GridBagConstraints gbc_lblStartDateddmmyyyy = new GridBagConstraints();
		gbc_lblStartDateddmmyyyy.anchor = GridBagConstraints.EAST;
		gbc_lblStartDateddmmyyyy.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDateddmmyyyy.gridx = 0;
		gbc_lblStartDateddmmyyyy.gridy = 2;
		add(lblStartDateddmmyyyy, gbc_lblStartDateddmmyyyy);
		
		//day1 = new JTextField();
		GridBagConstraints gbc_day1 = new GridBagConstraints();
		gbc_day1.gridwidth = 3;
		gbc_day1.insets = new Insets(0, 0, 5, 5);
		gbc_day1.fill = GridBagConstraints.HORIZONTAL;
		gbc_day1.gridx = 1;
		gbc_day1.gridy = 2;
		add(startdatePicker, gbc_day1);
		//day1.setColumns(2);
		startdatePicker.setToolTipText("Enter a day.");
		
		JLabel lblEndDateddmmyyyy = new JLabel("End Date (DD/MM/YYYY)");
		GridBagConstraints gbc_lblEndDateddmmyyyy = new GridBagConstraints();
		gbc_lblEndDateddmmyyyy.anchor = GridBagConstraints.EAST;
		gbc_lblEndDateddmmyyyy.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDateddmmyyyy.gridx = 0;
		gbc_lblEndDateddmmyyyy.gridy = 3;
		add(lblEndDateddmmyyyy, gbc_lblEndDateddmmyyyy);
		
		//day2 = new JTextField();
		GridBagConstraints gbc_day2 = new GridBagConstraints();
		gbc_day2.gridwidth = 3;
		gbc_day2.insets = new Insets(0, 0, 5, 5);
		gbc_day2.fill = GridBagConstraints.HORIZONTAL;
		gbc_day2.gridx = 1;
		gbc_day2.gridy = 3;
		add(enddatePicker, gbc_day2);
		//day2.setColumns(2);
		enddatePicker.setToolTipText("Enter a day.");
		
		lblGuestEmail = new JLabel("Guest Email");
		GridBagConstraints gbc_lblGuestEmail = new GridBagConstraints();
		gbc_lblGuestEmail.anchor = GridBagConstraints.EAST;
		gbc_lblGuestEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestEmail.gridx = 0;
		gbc_lblGuestEmail.gridy = 4;
		add(lblGuestEmail, gbc_lblGuestEmail);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		textField_2.setToolTipText("Enter a verifiable email address.");
		
		lblGuestName = new JLabel("Guest Name (First/Last)*");
		GridBagConstraints gbc_lblGuestName = new GridBagConstraints();
		gbc_lblGuestName.anchor = GridBagConstraints.EAST;
		gbc_lblGuestName.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestName.gridx = 0;
		gbc_lblGuestName.gridy = 5;
		add(lblGuestName, gbc_lblGuestName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setToolTipText("Enter the guest's first name.");
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 5;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		textField_1.setToolTipText("Enter the guest's last name.");
		
		lblGuestPhoneNumber = new JLabel("Guest Phone Number*");
		GridBagConstraints gbc_lblGuestPhoneNumber = new GridBagConstraints();
		gbc_lblGuestPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblGuestPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestPhoneNumber.gridx = 0;
		gbc_lblGuestPhoneNumber.gridy = 6;
		add(lblGuestPhoneNumber, gbc_lblGuestPhoneNumber);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 6;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		textField_3.setToolTipText("Enter the guest's phone number.");
		
		lblRequestedLayout = new JLabel("Requested Layout");
		GridBagConstraints gbc_lblRequestedLayout = new GridBagConstraints();
		gbc_lblRequestedLayout.anchor = GridBagConstraints.EAST;
		gbc_lblRequestedLayout.insets = new Insets(0, 0, 5, 5);
		gbc_lblRequestedLayout.gridx = 0;
		gbc_lblRequestedLayout.gridy = 7;
		add(lblRequestedLayout, gbc_lblRequestedLayout);
		
		comboBox = new JComboBox<RoomLayout>(RoomLayout.values());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 7;
		add(comboBox, gbc_comboBox);
		comboBox.setToolTipText("Select the guest's preferred room layout.");
		
		JButton btnAddReservation = new JButton("Add Reservation");
		btnAddReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = textField_2.getText();
				Guest g = model.getGuest(email);
				if(g == null) {
					g = new Guest(textField.getText(), textField_1.getText(), email, textField_3.getText());
					model.addGuest(textField.getText(), textField_1.getText(), email, textField_3.getText());
				}
				try{
					String sdate = startdatePicker.getJFormattedTextField().getText();
					String[] sArray = sdate.split("-");
					
					String edate = enddatePicker.getJFormattedTextField().getText();
					String[] eArray = edate.split("-");
					
					int sday = Integer.parseInt(sArray[1]);
					int smonth = Integer.parseInt(sArray[0]);
					int syear = Integer.parseInt(sArray[2]);
					int eday = Integer.parseInt(eArray[1]);
					int emonth = Integer.parseInt(eArray[0]);
					int eyear = Integer.parseInt(eArray[2]);
					if(eyear < syear || (eyear == syear && emonth < smonth) || (eyear == syear && emonth == smonth && eday <= sday))
						throw new Exception();
					model.addReservation(syear, smonth, sday, eyear, emonth, eday, (RoomLayout)comboBox.getSelectedItem(), email, "sampleemployeeemail@idunno.com");
					JOptionPane.showMessageDialog(addReservationPanel.this, "Reservation added successfully");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(addReservationPanel.this, "Enter an end date that is after the start date.", "Date error",  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnAddReservation = new GridBagConstraints();
		gbc_btnAddReservation.gridwidth = 2;
		gbc_btnAddReservation.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddReservation.gridx = 0;
		gbc_btnAddReservation.gridy = 8;
		add(btnAddReservation, gbc_btnAddReservation);
		btnAddReservation.setToolTipText("Click this button to add the completed reservation to\nthe reservation list.");
		
		lblifNewGuest = new JLabel("*If new guest");
		GridBagConstraints gbc_lblifNewGuest = new GridBagConstraints();
		gbc_lblifNewGuest.gridx = 3;
		gbc_lblifNewGuest.gridy = 8;
		add(lblifNewGuest, gbc_lblifNewGuest);

	}
}
