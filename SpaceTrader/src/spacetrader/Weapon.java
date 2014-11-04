package spacetrader;

/**
 * Weapon class for Space Trader
 * @author georgeli94
 *
 */
public class Weapon {
        
	private String name;
	private int damage, ammo, minQuality, price;
	
	/**
	 * Constructor for Weapon with parameters for name, damage, accuracy, ammo size, and minimum
	 * quality ship needed to mount it
	 * @param name The name of the weapon
	 * @param damage The amount of damage the weapon can deal
	 * @param ammo The amount of ammo a particular weapon has
	 * @param minQuality The minimum quality of ship needed to mount the weapon
	 */
	public Weapon (String name, int damage, int ammo, int minQuality, int price) {
		this.name = name;
		this.damage = damage;
		this.ammo = ammo;
		this.minQuality = minQuality;
                this.price = price;
	}
        
        public String getName() {
            return name;
        }
        public int getPrice() {
            return price;
        }
	/**
	 * Getter method for weapon damage
	 * @return The amount of damage the weapon can deal
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Getter method for ammo
	 * @return The amount of ammo the weapon has
	 */
	public int getAmmo() {
		return ammo;
	}
	
	/**
	 * Getter method for minimum quality of the ship needed
	 * @return The minimum quality of ship needed to mount the weapon
	 */
	public int getMinQuality() {
		return minQuality;
	}
        
        public void fireWeapon() {
            ammo--;
        }
}