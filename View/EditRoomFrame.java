package View;

import Model.Hotel;
import Model.Room;
import Model.RoomLayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EditRoomFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	
	/**
	 * Create the frame.
	 */
	public EditRoomFrame(Hotel h, Room r) implements Listener {
		h.addListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{106, 5, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel titleLabel = new JLabel("Edit Room");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridheight = 2;
		gbc_titleLabel.gridwidth = 3;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		contentPane.add(titleLabel, gbc_titleLabel);
		
		JLabel roomIDLabel = new JLabel("Room ID");
		GridBagConstraints gbc_roomIDLabel = new GridBagConstraints();
		gbc_roomIDLabel.anchor = GridBagConstraints.EAST;
		gbc_roomIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roomIDLabel.gridx = 0;
		gbc_roomIDLabel.gridy = 2;
		contentPane.add(roomIDLabel, gbc_roomIDLabel);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 2;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		textField_4.setText(r.getID());
		
		JLabel floorLabel = new JLabel("Floor");
		GridBagConstraints gbc_floorLabel = new GridBagConstraints();
		gbc_floorLabel.anchor = GridBagConstraints.EAST;
		gbc_floorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_floorLabel.gridx = 0;
		gbc_floorLabel.gridy = 3;
		contentPane.add(floorLabel, gbc_floorLabel);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		textField_3.setText(""+r.getFloor());
		
		JLabel layoutLabel = new JLabel("Room Layout");
		GridBagConstraints gbc_layoutLabel = new GridBagConstraints();
		gbc_layoutLabel.anchor = GridBagConstraints.EAST;
		gbc_layoutLabel.insets = new Insets(0, 0, 5, 5);
		gbc_layoutLabel.gridx = 0;
		gbc_layoutLabel.gridy = 4;
		contentPane.add(layoutLabel, gbc_layoutLabel);
		
		JComboBox<RoomLayout> comboBox = new JComboBox<RoomLayout>(RoomLayout.values());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r.setID(textField_4.getText());
				r.setFloor(Integer.parseInt(textField_3.getText()));
				r.setLayout((RoomLayout)comboBox.getSelectedItem());
				h.notifyListeners();
				setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.gridwidth = 2;
		gbc_editButton.insets = new Insets(0, 0, 0, 5);
		gbc_editButton.gridx = 0;
		gbc_editButton.gridy = 5;
		contentPane.add(editButton, gbc_editButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				h.removeRoom(r);
				h.notifyListeners();
				setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 2;
		gbc_deleteButton.gridy = 5;
		contentPane.add(deleteButton, gbc_deleteButton);
		
		this.setVisible(true);
	}

}
