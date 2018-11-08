package items.weapons;

public class GodSet extends Weapon{
	
	public GodSet() {
		name = "god set";
		lDesc = "the god set makes you immortal (use for debug only)";
		sDesc = "the god set is for debug purposes";
		minDamage = 100;
		maxDamage = 100;
	}
	
	public String toString() {
		return "the god set makes you immortal (use for debug only)";
	}

}
