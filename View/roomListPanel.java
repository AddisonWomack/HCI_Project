package View;

import Model.Hotel;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class roomListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public roomListPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"this is where", "a room would go", "IF I HAD ONE", "", "font also gets", "a little beefier", "each line represents a room in a string format", "this string has to be used by the list to find the room"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		

	}

}
