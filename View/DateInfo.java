package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;
import java.util.GregorianCalendar;

import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.SpringLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Created by James Augustus Ferguson, 4/4/2017
 */ 

public class DateInfo extends JPanel{
	/**
	 * shut up compiler
	 */
	private static final long serialVersionUID = 1L;
	private TableModel dataModel = new AbstractTableModel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public int getColumnCount() { return 1;}
		public int getRowCount() { return 10;}
		public Object getValueAt(int row, int col) { return new Integer(row*col); }
	};
	private JTable table;
	
	/** 
	 * creates the pane
	 */
	
	public DateInfo() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton btnDelete = new JButton("Delete");
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, this);
		add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		springLayout.putConstraint(SpringLayout.SOUTH, btnExit, 0, SpringLayout.SOUTH, btnDelete);
		springLayout.putConstraint(SpringLayout.EAST, btnExit, -10, SpringLayout.EAST, this);
		add(btnExit);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, btnDelete);
		springLayout.putConstraint(SpringLayout.SOUTH, table, -6, SpringLayout.NORTH, btnDelete);
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, btnExit);
		add(table);
		

	}
}
