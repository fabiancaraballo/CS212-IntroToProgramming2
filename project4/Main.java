package Assignment4;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Main {
	public static void main(String[] args) {
		
		JFrame application = new JFrame("A simple paint program");
		MainPanel paintPanel = new MainPanel(); // create paint panel
		application.add(paintPanel, BorderLayout.CENTER); // in center
		// create a label and place it in SOUTH of BorderLayout
		application.add( new JLabel("Drag the mouse to draw" ),	BorderLayout.SOUTH);
	    //application.pack();
	    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize( 1200, 800 ); // set frame size
	    application.setVisible( true ); // display frame
	    

	   } // end main
	} // end class Painter
		
