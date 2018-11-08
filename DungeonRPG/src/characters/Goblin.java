package characters;

import items.weapons.ShortSword;

public class Goblin extends Character{ 
	public Goblin() {
		super(2, 1, 4);
		MAX_HP = 20;
		hp = MAX_HP;
		name = "Goblin";
		primaryWeapon = new ShortSword();
	}
	
	@Override
	public int damage() {
		return primaryWeapon.getDamage() + 5;
	}
	
	@Override
	public int dodgeChance() {
		return (dex-1) * 10;
		
	}

}
