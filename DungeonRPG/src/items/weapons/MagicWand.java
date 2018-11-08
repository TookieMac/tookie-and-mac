package items.weapons;

import characters.Player;

public class MagicWand extends Weapon{
	private Player player;

	public MagicWand(Player player) {
		this.player = player;
		name = "Magic wand";
		sDesc = "birch with angel’s feather core and rubberised leather grip.";
		lDesc = "Apparently, there is no other wand like this one in existence. "
				+ "The angel’s feather at its core allows the bearer to perform unbelievable feats of healing";
		minDamage = 5;
		maxDamage = 10;
	}
	@Override
	public  int ability() {
		player.setHp(player.getMAX_HP());
		return 0;
	}

}
