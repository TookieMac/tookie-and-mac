package items.weapons;

public class WizardStaff extends Weapon{

	public WizardStaff(){
		name = "Wizards staff";
		sDesc = "it would break if you leant on it, but it shoots fireballs so that’s something.";
		lDesc = "Not a very sturdy staff, but the swirl of magical fire around its top belies a magical secret: it shoots fireballs!";
		minDamage = 1;
		maxDamage = 2;
	}
	@Override
	public int ability() {
		return (int)Math.random()*20 + 10;
	}


}
