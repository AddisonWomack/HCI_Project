package View;

import Model.Hotel;
import Model.Listener;
import Model.Room;
import Model.RoomLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
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
	private RoomInfo roomInfo;
	private JList<String> list;

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
		list = new JList<String>(listModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  roomInfo.updated();
                }
            }
        });
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
		
		roomInfo = new RoomInfo(list,model);
		//roomInfo.setEditable(false);
		GridBagConstraints gbc_roomInfo = new GridBagConstraints();
		gbc_roomInfo.fill = GridBagConstraints.BOTH;
		gbc_btnResolve.gridx = 1;
		gbc_btnResolve.gridy = 1;
		add(roomInfo, gbc_roomInfo);
		roomInfo.setToolTipText("Room information will appear here when a room is selected.");
		scrollPane.setViewportView(list);

		JButton btnCheckIn = new JButton("Check-In");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null){
					String rID = list.getSelectedValue().split(" ")[0];
					System.out.println("rID = " + rID);
					String guestEmail = JOptionPane.showInputDialog(null, "Enter guest e-mail address");
					model.checkInGuest(guestEmail, model.getCurrentEmployee().getEMailAddress(), rID);
				}
			}
		});
		GridBagConstraints gbc_btnCheckIn = new GridBagConstraints();
		gbc_btnCheckIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheckIn.gridx = 0;
		gbc_btnCheckIn.gridy = 2;
		add(btnCheckIn, gbc_btnCheckIn);
		btnCheckIn.setToolTipText("Check in guest.");

		JButton btnCheckOut = new JButton("Check-Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null) {
					String rID = list.getSelectedValue().split(" ")[0];
					String guestEmail = JOptionPane.showInputDialog(null, "Enter guest e-mail address");
					model.checkOutGuest(guestEmail, rID);
				}
			}
		});
		GridBagConstraints gbc_btnCheckOut = new GridBagConstraints();
		gbc_btnCheckOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheckOut.gridx = 1;
		gbc_btnCheckOut.gridy = 2;
		add(btnCheckOut, gbc_btnCheckOut);
		btnResolve.setToolTipText("Check-Out");

		JButton btnissue = new JButton("Make Issue");
		btnissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room r = model.getRoom(list.getSelectedValue());
				RoomIssueView newIssue = new RoomIssueView(r.getID(), model);
			}
		});
		GridBagConstraints gbc_btnissue = new GridBagConstraints();
		gbc_btnissue.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnissue.gridx = 3;
		gbc_btnissue.gridy = 1;
		add(btnissue, gbc_btnissue);
		btnResolve.setToolTipText("If there is an issue with the room, click this button to fill in the issue.");

	}
	
	public void updated() {
		listModel.removeAllElements();
        ArrayList<Room> roomlist = model.getRooms();
    	for(int i = 0; i < roomlist.size(); i++) {
    		Room r = roomlist.get(i);
            listModel.addElement(r.toString()); 
    	}
    	//roomInfo.setText(list.getSelectedValue());
	}
}