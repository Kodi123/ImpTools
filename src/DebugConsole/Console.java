package DebugConsole;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

public class Console extends JFrame implements ActionListener {

	private String title = "Debug Console";
	private int width = 400;
	private int height = (width / 16) * 9;

	private Font font = new Font("Verdana", Font.PLAIN, 11);
	private JPanel contentPane;
	private JTextPane log;
	private StyledDocument doc;
	private JTextArea input;
	private JButton btn_submit;
	
	public Console() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, width, height);
		setResizable(true);
		setTitle(title);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 32, 2)); // ^, <, V, >
		setContentPane(contentPane);

		log = new JTextPane();
		//log.setBounds(2, 2, 380, 158);
		doc = log.getStyledDocument();
		log.setFont(font);
		contentPane.setLayout(null);
		//contentPane.add(log);
		
		JScrollPane scroll_log = new JScrollPane (log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll_log.setBounds(2, 2, 380, 158);
		contentPane.add(scroll_log);
		
		input = new JTextArea();
		//input.setBounds(height - 63, height - 63, width - 91, 22);
		input.setFont(font);
		//contentPane.add(input);
		
		JScrollPane scroll_input = new JScrollPane (input, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll_input.setBounds(0, getHeight() - 63, width - 91, 22);
		contentPane.add(scroll_input);
		
		btn_submit = new JButton("Submit");
		btn_submit.setBounds(312, 161, 71, 24);
		btn_submit.addActionListener(this);
		btn_submit.setActionCommand("submit");
		contentPane.add(btn_submit);
	}
	
	public void DebugPrint( String Message ) {
		try {
			doc.insertString(doc.getLength(), Message + "\n", null );
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
		switch( Iterator.toLowerCase() ) {
		
			case("+"):
				return "+";
			case("#"):
			case("numbers"):
			case("nums"):
				return "Numbers";
			default:
				return Iterator;
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("submit")) {
			switch(input.getText().toLowerCase()) {
			
				case("clear"):
					log.setText("Console Cleared\n");
					break;
				default:
					DebugPrint(input.getText());
					break;
			}
			input.setText("");
		}
		
	}

}
