package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;


public class Lever extends Actor implements Signal{
	private boolean active;
	private double cooldown = 0;
	private double time;
	
	public Lever(double x, double y, boolean active, double time) {
		this.active = active;
		this.time = time;
		zone = new Box(new Vector(x,y),0.8,0.8);
		if (active)
			sprite = getSprite("lever.right");
		else
			sprite = getSprite("lever.left");
		priority = 30;
	}
	
	public void update(Input input) {
		cooldown -= input.getDeltaTime();
		if (cooldown < 0)
			active = false;
	}
	
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
		case ACTIVATION:
			cooldown = time;
			active = !active;
			return true;
		default :
			return super.hurt(instigator , type, amount , location) ;
		}
	}
	
	public void draw(Input input, Output output) {
		if (active)
			sprite = getSprite("lever.right");
		else
			sprite = getSprite("lever.left");
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
