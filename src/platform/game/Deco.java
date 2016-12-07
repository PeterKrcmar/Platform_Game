package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Deco extends Actor{
	
	public Deco(double x,double y, double width, double height, String name, int priority) {
		zone = new Box(new Vector(x,y),width,height);
		sprite = getSprite("deco/" + name);
		this.priority = priority;
	}
	
	public Deco(double x,double y, double width, double height, String name) {
		zone = new Box(new Vector(x,y),width,height);
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
