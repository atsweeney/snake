package snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	private JPanel panelMainMenu, panelOptions;
	private JButton btnOptions, btnStart, btnQuit;
	private JLabel title;
	
	
	/**
	 * Entry point of game, launches the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
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
		setBounds(100, 100, 615, 645);
		
		this.height = this.getHeight();
		this.width = this.getWidth();
		this.game = new GameBoard(height, width, null);
		
		game.setBorder(new EmptyBorder(5, 5, 5, 5));
		game.setLayout(new BorderLayout(0, 0));
		game.setVisible(true);
		game.setPaused(true);
		setContentPane(game);
		
		
		panelMainMenu = createMainMenu();
		game.add(panelMainMenu, BorderLayout.CENTER);		
		panelOptions = createPanelOptions();
		panelOptions.setVisible(false);		
		panelMainMenu.add(panelOptions);	
		
	}
	

	private JPanel createPanelOptions() {
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0, 0, width, height);
		panel.setBackground(Color.LIGHT_GRAY);
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setMinimum(-30);
		slider.setMaximum(30);
		slider.setValue(0);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {				
				game.setMoveSpeed(100 - slider.getValue());				
			}
		});
		slider.setBounds(120, 196, 350, 26);
		panel.add(slider);
		
		JLabel lblOptions = new JLabel("OPTIONS");
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setFont(new Font("Segoe UI Black", Font.PLAIN, 75));
		lblOptions.setBounds(10, 12, 569, 157);
		panel.add(lblOptions);
		
		JLabel lblMoveSpeed = new JLabel("Move Speed");
		lblMoveSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoveSpeed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMoveSpeed.setBounds(10, 159, 569, 26);
		panel.add(lblMoveSpeed);
		
		JLabel lblSlower = new JLabel("slower");
		lblSlower.setBounds(120, 221, 53, 14);
		panel.add(lblSlower);
		
		JLabel lblFaster = new JLabel("faster");
		lblFaster.setBounds(444, 215, 37, 27);
		panel.add(lblFaster);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelOptions.setVisible(false);
				btnOptions.setVisible(true);
				title.setVisible(true);
				btnStart.setVisible(true);
				btnQuit.setVisible(true);
			}
		});
		btnBack.setBounds(235, 319, 124, 25);
		panel.add(btnBack);
		
		return panel;
	}	
	

	private JPanel createMainMenu() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		mainPanel.setLayout(null);
		
		title = new JLabel("SNAKE");		
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(12, 78, 563, 157);
		title.setFont(new Font("Segoe UI Black", Font.PLAIN, 99));
		mainPanel.add(title);
		
		btnStart = new JButton("START GAME");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				new JOptionPane();
				JPanel info = new JPanel();									
				info.setLayout(new GridLayout(4,1));
				
				JLabel infoTitle = new JLabel("How To Play");				
				infoTitle.setFont(new Font("Tahoma", Font.PLAIN,32));
				
				JLabel infoText= new JLabel("<html>Eat apples to increase your score and grow your snake. Watch out for bombs! Bombs explode and reduce your score and length by 5. If your score is 5 or less, Game Over!</html>");		
				infoText.setPreferredSize(new Dimension(350,75));
				infoText.setFont(new Font("Tahoma", Font.PLAIN,14));
				
				JPanel legend = new JPanel();
				Icon appleImg = new ImageIcon(GameWindow.class.getResource("/assets/apple.png"));
				Icon bombImg = new ImageIcon(GameWindow.class.getResource("/assets/bomb.png"));
				
				JLabel apple = new JLabel();
				apple.setIcon(appleImg);
				
				JLabel bomb = new JLabel();
				bomb.setIcon(bombImg);
				legend.add(new JLabel("Apple: "));				
				legend.add(apple);	
				legend.add(new JLabel("                "));
				legend.add(new JLabel("Bomb: "));
				legend.add(bomb);		
				
				info.add(infoTitle);
				info.add(infoText);
				info.add(legend);
				info.add(new JLabel("Enter your name: "));
				String name = JOptionPane.showInputDialog(game, info);
				if(name == null || name.equals("")){
					game.setName("Player1");
				}else{
					game.setName(name);
				}
				
				game.setPaused(false);
			}
		});
		btnStart.setBounds(236, 319, 124, 25);
		mainPanel.add(btnStart);
		
		btnOptions = new JButton("OPTIONS");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				panelOptions.setVisible(true);
				btnOptions.setVisible(false);
				title.setVisible(false);
				btnStart.setVisible(false);
				btnQuit.setVisible(false);
			}
		});
		btnOptions.setBounds(236, 357, 124, 25);
		mainPanel.add(btnOptions);
		
		btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				System.exit(0);
			}
		});
		btnQuit.setBounds(236, 395, 124, 25);
		mainPanel.add(btnQuit);
		
		return mainPanel;
	}
	
	
	
}
