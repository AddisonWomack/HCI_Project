package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Addison on 4/23/2017.
 */
public class CurrentEmployeeInfoPanel extends JPanel implements Listener {
    private Hotel model;
    private JLabel nameLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailAddressLabel;
    private JButton logOutButton;

    public CurrentEmployeeInfoPanel(Hotel model) {
        this.model = model;
        this.model.addListener(this);
        this.nameLabel = new JLabel("");
        this.phoneNumberLabel = new JLabel("");
        this.emailAddressLabel = new JLabel("");
        this.logOutButton = new JButton("Log Out");
        logOutButton.setEnabled(false);
        logOutButton.setVisible(false);
        setLayout(new GridLayout(1,4));
        add(nameLabel);
        add(phoneNumberLabel);
        add(emailAddressLabel);
        add(logOutButton);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // log-out button
            }
        });
    }

    public void updated() {
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            if (model.getCurrentEmployee() != null) {
                nameLabel.setText(model.getCurrentEmployee().getFullName());
                phoneNumberLabel.setText(model.getCurrentEmployee().getPhoneNumber());
                emailAddressLabel.setText(model.getCurrentEmployee().getEMailAddress());
                logOutButton.setEnabled(true);
                logOutButton.setVisible(true);
            } else {
                nameLabel.setText("");
                phoneNumberLabel.setText("");
                emailAddressLabel.setText("");
                logOutButton.setEnabled(false);
                logOutButton.setVisible(false);
            }
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }
}
