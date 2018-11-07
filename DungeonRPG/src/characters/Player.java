package characters;

import items.Item;
import items.consumables.Consumable;
import items.weapons.Fists;
import items.weapons.Weapon;

public class Player extends Character{
	private int lvlPoints;
	private Consumable item;
	/**
	 * create a new player
	 * @param str - player strength
	 * @param wis - player wisdom
	 * @param dex - player dexterity
	 */
	public Player() {
		super (1, 1, 1);
		this.hp = 50;
		this.MAX_HP = 50;
		this.lvlPoints = 6;
		this.lvl = 1;
		this.primaryWeapon = new Fists();
		offHand = null;
	}
	public void pickup(Item item) {
		inventory.add(item);
		if (item.getClass().getSuperclass().getSimpleName().equals("Weapon")) {
			if (primaryWeapon == null || primaryWeapon.getClass().getSimpleName().equals("Fists")){
				primaryWeapon = (Weapon) item;
				System.out.println(item.getName() + "equipped to primary slot");
			}
			else if (offHand == null) {
				offHand = (Weapon) item;
				System.out.println(item.getName() + "equipped to off hand slot");
			}
		}
		else if (item.getClass().getSuperclass().getSimpleName().equals("Consumable")) {
			if (this.item == null) {
				this.item = (Consumable) item;
				System.out.println(item.getName() + "equipped to item slot");
			}
		}
	}

	public void UseItem() {
		if (item.getClass().getSimpleName().equals("HealthPotion")) {
			hp +=item.effect();
			if (hp >= MAX_HP) {
				hp = MAX_HP;
			}
			System.out.println("your health is now: " + hp);
		}
	}

	public int getLvlPoints() {
		return lvlPoints;
	}
	public void setLvlPoints(int lvlPoints) {
		this.lvlPoints = lvlPoints;
	}

	@Override
	public String toString() {
		return "name: " + name + ", hp: " + hp + "\nstr: " + str + ", wis: " + wis + ", dex: " + dex;
	}
}
