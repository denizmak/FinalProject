
/**
 * @author kay
 * @version 1.0
 * @created 16-Oct-2014 6:31:26 PM
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class MyReservationGUI extends JFrame{

	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean LEFT_TO_RIGHT = false;
	JButton exit = new JButton("Exit");


	public MyReservationGUI(){
		super();
		setResizable(false);
		
		}
	
	 public void addComponentsToPane(final Container pane){

		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.setPreferredSize(new Dimension(500,500));
		
		JLabel Reservation = new JLabel("The following is(are) the information of your reservation:");
		pane.add(Reservation);
		Dimension minSize = new Dimension(0, 30);
		Dimension prefSize = new Dimension(0, 30);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 20);
		pane.add(new Box.Filler(minSize, prefSize, maxSize));
		
		String[] columnNames = {"Year", "Month", "Day", "Hour", "Minute", "Field", "Type", ""};
		Object[][] data = {{"2014", "November", "20", "20", "00", "Soccer Field", "Full Field","Cancel Reservation"},
				{"2014", "November", "30", "22", "00", "BasketBall Field", "Full Field", "Cancel Reservation"}};
		

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable(model);
		table.getColumn("").setCellRenderer(new ButtonRenderer());
		table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		pane.add(table.getTableHeader());
		pane.add(table);
		Dimension minSize1 = new Dimension(0, 300);
		Dimension prefSize1 = new Dimension(0, 300);
		Dimension maxSize1 = new Dimension(Short.MAX_VALUE, 300);
		pane.add(new Box.Filler(minSize1, prefSize1, maxSize1));
		
		JPanel button = new JPanel();
		JButton exit = new JButton("Exit");
		button.setAlignmentY(Component.CENTER_ALIGNMENT);
		button.add(exit);
		pane.add(button);
		
		 
		exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//System.exit(0);
					setVisible(false);		//TODO uncomment
				}
			});	
		
	}
	

	public class ButtonRenderer extends JButton implements TableCellRenderer {
		
		public ButtonRenderer(){
			setOpaque(true);
		}
	
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			if (isSelected){
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}setText((value == null) ? "" : value.toString());
			return this;
		}
	}
	
	public class ButtonEditor extends DefaultCellEditor {

		protected JButton button;
		private String label;
		private boolean isPushed;
		private ActionListener action;
		
		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			fireEditingStopped();
		}
			
		public void actionPerformed(ActionEvent e)
		{
			JTable table = new JTable();
			int row = table.convertRowIndexToModel(table.getEditingRow() );
			fireEditingStopped();

			//  Invoke the Action

			ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, "" + row);
			action.actionPerformed(event);
		}
			

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) {
			if(isSelected){
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());				
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}
	    @Override
	    public boolean stopCellEditing() {
	        isPushed = false;
	        return super.stopCellEditing();
	    }

	    @Override
	    protected void fireEditingStopped() {
	        super.fireEditingStopped();
	    }

	}

	public static void createAndShowGUI() {
         
	        //Create and set up the window.
	        MyReservationGUI frame = new MyReservationGUI();
	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(new Dimension(999, 555));  //TODO 888,555
			frame.setLocationRelativeTo(null);;
	        //Set up the content pane.
	        frame.addComponentsToPane(frame.getContentPane());
	        //Use the content pane's default BorderLayout. No need for
	        //setLayout(new BorderLayout());
	        //Display the window.
	       // frame.pack();					// TODO comment
	        frame.setVisible(true);
	    }
}//end myReservationGUI