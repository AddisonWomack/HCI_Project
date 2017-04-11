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

	//private Hotel h;
	
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
		/*list.setModel(new AbstractListModel() {
			ArrayList<Room> roomlist = h.getRooms();
			String[] values = new String[h.getSize()];
			for(int i = 0; i < roomlist.size(); i++) {
				Room r = roomlist.get(i);
				values[i] = r.toString();
			}
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		scrollPane.setViewportView(list);
		

	}

}
