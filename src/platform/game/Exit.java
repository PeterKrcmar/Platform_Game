package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;
import platform.game.level.Level;

public class Exit extends Actor{
	private Level nextLevel;
	private Signal signal;
	
	public Exit(double x, double y, Level nextLevel, Signal signal) {
		if (signal == null)
			this.signal = new Constant();
		this.nextLevel = nextLevel;
		this.signal = signal;
		zone = new Box(new Vector(x,y),1,1.5);
		if (signal.isActive())
			sprite = getSprite("door.open");
		else
			sprite = getSprite("door.closed");
		priority = 0;
	}
	
	public void update(Input input) {
		if (signal.isActive())
			sprite = getSprite("door.open");
		else
			sprite = getSprite("door.closed");
	}
	
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
		case ACTIVATION:
			if (signal.isActive()) {
				getWorld().setNextLevel(nextLevel);
				getWorld().nextLevel();
			}
			return true;
		default :
			return super.hurt(instigator , type, amount , location) ;
		}
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
}
