package platform.game;

import java.awt.event.KeyEvent;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Player extends Actor{
	private Vector velocity;
	private Vector position;
	private final double SIZE = 0.6;
	private boolean colliding;
	private int zoom = 6 ;
	private double health;
	private final double MAX_HEALTH = 10;
	private int sautPossible = 1;
	private int leftPossible = 1;
	private int rightPossible = 1;
	
	
	public Player(Vector position) {
		if (position == null)
			throw new NullPointerException();
		this.position = position;
		velocity = Vector.ZERO;
		zone = getBox();
		sprite = getSprite("blocker.happy");
		priority = 42;
		health = MAX_HEALTH;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getHealthMax() {
		return MAX_HEALTH;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public Box getBox() {
		return new Box(position, SIZE, SIZE);
	}
	
	public void preUpdate(Input input) {
		super.preUpdate(input);
    	colliding = false;
    }
	
	// EVOLUTION
	public void update(Input input) {
		super.update(input) ;
	
	// ARRET SI COLLISION
		if (colliding && velocity.getX() != 0) {
			double scale = Math.pow(0.001, input.getDeltaTime());
			velocity = velocity.mul(scale);
			}
		
		double maxSpeed = 4.0 ;
		// DROITE
		if (input.getKeyboardButton(KeyEvent.VK_RIGHT).isDown()) {
			if (velocity.getX() < maxSpeed) {
				double increase = rightPossible*60.0 * input.getDeltaTime() ;
				double speed = rightPossible*velocity.getX() + increase ;
				if (speed > maxSpeed)
					speed = maxSpeed ;
				velocity = new Vector(speed*rightPossible , velocity.getY()) ;
				System.out.println("droite "+rightPossible);
			}
		} else
		// GAUCHE
		if (input.getKeyboardButton(KeyEvent.VK_LEFT).isDown()) {
			if (velocity.getX() > -maxSpeed) {
				double increase = leftPossible*-60.0 * input.getDeltaTime() ;
				double speed = leftPossible*velocity.getX() + increase ;
				if (speed < -maxSpeed)
					speed = -maxSpeed ;
				velocity = new Vector(speed*leftPossible , velocity.getY()) ;
				System.out.println("gauche "+leftPossible);
			}
		} else {
			velocity = new Vector(0, velocity.getY());
		}
		// SAUT
		if (input.getKeyboardButton(KeyEvent.VK_UP).isPressed() && sautPossible == 1) {
				velocity = new Vector(velocity.getX(), 7.0);
				sautPossible = 0;
		}else if (sautPossible == 0 && colliding && velocity.getY() == 0){
					sautPossible = 1;
		}
		
		//walljump
		if (sautPossible == 0 && colliding && velocity.getY() < 0 && input.getKeyboardButton(KeyEvent.VK_UP).isPressed() && input.getKeyboardButton(KeyEvent.VK_RIGHT).isDown()){
			velocity = new Vector(-15,5);
			//rightPossible = 0;
			//leftPossible = 1;
		}else if (sautPossible == 0 && colliding && velocity.getY() < 0 && input.getKeyboardButton(KeyEvent.VK_UP).isPressed() && input.getKeyboardButton(KeyEvent.VK_LEFT).isDown()){
			velocity = new Vector(15,5);
			//leftPossible = 0;
			//rightPossible = 1;
		}
		
		/*if (colliding){
			leftPossible = 1;
			rightPossible = 1;
		}*/
		
		
		
		
		/*if (sautPossible == 0 && colliding && velocity.getY() < 0){
			sautPossible = 1;
		}*/
		
		double delta = input.getDeltaTime() ;
		Vector acceleration = getWorld().getGravity();
		velocity = velocity.add(acceleration.mul(delta)) ;
		position = position.add(velocity.mul(delta)) ;
		
		// TIRER FIREBALL / CANARD
		Vector v = velocity.add(velocity.resized(2.0));
		if (input.getKeyboardButton(KeyEvent.VK_SPACE).isPressed()) {
			getWorld().register(new Fireball(position,v,this));
		}
		/*if (input.getKeyboardButton(KeyEvent.VK_CONTROL).isPressed()) {
			getWorld().register(new Fireball(position,v,"duck",this));
		}*/
		Vector w = ((input.getMouseLocation()).sub(position)).resized(20.0);
		if (input.getMouseButton(1).isPressed()) {
			getWorld().register(new Fireball(position,w,"spam",this));
		}
		
		// ZOOMIN / ZOOMOUT
		final int MAX_ZOOMOUT = 20;
		final int ZOOM_DEFAULT = 6;
		if (input.getKeyboardButton(KeyEvent.VK_1).isDown()) {
			zoom = 1;
		}
		else if (input.getKeyboardButton(KeyEvent.VK_2).isDown()) {
			zoom = MAX_ZOOMOUT;
		} else {zoom = ZOOM_DEFAULT;}

		// REPLACER AU DEBUT DU NIVEAU
		if (input.getKeyboardButton(KeyEvent.VK_R).isPressed()) {
			getWorld().nextLevel();
		}

		// SOUFFLER
		if (input.getKeyboardButton(KeyEvent.VK_B).isPressed())
			getWorld().hurt(getBox(), this , Damage.AIR, 1.0, getPosition());
		
		// DEVENIR SAD
		final double threshold = 2.0;
		if (health <= threshold)
			sprite = getSprite("blocker.sad");
		else
			sprite = getSprite("blocker.happy");
		
		// MOURRIR
		if (health <= 0)
			this.die();
	}
	
	// VUE FIXEE SUR PERSONNAGE
	public void postUpdate(Input input) {
		super.postUpdate(input);
		getWorld().setView(position, zoom);
	}
		
	// AFFICHAGE
	public void draw(Input input , Output output) {
		output.drawSprite(sprite , getBox()) ;
	}
	
	// INTERRACTION
	public void interact(Actor other) {
		super.interact(other) ;
		if (other.isSolid()) {
			Vector delta = other.getBox().getCollision(getBox()) ;
			if (delta != null) {
				colliding = true;
				position = position.add(delta) ;
				if (delta.getX() != 0.0)
					velocity = new Vector(0.0, velocity.getY()) ;
				if (delta.getY() != 0.0)
					velocity = new Vector(velocity.getX(), 0.0) ;
			}
		}
	}
	
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
		case AIR : 
			velocity = getPosition().sub(location).resized(amount) ;
			return true;
		case VOID :
			health -= amount;
			return true;
		case HEAL:
			if (health < MAX_HEALTH)
				health += amount;
			else
				health = MAX_HEALTH;
			return true;
		case PHYSICAL :
			health -= amount;
			return true;
		default :
			return super.hurt(instigator , type, amount , location) ;
		}
	}
	
	public void die() {
		getWorld().unregister(this);
		getWorld().nextLevel();
	}
}
