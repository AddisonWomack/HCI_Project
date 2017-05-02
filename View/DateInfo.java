package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import Model.Hotel;
import Model.Reservation;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JList;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

/**
 * 
 * Created by James Augustus Ferguson, 4/4/2017
 */ 

public class DateInfo extends JPanel{
	/**
	 * shut up compiler
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** 
	 * creates the pane
	 */
	
	public DateInfo(Hotel model, CalendarPanel cp) {
		setLayout(new BorderLayout(0, 0));

		// create list model, and list, add to frame initialized with a text string
		DefaultListModel<String> dModel = new DefaultListModel<String>();
		dModel.addElement("Calendar Panel - Display currently made reservations encompassing a given date!");
		dModel.addElement(" ");
		dModel.addElement("Select the date by clicking the '...' in the top right.");
		dModel.addElement("After selecting the date, click 'UPDATE'. The list will populate itself with reservations that include that date.");
		JList<String> list = new JList<String>(dModel);
		add(list, BorderLayout.CENTER);
		
		// create button with listener
		JButton btnUpdate = new JButton("== UPDATE ==");
		btnUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnUpdate) {
					
					// clear/reset the model
					dModel.clear();
					
					// spaghetti way to get the array of reservations
					String date = cp.datePicker.getJFormattedTextField().getText();
					String[] dArray = date.split("-");
					ArrayList<Reservation> rArray;
					
					if (date.isEmpty()) {
						rArray = model.getReservationsByDate(00, 00, 0000);
					} else {
						rArray = model.getReservationsByDate(Integer.parseInt(dArray[2]), Integer.parseInt(dArray[0]), Integer.parseInt(dArray[1]));
					}
					
					// check for null and emptiness
					if (rArray != null && (!(rArray.isEmpty()))) {
						
						// iterate through and create a three-line formatted string
						for (Reservation r: rArray) {
							dModel.addElement("Type: " + r.getRequestedLayout().toString() + " - Start: " + r.getStart().get(Calendar.MONTH) + "-" + r.getStart().get(Calendar.DAY_OF_MONTH) 
									+ "-" + r.getStart().get(Calendar.YEAR) + " - End: " + r.getEnd().get(Calendar.MONTH) + "-" + r.getEnd().get(Calendar.DAY_OF_MONTH) 
									+ "-" + r.getEnd().get(Calendar.YEAR));
							dModel.addElement("Name: " + r.getGuest().getFullName() + " - Phone: " + r.getGuest().getPhoneNumber() + " - Email: " + r.getGuest().getEMailAddress());
							dModel.addElement(" ");
						}
						
					} else {
						// and in case rArray is null or empty, display there's an issue
						dModel.addElement("ERROR: null or empty");
					}
					
					// reset the model of the list
					list.setModel(dModel);
				}
			}
			
		});
		
		// add the button to the frame post-listener implementation
		add(btnUpdate, BorderLayout.NORTH);
		

	}
}
