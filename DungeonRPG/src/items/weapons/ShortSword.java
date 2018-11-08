package items.weapons;

public class ShortSword extends Weapon{
	
	public ShortSword() {
		name = "short sword";
		sDesc = "a sharp and pointy instrument, good for stabbing ";
		lDesc = "Not very large, but with a sharp point. Short swords are designed more for stabbing than for slicing"
				+ ". The hilt is surprisingly ornate for such an inconspicuous weapon.";
		minDamage = 5;
		maxDamage = 10;
	}
}
