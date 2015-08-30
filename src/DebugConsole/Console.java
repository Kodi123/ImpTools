package DebugConsole;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Console extends JFrame {

	private String title = "Debug Console";
	private int width = 400;
	private int height = ( width / 16 ) * 9;
	
	private JPanel contentPane;
	private JTextPane log;
	private GridBagConstraints gbc_log;
	private GridBagLayout layout;
	
	public Console() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, width, height);
		setTitle(title);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 30, 0)); //Top, Left, Bottom, Right
		setContentPane(contentPane);
		
		layout = new GridBagLayout();
		layout.columnWidths = new int[]{0, 0};
		layout.rowHeights = new int[]{0, 0};
		layout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		layout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(layout);
		
		log = new JTextPane();
		log.setEditable(false);
		gbc_log = new GridBagConstraints();
		gbc_log.fill = GridBagConstraints.BOTH;
		gbc_log.gridx = 0;
		gbc_log.gridy = 0;
		contentPane.add(log, gbc_log);
	}
	
}
