package spacetrader;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Ship class for Space Trader
 * 
 * @author georgeli94
 *
 */
public abstract class Ship implements Serializable{
	private String name;
	private int maxRange, size, quality, hull, maxHull, currRange, maxCargo;
        private Weapon[] weaponSlots;
        private Shield[] shieldSlots;
        private int weaponSlot = 0, shieldSlot = 0;
	private HashMap<String, Integer> cargo = new HashMap<String, Integer>();
        private boolean escapePod;
	//private Equipment[] equipmentSlots;
	
	/**
	 * Constructor for Ship with parameters for name, maximum range, size of the ship, quality
	 * of the ship and location of the ship.
	 * @param name The name of the ship
	 * @param maxRange The maximum range the ship can travel on full fuel
	 * @param size The size of the ship
	 * @param quality The quality of the ship
	 */
	public Ship (String name, int maxRange, int size, int quality, 
                int maxCargo, int weaponSlotNumber, int shieldSlotNumber) {
		this.name = name;
		this.maxRange = maxRange;
		this.quality = quality;
		this.size = size;
                if (weaponSlotNumber != 0) {
                    weaponSlots = new Weapon[weaponSlotNumber];
                }
                if (shieldSlotNumber != 0) {
                    shieldSlots = new Shield[shieldSlotNumber];
                }
		maxHull = size*quality;
                hull = maxHull;
		currRange = maxRange;
		this.maxCargo = maxCargo;
                cargo = initCargoBay();
	}
        
        private HashMap<String, Integer> initCargoBay() {
            HashMap<String, Integer> cargo = new HashMap<String, Integer>();
            cargo.put("water", 0);
            cargo.put("fur", 0);
            cargo.put("food", 0);
            cargo.put("ore", 0);
            cargo.put("games", 0);
            cargo.put("firearms", 0);
            cargo.put("medicine", 0);
            cargo.put("machines", 0);
            cargo.put("narcotics", 0);
            cargo.put("robots", 0);
            return cargo;
        }
        public String getName() {
            return name;
        }
        
        public int getMaxRange() {
            return maxRange;
        }
        
        public int getQuality() {
            return quality;
        }
        
        public int getSize() {
            return size;
        }
        
        public int getHull() {
            return hull;
        }
	
        public int getCurrRange() {
            return currRange;
        }
        
        public Weapon getWeapon() {
            for (int i = 0; i < weaponSlots.length; i++) {
                return weaponSlots[i];
            }
            return null;
        }
        
        public Shield getShield() {
            for (int i = 0; i < shieldSlots.length; i++) {
                return shieldSlots[i];
            }
            return null;
        }
        
	/**
	 * Adds a new weapon to the ship
	 * @param newWeapon The weapon being added
	 */
	public void addWeapon(Weapon newWeapon) {
		if (quality >= newWeapon.getMinQuality() && weaponSlot < weaponSlots.length) {
			weaponSlots[weaponSlot] = newWeapon;
                        weaponSlot++;
		} else {
			System.out.println("You can't use this weapon!");
		}
	}

        public void addShield(Shield newShield) {
            if (shieldSlot < shieldSlots.length) {
			shieldSlots[shieldSlot] = newShield;
                        shieldSlot++;
		} else {
			System.out.println("You can't use this shield!");
		}
        }
        
	/**
	 * Changes new current range
	 * @param input The new current possible range
	 */
	public void setCurrRange(int input) {
            currRange = input;
	}
	
	/**
	 * Resets the ship's current travelable range to the maximum travelable range
	 */
	public void refuel() {
		currRange = maxRange;
	}
	
	public void takeDamage(int damageTaken) {
            if (shieldSlots.length != 0 && shieldSlots[0] != null) {
                for (int i = 0; i <= shieldSlot; i++) {
                    damageTaken = shieldSlots[i].absorbDamage(damageTaken);
                    if (damageTaken <= 0) {
                        damageTaken = 0;
                    }
                }
            }
            if (hull - damageTaken <= 0) {
                hull = 0;
            } else {
                hull = hull - damageTaken;
            }
	}
	
	/**
	 * Deals damage to an opposing ship
	 * @param opponent The opposing ship
	 */
	public void dealDamage (Ship opponent) {
            if (weaponSlots.length == 0 || weaponSlots[0] == null) {
                System.out.println("You can't fire a weapon!");
            } else {
                for (int i = 0; i < weaponSlot; i++) {
                    if (weaponSlots[i].getAmmo() > 0) {
                        weaponSlots[i].fireWeapon();
                        opponent.takeDamage((int)(weaponSlots[i].getDamage() * Math.random()));
                    }
                }
            }
	}
	
	/**
	 * Determines if the ship has enough room to hold a particular amount of cargo
	 * @param input The amount of cargo the player wishes to add to the ship
	 * @return A boolean determining whether or not the cargo can be added
	 */
	public boolean hasRoom(int input) {
		return getCurrentCargo() + input <= maxCargo;
	}
	
	/**
	 * Determines if the ship has enough cargo to sell in the specified amounts
	 * @param name The name of the cargo being sold
	 * @param amount The amount the player wants to sell
	 * @return A boolean determining whether or not the player can sell the specified cargo in the
	 * specified amounts
	 */
	public boolean canSell(String name, int amount) {
	    return cargo.containsKey(name.toLowerCase()) && cargo.get(name.toLowerCase()) >= amount;
	}
	
	/**
	 * Adds a specified amount of a specified cargo to the ship
	 * @param name The name of the cargo being added
	 * @param amount The amount of the cargo being added
	 */
	public void add(String name, int amount) {
		if (hasRoom(amount)) {
			cargo.put(name.toLowerCase(), getAmount(name) + amount);
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
            name = name.toLowerCase();
            if (canSell(name, amount)) {
                cargo.put(name, cargo.get(name) - amount);
            } else {
		System.out.println("You can't sell this item.");
            }
	}
        
        /**
	 * Returns the capacity left in the cargo
	 * 
	 * @return An int representing the current cargo
	 */
        public int getCurrentCargo() {
            int currCargo = 0;
            Iterator it = cargo.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                currCargo += (Integer) pairs.getValue();
            }
            return currCargo;
        }
        
        /**
	 * Returns the maximum capacity of the cargo
	 * 
	 * @return An int representing the max cargo
	 */
        public int getMaxCargo() {
            return maxCargo;
        }
        
        /**
	 * Returns the amount of a specified resource
	 * @param key a string representing the item
	 * @return An int representing the amount of resource
	 */
        public int getAmount(String key) {
            return cargo.get(key.toLowerCase());
        }
        
        public int getMaxHull() {
            return maxHull;
        }
        
        public boolean isDestroyed() {
            return hull <= 0;
        }

        public void emptyCargo() {
            cargo = new HashMap<String, Integer>();
            cargo.put("water", 0);
            cargo.put("fur", 0);
            cargo.put("food", 0);
            cargo.put("ore", 0);
            cargo.put("games", 0);
            cargo.put("firearms", 0);
            cargo.put("medicine", 0);
            cargo.put("machines", 0);
            cargo.put("narcotics", 0);
            cargo.put("robots", 0);
        }

        public void repair() {
            hull = maxHull;
        }
        
        public boolean getEscapePod() {
            return escapePod;
        }
        
        public void setEscapePod(boolean flag) {
            escapePod = flag;
        }
        
        public void setName(String newName) {
            name = newName;
        }
}
