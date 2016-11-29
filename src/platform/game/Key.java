package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;


public class Key extends Actor implements Signal{
	private boolean taken = false;
	private double size = 0.5;
	
	public Key(double x, double y, String color) {
		zone = new Box(new Vector(x,y),size,size);
		sprite = getSprite("key." + color);
		priority = 50;
	}
	
	public Box getBox() {
		return zone;
	}
	
	public void interact(Actor other) {
		if (other.getPriority() == 42 && getBox().isColliding(other.getBox())) {
			taken = true;
			getWorld().unregister(this);
		}
	
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public boolean isActive() {
		return taken;
	}
	
}
