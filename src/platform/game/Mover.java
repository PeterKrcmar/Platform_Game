package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Mover extends Block{
	private Vector min;
	private Vector max;
	private Signal signal;
	private double height;
	private double width;
	private Vector current;
	private Vector velocity;
	
	public Mover (Vector min,double width, double height, Vector max, String name, Signal signal) {
		super(new Box(min,width,height),name);
		this.height = height;
		this.width = width;
		this.signal = signal;
		this.min = min;
		this.max = max;
		current = min;
	}
	
	private boolean i = true;
	public void update(Input input) {
		double delta = input.getDeltaTime();
		if (signal.isActive()) {
			if ((current.getLength() < max.getLength()) && i){
				velocity = (max.sub(min)).resized(1.0);
				current = current.add(velocity.mul(delta));}
			else if (current.getLength() > min.getLength()){
				if (current.getLength() > max.getLength())
					i = false;
				velocity = (max.sub(min)).resized(1.0);
				current = current.sub(velocity.mul(delta));
				if (current.getLength() < min.getLength())
					i = true;
			}
		} else {
			velocity = Vector.ZERO;
		}
		zone = new Box(current,width,height);
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
}
