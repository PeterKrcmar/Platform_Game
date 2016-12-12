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
        
        // Create map
        world.register(new Block(new Vector(-5, 5), new Vector(-3, 7),null)); //9
        world.register(new Block(new Vector(3, -2), new Vector(4.2,-1),null)); //6
        //world.register(new Block(new Vector(4, -2), new Vector(5,-1),null)); //7
        world.register(new Block(new Vector(4.7, -2), new Vector(6,-1),null)); //8
        world.register(new Block(new Vector(-8, 0), new Vector(-5,2),null)); //1
        world.register(new Block(new Vector(-6, -2), new Vector(-3,0),null)); //2
        world.register(new Block(new Vector(-3, -2), new Vector(0, 0),null)); //3
        world.register(new Block(new Vector(0, -2), new Vector(3, 0),null)); //4
        world.register(new Block(new Vector(6, -2), new Vector(9, 0),null)); //5
        world.register(new Block(new Vector(4, -5), new Vector(7, -4),null)); //10
        //world.register(new Deco(1.5,1.5,"foliagePack_028"));
        
        // Create objects
        Player player = new Player(new Vector(8,0));
        Key blue = new Key(3,2,"blue");
        Key red = new Key(-3,7.5,"red");
        Key yellow = new Key(0,7.5,"yellow");
        Lever lever = new Lever(-3,0,false,7);
        Torch torch = new Torch(-4.5,0.5,false);

        world.register(player);
        world.register(new Overlay(player));
        world.register(new Heart(-4,7.5));
        //world.register(new Spike(3.8,-0.6));
        //world.register(new Spike(4.5,-0.6));
        //world.register(new Spike(5.1,-0.6));
        world.register(torch);
        world.register(new Limits(30,30));
        world.register(new Jumper(new Vector(-7.5,2.4)));
        world.register(blue);
        world.register(red);
        world.register(yellow);
        world.register(lever);
        world.register(new Door(5.5, 5.5,"blue",new And(red,new And(blue,yellow))));
        world.register(new Mover(new Vector(6,4), 1, 2, new Vector(8,8), null, torch));
        world.register(new Exit(5,0,new Menu(),new Constant()));
    }
    
}
