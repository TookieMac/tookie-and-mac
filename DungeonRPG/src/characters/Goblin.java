package characters;

public class Goblin extends Character{ 
	public Goblin() {
		super(2, 1, 4);
		hp = MAX_HP;
		name = "Goblin";
	}
	
	@Override
	public int damage() {
		return primaryWeapon.getDamage() + (1^str);
	}

}
