package menu;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("SNAKE MENU");
		
		JPanel panel = new JPanel();	
		panel.setBackground(Color.YELLOW);
		
		JButton playButton = new JButton("PLAY");
		JButton scoreButton = new JButton("SCORES");
		JButton exitButton = new JButton("EXIT");
		JButton otherButton = new JButton("OTHER");
		
		panel.add(playButton);
		panel.add(scoreButton);
		panel.add(exitButton);
		panel.add(otherButton);

		frame.add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setLocation(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
