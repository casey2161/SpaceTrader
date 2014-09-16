package SpaceTrader;

public abstract class Ship {
	protected int shield, speed;
	protected Weapon weapon;
	
	public Ship (int shield, int speed, Weapon weapon) {
		this.shield = shield;
		this.speed = speed;
		this.weapon = weapon;
	}
}