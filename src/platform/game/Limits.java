
package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Limits extends Actor {
	
	public Limits (int height, int width) {
		zone = new Box(Vector.ZERO,width,height);
		sprite = getSprite("empty");
		priority = 100;
	}
	
	public Limits (Vector lowerCorner, Vector upperCorner) {
		zone = new Box(lowerCorner, upperCorner);
		sprite = getSprite("empty");
		priority = 100;
	}
	
	public void update(Input input) {}
	
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, zone);
	}
	
	public Box getBox() {
		return zone;
	}
	
	public void interact(Actor other) {
		super.interact(other);
		if (!other.getBox().isColliding(this.getBox()))
			other.hurt(this , Damage.VOID, Double.POSITIVE_INFINITY, Vector.ZERO);
	}
}
