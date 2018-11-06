package characters;

import java.util.ArrayList;

import items.Item;
import items.weapons.Weapon;

public abstract class Character {
	protected final int MAX_HP;
	protected int str;
	protected int wis;
	protected int dex;
	protected int hp;
	protected String name;
	protected ArrayList<Item> inventory;
	protected Weapon primaryWeapon;
	protected Item offHand;

	/**
	 * 
	 * @param str - characters strength
	 * @param wis - characters wisdom
	 * @param dex - characters dexterity
	 */
	public Character (final int str, final int wis, final int dex) {
		this.str = str;
		this.wis = wis;
		this.dex = dex;
		this.inventory = new ArrayList<Item>();
		this.hp = 0;
		this.name = "";
		this.MAX_HP = 0;
		this.primaryWeapon = null;
		this.offHand = null;
	}

	public void attack(Character target) {

	}
	protected int damage() {
		return 2 * (str - 1);
	}
	protected int dodgeChance() {
		return 100 / 5 * (dex -1);
	}

	public void displayDetails() {
		System.out.println("name: " + name);
		System.out.println("stats [str: " + str + ", wis:" + wis + ", dex: " + dex + "]" );
		System.out.println("Health: " + hp + " (max " + MAX_HP +")");
		System.out.println("damage: " + damage());
		System.out.println("dodge chance: " + dodgeChance());
		if (primaryWeapon != null) {
			System.out.println("weapon: [" + primaryWeapon.getsDesc() + "]");
		}
		if (offHand != null) {
			System.out.println("item/off hand: [" + offHand.getsDesc() + "]");
		}
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
	public void setOffHand(Item offHand) {
		this.offHand = offHand;
	}



}
