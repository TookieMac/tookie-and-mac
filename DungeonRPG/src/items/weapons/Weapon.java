package items.weapons;

import java.util.Random;

import enchantments.Enchantment;
import items.Item;

public abstract class Weapon extends Item{
	protected int maxDamage;
	protected int minDamage;
	protected Enchantment ability;
	protected Enchantment enchantment;
	
	public Weapon(){
		maxDamage = 0;
		minDamage = 0;
		ability = null;
		enchantment = null;
	}
	
	
	public int getDamage() {
		Random rand = new Random();
		return rand.nextInt(maxDamage) + minDamage;
	}


	@Override
	public String toString() {
		return "Weapon [maxDamage=" + maxDamage + ", minDamage=" + minDamage + ", ability=" + ability.toString() + ", enchantment="
				+ enchantment.toString() + ", name=" + name + ", sDesc=" + sDesc + ", lDesc=" + lDesc + "]";
	}
}
