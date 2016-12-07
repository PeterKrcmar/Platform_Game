package platform.game;

import platform.util.Vector;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;

public class Cloud extends Mover{

	public Cloud(Vector min,double width, double height, Vector max, double velocityFactor) {
		super(min,width,height,max,"cloud",new Constant(),velocityFactor);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone, 0, 0.7);
	}
}
