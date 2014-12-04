package spacetrader;

public class Shield {
    private int charge, maxCharge, price;
    private boolean isReflective, isExplosive;
    
    public Shield(int maxCharge, boolean isReflective, boolean 
            isExplosive, int price) {
        this.maxCharge = maxCharge;
        this.isReflective = isReflective;
        this.isExplosive = isExplosive;
        charge = maxCharge;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public int getCharge() {
        return charge;
    }
    
    public int getMaxCharge() {
        return maxCharge;
    }
    
    public boolean isReflective() {
        return isReflective;
    }
    
    public boolean isExplosive() {
        return isExplosive;
    }
    
    public void recharge(int distance) {
        charge = maxCharge;
    }
    
    public int absorbDamage(int damage) {
        if (charge - damage <= 0) {
            damage = damage - charge;
            charge = 0;
            return damage;
        } else {
            charge -= damage;
            return 0;
        }
    }
    
    public void dealDamage(int damage, Ship opponent) {
        if (isReflective) {
            opponent.takeDamage((int) Math.random() * damage);
        }
    }
    
    public void explode(Ship opponent) {
        if (isExplosive && charge == 0) {
            opponent.takeDamage((int) Math.random() * 10);
        }
    }
}