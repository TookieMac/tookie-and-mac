package characters;

import items.weapons.WizardStaff;

public class EvilWizard extends Character{

	public EvilWizard(int str, int wis, int dex) {
		super(1, 5, 2);
		MAX_HP = 50;
		primaryWeapon = new WizardStaff();
		
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
