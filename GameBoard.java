package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Group Alpha Date: 11/04/17 Class: CSIS 2450 Assignment: Group Project
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {

	/**
	 * Attributes
	 */
	private Snake player1Snake;

	private PlayerScore player1Info;

	private int counter;

	private ArrayList<Item> items;

	private int height;

	private int width;

	private int dotSize;

	private int moveSpeed;

	private TimerTask doPlay;

	private TimerTask updateScreen;

	private Timer gameTimer;

	private boolean gameOver;

	private boolean paused;

	private boolean appleEaten;
	private boolean bombEaten;
	private int explodeCount = 1;

	/**
	 * Game Board Constructor
	 */
	public GameBoard(int height, int width, String playerName) {
		this.addKeyListener(new Keys());
		this.setBackground(Color.decode("#000000"));
		this.setFocusable(true);
		this.setHeight(height);
		this.setWidth(width);
		this.setPlayer1Info(new PlayerScore(playerName, 0));
		this.setPlayer1Snake(new Snake(9.0, 10.0));
		this.items = new ArrayList<Item>();
		this.dotSize = 30;
		this.moveSpeed = 100;
		this.setGameOver(false);
		this.gameTimer = new Timer();
		this.gameTimer.schedule(this.updateScreen(), 25, 25);
		this.gameTimer.schedule(this.doPlay(), moveSpeed, moveSpeed);
	}

	/**
	 * Method updateScreen Re-initializes the updateScreen variable for use in a
	 * timer
	 * 
	 * @return TimerTask object updateScreen
	 */
	public TimerTask updateScreen() {
		this.updateScreen = new TimerTask() {
			@Override
			public void run() {
				Toolkit.getDefaultToolkit().sync();
				repaint();
			}
		};
		return this.updateScreen;
	}

	/**
	 * Method doPlay Re-initializes the doPlay variable for use in a timer
	 * 
	 * @return TimerTask object doPlay
	 */
	public TimerTask doPlay() {
		this.doPlay = new TimerTask() {

			@Override
			public void run() {
				if (!isGameOver()) {
					play();
				}
				player1Snake.setMoved(true);
			}
		};
		return this.doPlay;
	}

	/**
	 * Player Snake Getter
	 * 
	 * @return a Snake object representing the player
	 */
	public Snake getPlayer1Snake() {
		return player1Snake;
	}

	/**
	 * Player Snake Setter
	 * 
	 * @param player1Snake
	 *            is the player's snake
	 */
	public void setPlayer1Snake(Snake player1Snake) {
		this.player1Snake = player1Snake;
	}

	/**
	 * Player Info Getter
	 * 
	 * @return
	 */
	public PlayerScore getPlayer1Info() {
		return player1Info;
	}

	/**
	 * Player Info Setter
	 * 
	 * @param player1Info
	 */
	public void setPlayer1Info(PlayerScore player1Info) {
		this.player1Info = player1Info;
	}

	/**
	 * Bad Item Time Counter Getter
	 * 
	 * @return the time a bad item has appeared on the screen
	 */
	public int getCounter() {
		return this.counter;
	}

	/**
	 * Bad Item Time Counter Setter
	 * 
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Item list Getter
	 * 
	 * @return
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Height Getter
	 * 
	 * @return the height of the board
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Height Setter
	 * 
	 * @param height
	 *            is the new height of the board
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Width Getter
	 * 
	 * @return width of the board
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Width Setter
	 * 
	 * @param width
	 *            is the new width of the board
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * movespeed setter
	 * 
	 * @param speed
	 *            to set
	 */
	public void setMoveSpeed(int speed) {
		this.moveSpeed = speed;
	}

	/**
	 * movespeed getter
	 * 
	 * @return moveSpeed
	 */
	public int getMoveSpeed() {
		return this.moveSpeed;
	}

	/**
	 * GameOver Getter
	 * 
	 * @return true value if game status is over
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * GameOver Setter
	 * 
	 * @param gameOver
	 *            is the boolean flag of whether or not game has ended
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * Paused Getter
	 * 
	 * @return true value if game status is paused
	 */
	public boolean isPaused() {
		return this.paused;
	}

	/**
	 * Paused Setter
	 * 
	 * @param paused
	 *            set to true to pause the game
	 */
	public void setPaused(boolean paused) {
		if (this.isPaused() && !paused) {
			gameTimer.schedule(this.doPlay(), moveSpeed, moveSpeed);
			this.paused = paused;

		} else if (!this.isPaused() && paused) {
			doPlay.cancel();
			this.paused = paused;
		}

	}

	public void setName(String name) {
		player1Info.setName(name);
	}

	/**
	 * Method that handles a "round" of game play.
	 */
	public void play() {
		this.appleEaten = false;
		this.bombEaten = false;

		if (collisionOccurred() && !isGameOver()) {
			if (this.appleEaten) {
				player1Info.increaseScore(1);
			}
			if (this.bombEaten) {
				if (player1Info.getScore() < 6) {
					this.gameOver = true;
				} else {
					this.doPlay.cancel();
					player1Info.decreaseScore(5);
					player1Snake.explode();

					gameTimer.schedule(this.doPlay(), this.moveSpeed, this.moveSpeed);
				}
			}
		}

		// allow only 1 item on screen unless there is a bomb then allow two
		// after a delay
		if (items.size() < 1 || ((items.get(0).getTypeOfItem().equals(ItemType.BOMB) && items.size() < 2))
				&& items.get(0).getCounter() > 50) {
			int random = 1 + (int) (Math.random() * 100);
			// System.out.println(random);
			if (random > 10) {
				items.add(new Item(true, getRandomPoint(player1Snake)));
			} else {
				items.add(new Item(false, getRandomPoint(player1Snake)));
			}
		}

		// loop through items to increment each item's counter
		for (Item i : items) {
			// set counter for the bad item
			if (i.getTypeOfItem().equals(ItemType.BOMB)) {
				int count = i.getCounter();
				i.setCounter(count += 1);
			}
			// System.out.println(i.getTypeOfItem() + " " + i.getCounter());
			if (i.getCounter() == 150) {
				i.setCounter(0);
				items.remove(i);
			}
		}

		if (!isGameOver()) {
			// System.out.println(appleEaten);
			player1Snake.move(this.appleEaten);
		} else { // when game is over offer the user the option to try again
			String message = null;
			ArrayList<PlayerScore> highscores = player1Info.getHighScores();

			// check if the user beat the high score
			for (int i = 0; i < highscores.size(); i++) {
				if (player1Info.getScore() > highscores.get(0).getScore()) {
					message = "<html><h1>Game Over!</h1><br> <h3>You scored " + player1Info.getScore()
							+ " points!</h3> Congratulations, you beat the high score!<br> Do you want to play again?";
					highscores.add(0, player1Info);
					highscores.remove(highscores.size() - 1);
					player1Info.setHighScores(highscores);
					break;
				} else if (player1Info.getScore() > highscores.get(i).getScore()) {
					message = "<html><h1>Game Over!</h1><br> <h3>You scored " + player1Info.getScore()
							+ " points!</h3> Congratulations, you beat #" + (i + 1)
							+ "!<br> Do you want to play again?";
					highscores.add(i, player1Info);
					highscores.remove(highscores.size() - 1);
					player1Info.setHighScores(highscores);
					break;
				} else {
					message = "<html><h1>Game Over!</h1><br> <h3>You scored " + player1Info.getScore()
							+ " points!</h3> Do you want to play again?";
				}

			}

			message += "<br><br><table><tr><th>Place</th><th>Name</td><th>Score</td></tr>";
			new JOptionPane();

			int count = 1;
			for (PlayerScore p : player1Info.getHighScores()) {
				message += "<tr><td>#" + count + "</td><td>" + p.getName() + "</td><td>" + p.getScore() + "</td></tr>";
				count++;
			}
			message += "</table></html>";

			int retry = JOptionPane.showOptionDialog(this, new JLabel(message, SwingConstants.CENTER), "GAME OVER",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

			if (retry == JOptionPane.YES_OPTION) {
				player1Info.resetScore();
				player1Snake.resetSnake(9, 10);
				this.setGameOver(false);

			} else {
				System.exit(0);
			}
		}
	}

	/**
	 * Method that detects if snake has made contact with an object or itself.
	 * 
	 * @return boolean indicating whether or not a collision has occurred
	 */
	public boolean collisionOccurred() {
		this.appleEaten = false;
		this.bombEaten = false;
		// loop through items
		for (int i = 0; i < items.size(); i++) {
			if (player1Snake.getSnakeHead().equals(items.get(i).getPosition())) {
				if (items.get(i).isGoodItem()) {
					items.remove(i);
					this.appleEaten = true;
				} else if (!items.get(i).isGoodItem()) {
					items.remove(i);
					this.bombEaten = true;
				}

				return true;
			}
		}

		// check if snake hits border
		if ((player1Snake.getSnakeHead().getX() == 0
				|| player1Snake.getSnakeHead().getX() >= this.getWidth() / this.dotSize + 1)
				|| (player1Snake.getSnakeHead().getY() == 0
						|| player1Snake.getSnakeHead().getY() >= this.getHeight() / this.dotSize)) {
			setGameOver(true);
		}

		// check if snake hits self
		for (int i = 1; i < player1Snake.getSnake().size(); i++) {
			if (player1Snake.getSnakeHead().equals(player1Snake.getSnake().get(i))) {
				setGameOver(true);
			}
		}

		return false;
	}

	/**
	 * METHOD getRandomPoint generates a random point that does not intersect
	 * the snake.
	 * 
	 * @param s
	 *            is the Snake object
	 * @return point is the Point2D object that does not intersect the Snake
	 *         object
	 */
	public Point2D getRandomPoint(Snake s) {
		Point2D point = new Point2D.Double();
		boolean search = true;
		while (search) {
			int x = (int) (Math.random() * 20) + 1;
			int y = (int) (Math.random() * 20) + 1;
			point.setLocation(x, y);

			if (s.getSnake().contains(point) || (s.getSnakeHead().distance(point) < 4)) {
				// System.out.println("Point found.");
				search = true;
			} else {
				// System.out.println("Point NOT found.");
				search = false;
			}
		}
		return point;
	}

	/**
	 * Paints components onto JPanel by calling draw method.
	 * 
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// paint background grid
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (j % 2 == i % 2) {
					g.setColor(Color.decode("#111111"));
					g.fillRect(j * dotSize, i * dotSize, dotSize, dotSize);
				}
			}
		}
		draw(g);

		if (this.bombEaten) {
			this.drawExplosion(g);
			if (this.explodeCount < 6) {
				this.explodeCount++;
			}

		}
	}

	/**
	 * Method that paints objects on screen. Apples are red and round, snake is
	 * blue and square.
	 * 
	 * @param g
	 */
	private void draw(Graphics g) {

		for (Item item : items) {
			if (item.getTypeOfItem().equals(ItemType.APPLE)) {
				g.setColor(Color.red);
				g.fillOval((int) (item.getPosition().getX() - 1) * dotSize,
						(int) (item.getPosition().getY() - 1) * dotSize, dotSize, dotSize);
			}
			if (item.getTypeOfItem().equals(ItemType.BOMB)) {
				g.setColor(Color.ORANGE);
				g.fillOval((int) (item.getPosition().getX() - 1) * dotSize,
						(int) (item.getPosition().getY() - 1) * dotSize, dotSize, dotSize);
			}

		}

		g.setColor(Color.blue);

		for (Point2D p : player1Snake.getSnake()) {
			g.fillRect((int) (p.getX() - 1) * dotSize, (int) (p.getY() - 1) * dotSize, dotSize, dotSize);
		}

		// draw score
		g.setColor(Color.white);
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 30));
		g.drawString(player1Info.getScoreString(), 560, 30);
	}

	public void drawExplosion(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int) (player1Snake.getSnakeHead().getX() - 1) * dotSize,
				(int) (player1Snake.getSnakeHead().getY() - 1) * dotSize, this.explodeCount * dotSize,
				this.explodeCount * dotSize);

	}

	/** Method to generate pause menu */
	public void pauseMenu() {
		Object[] options = { "UNPAUSE" };
		JSlider slider = new JSlider();
		slider.setMinimum(-30);
		slider.setMaximum(30);

		if (this.getMoveSpeed() == 100) {
			slider.setValue(0);
		} else {
			slider.setValue(100 - this.getMoveSpeed());
		}
		System.out.println(slider.getValue());

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setMoveSpeed(100 - slider.getValue());
			}
		});
		slider.setBounds(0, 0, 350, 26);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Set Move Speed"));
		panel.add(slider);
		int n = JOptionPane.showOptionDialog(this, panel, "PAUSED", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		if (n == 0 || n == -1) {
			this.setPaused(false);
		}

	}

	/**
	 * Class to handle user key inputs
	 */
	private class Keys extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			// if esc key is pressed, pause/unpause game
			if (key == 27) {
				if (!isPaused()) {
					setPaused(true);
					pauseMenu();
				} else {
					setPaused(false);
				}
			}

			if (((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_A))
					&& (player1Snake.getSnakeDirection() != Direction.RIGHT) && player1Snake.hasMoved()) {
				player1Snake.setSnakeDirection(Direction.LEFT);
				player1Snake.setMoved(false);
			} else if (((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D))
					&& (player1Snake.getSnakeDirection() != Direction.LEFT) && player1Snake.hasMoved()) {
				player1Snake.setSnakeDirection(Direction.RIGHT);
				player1Snake.setMoved(false);
			} else if (((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_W))
					&& (player1Snake.getSnakeDirection() != Direction.DOWN) && player1Snake.hasMoved()) {
				player1Snake.setSnakeDirection(Direction.UP);
				player1Snake.setMoved(false);
			} else if (((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_S) && player1Snake.hasMoved())
					&& (player1Snake.getSnakeDirection() != Direction.UP)) {
				player1Snake.setSnakeDirection(Direction.DOWN);
				player1Snake.setMoved(false);
			}
		}
	}
}
