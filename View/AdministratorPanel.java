package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Addison on 4/11/2017.
 */
public class AdministratorPanel extends JPanel implements Listener{
    private Hotel model;

    private JTextField hotelName;
    private JTextField phoneNumber;
    private JTextField address;

    public AdministratorPanel(Hotel model) {
        this.model = model;
        setName("Admin");

        JLabel titleLabel = new JLabel("Edit Hotel Properties");

        JLabel nameLabel = new JLabel("Hotel Name:");

        JTextField hotelName = new JTextField(model.getName());

        JLabel phoneLabel = new JLabel("Phone Number:");

        JTextField phoneNumber = new JTextField(model.getPhoneNumber());

        JLabel addressLabel = new JLabel("Address:");

        JTextField address = new JTextField(model.getAddress());

        JButton saveButton = new JButton("Save Hotel Properties");

        JButton emergencyButton = new JButton("SHUTDOWN HOTEL");
        emergencyButton.setBackground(Color.RED);

        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(new GridBagLayout());

        gbc.insets = new Insets(0, 3, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(hotelName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(phoneLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(phoneNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addressLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(address, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 40, 0);
        add(saveButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(emergencyButton, gbc);
    }


    public void updated() {

        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            hotelName.setText(model.getName());
            phoneNumber.setText(model.getPhoneNumber());
            address.setText(model.getAddress());
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }






}
