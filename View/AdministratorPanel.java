package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Addison on 4/11/2017.
 */
public class AdministratorPanel extends JPanel {
    private Hotel model;

    public AdministratorPanel(Hotel model) {
        this.model = model;
        setName("Admin");
        setLayout(new GridLayout(2,1));

        add(new AdminEmployeePanel());
        add(new AdminFunctionPanel(model));

    }

}
