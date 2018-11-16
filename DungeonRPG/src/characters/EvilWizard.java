package characters;

import items.weapons.WizardStaff;

public class EvilWizard extends Character{

	public EvilWizard() {
		super(1, 5, 2);
		name = "Evil Wizard";
		MAX_HP = 50;
		init();
	}
	/**
	 * create a boss wizard with increased strength, wisdom, dexterity and health
	 * @param name - boss's name
	 */
	public EvilWizard(String name) {
		super (2,6,3);
		MAX_HP = 60;
		this.name = name;
		init();
	}

	/**
	 * initialise all common variables 
	 */
	private void init() {
		hp = MAX_HP;
		primaryWeapon = new WizardStaff();
		lvl = 1;
		ap = 0;
	}

	protected int damage() {
		int res = (int) Math.random() * 2 +1;
		if (res == 1) {
			return primaryWeapon.getDamage();
		}
		else {
			return primaryWeapon.ability();
		}
	}

	protected int dodgeChance() {
		return 100 / 5 * (dex -1);
	}

}
