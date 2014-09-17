package spacetrader.Universe;

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
    
    public Planet (String name, int level, int resourcelvl, int x, int y, boolean pirates) { //used for loading saved planet config from saved game
        planetName = name;
        techLevel = level;
        resources = resourcelvl;
        spawnsPirates = pirates;
        xPosition = x;
        yPosition = y;
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
    public String dumpInfo() { //dump method for demo purposes
        String dump = "Planet Name: " + planetName;
        dump += "\nTech Level: " + tchlvlString(techLevel);
        dump += "\nResources: " + rscString(resources);
        dump += "\nSpawn Pirates: " + spawnsPirates;
        dump += "\n";
        return dump;
    }
}  
    

