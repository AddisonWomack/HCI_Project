package View;

import Model.Hotel;
import Model.Room;

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
import java.util.ArrayList;

public class roomListPanel extends JPanel {

	private Hotel model;

	/**
	 * Create the panel.
	 */
	public roomListPanel(Hotel model) {

		this.model = model;

		setName("Rooms");

		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		ArrayList<Room> roomlist = model.getRooms();
		String[] values = new String[roomlist.size()];
		for(int i = 0; i < roomlist.size(); i++) {
			Room r = roomlist.get(i);
			values[i] = r.toString();
		}
		JList<String> list = new JList<String>(values);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(list);
		

	}

}
