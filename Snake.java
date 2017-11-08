package snake;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
public class Snake {
	
	/**
	 * Attributes
	 */
	private Point2D headPosition;
	
	private ArrayList<Point2D> body; 
	
	private Direction currentDirection;
	
	private int snakeLength;
	
	/**
	 * Snake Constructor
	 * @param x is the initial X Coordinate of snake
	 * @param y is the initial Y Coordinate of snake
	 */
	public Snake(Double x, Double y) {
		this.headPosition.setLocation(x, y);
		this.snakeLength = 3;
		this.currentDirection = Direction.RIGHT;
	}
	
	/**
	 * Snake Head Getter
	 * @return Point2D representing the snake's head position
	 */
	public Point2D getSnakeHead() {
		return headPosition;
	}
	
	/**
	 * Snake Body Getter
	 * @return ArrayList representing snake's body
	 */
	public ArrayList<Point2D> getSnake() {
		return body;
	}
	
	/**
	 * Snake Direction Getter
	 * @return Snake's current direction
	 */
	public Direction getSnakeDirection() {
		return currentDirection;
	}
	
	/**
	 * Snake Direction Setter
	 * @param dir is the direction the snake will be moving
	 */
	public void setSnakeDirection(Direction dir) {
		
	}
	
	/**
	 * Snake Length Getter
	 * @return the snake's current length
	 */
	public int getSnakeLength() {
		return snakeLength;
	}
	
	/**
	 * Snake Length Setter
	 * @param length is the number of segments in body
	 */
	public void setSnakeLength(int length) {
		
	}
	
	/**
	 * Causes snake to grow one point in length
	 */
	public void grow() {
		
	}
	
	/**
	 * Moves snakes coordinates to be painted for animation
	 */
	public void move() {
		
	}
}
