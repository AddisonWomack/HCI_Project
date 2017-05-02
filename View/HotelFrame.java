package View;

import Model.Hotel;
import Model.Listener;

import javax.swing.*;
import java.awt.*;

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
        int height = 600;
        setMinimumSize(new Dimension(1618 * height / 1000,height));
        setSize(1618 * height / 1000,height);
        setLayout(new BorderLayout());
        pane = new JTabbedPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pane, BorderLayout.CENTER);
        add(new CurrentEmployeeInfoPanel(model), BorderLayout.NORTH);
        add(new JLabel("\u00a9" + " 2017 Radhakrishnan's Raptors Inc."), BorderLayout.SOUTH); // add copyright logo
        init();
    }

    private void init() {
        LoginPanel loginPanel = new LoginPanel(model);

        addReservationPanel addReservationPanel = new addReservationPanel(model);

        roomListPanel roomListPanel = new roomListPanel(model);

        AdminPanel adminPanel = new AdminPanel(model);

        CalendarPanel calendarPanel = new CalendarPanel(model);

        pane.add(loginPanel);
        pane.setToolTipTextAt(0,"menu for logging into your account");

        pane.add(addReservationPanel);
        pane.setToolTipTextAt(1,"menu for adding, removing, and editing reservations");

        pane.add(roomListPanel);
        pane.setToolTipTextAt(2, "menu for adding, removing, editing, and reporting and resolving" +
                " problems that rooms have.");

        pane.add(calendarPanel);
        pane.setToolTipTextAt(3,"menu for viewing a calendar that links to all of the rooms");

        pane.add(adminPanel);
        pane.setToolTipTextAt(4,"menu for editing hotel information, creating, editing, and deleting" +
                "employees, and shutting down the hotel");

        setTabVisibility();
    }

    private void setTabVisibility() {

        if (model.getCurrentEmployee() == null) {
            pane.setEnabledAt(0, true);
            pane.setSelectedIndex(0); // selects login screen
            for (int i = 1; i < pane.getTabCount(); i++) {
                pane.setEnabledAt(i, false);
            }

        } else {
            pane.setEnabledAt(0,false);
            for (int i = 1; i < pane.getTabCount() - 1; i++) {
                pane.setEnabledAt(i, true);
            }
            pane.setEnabledAt(pane.getTabCount() - 1, model.getCurrentEmployee().isAdmin());
            if (pane.getSelectedIndex() == 0) pane.setSelectedIndex(1); // selects logout screen
        }
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
