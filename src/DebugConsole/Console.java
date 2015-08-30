package DebugConsole;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

public class Console extends JFrame {

	private String title = "Debug Console";
	private int width = 400;
	private int height = (width / 16) * 9;

	private JPanel contentPane;
	private JTextPane log;
	private GridBagConstraints gbc_log;
	private GridBagLayout layout;
	private StyledDocument doc;
	
	
	public Console() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, width, height);
		setTitle(title);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 30, 0)); // Top, Left,
																// Bottom, Right
		setContentPane(contentPane);

		layout = new GridBagLayout();
		layout.columnWidths = new int[] { 0, 0 };
		layout.rowHeights = new int[] { 0, 0 };
		layout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		layout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(layout);

		log = new JTextPane();
		doc = log.getStyledDocument();
		gbc_log = new GridBagConstraints();
		gbc_log.fill = GridBagConstraints.BOTH;
		gbc_log.gridx = 0;
		gbc_log.gridy = 0;
		contentPane.add(log, gbc_log);
	}
	
	public void DebugPrint( String Message ) {
		try {
			doc.insertString(doc.getLength(), "Debug: " + Message + "\n", null );
		} catch(Exception e) { 
			System.out.println(e); 
		}
	}
	
	public void DebugTable( ArrayList<String> messages, String Iterator ) {
		String CheckIterator = ParseIterator(Iterator);
		for( int i = 0; i < messages.size(); i++ ) {
			if( CheckIterator == "Numbers" ) {
				DebugPrint(i + " - " + messages.get(i) );
			} else {
				DebugPrint( CheckIterator + " - " + messages.get(i) );
			}
		}
	}
	
	private String ParseIterator( String Iterator ) {
		switch( Iterator ) {
		case("+"):
			return "+";
		case("#"):
			return "Numbers";
		default:
			return Iterator;
		
		}
	}

}
