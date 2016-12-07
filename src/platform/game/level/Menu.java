package platform.game.level;

import platform.util.Box;
import platform.util.Vector;

import java.awt.event.KeyEvent;

import platform.game.*;

public class Menu extends Level{
	
	public void register(World world) {
        super.register(world);
        
     // Register a new instance, to restart level automatically
        world.setNextLevel(new Menu());
        world.setView(new Vector(10,6), 6);
        
     // Construct terrain
        world.register(new Limits(20,20));
        
        world.register(new Terrain(1,-4,19,10,"snow"));
           
        
     // Other objects
        Player player = new Player(new Vector(10,6));
        world.register(player);
        world.register(new Hat(player));
        world.register(new Exit(15,6,new Tutorial(),new Constant()));
        world.register(new Exit(17,6,new Lvl_Select(),new Constant()));
        
     // Deco
        //Arbres gauche
        world.register(new Deco(1,6.5,1.2,2.2,"foliagePack_030"));
        world.register(new Deco(1.6,6.35,0.8,1.8,"foliagePack_030",-1));
        world.register(new Deco(2.4,6.4,1,2,"foliagePack_030"));
        
        //Arbres droite
        world.register(new Deco(18.4,6.3,0.8,1.8,"foliagePack_030"));
        world.register(new Deco(19,6.55,1.2,2.2,"foliagePack_030",-1));
        
        //Nuages
        world.register(new Cloud(new Vector(4,10),5,2,new Vector(18,10),0.1));
        world.register(new Cloud(new Vector(-2,9.8),3,1,new Vector(20,9.8),0.4));
        world.register(new Cloud(new Vector(20,10.2),5,2,new Vector(-2,10.2),0.25));
        world.register(new Cloud(new Vector(19,9.5),3.5,1.2,new Vector(-1,9.5),0.3));
        
        //Logo + texte
        world.register(new Background(10,8,8,1,"logo01"));
        world.register(new Background(15,7,2,0.3,"tutorial"));
        world.register(new Background(17,7,1.5,0.3,"lvl_select"));
	
	}
}
