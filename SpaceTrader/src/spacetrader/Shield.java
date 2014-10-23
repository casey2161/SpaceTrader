package spacetrader;

public class Shield {
    private int charge, maxCharge;
    private boolean isReflective, isExplosive;
    
    public Shield(int maxCharge, boolean isReflective, boolean 
            isExplosive) {
        this.maxCharge = maxCharge;
        this.isReflective = isReflective;
        this.isExplosive = isExplosive;
        charge = maxCharge;
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
            charge = 0;
            return damage - charge;
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