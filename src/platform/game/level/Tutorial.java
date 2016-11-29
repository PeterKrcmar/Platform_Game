package platform.game.level;

import platform.util.Box;
import platform.util.Vector;
import platform.game.*;

public class Tutorial extends Level {

    @Override
    public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new Tutorial());
        
        // Create terrain
        world.register(new Limits(100,100));
        for (int i = 0; i < 7; i++){
        	world.register(new Block(i+0,5,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 2; i++){
        	world.register(new Block(i+9,6,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 7; i++){
        	world.register(new Block(i+13,7,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 2; i++){
        	world.register(new Block(i+23,4,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 10; i++){
        	world.register(new Block(i+35,4,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 4; i++){
        	for (int j = 0; j < 7; j++) {
        		world.register(new Block(i+38,j+5.3,1,1,"grass.center"));
        	}
        }
        
        world.register(new Block(42,8,1,1,"grass.middle"));
        
        for (int j = 0; j < 15; j++){
        	world.register(new Block(45,j+4,1,1,"grass.center"));
        }
        
        for (int i = 0; i < 4; i++){
        	world.register(new Block(i+38,12,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 3; i++){
        	world.register(new Spike(i+35,11.8));
        }
        
        for (int i = 0; i < 3; i++){
        	world.register(new Block(i+35,11,1,1,"stone.1"));
        }
        
        for (int i = 0; i < 3; i++){
        	world.register(new Block(i+32,12,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 3; i++){
        	world.register(new Block(i+32,11,1,1,"grass.center"));
        }
        
        for (int i = 0; i < 4; i++){
        	world.register(new Block(i+26,13,1,1,"grass.middle"));
        }
        
        for (int i = 0; i < 10; i++){
        	world.register(new Block(i+14,13,1,1,"grass.middle"));
        }
        
        for (int j = 0; j < 3; j++){
        	world.register(new Block(21,j+15,1,1,"grass.center"));
        }
        
        world.register(new Block(21,18,1,1,"grass.middle"));

        
        // Other objects
        Player player = new Player(new Vector(0,6));
        Key blue = new Key(26,14,"blue");
        Lever lever = new Lever(23.5,4.7,false,Double.POSITIVE_INFINITY);
        Torch torch = new Torch(19,8,false);
        
        world.register(player);
        world.register(new Overlay(player));
        world.register(torch);
        world.register(blue);
        world.register(lever);
        world.register(new Heart(32,13));
        world.register(new Jumper(new Vector(44,4.8)));
        world.register(new Jumper(new Vector(42,8.8)));
        world.register(new Door(21,14,"blue", blue));
        world.register(new Mover(new Vector(26,4), 3, 1, new Vector(33,4), "stone.2", lever));
        world.register(new Exit(15,14,new BasicLevel(),new Constant()));
        //world.register(new Deco(45,19.2,"foliagePack_028"));
    }
    
}
