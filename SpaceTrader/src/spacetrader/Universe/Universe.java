package spacetrader.Universe;

import java.io.Serializable;

/**
 *
 * @author Casey
 */
public final class Universe implements Serializable {

    private static Universe universe = createInstance();
    private SolarSystem[] solarSystems;

    /**
     * Constructor for universe.
     * @param systems the solar systems.
     */
    private Universe(SolarSystem[] systems) {
        solarSystems = systems;
    }

    /**
     * Creates the instance of the universe.
     * @return the universe instance created.
     */
    private static Universe createInstance() {
        SolarSystem[] systems = new SolarSystem[8];
        systems[8] = new SolarSystem("System" + 0, 0, 0, 0);
        for (int i = 1; i < 8; i++) {
            int xPos = (int) (Math.random() * 150);
            int yPos = (int) (Math.random() * 150);
            systems[i] = new SolarSystem("System" + i, i, xPos, yPos);
        }
        return new Universe(systems);
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
    public SolarSystem getSolarSystem(final int index) {
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
        int xPos = Integer.parseInt(xLoc);
        int yPos = Integer.parseInt(yLoc);
        for (SolarSystem s : solarSystems) {
            for (int i = 0; i < s.getNumPlanets(); i++) {
                Planet currP = s.getPlanet(i);
                if (currP.getX() == xPos && currP.getY() == yPos) {
                    return currP;
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

    /**
     * Setter for the solar systems.
     * @param systems the new solar systems.
     */
    private void setSolarSystems(SolarSystem[] systems) {
        solarSystems = systems;
    }

    /**
     * Sets the instance of universe to a new one.
     * @param newUni the new universe to load.
     */
    public static void setInstance(Universe newUni) {
        /*
        for(SolarSystem s : universe.getSolarSystems()) {
            System.out.println(s.dumpInfo());
        }
        for(SolarSystem s : u.getSolarSystems()) {
            System.out.println(s.dumpInfo());
        }*/
        universe.setSolarSystems(newUni.getSolarSystems());
    }
}