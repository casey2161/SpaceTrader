package spacetrader;

/**
 * Weapon class for Space Trader
 * @author georgeli94
 *
 */
public class Weapon {
	String name;
	private int damage, accuracy, ammo, minQuality;
	
	/**
	 * Constructor for Weapon with parameters for name, damage, accuracy, ammo size, and minimum
	 * quality ship needed to mount it
	 * @param name The name of the weapon
	 * @param damage The amount of damage the weapon can deal
	 * @param accuracy The accuracy of the weapon
	 * @param ammo The amount of ammo a particular weapon has
	 * @param minQuality The minimum quality of ship needed to mount the weapon
	 */
	public Weapon (String name, int damage, int accuracy, int ammo, int minQuality) {
		this.name = name;
		this.damage = damage;
		this.accuracy = accuracy;
		this.ammo = ammo;
		this.minQuality = minQuality;
	}
	
	/**
	 * Getter method for weapon damage
	 * @return The amount of damage the weapon can deal
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Getter method for accuracy
	 * @return The accuracy of the weapon
	 */
	public int getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Getter method for ammo
	 * @return The amount of ammo the weapon has
	 */
	public int getAmmo() {
		return ammo;
	}
	
	/**
	 * Getter method for minimm quality of the ship needed
	 * @return The minimum quality of ship needed to mount the weapon
	 */
	public int getMinQuality() {
		return minQuality;
	}
}