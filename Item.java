package snake;

import java.awt.geom.Point2D;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
public class Item {
	
	/**
	 * Attributes
	 */
	private Point2D position;
	
	private ItemType typeOfItem;
	
	private boolean goodItem;
	
	private int counter;
	
	/**
	 * Item Constructor
	 * @param goodItem
	 */
	public Item(boolean goodItem, Point2D position) {
		this.setGoodItem(goodItem);
		this.setPosition(position);
		this.setCounter(0);
		if(this.isGoodItem() == true) {
			this.setTypeOfItem(ItemType.APPLE);
		} else {
			this.setTypeOfItem(ItemType.BOMB);
		}
	}
	
	/**couter getter
	 * @return
	 */
	public int getCounter() {
		return counter;
	}

	/** counter setter
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Position Getter
	 * @return
	 */
	public Point2D getPosition() {
		return this.position;
	}

	/**
	 * Position setter
	 * @param position
	 */
	public void setPosition(Point2D position) {
		this.position = position;
	}

	/**
	 * Item Type Getter
	 * @return
	 */
	public ItemType getTypeOfItem() {
		return typeOfItem;
	}

	/**
	 * Item Type Setter
	 * @param typeOfItem
	 */
	public void setTypeOfItem(ItemType typeOfItem) {
		this.typeOfItem = typeOfItem;
	}

	/**
	 * Good/Bad Flag Getter
	 * @return
	 */
	public boolean isGoodItem() {
		return goodItem;
	}

	/**
	 * Good.Bad Flag Setter
	 * @param goodItem
	 */
	public void setGoodItem(boolean goodItem) {
		this.goodItem = goodItem;
	}
}