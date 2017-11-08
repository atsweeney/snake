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
	
	/**
	 * Item Constructor
	 * @param goodItem
	 */
	public Item(boolean goodItem) {
		
	}
	
	/**
	 * Position Getter
	 * @return
	 */
	public Point2D getPosition() {
		return position;
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
