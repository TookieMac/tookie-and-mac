package characters;

import items.weapons.BattleAxe;

public class Troll extends Character{
	
	public Troll() {
		super(4, 1, 1);
		MAX_HP = 60;
		name = "troll";
		init();
	}
	
	public Troll(String name) {
		super(5,2,2);
		MAX_HP = 120;
		this.name = name;
		init();
	}
	
	/**
	 * initialise all common variables 
	 */
	private void init() {
		hp = MAX_HP;
		primaryWeapon = new BattleAxe();
		lvl = 0;
		ap = 0;
	}
}
