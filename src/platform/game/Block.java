package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Simple solid actor that does nothing.
 */
public class Block extends Actor {
	
	public Block(Vector lowerCorner, Vector upperCorner, String name) {
		zone = new Box(lowerCorner,upperCorner);
		sprite = getSprite(name);
		priority = 0;
	}
	
	public Block(Box zone, String name) {
		this.zone = zone;
		sprite = getSprite(name);
		priority = 0;
	}
	
	public Block(double x, double y, double width, double height, String name) {
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
