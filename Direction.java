package snake;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
public enum Direction {
	RIGHT(90),	//Movement will occur to the right
	UP(360),	//Movement will occur in the upward direction
	LEFT(270),	//Movement will occur to the left
	DOWN(180);	//Movement will occur in the downward direction
	
	private final int degrees;
	
	Direction(int degree){
		this.degrees = degree;
	}
}
