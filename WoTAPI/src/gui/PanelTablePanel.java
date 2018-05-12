package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

public class PanelTablePanel extends JPanel{
	public PanelTablePanel() {
		super();
		setLayout(new BorderLayout());
		JTable table =new JTable(new TableModelSpieler());
		add(table, BorderLayout.CENTER);
		setVisible(true);
	}
}
