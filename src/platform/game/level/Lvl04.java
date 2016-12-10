package platform.game.level;

import platform.util.Box;
import platform.util.Vector;
import platform.game.*;

public class Lvl04 extends Level {
	
	public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new Lvl04());
        
        // Create terrain
        world.register(new Limits(30,150));
        world.register(new Background("BG"));
        
        world.register(new Terrain(15,14,4,1,"snow")); //

        
        
        
        // Create objects
        Player player = new Player(new Vector(1,145));
        Key blue = new Key(1,5,"blue");
        Key red = new Key(22,12,"red");
        Key yellow = new Key(26,16,"yellow");
        Torch torch = new Torch(26,8,false);
        Lever lever = new Lever(18,11.8,true,4);
        
        // Register player
        world.register(player);
        world.register(new Overlay(player));
        world.register(new Hat(player));
        
        // Register Spikes
        world.register(new Spike(21,5,3));
        
        // Register Lasers
        world.register(new Laser(21,10,3,"h",lever));
        world.register(new Laser(21,13,3,"h",lever));
        
        // Register Jumpers
        world.register(new Jumper(8,4.8));
        world.register(new Jumper(5.5,9.8));
        
        // Register Signals
        world.register(blue);
        world.register(red);
        world.register(yellow);
        world.register(torch);
        world.register(lever);
        
        // Register Mover
        world.register(new Mover(new Vector(26,5),3,1,new Vector(26,15),"stone.3",torch,5));
        
        // Register Locks
        world.register(new Door(20,16,"blue",blue));
        world.register(new Door(24,16,"red",red));
        world.register(new Door(24,6,"red",red));
        world.register(new Door(12,12,"yellow",yellow));
        
        // Register Exit
        world.register(new Exit(10.5,12,new Lvl_Select(),new Constant()));
        
        // Register Deco
        world.register(new Deco(4.3,10.2,1.5,1.5,"snowman",-1));
        world.register(new Deco(16.5,14.5,0.8,2,"foliagePack_028",-1));
        world.register(new Deco(16.8,14.5,1,2.2,"foliagePack_028"));

    }
	
}
