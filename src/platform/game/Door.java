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
	
	public void update(Input input) {
		if (signal.isActive())
			getWorld().unregister(this);
	}
	
	public Door(Box zone, String color, Signal signal) {
		super(zone,"door." + color);
		this.signal = signal;
	}
	
	public void draw(Input input, Output output) {
		if (!signal.isActive())
			output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}

}
