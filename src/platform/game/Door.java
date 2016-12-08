package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Door extends Block{
	private Signal signal;

	/**
     * Create a new Door (Lock).
     * @param first coordinate of spawn
     * @param second coordinate of spawn
     * @param color (blue, red, yellow)
     * @param activation signal
     */
	public Door(int x, int y, String color, Signal signal) {
		super(x,y,1,1,"lock." + color);
		assert(color == "blue" || color == "red" || color == "yellow");
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
		if (other instanceof Player && other.getBox().isColliding(getBox()))
				getWorld().unregister(this);
	}
	
	public Box getBox() {
		return zone;
	}

}
