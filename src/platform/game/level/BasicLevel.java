package platform.game.level;

import platform.util.Box;
import platform.util.Vector;
import platform.game.*;

public class BasicLevel extends Level {

    @Override
    public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new BasicLevel());
        
        // Create blocks
        Player player = new Player(Vector.ZERO);
        world.register(player);
        world.register(new Overlay(player));
        world.register(new Heart(2,1.5));
        world.register(new Spike(1,1.4));
        world.register(new Torch(-0.5,2,false));
        world.register(new Limits(30,30));
        world.register(new Jumper(new Vector(-5,6)));
        world.register(new Block(new Box(new Vector(-5,4.5),2,2),"stone.broken.1"));
        world.register(new Block(new Box(new Vector(-3,3),1,1),"stone.broken.1"));
        world.register(new Block(new Box(new Vector(0, 0), 4, 2),"stone.broken.2"));
        world.register(new Block(new Box(new Vector(-1.5, 1.5), 1, 1),"stone.broken.1"));
        
    }
    
}
