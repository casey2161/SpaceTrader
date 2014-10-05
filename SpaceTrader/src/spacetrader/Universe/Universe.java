package spacetrader.Universe;

/**
 *
 * @author Casey
 */
public class Universe {

    private static Universe universe = createInstance();
    private SolarSystem[] solarSystems;
    
    private Universe(SolarSystem[] systems) {
        solarSystems = systems;
    }
    
    private static Universe createInstance() {
        SolarSystem[] s = new SolarSystem[8];
        s[0] = new SolarSystem("System" + 0, 0, 0, 0);
        for(int i = 1; i < 8; i++) {
            int x = (int) (Math.random() * 150);
            int y = (int) (Math.random() * 150);
            s[i] = new SolarSystem("System" + i, i, x, y);
        }
        return new Universe(s);
    }
    
    public static Universe getInstance() {
        return universe;
    }
    
    public SolarSystem getSolarSystem(int index) {
        return solarSystems[index];
    }
    
    public SolarSystem[] getSolarSystems() {
        return solarSystems;
    }
    public void dumpInfo() {
        System.out.println(solarSystems[0].dumpInfo());
    }
}
