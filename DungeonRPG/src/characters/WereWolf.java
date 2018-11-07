package characters;

import java.util.Random;

public class WereWolf extends Character{
	private Random rand = new Random();

	public WereWolf() {
		super(5, 1, 2);
		name = "Were wolf";
		lvl = 1;
		MAX_HP = 30;
		hp = MAX_HP;
	}

	protected int damage(){
		int att = rand.nextInt(60);
		if (att <=10) {//all 3 attacks
			return (rand.nextInt(7 + 3)) + (4^str) + (rand.nextInt(7)+3) + (4^str) + (rand.nextInt(10) + 5) + (4^str);
		}
		else if (att <= 30) {
			int attackOne = rand.nextInt(3);
			int attackTwo = rand.nextInt(3);
			if (attackOne == 1 || attackOne == 2) {
				attackOne = (rand.nextInt(7)+3) + (4^str);
			}
			else if (attackOne == 3) {
				attackOne = (rand.nextInt(10) + 5) + (4^str);
			}
			if (attackTwo == 1 || attackTwo == 2) {
				attackTwo = (rand.nextInt(7)+3) + (4^str);
			}
			else if (attackTwo == 3) {
				attackTwo = (rand.nextInt(10) + 5) + (4^str);
			}
			return attackOne + attackTwo;
		}
		else {
			return (rand.nextInt(10) + 5) + (4^str);
		}		
	}

}
