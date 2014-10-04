package spacetrader;

import spacetrader.Universe.Planet;

public class Player {
    private String name;
    private int diff;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int money;
    private static Player player;
    private Ship ship;
    private Planet location;
    private static int DEFAULT_DIFF = 1;
    private static int DEFAULT_SKILL = 4;

    private Player(String name, int diff, int pilotPoints, int fighterPoints,
        int traderPoints, int engineerPoints, Planet location) {
            this.name = name;
            this.diff = diff;
            this.pilotPoints = pilotPoints;
            this.fighterPoints = fighterPoints;
            this.traderPoints = traderPoints;
            this.engineerPoints = engineerPoints;
            this.money = 1500;
            this.location = location;
            ship = new Ship("SpawnShip", 50, 1, 1);
    }


    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int diff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int pilot() {
        return pilotPoints;
    }

    public void setPilot(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public int fighter() {
        return fighterPoints;
    }

    public void setFighter(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public int trader() {
        return traderPoints;
    }

    public void setTrader(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public int engineer() {
        return engineerPoints;
    }

    public void setEngineer(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public int money() {
        return money;
    }
    
    public void setMoney(int i) {
        money = i;
    }

    public void addMoney(int i) {
        money = money + i;
    }

    public void subtractMoney(int i) {
        money = money - i;
    }

    public static void createInstance(String name, int diff, int pilotPoints, int fighterPoints,
        int traderPoints, int engineerPoints, Planet location) {
        player = new Player(name, diff, pilotPoints, fighterPoints, traderPoints, engineerPoints, location);

    }

    public static Player getInstance() {
        return player;
    }

    public Ship ship() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Planet location() {
        return location;
    }


    public void travel(Planet destination) {
        int distance = (int) Math.sqrt(Math.pow(destination.getX() - location.getX(), 2)
                        + Math.pow(destination.getY() - location.getY(), 2));
        if (distance > ship.getCurrRange()) {
            System.out.println("Destination is out of range for your ship!");
        } else {
            this.location = destination;
            ship.setCurrRange(ship.getCurrRange() - distance);
        }
    }
}