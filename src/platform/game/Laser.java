package platform.game;

import platform.util.Box;
import platform.util.Vector;
import platform.util.Input;
import platform.util.Output;

public class Laser extends Actor{
	private Signal signal;
	private double x;
	private double y;
	private double length;
	private String direction;
	private double cooldown = 0;
	
	public Laser(double x, double y, double length, String direction, Signal signal) {
		if (direction == "v")
			zone = new Box(new Vector(x,y+(length-1)/2),1,length);
		else if (direction == "h")
			zone = new Box(new Vector(x+(length-1)/2,y),length,1);
		this.x = x;
		this.y = y;
		this.length = length;
		this.direction = direction;
		this.signal = signal;
		priority = 50;
	}
	
	public void update(Input input) {
		cooldown -= input.getDeltaTime();
	}
	
	public void draw(Input input, Output output) {
		if (signal.isActive())
		for (int i = 0; i < length; i++) {
			if (direction == "v")
				output.drawSprite(getSprite("laser.vertical"),new Box(new Vector(x,i+y),1,1));
			else
				output.drawSprite(getSprite("laser.horizontal"),new Box(new Vector(i+x,y),1,1));
		}
	}
	
	public void interact(Actor other) {
		super.interact(other);
		
		// LASER DAMAGE
		if (signal.isActive() && other.getBox().isColliding(getBox()) && cooldown <= 0)
			if (other.hurt(this , Damage.LASER, 5.0, getPosition()))
				cooldown = 1;
		}
	
	public Box getBox() {
		return zone;
	}

}
