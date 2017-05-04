package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Model.Hotel;
import Model.RoomIssue;

public class RoomIssueView extends JFrame {

	private JPanel contentPane;
	private JTextArea descriptionField;
	private JDatePickerImpl startdatePicker;
	private JDatePickerImpl enddatePicker;
	private JDatePanelImpl startdatePanel;
	private JDatePanelImpl enddatePanel;
	private UtilDateModel startutilModel;
	private UtilDateModel endutilModel;

	/**
	 * Create the frame.
	 */
	public RoomIssueView(String roomNumber, Hotel h) {

		setName("Report Room Issue");

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		startutilModel = new UtilDateModel();
		endutilModel = new UtilDateModel();

		startdatePanel = new JDatePanelImpl(startutilModel, p);
		startdatePicker = new JDatePickerImpl(startdatePanel, new DateLabelFormatter());
		startdatePicker.setBackground(Color.WHITE);

		enddatePanel = new JDatePanelImpl(endutilModel, p);
		enddatePicker = new JDatePickerImpl(enddatePanel, new DateLabelFormatter());
		enddatePicker.setBackground(Color.WHITE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 5;
		gbc.ipady = 5;
		contentPane.setLayout(layout);
		

		
		JLabel lblDateOfIssue = new JLabel("Date of Issue:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(lblDateOfIssue, gbc);


		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPane.add(startdatePicker, gbc);

		JLabel lblDateOfResolution = new JLabel("Date of Resolution");

		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPane.add(lblDateOfResolution,gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(enddatePicker, gbc);

		JCheckBox severityCheckbox = new JCheckBox("Severe");
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(severityCheckbox, gbc);

		JLabel lblIssueName = new JLabel("Description: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblIssueName,gbc);

		descriptionField = new JTextArea();
		descriptionField.setEditable(true);
		descriptionField.setToolTipText("Enter a description of the room issue here.");
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(descriptionField, gbc);
		
		JButton btnAddIssue = new JButton("Add Issue");

		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 6;
		btnAddIssue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				Date issueStart = new Date();
				issueStart.setDate(startutilModel.getDay());
				issueStart.setMonth(startutilModel.getMonth());
				issueStart.setYear(startutilModel.getYear());
				RoomIssue r = new RoomIssue(issueStart, descriptionField.getText());
				try{
					Date issueEnd = new Date(endutilModel.getYear(), endutilModel.getMonth(), endutilModel.getDay());
					if(endutilModel.getDay() != new Date().getDay())
					r.resolve(issueEnd);
				} catch (Error e) {
					
				}
				h.reportIssue(roomNumber,r, severityCheckbox.isSelected());
				setVisible(false);
			}
		});
		contentPane.add(btnAddIssue,gbc);
	}
}
