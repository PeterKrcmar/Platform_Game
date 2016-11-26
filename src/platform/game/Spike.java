package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Spike extends Actor{
	private final double SIZE = 0.8;
	private double cooldown = 0;
	
	public Spike (Vector lowerCorner, Vector upperCorner) {
		zone = new Box(lowerCorner, upperCorner);
		sprite = getSprite("spikes");
		priority = 50;
	}
	
	public Spike (double x, double y) {
		zone = new Box(new Vector(x,y),SIZE,SIZE);
		sprite = getSprite("spikes");
		priority = 50;
	}
	
	public void update(Input input) {
		super.update(input) ;
		cooldown -= input.getDeltaTime();
	}
	
	public void interact(Actor other) {
		super.interact(other);
		if (!other.isSolid() && cooldown <= 0 && getBox().isColliding(other.getBox())) {
			if (other.getVelocity().getY() < -1)
				if(other.hurt(this , Damage.PHYSICAL, 2.0, Vector.ZERO))
						cooldown = 1.0;
		}
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
}
