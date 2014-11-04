package spacetrader.Universe;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;
import spacetrader.Ship;
import spacetrader.Flea;
import spacetrader.Weapon;
import spacetrader.Shield;

/*Nickolas Graham
 * C3POs team 27
 * Version 2.1 of Planet
 */
public class Planet implements Serializable{
    /* VALUE KEY: numbers correspond to 
     * TECH LEVELS --------------
     * 0 = Pre-Agriculture
     * 1 = Agriculture
     * 2 = Medieval
     * 3 = Renaissance
     * 4 = Early Industrial
     * 5 = Industrial
     * 6 = Post-Industrial
     * 7 = High Tech
     * RESOURCES ----------------
     * 0 = Non special resources
     * 1 = Mineral Rich
     * 2 = Mineral Poor
     * 3 = Desert
     * 4 = Lots of Water
     * 5 = Rich Soil
     * 6 = Poor Soil
     * 7 = Rich Fauna
     * 8 = Lifeless
     * 9 = Weird Mushrooms
     * 10 = Lots of herbs
     * 11 = Artistic
     * 12 = Warlike
     */
    
    private final String planetName;
    private final int xPosition, yPosition, techLevel, resources;
    private final boolean spawnsPirates;
    private static final String[] TECH_LEVEL = { "Pre Agriculture", "Agriculture", "Medieval",
            "Renaissance", "Early Industrial", "Industrial", "Post-Industrial", "High Tech" };
    private static final String[] RESOURCES = { "NOSPECIALRESOURCES", "MINERALRICH", "MINERALPOOR",
        "DESERT", "LOTSOFWATER", "RICHSOIL", "POORSOIL", "RICHFAUNA", "LIFELESS", "WEIRDMUSHROOMS",
        "LOTSOFHERBS", "ARTISTIC", "WARLIKE"};
    private HashMap<String, Integer> priceMap, cargoMap;
    private HashMap<String, Object> upgradeMap;
    
    public Planet (String name, int level, int resourcelvl, int x, int y, boolean pirates,
            HashMap<String, Integer> prices, HashMap<String, Integer> amount) {//used for loading saved planet config from saved game
        planetName = name;
        techLevel = level;
        resources = resourcelvl;
        spawnsPirates = pirates;
        xPosition = x;
        yPosition = y;
        priceMap = prices;
        this.cargoMap = amount;
        this.upgradeMap = new HashMap<String, Object>();
        this.generateUpgradeMap();
        //this.computePrices();
    }
    public String getName() { //returns the name of the planet
        return planetName;
    }
    public int getTechLevel() { //returns the tech level of the planet
        return techLevel;
    }
    public int getResources() { //returns the resource type of the planet
        return resources;
    }
    public boolean spawnsPirates() { //returns whether the planet spawns pirates
        return spawnsPirates;
    }
    public int getX() { //returns x position
        return xPosition;
    }
    public int getY() {//returns y position
        return yPosition;
    }
    public String tchlvlString(int level) { //returns tech level as a string
        String returnStr = TECH_LEVEL[level];
        return returnStr;   
    }
    public String rscString(int resources) { //returns resources as a string
        String returnStr = RESOURCES[resources];
        return returnStr;
    }
    
    public int getAmount(String key) {//gets amount of goods one can buy
        return cargoMap.get(key.toLowerCase());
    }
    public void updateAmount(String key, int value) {//updates quantity of goods
        cargoMap.put(key.toLowerCase(), value);
    }
    
    public Object[] returnMap() {// returns quantities as array
        Set result = cargoMap.entrySet();
        Object[] array = result.toArray();
        return array;
    }
    
    public int getPrice(String key) {//returns item price
        return priceMap.get(key.toLowerCase());
    }
    public Object[] returnPriceMap() {// returns prices as array
        Set result = priceMap.entrySet();
        Object[] array = result.toArray();
        return array;
    }
    public String dumpInfo() { //dump method for demo purposes
        String dump = "Planet Name: " + planetName;
        dump += "\nTech Level: " + tchlvlString(techLevel);
        dump += "\nResources: " + rscString(resources);
        dump += "\nSpawn Pirates: " + spawnsPirates;
        dump += "\nCargo: " + dumpMap(cargoMap);
        dump += "\nPrices: " + dumpMap(priceMap);
        dump += "\n---------------------------------------------\n";
        return dump;
    }
    
