package platform.game;

public class Constant implements Signal{
	private final boolean signal = true;
	
	public Constant() {}
	
	public boolean isActive() {
		return signal;
	}
}
