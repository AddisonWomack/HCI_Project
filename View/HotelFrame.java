package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Addison on 3/30/2017.
 */
public class HotelFrame extends JFrame implements Listener {

    private Hotel model;
    private JTabbedPane pane;

    public HotelFrame(Hotel model) {
        this.model = model;
        this.model.addListener(this);
        setTitle(model.getName());
        setLayout(new BorderLayout());
        pane = new JTabbedPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pane, BorderLayout.CENTER);
        add(new CurrentEmployeeInfoPanel(model), BorderLayout.NORTH);
        add(new JLabel("\u00a9" + " 2017 Radhakrishnan's Raptors Inc."), BorderLayout.SOUTH); // add copyright logo
        init();
        setSize(600,400);
    }

    private void init() {
        LoginPanel loginPanel = new LoginPanel(model);

        addReservationPanel addReservationPanel = new addReservationPanel(model);

        roomListPanel roomListPanel = new roomListPanel(model);

        AdministratorPanel adminPanel = new AdministratorPanel(model);

        createTab(loginPanel);

        createTab(addReservationPanel);

        createTab(roomListPanel);

        createTab(adminPanel);
    }

    private void createTab(Component component) {
        pane.add(component);
    }

    private void setTabVisibility() {
        pane.setEnabledAt(0, true);
        for (int i = 1; i < pane.getTabCount() - 1; i++) {
            pane.setEnabledAt(i, (model.getCurrentEmployee() != null));
        }
        pane.setEnabledAt(pane.getTabCount() - 1, (model.getCurrentEmployee() != null) && model.getCurrentEmployee().isAdmin());
    }

    public void updated() {
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            setTitle(model.getName());
            setTabVisibility();
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }

}
