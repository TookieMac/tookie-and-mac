package characters;

import items.weapons.WizardStaff;

public class EvilWizard extends Character{

	public EvilWizard() {
		super(1, 5, 2);
		MAX_HP = 50;
		primaryWeapon = new WizardStaff();
		
		
	}
	/**
	 * create a boss wizard
	 * @param name - boss's name
	 */
	public EvilWizard(String name) {
			super (2,6,3);
			MAX_HP = 60;
			primaryWeapon = new WizardStaff();
			this.name = name;
			
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
