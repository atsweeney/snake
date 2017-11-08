package snake;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
public class PlayerScore {

	/**
	 * Attributes
	 */
	private int score;
	
	private String name;
	
	/**
	 * PlayerScore Constructor
	 * @param name is the name/initials of the player
	 * @param score is the score of the player
	 */
	public PlayerScore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Score Getter
	 * @return current score of the player
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Name Getter
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Name Setter
	 * @param name is the new player name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Method to increase player score
	 * @param points is the number of points the score is increased by
	 */
	public void increaseScore(int points) {
		
	}
	
	/**
	 * Method to decrease player score
	 * @param points is the number of points the score is decreased by
	 */
	public void decreaseScore(int points) {
		
	}
}
