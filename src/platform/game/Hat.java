package platform.game;

import java.awt.event.KeyEvent;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Hat extends Actor{
	private Player player;
	
	/**
     * Create a new Santa's Hat.
     * @param player player, not null
     */
	public Hat(Player player) {
		if (player == null)
			throw new NullPointerException();
		this.player = player;
		priority = 43;
	}
	
	public void update(Input input) {
		super.update(input);
		if (player.getWorld() == null)
			getWorld().unregister(this);
	}

	public Box getBox() {
		return new Box(player.getPosition(),0.1,0.1);
	}
	
	public void draw(Input input, Output output) {
		double ghost = (player.getHealth()/player.getHealthMax())+0.1;
		if (input.getKeyboardButton(KeyEvent.VK_LEFT).isDown()) {
			sprite = getSprite("santa_hat_left");
			output.drawSprite(sprite, new Box(player.getPosition().add(new Vector(player.getBox().getWidth()*0.25,player.getBox().getHeight()*0.5)),player.getBox().getWidth()*1.7,player.getBox().getHeight()*0.8),0,ghost);
		} else {
			sprite = getSprite("santa_hat");
			output.drawSprite(sprite, new Box(player.getPosition().add(new Vector(player.getBox().getWidth()*-0.25,player.getBox().getHeight()*0.5)),player.getBox().getWidth()*1.7,player.getBox().getHeight()*0.8),0,ghost);
		}
		
	}
	
}
