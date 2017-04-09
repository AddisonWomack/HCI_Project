package View;

import org.jdatepicker.impl.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Properties;
import java.awt.Color;

public class CalendarPanel extends JPanel {

	/**
	 * shut up compiler
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CalendarPanel() {
		setLayout(new BorderLayout(0, 0));
		
		Properties p = new Properties();
		p.put("text.day", "Day");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePanel.setBackground(Color.WHITE);
		
		add(datePanel, BorderLayout.CENTER);
		
		
	}
}
