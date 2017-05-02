package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Addison on 4/18/2017.
 */
public class AdminPanel extends JPanel implements Listener{
    private Hotel model;
    private JTextField hotelName;
    private JTextField phoneNumber;
    private JTextField address;
    private JList<String> eList;
    private DefaultListModel listModel;
    public AdminPanel(Hotel model) {
        setName("Admin");

        this.model = model;
        model.addListener(this);
        JLabel titleLabel = new JLabel("Edit Hotel Properties");

        JLabel nameLabel = new JLabel("Hotel Name:");

        listModel = new DefaultListModel();

        hotelName = new JTextField(model.getName());

        JLabel phoneLabel = new JLabel("Phone Number:");

        phoneNumber = new JTextField(model.getPhoneNumber());

        JLabel addressLabel = new JLabel("Address:");

        address = new JTextField(model.getAddress());

        JButton saveButton = new JButton("Save Hotel Properties");

        JButton emergencyButton = new JButton("SHUTDOWN HOTEL");
        emergencyButton.setBackground(Color.RED);

        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(new GridBagLayout());

        gbc.insets = new Insets(0, 3, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JScrollPane scrollPane = new JScrollPane();

        ArrayList<Employee> employeeList = model.getEmployeesList();
        //String[] values = new String[employeeList.size()];
        for(int i = 0; i < employeeList.size(); i++) {
            Employee e = employeeList.get(i);
            //values[i] = e.toString();
            listModel.addElement(e.toString());
        }
        eList = new JList<>(listModel);
        eList.setFont(new Font("Tahoma", Font.PLAIN, 16));
        eList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(eList);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 3;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        add(scrollPane, gbc_scrollPane);
        scrollPane.setToolTipText("Please select an employee from this list to view and edit its details.");

        JButton btnCreate = new JButton("Create");
        GridBagConstraints gbc_btnCreate = new GridBagConstraints();
        gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
        gbc_btnCreate.gridx = 0;
        gbc_btnCreate.gridy = 1;
        add(btnCreate, gbc_btnCreate);
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addEmployee("New", "Employee", "TEMPORARY_EMAIL", "phone#", "password");
                EditEmployeeFrame  eef = new EditEmployeeFrame(model, model.getEmployee(("TEMPORARY_EMAIL")));
            }
        });
        btnCreate.setToolTipText("Create a new employee.");

        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (eList.getSelectedValue() != null) {
                    String targetEmail = eList.getSelectedValue().split(" ")[0];
                    EditEmployeeFrame eef = new EditEmployeeFrame(model, model.getEmployee(targetEmail));
                }
            }
        });
        GridBagConstraints gbc_btnEdit = new GridBagConstraints();
        gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
        gbc_btnEdit.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnEdit.gridx = 1;
        gbc_btnEdit.gridy = 1;
        add(btnEdit, gbc_btnEdit);
        btnEdit.setToolTipText("Edit Selected Employee");

        JButton btnDelete = new JButton("Delete Selected Employee");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String targetEmail = eList.getSelectedValue().split(" ")[0];
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete " + targetEmail + "?", "Delete Employee", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) model.fireEmployee(targetEmail);
            }
        });
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDelete.gridx = 2;
        gbc_btnDelete.gridy = 1;
        add(btnDelete, gbc_btnDelete);
        btnDelete.setToolTipText("Delete the Selected Employee");

        scrollPane.setViewportView(eList);


        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(titleLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(nameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(hotelName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(phoneLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(phoneNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(addressLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(address, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 40, 0);
        add(saveButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setName(hotelName.getText());
                model.setPhoneNumber(phoneNumber.getText());
                model.setAddress(address.getText());
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(emergencyButton, gbc);

        emergencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pword = JOptionPane.showInputDialog(null, "Enter \"I understand that I am shutting down the hotel\" to Continue Hotel Shutdown.");

                if (pword != null) {
                    if (model.shutDown(pword)) {
                        JOptionPane.showMessageDialog(null,"Hotel Shutdown Successful","Shutdown Successful", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Shutdown Failed", "Shutdown Failed",JOptionPane.ERROR_MESSAGE);
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
            listModel.removeAllElements();
            ArrayList<Employee> employeeList = model.getEmployeesList();
            for(int i = 0; i < employeeList.size(); i++) {
                Employee e = employeeList.get(i);
                listModel.addElement(e.toString());
            }
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }
}
