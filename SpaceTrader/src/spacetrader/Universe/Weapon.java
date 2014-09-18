public abstract class Weapon {
	protected int damage, accuracy, ammo, minQuality;
	
	public Weapon (int damage, int accuracy, int ammo, int minQuality) {
		this.damage = damage;
		this.accuracy = accuracy;
		this.ammo = ammo;
		this.minQuality = minQuality;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getAmmo() {
		return ammo;
	}
	
	public int getMinQuality() {
		return minQuality;
	}
}