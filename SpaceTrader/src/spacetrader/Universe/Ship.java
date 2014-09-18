public class Ship {
	private String name;
	private int maxRange, size, quality, shield, currRange;
	private Weapon weapon;
	private Equipment[] equipmentSlots;
	
	public Ship (String name, int maxRange, int size, int quality) {
		this.name = name;
		this.maxRange = maxRange;
		this.quality = quality;
		this.size = size;
		shield = size*quality;
		currRange = maxRange;
	}
	
	public void addWeapon(Weapon newWeapon) {
		if (quality >= newWeapon.getMinQuality()) {
			weapon = newWeapon;
		} else {
			System.out.println("Your ship is too low-tech to use this weapon!");
		}
	}
	
	public void travel(int distance) {
		if (distance > currRange) {
			System.out.println("Planet is outside of the current range of your ship!");
		} else {
			currRange = currRange - distance;
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
	
	public void dealDamage (Ship opponent, int damageDealt) {
		opponent.takeDamage(damageDealt);
	}
}