package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Fireball extends Actor {
	private Vector position;
	private Vector velocity;
	private final double SIZE = 0.4;
	private Actor owner;
	
	public Fireball(Vector position, Vector velocity, Actor owner) {
		if (position == null || velocity == null)
			throw new NullPointerException();
		this.owner = owner;
		this.position = position;
		this.velocity = velocity;
		zone = getBox();
		sprite = getSprite("fireball");
		priority = 80;
	}
	
	public Fireball(Vector position, Vector velocity, String name, Actor owner) {
		if (position == null || velocity == null)
			throw new NullPointerException();
		this.owner = owner;
		this.position = position;
		this.velocity = velocity;
		zone = getBox();
		sprite = getSprite(name);
		priority = 80;
	}
	
	// EVOLUTION	
	public void update(Input input) {
		super.update(input);
		double delta = input.getDeltaTime();
		Vector acceleration = getWorld().getGravity();
		velocity = velocity.add(acceleration.mul(delta));
		position = position.add(velocity.mul(delta));
	}
	
	// AFFICHAGE
	public void draw(Input input, Output output) {
		output.drawSprite(sprite, getBox(), input.getTime());
	}
		
	// INTERACTION
	public void interact(Actor other) {
		super.interact(other);
		if (other.isSolid()) {
			if (other.getBox().isColliding(getBox()))
			getWorld().unregister(this);
		// REBONDIR
		/*	Vector delta = other.getBox().getCollision(position);
		if (delta != null) {
			position = position.add(delta);
			velocity = velocity.mirrored(delta);
			}*/
		}
		
		if (other.getBox().isColliding(getBox()) && other != owner) {
			if (other.hurt(this , Damage.FIRE, 1.0, getPosition()))
				getWorld().unregister(this);
		}
	}
	
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
			case VOID:
				getWorld().unregister(this);
				return true;
			default :
				return super.hurt(instigator, type, amount, location);
		}
	}
	
	// ZONE CENTREE
	public Box getBox() {
		return new Box(position , SIZE, SIZE);
	}

	
}
