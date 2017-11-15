package snake;

import java.util.Random;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
public class GameBoard {

	/**
	 * Attributes
	 */
	public Snake player1Snake;
	
	private PlayerScore player1Info;
	
	private PlayerScore[] highScores;
	
	private int counter;
	
	private int[] items;
	
	private int height;
	
	private int width;
	
	private boolean gameOver;
	
	private Random rng;
	
	/**
	 * Game Board Constructor
	 */
	public GameBoard(int height, int width, String playerName) {
		this.height = height;
		this.width = width;
		this.player1Info.setName(playerName);
	}

	/**
	 * Player Snake Getter 
	 * @return a Snake object representing the player 
	 */
	public Snake getPlayer1Snake() {
		return player1Snake;
	}

	/**
	 * Player Snake Setter
	 * @param player1Snake is the player's snake
	 */
	public void setPlayer1Snake(Snake player1Snake) {
		this.player1Snake = player1Snake;
	}

	/**
	 * 
	 * @return
	 */
	public PlayerScore getPlayer1Info() {
		return player1Info;
	}

	/**
	 * 
	 * @param player1Info
	 */
	public void setPlayer1Info(PlayerScore player1Info) {
		this.player1Info = player1Info;
	}

	/**
	 * 
	 * @return
	 */
	public PlayerScore[] getHighScores() {
		return highScores;
	}

	/**
	 * 
	 * @param highScores
	 */
	public void setHighScores(PlayerScore[] highScores) {
		this.highScores = highScores;
	}

	/**
	 * 
	 * @return
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * 
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getItems() {
		return items;
	}

	/**
	 * 
	 * @param items
	 */
	public void setItems(int[] items) {
		this.items = items;
	}
	
	/**
	 * Height Getter
	 * @return the height of the board
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Height Setter
	 * @param height is the new height of the board
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Width Getter
	 * @return width of the board
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Width Setter
	 * @param width is the new width of the board
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * GameOver Getter
	 * @return true value if game status is over
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * GameOver Setter
	 * @param gameOver is the boolean flag of whether or not game has ended
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * Method that handles a "round" of game play
	 */
	public void play() {
		
	}
	
	/**
	 * Method that detects if snake has made contact with an object or itself
	 * @return
	 */
	public boolean collisionOccurred() {
		return false;
	}
	
	/**
	 * Method that checks if game has ended
	 * @return
	 */
	public boolean gameEnded() {
		return false;
	}
}
