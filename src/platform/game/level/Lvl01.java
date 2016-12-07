package platform.game.level;

import platform.util.Box;
import platform.util.Vector;
import platform.game.*;

public class Lvl01 extends Level {

	public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new Lvl01());
        
        // Create terrain
        world.register(new Limits(30,30));
        
        world.register(new Terrain(30,4,1,10,"snow")); //9
        
        world.register(new Terrain(9,13,21,1,"snow")); //10
        
        world.register(new Terrain(0,-2,16,7,"snow")); //1
        
        world.register(new Terrain(17,-2,14,7,"snow")); //2
        
        world.register(new Terrain(15,-2,3,5,"snow")); //3
        
        world.register(new Terrain(4,6,4,1,"snow")); //4
        
        world.register(new Terrain(9,6,1,8,"snow")); //5
        
        world.register(new Terrain(10,10,1,4,"snow")); //6
        
        world.register(new Terrain(11,8,9,6,"snow")); //7
        
        world.register(new Terrain(20,10,11,4,"snow")); //8
        
        
        // Create objects
        Player player = new Player(new Vector(0,4));
        Torch torch1 = new Torch(3.5,5,false);
        Torch torch2 = new Torch(5,5,true);
        Torch torch3 = new Torch(6.5,5,false);
        Torch torch4 = new Torch(4,7,true);
        Torch torch5 = new Torch(5.5,7,false);
        Torch torch6 = new Torch(7,7,true);

        world.register(player);
        world.register(new Overlay(player));
        world.register(torch1);
        world.register(torch2);
        world.register(torch3);
        world.register(torch4);
        world.register(torch5);
        world.register(torch6);
        world.register(new Mover(new Vector(10,6),1,3,new Vector(10,8),"stone.8",new And(torch1,torch4)));
        world.register(new Mover(new Vector(16,6),1,3,new Vector(16,4),"stone.8",new And(torch2,torch5)));
        world.register(new Mover(new Vector(20,6),1,3,new Vector(20,8),"stone.8",new And(torch3,torch6)));
        world.register(new Exit(27,5,new Lvl_Select(), new And(torch1,new And(new Not(torch2),new And(torch3,new And(torch4,new And(torch5,torch6)))))));

    }
	
}
