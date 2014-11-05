package spacetrader.Universe;

import java.io.Serializable;

/**
 *
 * @author Casey
 */
public class Universe implements Serializable {

    private static Universe universe = createInstance();
    private SolarSystem[] solarSystems;
    
    private Universe(SolarSystem[] systems) {
        solarSystems = systems;
    }
    
    private static Universe createInstance() {
        SolarSystem[] s = new SolarSystem[8];
        s[0] = new SolarSystem("System" + 0, 0, 0, 0);
        for (int i = 1; i < 8; i++) {
            int x = (int) (Math.random() * 150);
            int y = (int) (Math.random() * 150);
            s[i] = new SolarSystem("System" + i, i, x, y);
        }
        return new Universe(s);
    }
    
    /**
     * Gets the instance of the universe Singleton.
     * @return universe.
     */
    public static Universe getInstance() {
        return universe;
    }
    
    /**
     * Gets a specific solar system.
     * @param index the index to retrieve
     * @return the solar system at index index.
     */
    public SolarSystem getSolarSystem(int index) {
        return solarSystems[index];
    }
    
    /**
     * Getter for the solar system array.
     * @return solarSystems.
     */
    public SolarSystem[] getSolarSystems() {
        return solarSystems;
    }
    
    /**
     * A debugging method to get an idea of the contents of universe.
     */
    public void dumpInfo() {
        System.out.println(solarSystems[0].dumpInfo());
    }
    
    /**
     * Gets a planet at a specific (x,y).
     * @param xLoc the x position.
     * @param yLoc the y position.
     * @return the planet at the specific (x,y) or null if none exists.
     */
    public Planet getPlanet(String xLoc, String yLoc) {
        int x = Integer.parseInt(xLoc);
        int y = Integer.parseInt(yLoc);
        for (SolarSystem s : solarSystems) {
            for (int i = 0; i < s.getNumPlanets(); i++) {
                Planet p = s.getPlanet(i);
                if (p.getX() == x && p.getY() == y) {
                    return p;
                }
            }
        }
        return null;
    }
    
    /**
     * refreshes the instance of the universe.
     */
    public static void recreateInstance() {
        universe.setSolarSystems(createInstance().getSolarSystems());
    }
    
    private void setSolarSystems(SolarSystem[] s) {
        solarSystems = s;
    }
    
    /**
     * Sets the instance of universe to a new one.
     * @param u the new universe to load.
     */
    public static void setInstance(Universe u) {
        System.out.println(universe.getSolarSystem(0).getPlanet(0).dumpInfo());
        System.out.println(u.getSolarSystem(0).getPlanet(0).dumpInfo());
        /*
        for(SolarSystem s : universe.getSolarSystems()) {
            System.out.println(s.dumpInfo());
        }
        for(SolarSystem s : u.getSolarSystems()) {
            System.out.println(s.dumpInfo());
        }*/
        universe.setSolarSystems(u.getSolarSystems());
    }
}
