package spacetrader;

public class Shield {
    private int charge, chargeTime, maxCharge;
    private boolean isReflective, isExplosive;
    
    public Shield(int maxCharge, int chargeTime, boolean isReflective, boolean 
            isExplosive) {
        this.maxCharge = maxCharge;
        this.chargeTime = chargeTime;
        this.isReflective = isReflective;
        this.isExplosive = isExplosive;
        charge = maxCharge;
    }
    
    public int getCharge() {
        return charge;
    }
    
    public int getChargeTime() {
        return chargeTime;
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
        int recharge = distance*chargeTime;
        if (charge+recharge >= maxCharge) {
            charge = maxCharge;
        } else {
            charge += recharge;
        }
    }
    
    public void takeDamage(int damage) {
        if (charge - damage <= 0) {
            charge = 0;
        } else {
            charge -= damage;
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