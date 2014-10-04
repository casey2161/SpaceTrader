package spacetrader.Universe;

/**
 *
 * @author Casey
 */
public class Universe {

    private static Universe universe;
    private SolarSystem[] solarSystems;
    
    private Universe(SolarSystem[] systems) {
        solarSystems = systems;
    }
    
    public static void createInstance() {
        //TODO Generate the universe
        SolarSystem[] solarSystems = new SolarSystem[7];
        
        universe = new Universe(solarSystems);
    }
    
    public static Universe getInstance() {
        return universe;
    }
    
    public SolarSystem getSolarSystem(int index) {
        return solarSystems[index];
    }
}
