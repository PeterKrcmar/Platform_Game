package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Simple solid actor that does nothing.
 */
public class Block extends Actor {
	
	/**
     * Create a new Block.
     * @param lower corner of spawn
     * @param upper corner of spawn
     * @param sprite name
     */
	public Block(Vector lowerCorner, Vector upperCorner, String name) {
		zone = new Box(lowerCorner,upperCorner);
		sprite = getSprite(name);
		priority = 0;
	}
	
	/**
     * Create a new Block.
     * @param spawn position, not null
     * @param sprite name
     */
	public Block(Box zone, String name) {
		if (zone == null)
			throw new NullPointerException();
		this.zone = zone;
		sprite = getSprite(name);
		priority = 0;
	}
	
	/**
     * Create a new Block.
     * @param first cooridinate of spawn
     * @param second coordinate of spawn
     * @param width, greater than 0
     * @param height, greater than 0
     * @param sprite name
     */
	public Block(double x, double y, double width, double height, String name) {
		if (width <= 0 || height <= 0)
			throw new IllegalArgumentException();
		zone = new Box(new Vector(x,y),width,height);
		sprite = getSprite(name);
		priority = 0;
	}
	
	// pour évoluer au cours du temps :
	public void update(Input input) {}
	
	// pour être dessiné
	public void draw(Input input , Output output) {
		output.drawSprite(sprite,zone);
	}
	
	public Box getBox() {
		return zone;
	}
		
	public void interact(Actor other) {}
	
	public boolean isSolid() {
		return true; }
	
}
