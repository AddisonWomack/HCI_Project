package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Addison on 4/18/2017.
 */
public class AdminFunctionPanel extends JPanel implements Listener{
    private Hotel model;
    private JTextField hotelName;
    private JTextField phoneNumber;
    private JTextField address;
    public AdminFunctionPanel(Hotel model) {
        this.model = model;
        JLabel titleLabel = new JLabel("Edit Hotel Properties");

        JLabel nameLabel = new JLabel("Hotel Name:");

        hotelName = new JTextField(model.getName());

        JLabel phoneLabel = new JLabel("Phone Number:");

        phoneNumber = new JTextField(model.getPhoneNumber());

        JLabel addressLabel = new JLabel("Address:");

        address = new JTextField(model.getAddress());

        JButton saveButton = new JButton("Save Hotel Properties");

        JButton emergencyButton = new JButton("SHUTDOWN HOTEL");
        emergencyButton.setBackground(Color.RED);

        add(new AdminEmployeePanel());

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

        emergencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pword = JOptionPane.showInputDialog(null, "Enter Password to Continue Hotel Shutdown.");

                System.out.println(pword);
                if (pword != null) {
                    if (model.shutDown(pword)) {
                        JOptionPane.showMessageDialog(null,"Hotel Shutdown Successful","Shutdown Successful", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Password Shutdown Failed", "Shutdown Failed",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
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
