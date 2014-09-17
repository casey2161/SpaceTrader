/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.Universe;

/**
 *
 * @author Casey
 */
public class SolarSystem {
    private PlanetFactory pf;
    private String name;
    private Planet[] planets;
    private int x,y;
    
    public SolarSystem(String name, int techLevel, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        int distance = (int) Math.sqrt((x*x + y*y));
        pf = new PlanetFactory(techLevel, distance);
        
        planets = new Planet[(int)(Math.random()*10) + 1];
        for(int i = 0; i < planets.length; i++) {
            planets[i] = pf.createPlanet();
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Planet getPlanet(int i) {
        if(i > planets.length || i < 0) {
            throw new IllegalArgumentException("Invalid position argument");
        } else {
            return planets[i];
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String dumpInfo() {
        String dump = "Begin Solar System:" + name;
        for(Planet p : planets) {
            dump += p.dumpInfo();
        }
        dump += "End Solar System:" + name + "\n\n";
        return dump;
    }
}
