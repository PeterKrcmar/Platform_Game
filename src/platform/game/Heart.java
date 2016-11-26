package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Heart extends Actor{
	private double cooldown = 0.0;
	private final double SIZE = 0.4;
	
	public Heart(double x, double y) {
		zone = new Box(new Vector(x,y),SIZE,SIZE);
		sprite = getSprite("heart.full");
		priority = 50;
	}
	
	public void update(Input input) {
		super.update(input) ;
		cooldown -= input.getDeltaTime() ;
	}
	
	public void interact(Actor other) {
		super.interact(other) ;
		if (cooldown <= 0 && getBox().isColliding(other.getBox())) {
			if (other.hurt(this , Damage.HEAL, 1.0, Vector.ZERO))
				cooldown = 10.0 ;
		}
	}
	
	public void draw(Input input, Output output) {
		if (cooldown <= 0.0)
			output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
}
