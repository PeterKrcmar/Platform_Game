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
        Player player = new Player(new Vector(8,0));
        world.register(player);
        world.register(new Overlay(player));
        world.register(new Heart(-4,7.5));
        world.register(new Spike(3.5,-0.6));
        world.register(new Spike(4.5,-0.6));
        world.register(new Spike(5.5,-0.6));
        world.register(new Torch(-4.5,0.5,false));
        world.register(new Limits(30,30));
        world.register(new Jumper(new Vector(-7.5,2.4)));
        world.register(new Block(new Vector(-5, 5), new Vector(-3, 7),"stone.broken.1")); //9
        world.register(new Block(new Vector(3, -2), new Vector(4,-1),"stone.broken.1")); //6
        world.register(new Block(new Vector(4, -2), new Vector(5,-1),"stone.broken.1")); //7
        world.register(new Block(new Vector(5, -2), new Vector(6,-1),"stone.broken.1")); //8
        world.register(new Block(new Vector(-8, 0), new Vector(-5,2),"stone.broken.2")); //1
        world.register(new Block(new Vector(-6, -2), new Vector(-3,0),"stone.broken.2")); //2
        world.register(new Block(new Vector(-3, -2), new Vector(0, 0),"stone.broken.2")); //3
        world.register(new Block(new Vector(0, -2), new Vector(3, 0),"stone.broken.2")); //4
        world.register(new Block(new Vector(6, -2), new Vector(9, 0),"stone.broken.2")); //5
        world.register(new Deco(1.5,1.5,"foliagePack_028"));
        
    }
    
}
