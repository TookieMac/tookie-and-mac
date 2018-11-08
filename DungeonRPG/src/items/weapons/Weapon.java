package items.weapons;

import enchantments.Enchantment;
import items.Item;

public abstract class Weapon extends Item{
	protected int maxDamage;
	protected int minDamage;
	protected Enchantment enchantment;

	public Weapon(){
		maxDamage = 0;
		minDamage = 0;
		enchantment = null;
	}
	
	protected void Enchant(Enchantment enchantment) {
		this.enchantment = enchantment;
		if (enchantment.isSuffix()){
			name += " " + enchantment.getName();
		}
		else {
			name = enchantment.getName() + " " + name;
		}
	}


	public int getDamage() {
		return (int)Math.random() * maxDamage + minDamage + ability();
	}
	
	public int ability() {
		return 0;
	}


	@Override
	public String toString() {
		return "Weapon [maxDamage=" + maxDamage + ", minDamage=" + minDamage + ", enchantment="
				+ enchantment.toString() + ", name=" + name + ", sDesc=" + sDesc + ", lDesc=" + lDesc + "]";
	}
}
