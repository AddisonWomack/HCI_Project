package View;

import Model.Hotel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Addison on 3/30/2017.
 */
public class HomePanel extends JPanel{

    private Hotel model;

    public HomePanel(Hotel model) {
        this.model = model;
        setName("Home");
        setLayout(new BorderLayout());
        JLabel nameLabel = new JLabel(model.getName());
        add(nameLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        // center
        /*
        public void setName(String name) {
        this.name = name;
        notifyListeners();
    }

    public void setAddress(String address) {
        this.address = address;
        notifyListeners();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyListeners();
    }

         */
    }
}
