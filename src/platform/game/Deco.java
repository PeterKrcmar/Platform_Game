package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Deco extends Actor{
	
	public Deco(double x,double y,String name) {
		zone = new Box(new Vector(x,y),1,3);
		sprite = getSprite("deco/" + name);
		priority = 101;
	}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
}
