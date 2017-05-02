package View;

import org.jdatepicker.impl.*;

import Model.Hotel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Properties;
import java.awt.Color;

public class CalendarPanel extends JPanel {

	UtilDateModel utilModel = new UtilDateModel();
	JDatePanelImpl datePanel;
	public JDatePickerImpl datePicker;

	/**
	 * shut up compiler
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CalendarPanel(Hotel model) {
		setName("Reservations");
		setLayout(new BorderLayout(0, 0));

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		datePanel = new JDatePanelImpl(utilModel, p);

		DateInfo dateInfo = new DateInfo(model, this);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBackground(Color.WHITE);

		add(datePicker, BorderLayout.NORTH);
		add(dateInfo, BorderLayout.CENTER);


	}
}
