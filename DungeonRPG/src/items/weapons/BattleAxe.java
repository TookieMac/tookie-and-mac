package items.weapons;

public class BattleAxe extends Weapon{

	public BattleAxe() {
		name = "Battle axe";
		sDesc = "heavy, but effective.";
		lDesc = "A large and heavy weapon. The battle axe must be wielded with two hands "
				+ "but even then you are almost as likely to cut off your own limbs as those of an enemy.";
		minDamage = 10;
		maxDamage = 15;
	}

}
