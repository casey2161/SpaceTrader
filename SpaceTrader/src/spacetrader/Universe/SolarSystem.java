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

    private String name;
    private Planet[] planets;
    
    /**
     * The constructor for a solar system.
     * @param name the name of the system.
     * @param techLevel the system's tech level.
     * @param xPos the x position of the sun.
     * @param yPos the y position of the sun.
     */
    public SolarSystem(String name, int techLevel, int xPos, int yPos) {
        this.name = name;
        PlanetFactory planetFactory = new PlanetFactory(techLevel, xPos, yPos);
        
        planets = new Planet[(int) (Math.random() * 5) + 3];
        for (int i = 0; i < planets.length; i++) {
            planets[i] = planetFactory.createPlanet();
        }
    }
    
    /**
     * Getter for the array of planets.
     * @return the array of planets.
     */
    public Planet[] getPlanets() {
        return planets;
    }

    /**
     * Setter for the array of planets.
     * @param planets the array to set.
     */
    public void setPlanets(Planet[] planets) {
        this.planets = planets;
    }
    /**
     * Returns a specific planet.
     * @param index the index of the planet to get.
     * @return the planet at index i.
     */
    
    public Planet getPlanet(int index) {
        if (index > planets.length || index < 0) {
            throw new IllegalArgumentException("Invalid position argument");
        } else {
            return planets[index];
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
