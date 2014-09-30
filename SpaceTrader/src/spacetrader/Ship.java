package spacetrader;


import spacetrader.Universe.Planet;
import java.util.HashMap;
/**
 * Ship class for Space Trader
 * 
 * @author georgeli94
 *
 */
public class Ship {
	private String name;
	private int maxRange, size, quality, shield, currRange, maxCargo, currCargo;
	private Weapon weapon;
	private Planet location;
	private HashMap<String, Integer> cargo = new HashMap<String, Integer>();
	//private Equipment[] equipmentSlots;
	
	/**
	 * Constructor for Ship with parameters for name, maximum range, size of the ship, quality
	 * of the ship and location of the ship.
	 * @param name The name of the ship
	 * @param maxRange The maximum range the ship can travel on full fuel
	 * @param size The size of the ship
	 * @param quality The quality of the ship
	 * @param location The Planet the ship is at
	 */
	public Ship (String name, int maxRange, int size, int quality, Planet location) {
		this.name = name;
		this.maxRange = maxRange;
		this.quality = quality;
		this.size = size;
		this.location = location;
		shield = size*quality;
		currRange = maxRange;
		maxCargo = size*quality;
		currCargo = 0;
	}
	
	/**
	 * Adds a new weapon to the ship
	 * @param newWeapon The weapon being added
	 */
	public void addWeapon(Weapon newWeapon) {
		if (quality >= newWeapon.getMinQuality()) {
			weapon = newWeapon;
		} else {
			System.out.println("Your ship is too low-tech to use this weapon!");
		}
	}
	
	/**
	 * Travels to the specified Planet
	 * @param destination The planet that the ship is travelling to
	 */
	public void travel(Planet destination) {
		int distance = (int) Math.sqrt(Math.pow(destination.getX() - location.getX(), 2)
                        + Math.pow(destination.getY() - location.getY(), 2));
		if (distance > currRange) {
			System.out.println("Planet is outside of the current range of your ship!");
		} else {
			currRange = currRange - distance;
			location = destination;
		}
	}
	
	/**
	 * Resets the ship's current traveable range to the maximum traveable range
	 */
	public void refuel() {
		currRange = maxRange;
	}
	
	public void takeDamage(int damageTaken) {
		if (shield - damageTaken <= 0) {
			System.out.println("Your ship has been destroyed!");
		} else {
			shield = shield - damageTaken;
		}
	}
	
	/**
	 * Deals damage to an opposing ship
	 * @param opponent The opposing ship
	 */
	public void dealDamage (Ship opponent) {
		if (weapon.getAmmo() <= 0) {
			System.out.println("You're out of ammo! Can't shoot!");
		} else {
			int hit = (int) Math.random()*7;
			if (hit <= weapon.getAccuracy()) {
				opponent.takeDamage(weapon.getDamage());
			}
		}
	}
	
	/**
	 * Determines if the ship has enough room to hold a particular amount of cargo
	 * @param input The amount of cargo the player wishes to add to the ship
	 * @return A boolean determining whether or not the cargo can be added
	 */
	public boolean hasRoom(int input) {
		return currCargo + input <= maxCargo;
	}
	
	/**
	 * Determines if the ship has enough cargo to sell in the specified amounts
	 * @param name The name of the cargo being sold
	 * @param amount The amount the player wants to sell
	 * @return A boolean determing whether or not the player can sell the specified cargo in the
	 * specified amounts
	 */
	public boolean canSell(String name, int amount) {
		return cargo.containsKey(name) && cargo.get(name) >= amount;
	}
	
	/**
	 * Adds a specified amount of a specified cargo to the ship
	 * @param name The name of the cargo being added
	 * @param amount The amount of the cargo being added
	 */
	public void add(String name, int amount) {
		if (hasRoom(amount)) {
			cargo.put(name, amount);
			currCargo = currCargo + amount;
		} else {
			System.out.println("You don't have enough room");
		}
	}
	
	/**
	 * Removes a specified amount of a specified cargo from the ship
	 * @param name The name of the cargo being removed
	 * @param amount The amount of the cargo being removed
	 */
	public void remove(String name, int amount) {
		if (canSell(name, amount)) {
			currCargo = currCargo - amount;
			cargo.put(name, cargo.get(name) - amount);
		} else {
			System.out.println("You can't sell this item.");
		}
	}
        
        public int getAmount(String key) {
        Object result;
        result = cargo.get(key);
        return (int) result;
        }
        
        public void updateAmount(String key, int value) {
            cargo.put(key, value);
        }
        
        public int getCurrentCargo() {
            return currCargo;
        }
        
        public int getMaxCargo() {
            return maxCargo;
        }
}