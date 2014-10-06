package spacetrader.Universe;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.Random;

/*Nickolas Graham
 * C3POs team 27
 * Version 2.1 of Planet
 */
public class Planet {
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
        //this.computePrices();
    }
    public String getName() { //returns the name of the planet
        return planetName;
    }
    public int getTechLevel() { //returns the tech level of the planet
        return techLevel;
    }
    public int getResouces() { //returns the resource type of the planet
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
        dump += "\nCargo: " + Arrays.toString(this.returnMap());
        dump += "\nPrices: " + Arrays.toString(this.returnPriceMap());
        dump += "\n---------------------------------------------\n";
        return dump;
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
}  
    

