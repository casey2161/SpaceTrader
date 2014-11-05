/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.Universe;

import java.io.Serializable;

/**
 *
 * @author Casey
 */
public class SolarSystem implements Serializable {
    
    private PlanetFactory pf;
    private String name;
    private Planet[] planets;
    
    public SolarSystem(String name, int techLevel, int x, int y) {
        this.name = name;
        pf = new PlanetFactory(techLevel, x, y);
        
        planets = new Planet[(int) (Math.random() * 5) + 3];
        for (int i = 0; i < planets.length; i++) {
            planets[i] = pf.createPlanet();
        }
    }
    
    /**
     * Returns a specific planet.
     * @param i the index of the planet to get.
     * @return the planet at index i.
     */
    
    public Planet getPlanet(int i) {
        if (i > planets.length || i < 0) {
            throw new IllegalArgumentException("Invalid position argument");
        } else {
            return planets[i];
        }
    }
    
    /**
     * Gets the name of the SolarSystem.
     * @return returns the name.
     */
    
    public String getName() {
        return name;
    }
    
    /**
     * Method for debugging.
     * @return returns a verbose representation of the SolarSystem.
     */
    public String dumpInfo() {
        String dump = "Begin Solar System:" + name;
        for (Planet p : planets) {
            dump += p.dumpInfo();
        }
        dump += "End Solar System:" + name + "\n\n";
        return dump;
    }
    
    /**
     * Getter for the number of planets.
     * @return returns the number of planets in the solar system.
     */
    
    public int getNumPlanets() {
        return planets.length;
    }
}
