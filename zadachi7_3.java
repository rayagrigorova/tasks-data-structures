package Lists_zadachi7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.*;

public class zadachi7_3 {
	JFrame frame;
	JPanel panel;
	JLabel enterNumber;
	JTextField numberField;
	JTextArea textArea;
	JButton sortButton, shuffleButton, reverseButton;
	JScrollPane scrollPane;
	
	LinkedList <Integer> list;
	
	zadachi7_3(){
		list = new LinkedList <>();
		frame = new JFrame("Zadacha 3");
		panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		
	    GridBagConstraints c = new GridBagConstraints(); 
	    c.gridx = 0;
	    c.gridy = 0;
		enterNumber = new JLabel("Enter a number: ");
		panel.add(enterNumber, c);
		
	    c.gridx = 1;
	    c.gridy = 0;
	    c.gridwidth = 2;
		numberField = new JTextField();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    numberField.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!list.contains(Integer.parseInt(numberField.getText()))) {
						list.add(Integer.parseInt(numberField.getText()));
						textArea.setText(list.toString());
					}
				}
				catch(Exception x) {
				}

				numberField.setText("");
				
			}
	    });
		panel.add(numberField, c);
		
	    c.gridx = 0;
	    c.gridy = 1;
	    c.gridwidth = 3;
		//weightx and weighty are used to determine how to distribute space among columns and among rows.
	    c.weightx = 1;
	    c.weighty = 1;
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
	    c.fill = GridBagConstraints.BOTH;	
	    scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		panel.add(scrollPane, c);

		c.insets = new Insets(5, 5, 5, 5);
	    c.gridx = 0;
	    c.gridy = 2;
	    c.gridwidth = 1;
	    c.weightx = 0.1;
	    c.weighty = 0.1;
	    c.fill = GridBagConstraints.BOTH;
		sortButton = new JButton("Sort");
		sortButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(list);
				textArea.setText(list.toString());
				
			}
			
		});
		panel.add(sortButton, c);

	    c.gridx = 1;
	    c.gridy = 2;
		shuffleButton = new JButton("Shuffle");
		shuffleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(list);
				textArea.setText(list.toString());
				
			}
			
		});
		panel.add(shuffleButton, c);

	    c.gridx = 2;
	    c.gridy = 2;
		reverseButton = new JButton("Reverse");
		reverseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.reverse(list);
				textArea.setText(list.toString());
				
			}
			
		});
		panel.add(reverseButton, c);
		 
		frame.add(panel);
        frame.setSize(400, 400);  
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	public static void main(String[] args) {
		new zadachi7_3();
	}
}
