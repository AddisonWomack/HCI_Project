package View;

import Model.Hotel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Addison on 3/30/2017.
 */
public class HotelFrame extends JFrame {

    private Hotel model;
    private JTabbedPane pane;

    public HotelFrame(Hotel model) {
        this.model = model;
        setTitle(model.getName());
        pane = new JTabbedPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pane);
    }

    public void createTab(Component component) {
        pane.add(component);
    }

    public void setTabVisibility() {
        pane.setEnabledAt(0, true);
        for (int i = 1; i < pane.getTabCount() - 1; i++) {
            pane.setEnabledAt(i, (model.getCurrentEmployee() != null));
        }
        pane.setEnabledAt(pane.getTabCount() - 1, (model.getCurrentEmployee() != null) && model.getCurrentEmployee().isAdmin());
    }

}
