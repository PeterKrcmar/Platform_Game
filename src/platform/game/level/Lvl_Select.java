package platform.game.level;

import platform.util.Box;
import platform.util.Vector;
import platform.game.*;

public class Lvl_Select extends Level {
	
	public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new Lvl_Select());
        
        // Create terrain
        world.register(new Limits(30,20));
        
        world.register(new Terrain(0,10,5,6,"castle"));
        
        world.register(new Terrain(8,15,22,1,"castle"));
        
        world.register(new Terrain(5,10,1,4,"castle"));
        
        world.register(new Terrain(6,10,1,3,"castle"));
        
        world.register(new Terrain(7,10,1,2,"castle"));
        
        world.register(new Terrain(8,10,1,1,"castle"));
        
        world.register(new Terrain(0,10,30,1,"castle"));
        
        
        // OBJECTS
        Player player = new Player(new Vector(2,15));
        
        world.register(player);
        world.register(new Hat(player));
        // Menu door
        world.register(new Exit(0.5,16,new Menu(),new Constant()));
        // Doors lvl 1-5
        world.register(new Background(10,17.2,0.35,0.5,"digit.1"));
        world.register(new Exit(10,16,new Lvl01(),new Constant()));
        
        world.register(new Background(13,17.2,0.35,0.5,"digit.2"));
        world.register(new Exit(13,16,new Menu(),new Not(new Constant())));

        world.register(new Background(16,17.2,0.35,0.5,"digit.3"));
        world.register(new Exit(16,16,new Menu(),new Not(new Constant())));

        world.register(new Background(19,17.2,0.35,0.5,"digit.4"));
        world.register(new Exit(19,16,new Menu(),new Not(new Constant())));

        world.register(new Background(22,17.2,0.35,0.5,"digit.5"));
        world.register(new Exit(22,16,new Menu(),new Not(new Constant())));
        
        // Doors lvl 6-10
        world.register(new Background(10,12.2,0.35,0.5,"digit.6"));
        world.register(new Exit(10,11,new Menu(),new Not(new Constant())));

        world.register(new Background(13,12.2,0.35,0.5,"digit.7"));
        world.register(new Exit(13,11,new Menu(),new Not(new Constant())));

        world.register(new Background(16,12.2,0.35,0.5,"digit.8"));
        world.register(new Exit(16,11,new Menu(),new Not(new Constant())));
        
        world.register(new Background(19,12.2,0.35,0.5,"digit.9"));
        world.register(new Deco(19,11,1,0.6,"underconstruction2",1));
        world.register(new Exit(19,11,new Menu(),new Not(new Constant())));
        
        world.register(new Background(21.8,12.2,0.35,0.5,"digit.1"));
        world.register(new Background(22.2,12.2,0.35,0.5,"digit.0"));
        world.register(new Deco(22,11,1,0.6,"underconstruction2",1));
        world.register(new Exit(22,11,new Menu(),new Not(new Constant())));
        
	}
}
