package characters;

import items.weapons.ShortSword;

public class Goblin extends Character{ 
	public Goblin() {
		super(2, 1, 4);
		MAX_HP = 20;
		name = "Goblin";
		init();
	}
	
	public Goblin(String name) {
		super (3,2,5);
		MAX_HP = 30;
		this.name = name;
		init();
	}
	
	/**
	 * initialise all common variables 
	 */
	private void init() {
		hp = MAX_HP;
		primaryWeapon = new ShortSword();
		lvl = 1;
		ap = 0;
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