    private String dumpMap(HashMap<String, Integer> map) {
        String ret = "";
        for( HashMap.Entry e : map.entrySet()) {
            ret+= e.getKey() + ": " + e.getValue() + "\n"; 
        }
        return ret;
    }
    
    public boolean isEncounter() {
        if(spawnsPirates) {
            return Math.random() <= 0.5;
        } else {
            return Math.random() <= 0.1;
        }
    }
    
    public Ship getEncounterShip() {
        Ship encounter;
        String name;
        int size = (int)(Math.random() * 2) + 5;
        if(Math.random() <=0.5) {
            name = "Pirate";
        } else {
            name = "Police";
        }
        int quality = 0;
        if(techLevel < 3) {
            quality = 1;
        } else if(techLevel < 5) {
            quality = 2;
        } else {
            quality = 3;
        }
        
        encounter = new Flea();
        encounter.addWeapon(new Weapon("Weaker Laser", 2, 30, 1, 1000));
        return encounter;
    }
    
    private void computePrices() {
        Random rand = new Random();
        priceMap.put("Water", (int) (30 + 3 * techLevel + 30 * rand.nextFloat()));
        priceMap.put("Furs", (int) (250 + 10 * techLevel + 250 * rand.nextFloat()));
        priceMap.put("Food", (int) (100 + 5 * (techLevel - 1) + 100 * rand.nextFloat()));
        priceMap.put("Ore", (int) (350 + 20 * (techLevel - 2) + 350 * rand.nextFloat()));
        priceMap.put("Games", (int) (250 + -10 * (techLevel - 3) + 250 * rand.nextFloat()));
        priceMap.put("Firearms", (int) (1250 + -75 * (techLevel - 3) + 1250 * rand.nextFloat()));
        priceMap.put("Medicine", (int) (650 + -20 * (techLevel - 4) + 650 * rand.nextFloat()));
        priceMap.put("Machines", (int) (900 + -30 * (techLevel - 4) + 900 * rand.nextFloat()));
        priceMap.put("Narcotics", (int) (3500 + -125 * (techLevel - 5) + 3500 * rand.nextFloat()));
        priceMap.put("Robots", (int) (5000 + -150 * (techLevel - 6) + 5000 * rand.nextFloat()));
    }

    public void generateUpgradeMap() {
        Random gen = new Random();
        Weapon cheapWeapon = new Weapon("Lo-power Lazer", (int) (techLevel*(1.5)), Integer.MAX_VALUE, 0,
        (int) (1500*(1 + gen.nextFloat())));
        Weapon midTier = new Weapon("Mid-Power Lazer", (int) (gen.nextInt(6) + 1 + techLevel*1.75), Integer.MAX_VALUE, 0,
        (int) (3000*(1.2 + gen.nextFloat())));
        Weapon highTier = new Weapon("Hi-Power Lazer", gen.nextInt(5) + 5 + techLevel*2, Integer.MAX_VALUE,0,
        (int) (5000*(1.5 + gen.nextFloat())));
        upgradeMap.put("Lo-power Lazer", cheapWeapon);
        upgradeMap.put("Mid-Power Lazer", midTier);
        upgradeMap.put("Hi-Power Lazer", highTier);

        if(techLevel >= 5 && gen.nextFloat() < 0.5) {
            upgradeMap.put("Escape Pod", 10000);
        }

        Shield cheapShield = new Shield(techLevel * (2 * (gen.nextInt(5) + 1)), gen.nextBoolean(), gen.nextBoolean(),
        (int) (3000 * (1 + (techLevel * gen.nextFloat()))));
        Shield goodShield = new Shield(techLevel * (4 * (gen.nextInt(7) + 1)), gen.nextBoolean(), gen.nextBoolean(),
        (int) (5000 * (1.2 + (techLevel * gen.nextFloat()))));
        upgradeMap.put("Shield Level 1", cheapShield);
        upgradeMap.put("Shield Level 2", goodShield);

    }

    public HashMap<String, Object> getUpgrades() {
        return upgradeMap;
    }
}  
    

