package spacetrader;


import spacetrader.Universe.Planet;
import java.util.HashMap;

public class Ship {
	private String name;
	private int maxRange, size, quality, shield, currRange, maxCargo, currCargo;
	private Weapon weapon;
	private Planet location;
	private HashMap<String, Integer> cargo = new HashMap<String, Integer>();
	//private Equipment[] equipmentSlots;
	
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
	
	public void addWeapon(Weapon newWeapon) {
		if (quality >= newWeapon.getMinQuality()) {
			weapon = newWeapon;
		} else {
			System.out.println("Your ship is too low-tech to use this weapon!");
		}
	}
	
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
	
	public boolean hasRoom(int input) {
		return currCargo + input <= maxCargo;
	}
	
	public boolean canSell(String name, int amount) {
		return cargo.containsKey(name) && cargo.get(name) >= amount;
	}
	
	public void add(String name, int amount) {
		if (hasRoom) {
			cargo.put(name, amount);
			currCargo = currCargo + amount;
		} else {
			System.out.println("You don't have enough room");
		}
	}
	
	public void remove(String name, int amount) {
		if (canSell(name, amount)) {
			currCargo = currCargo - amount;
			cargo.put(name, cargo.get(name) - amount);
		} else {
			System.out.println("You can't sell this item.");
		}
	}
}