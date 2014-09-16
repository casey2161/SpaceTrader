package spacetrader.Universe;

public abstract class Weapon {
	protected int damage, accuracy, ammo;
	
	public Weapon (int damage, int accuracy, int ammo) {
		this.damage = damage;
		this.accuracy = accuracy;
		this.ammo = ammo;
	}
}