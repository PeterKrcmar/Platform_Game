package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Door extends Block{
	private Signal signal;
	
	public Door(Vector lowerCorner, Vector upperCorner, String color, Signal signal) {
		super(lowerCorner, upperCorner, "lock." + color);
		this.signal = signal;
	}
	
	public Door(Box zone, String color, Signal signal) {
		super(zone,"lock." + color);
		this.signal = signal;
	}
	
	public Door(int x, int y, String color, Signal signal) {
		super(x,y,1,1,"lock." + color);
		this.signal = signal;
	}
	
	public void update(Input input) {
		if (signal.isActive())
			priority = 50;
	}
	
	public void draw(Input input, Output output) {
			output.drawSprite(sprite, zone);
	}
	
	public void interact(Actor other) {
		if (other.getPriority() == 42 && other.getBox().isColliding(getBox()))
				getWorld().unregister(this);
	}
	
	public Box getBox() {
		return zone;
	}

}
