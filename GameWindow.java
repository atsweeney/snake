package snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	/**
	 * Attributes
	 */
	private GameBoard game;
	
	private int height;
	
	private int width;
	
	/**
	 * Entry point of game, launches the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * GameWindow Constructor
	 */
	public GameWindow() {
		setTitle("Snake Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 640);
		
		this.height = this.getHeight();
		this.width = this.getWidth();
		this.game = new GameBoard(height, width, "Player1");
		
		game.setBorder(new EmptyBorder(5, 5, 5, 5));
		game.setLayout(new BorderLayout(0, 0));
		game.setVisible(true);
		setContentPane(game);
	}
}
