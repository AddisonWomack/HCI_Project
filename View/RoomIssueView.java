package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Model.Hotel;
import Model.Room;
import Model.RoomIssue;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RoomIssueView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public RoomIssueView(String roomNumber, Hotel h) {
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblIssueName = new JLabel("Description: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIssueName, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIssueName, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblIssueName);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDateOfIssue, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDateOfIssue, 0, SpringLayout.WEST, lblIssueName);
		contentPane.add(lblDateOfIssue);
		
		JLabel lblDateOfResolution = new JLabel("Date of Resolution");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDateOfResolution, 0, SpringLayout.WEST, lblIssueName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDateOfResolution, -6, SpringLayout.NORTH, lblIssueName);
		contentPane.add(lblDateOfResolution);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblIssueName);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, -10, SpringLayout.EAST, contentPane);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl fred = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(fred, null);
		sl_contentPane.putConstraint(SpringLayout.NORTH, datePicker, 0, SpringLayout.NORTH, lblDateOfIssue);
		sl_contentPane.putConstraint(SpringLayout.WEST, datePicker, 6, SpringLayout.EAST, lblDateOfIssue);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, datePicker, -1, SpringLayout.NORTH, lblDateOfResolution);
		contentPane.add(datePicker);
		
		UtilDateModel model2 = new UtilDateModel();
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl dp = new JDatePanelImpl(model2, p2);
		JDatePickerImpl thatPicker = new JDatePickerImpl(dp, null);
		sl_contentPane.putConstraint(SpringLayout.NORTH, thatPicker, 0, SpringLayout.NORTH, lblDateOfResolution);
		sl_contentPane.putConstraint(SpringLayout.WEST, thatPicker, 6, SpringLayout.EAST, lblDateOfResolution);
		contentPane.add(thatPicker);
		
		JButton btnAddIssue = new JButton("Add Issue");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddIssue, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_2, -6, SpringLayout.NORTH, btnAddIssue);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAddIssue, -10, SpringLayout.SOUTH, contentPane);
		btnAddIssue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				Date issueStart = new Date();
				issueStart.setDate(model.getDay());
				issueStart.setMonth(model.getMonth());
				issueStart.setYear(model.getYear());
				RoomIssue r = new RoomIssue(issueStart, textField_2.getText());
				try{
					Date issueEnd = new Date(model2.getYear(), model2.getMonth(), model2.getDay());
					//issueEnd.setDate(model2.getDay());
					//issueEnd.setMonth(model2.getMonth());
					//issueEnd.setYear(model2.getYear());
					if(model2.getDay() != new Date().getDay())
					r.resolve(issueEnd);
				} catch (Error e) {
					
				}
				h.getRoom(roomNumber + " ").addProblem(r, false);
				h.notifyListeners();
				setVisible(false);
			}
		});
		contentPane.add(btnAddIssue);
	}
}
