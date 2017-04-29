package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JTextField emailAddressField;
    private JButton logOutButton;

    public CurrentEmployeeInfoPanel(Hotel model) {
        this.model = model;
        this.model.addListener(this);
        this.nameLabel = new JLabel("Employee Name:");
        this.phoneNumberLabel = new JLabel("Phone Number:");
        this.emailAddressLabel = new JLabel("EmailAddress");
        this.logOutButton = new JButton("Log Out");
        logOutButton.setEnabled(false);
        logOutButton.setVisible(false);
        setLayout(new GridLayout(1,8));

        firstNameField = new JTextField();
        firstNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setFirstName(firstNameField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setFirstName(firstNameField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setFirstName(firstNameField.getText());
            }
        });

        lastNameField = new JTextField();
        lastNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setLastName(lastNameField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setLastName(lastNameField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setLastName(lastNameField.getText());
            }
        });

        phoneNumberField = new JTextField();
        phoneNumberField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setPhoneNumber(phoneNumberField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setPhoneNumber(phoneNumberField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setPhoneNumber(phoneNumberField.getText());
            }
        });

        emailAddressField = new JTextField();
        emailAddressField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setEMailAddress(emailAddressField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setEMailAddress(emailAddressField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.getCurrentEmployee().setEMailAddress(emailAddressField.getText());
            }
        });


        add(nameLabel);
        add(firstNameField);
        add(lastNameField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(emailAddressLabel);
        add(emailAddressField);
        add(logOutButton);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure that you want to log out?", null, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) model.logout();
            }
        });

        // makes the employee info initially null, since no employee will be logged in
        setFieldDisplay(false);
    }

    public void updated() {
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            if (model.getCurrentEmployee() != null) {
                setFieldDisplay(true);
                firstNameField.setText(model.getCurrentEmployee().getFirstName());
                lastNameField.setText(model.getCurrentEmployee().getLastName());
                phoneNumberField.setText(model.getCurrentEmployee().getPhoneNumber());
                emailAddressField.setText(model.getCurrentEmployee().getEMailAddress());
            } else {
                setFieldDisplay(false);
            }
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }

    private void setFieldDisplay(boolean isLoggedIn) {
        nameLabel.setVisible(isLoggedIn);
        firstNameField.setEnabled(isLoggedIn);
        firstNameField.setVisible(isLoggedIn);
        lastNameField.setEnabled(isLoggedIn);
        lastNameField.setVisible(isLoggedIn);
        phoneNumberLabel.setVisible(isLoggedIn);
        phoneNumberField.setEnabled(isLoggedIn);
        phoneNumberField.setVisible(isLoggedIn);
        emailAddressLabel.setVisible(isLoggedIn);
        emailAddressField.setEnabled(isLoggedIn);
        emailAddressField.setVisible(isLoggedIn);
        logOutButton.setEnabled(isLoggedIn);
        logOutButton.setVisible(isLoggedIn);
    }
}
