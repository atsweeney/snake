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

	private ArrayList<Point2D> body = new ArrayList<Point2D>();
	
	private Direction currentDirection;

	/**
	 * Snake Constructor
	 * 
	 * @param x
	 *            is the initial X Coordinate of snake
	 * @param y
	 *            is the initial Y Coordinate of snake
	 */
	public Snake(double x, double y) {

		this.body.add(0, new Point2D.Double(x, y));
		this.body.add(new Point2D.Double(x - 1, y));
		this.body.add(new Point2D.Double(x - 2, y));
		this.currentDirection = Direction.RIGHT;
		
	}

	/**
	 * Snake Head Getter
	 * 
	 * @return Point2D representing the snake's head position
	 */
	public Point2D getSnakeHead() {
		return this.body.get(0);
	}

	
	/**
	 * Snake Body Getter
	 * 
	 * @return ArrayList representing snake's body
	 */
	public ArrayList<Point2D> getSnake() {
		return body;
	}

	/**
	 * Snake Direction Getter
	 * 
	 * @return Snake's current direction
	 */
	public Direction getSnakeDirection() {
		return currentDirection;
	}

	/**
	 * Snake Direction Setter
	 * 
	 * @param dir
	 *            is the direction the snake will be moving
	 */
	public void setSnakeDirection(Direction dir) {
		this.currentDirection = dir;
	}

	
	/**
	 * Moves snakes coordinates to be painted for animation
	 */
	public void move(boolean grow) {
		// Moving right
		if (this.currentDirection == Direction.RIGHT) {
			this.body.add(0, new Point2D.Double(this.getSnakeHead().getX() + 1, this.getSnakeHead().getY()));
		}

		// Moving down
		if (this.currentDirection == Direction.DOWN) {
			this.body.add(0, new Point2D.Double(this.getSnakeHead().getX(), this.getSnakeHead().getY() + 1));
		}

		// Moving left
		if (this.currentDirection == Direction.LEFT) {
			this.body.add(0, new Point2D.Double(this.getSnakeHead().getX() - 1, this.getSnakeHead().getY()));
		}

		// Moving up
		if (this.currentDirection == Direction.UP) {
			this.body.add(0, new Point2D.Double(this.getSnakeHead().getX(), this.getSnakeHead().getY() - 1));
		}

		// if snake doesn't grow, remove the last piece of the body
		if (!grow) {
			this.body.remove(body.size() - 1);
		}
	}
}