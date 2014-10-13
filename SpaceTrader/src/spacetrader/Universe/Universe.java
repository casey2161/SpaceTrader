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
    
    //This is an incredibly slow operation
    public Planet getPlanet(String xLoc, String yLoc) {
        int x = Integer.parseInt(xLoc);
        int y = Integer.parseInt(yLoc);
        for(SolarSystem s : solarSystems) {
            for(int i = 0; i < s.getNumPlanets(); i++) {
                Planet p = s.getPlanet(i);
                if(p.getX() == x && p.getY() == y) {
                    return p;
                }
            }
        }
        return null;
    }
    
    public String saveUniverse() {
        String ret = "";
        for(SolarSystem s : solarSystems) {
            ret += s.saveSolarSystem() ;
        }
        return ret;
    }
}
