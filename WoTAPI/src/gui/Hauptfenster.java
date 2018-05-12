package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Hauptfenster extends JFrame {
	public Hauptfenster() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,800);
		
		setJMenuBar(createJMenuBar());
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new PanelTablePanel());
		
		setVisible(true);
	}
	private JMenuBar createJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		return menuBar;
	}
}
