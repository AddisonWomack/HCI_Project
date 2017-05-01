package View;

import Model.Hotel;
import Model.Listener;
import Model.Room;
import Model.RoomLayout;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class roomListPanel extends JPanel implements Listener{

	private Hotel model;
	static DefaultListModel listModel;

	/**
	 * Create the panel.
	 */
	public roomListPanel(Hotel model) {

		this.model = model;
		model.addListener(this);

		setName("Rooms");
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {175, 175, 175, 0};
		gridBagLayout.rowHeights = new int[]{300, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
				
		JScrollPane scrollPane = new JScrollPane();
		
		ArrayList<Room> roomlist = model.getRooms();
		//String[] values = new String[roomlist.size()];
        listModel = new DefaultListModel();

		for(int i = 0; i < roomlist.size(); i++) {
			Room r = roomlist.get(i);
			//values[i] = r.toString();
            listModel.addElement(r.toString());
		}
		JList<String> list = new JList<String>(listModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		scrollPane.setToolTipText("Please select a room from this list to view and edit its details.");
		
		JButton btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 1;
		add(btnCreate, gbc_btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room r = new Room("New Room", -1, RoomLayout.STANDARDSUITE);
				model.addRoom(r);
				EditRoomFrame erf = new EditRoomFrame(model, r);
			}
		});
		btnCreate.setToolTipText("Create a room that previously didn't exist.");
		
		JButton btnED = new JButton("Edit/Delete");
		btnED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room r = model.getRoom(list.getSelectedValue());
				EditRoomFrame  erf = new EditRoomFrame(model, r);
			}
		});
		GridBagConstraints gbc_btnED = new GridBagConstraints();
		gbc_btnED.insets = new Insets(0, 0, 0, 5);
		gbc_btnED.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnED.gridx = 1;
		gbc_btnED.gridy = 1;
		add(btnED, gbc_btnED);
		btnED.setToolTipText("Edit or Delete and existing room.");
		
		JButton btnResolve = new JButton("Resolve Issue");
		btnResolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room r = model.getRoom(list.getSelectedValue());
				r.openRoom();
				r.resolveIssue();
			}
		});
		GridBagConstraints gbc_btnResolve = new GridBagConstraints();
		gbc_btnResolve.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnResolve.gridx = 2;
		gbc_btnResolve.gridy = 1;
		add(btnResolve, gbc_btnResolve);
		btnResolve.setToolTipText("If the issue with the room is resolved, click this button.");
		
		scrollPane.setViewportView(list);
	}
	
	public void updated() {
		listModel.removeAllElements();
        ArrayList<Room> roomlist = model.getRooms();
    	for(int i = 0; i < roomlist.size(); i++) {
    		Room r = roomlist.get(i);
            listModel.addElement(r.toString()); 
    	}
	}
}