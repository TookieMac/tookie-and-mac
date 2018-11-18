package characters;

import java.util.ArrayList;
import java.util.Random;
import items.*;
import items.weapons.*;

public abstract class Character {
	protected int MAX_HP;
	protected int lvl;
	protected int ap;
	protected int str;
	protected int wis;
	protected int dex;
	protected int hp;
	protected String name;
	protected ArrayList<Item> inventory;
	protected Weapon primaryWeapon;
	protected Weapon offHand;
	protected Random rand = new Random();

	/**
	 * create a new character with the given strenght, wisdom, and dexterity
	 * @param str - characters strength
	 * @param wis - characters wisdom
	 * @param dex - characters dexterity
	 */
	public Character (final int str, final int wis, final int dex) {
		this.str = str;
		this.wis = wis;
		this.dex = dex;
		this.lvl = 1;
		this.inventory = new ArrayList<Item>();
		this.hp = 0;
		this.name = "";
		this.ap = 0;
		this.MAX_HP = 0;
		this.primaryWeapon = null;
		this.offHand = null;
	}
	/**
	 * attack the targeted character
	 * @param target -the target character
	 * @return - true if the attack lands
	 */
	public boolean attack(Character target) {
		int dodge = rand.nextInt(100);
		//if both characters have the godset, just act as if neither have it
		if (target.hasGodset() && this.hasGodset()) {
			if (dodge > target.dodgeChance()) {
				target.setHp(target.getHp() - damage());
			}
			else {
				System.out.println(target.getName() + " dodges the attack");
			}
		}
		else {
			if (target.getOffHand() instanceof GodSet || target.getPrimaryWeapon() instanceof GodSet) {
				System.out.println("use of the god set makes " + target.getName() + " take no damage");
			}
			// if the hit lands
			else if (dodge > target.dodgeChance()) {
				target.setHp(target.getHp() - damage());
			}
			else {
				System.out.println(target.getName() + " dodges the attack");
			}
		}
	}
	/**
	 * get a string representation of the characters inventory and print the inventory to the screen
	 * @return - the string representation of the characters inventory
	 */
	public String displayInventory() {
		String res = "";
		for (int item = 0; item < inventory.size(); item ++) {
			res += inventory.get(item).getName() + "\n";
		}
		System.out.println(res);
		return res;
	}

	protected int damage() {
		return str;
	}

	protected int dodgeChance() {
		return (5 * (dex - 1));//removed the /100 from begginign as the the dodge chance would go over 100 at times when it was left in
	}

	/**
	 * display the details about the character
	 * @return character details
	 */
	public String getDetails() {
		String res = "";
		res += "type: " + getClass().getSimpleName() + "\n";
		res += "name: " + name + "\n";
		res += "stats [str: " + str + ", wis:" + wis + ", dex: " + dex + "]" + "\n";
		res += "Health: " + hp + " (max " + MAX_HP +")\n";
		res += "damage: " + damage() + "\n";
		res += "dodge chance: " + dodgeChance() + "\n";
		if (primaryWeapon != null) {
			res += "weapon: [" + primaryWeapon.getsDesc() + "]\n";
		}
		if (offHand != null) {
			res += "item/off hand: [" + offHand.getsDesc() + "]\n";
		}
		return res;
	}

	/**
	 * check if character has the godset equipped
	 * @return
	 */
	private boolean hasGodset() {
		if (this.primaryWeapon instanceof GodSet || this.offHand instanceof GodSet) {
			return true;
		}
		return false;
	}
	//accesors and mutators
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getWis() {
		return wis;
	}
	public void setWis(int wis) {
		this.wis = wis;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public Weapon getPrimaryWeapon() {
		return primaryWeapon;
	}
	public void setPrimaryWeapon(Weapon primaryWeapon) {
		this.primaryWeapon = primaryWeapon;
	}
	public Item getOffHand() {
		return offHand;
	}
	public void setOffHand(Weapon offHand) {
		this.offHand = offHand;
	}
	public int getMAX_HP() {
		return MAX_HP;
	}
}
