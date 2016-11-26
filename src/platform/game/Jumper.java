package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Jumper extends Actor{
	private double cooldown;
	private Vector position;
	private final double SIZE = 0.8;
	
	public Jumper(Vector position) {
		this.position = position;
		zone = new Box(position, SIZE, SIZE);
		sprite = getSprite("jumper.normal");
		priority = 50;
	}
	
	public void update(Input input) {
		super.update(input) ;
		cooldown -= input.getDeltaTime() ;
	}
	
	public void interact(Actor other) {
		super.interact(other) ;
		if (cooldown <= 0 && getBox().isColliding(other.getBox())) {
			Vector below = new Vector(position.getX(), position.getY() - 1.0) ;
		if (other.hurt(this , Damage.AIR, 10.0, below))
			cooldown = 0.5 ;
		}
		if (cooldown > 0) {
		sprite = getSprite("jumper.extended"); } else {
			sprite = getSprite("jumper.normal");
		}
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
	
}