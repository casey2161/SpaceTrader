package spacetrader;

import java.io.Serializable;
import spacetrader.Universe.Planet;

public class Player implements Serializable{

    // Player 1
    private String name;
    private int diff;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int money;
    private Ship ship;
    private Weapon weapon;
    private Planet location;

    //Player 2
    private String namemp;
    private int diffmp;
    private int pilotPointsmp;
    private int fighterPointsmp;
    private int traderPointsmp;
    private int engineerPointsmp;
    private int moneymp;
    private Ship shipmp;
    private Weapon weaponmp;
    private Planet locationmp;

    // Statics
    private static int DEFAULT_DIFF = 1;
    private static int DEFAULT_SKILL = 4;
    private static Player player = createInstance();
    private static boolean multiplayer;
    private static boolean playerTwo = false;

    private Player(String name, int diff, int pilotPoints, int fighterPoints,
        int traderPoints, int engineerPoints, Planet location) {
            if (playerTwo) {
                this.namemp = name;
                this.diffmp = diff;
                this.pilotPointsmp = pilotPoints;
                this.fighterPointsmp = fighterPoints;
                this.traderPointsmp = traderPoints;
                this.engineerPointsmp = engineerPoints;
                this.moneymp = 5000;
                this.locationmp = location;
                shipmp = new Flea();
                weaponmp = new Weapon("Lazer", 10, 30, 1, 1500);
                shipmp.addWeapon(weaponmp);
            } else {
                this.name = name;
                this.diff = diff;
                this.pilotPoints = pilotPoints;
                this.fighterPoints = fighterPoints;
                this.traderPoints = traderPoints;
                this.engineerPoints = engineerPoints;
                this.money = 5000;
                this.location = location;
                ship = new Flea();
                weapon = new Weapon("Lazer", 10, 30, 1, 1500);
                ship.addWeapon(weapon);
            }
    }


    public String name() {
        if (playerTwo) {
            return namemp;
        } else {
            return name;
        }
    }

    public void setName(String name) {
        if (playerTwo) {
            namemp = name;
        } else {
            this.name = name;
        }
    }

    public int diff() {
        if (playerTwo) {
            return diffmp;
        } else {
            return diff;
        }
    }

    public void setDiff(int diff) {
        if (playerTwo) {
            diffmp = diff;
        } else {
            this.diff = diff;
        }
    }

    public int pilot() {
        if (playerTwo) {
            return pilotPointsmp;
        } else {
            return pilotPoints;
        }
    }

    public void setPilot(int pilotPoints) {
        if (playerTwo) {
            pilotPointsmp = pilotPoints;
        } else {
            this.pilotPoints = pilotPoints;
        }
    }

    public int fighter() {
        if (playerTwo) {
            return fighterPointsmp;
        } else {
            return fighterPoints;
        }
    }

    public void setFighter(int fighterPoints) {
        if (playerTwo) {
            fighterPointsmp = fighterPoints;
        } else {
            this.fighterPoints = fighterPoints;
        }
    }

    public int trader() {
        if (playerTwo) {
            return traderPointsmp;
        } else {
            return traderPoints;
        }
    }

    public void setTrader(int traderPoints) {
        if (playerTwo) {
            traderPointsmp = traderPoints;
        } else {
            this.traderPoints = traderPoints;
        }
    }

    public int engineer() {
        if (playerTwo) {
            return engineerPointsmp;
        } else {
            return engineerPoints;
        }
    }

    public void setEngineer(int engineerPoints) {
        if (playerTwo) {
            engineerPointsmp = engineerPoints;
        } else {
            this.engineerPoints = engineerPoints;
        }
    }

    public int money() {
        if (playerTwo) {
            return moneymp;
        } else {
            return money;
        }
    }
    
    public void setMoney(int i) {
        if (playerTwo) {
            moneymp = i;
        } else {
            money = i;
        }
    }

    public void addMoney(int i) {
        if (playerTwo) {
            moneymp = moneymp + i;
        } else {
            money = money + i;
        }
    }

    public void subtractMoney(int i) {
        if (playerTwo) {
            moneymp = moneymp - i;
            if (moneymp < 0) {
                moneymp = 0;
            }
        } else {
            money = money - i;
            if (money < 0) {
                money = 0;
            }
        }
    }

    public static void updateInstance(String name, int diff, int pilotPoints, int fighterPoints,
        int traderPoints, int engineerPoints, Planet location) {
        player.setDiff(diff);
        player.setEngineer(engineerPoints);
        player.setFighter(fighterPoints);
        player.setPilot(pilotPoints);
        player.setTrader(traderPoints);
        player.setName(name);
        player.initLocation(location);
        player.setMoney(5000);
        Ship standardShip = new Flea();
        Weapon standardWeapon = new Weapon("Lazer", 10, 30, 1, 1500);
        standardShip.addWeapon(standardWeapon);
        player.setShip(standardShip);
    }
    
    private void initLocation(Planet location) {
        if (playerTwo) {
            locationmp = location;
        } else {
            this.location = location;
        }
    }
    
    private static Player createInstance() {
        return new Player("",0,0,0,0,0,null);
    }
    public static void clearInstance() {
        player = new Player("",0,0,0,0,0,null);
    }
    public static Player getInstance() {
        return player;
    }

    public Ship ship() {
        if (playerTwo) {
            return shipmp;
        } else {
            return ship;
        }
    }

    public void setShip(Ship ship) {
        if (playerTwo) {
            shipmp = ship;
        } else {
            this.ship = ship;
        }
    }

    public Planet location() {
        if (playerTwo) {
            return locationmp;
        } else {
            return location;
        }
    }


    public void travel(Planet destination) {
        if (playerTwo) {
            if(canTravel(destination)) {
                int distance = (int) Math.sqrt(Math.pow(destination.getX() - locationmp.getX(), 2)
                            + Math.pow(destination.getY() - locationmp.getY(), 2));
                shipmp.setCurrRange(shipmp.getCurrRange() - distance);
                this.locationmp = destination;
            }
        } else {
            if(canTravel(destination)) {
                int distance = (int) Math.sqrt(Math.pow(destination.getX() - location.getX(), 2)
                            + Math.pow(destination.getY() - location.getY(), 2));
                ship.setCurrRange(ship.getCurrRange() - distance);
                this.location = destination;
            }
        }
    }

    public boolean canTravel(Planet destination) {
        if (playerTwo) {
            int distance = (int) Math.sqrt(Math.pow(destination.getX() - locationmp.getX(), 2)
                            + Math.pow(destination.getY() - locationmp.getY(), 2));
            return distance < shipmp.getCurrRange();
        } else {
            int distance = (int) Math.sqrt(Math.pow(destination.getX() - location.getX(), 2)
                            + Math.pow(destination.getY() - location.getY(), 2));
            return distance < ship.getCurrRange();
        }
    }

    public void buy(String key, int amount) {
        if (playerTwo) {
            int price = locationmp.getPrice(key) * amount / 2;
            if (shipmp.hasRoom(amount)  && locationmp.getAmount(key) - amount >= 0
                    && (moneymp - price) >= 0) {
                moneymp = moneymp - price;
                shipmp.add(key, amount);
                locationmp.updateAmount(key, locationmp.getAmount(key) - amount);
            }
        } else {
        int price = location.getPrice(key) * amount / 2;
            if (ship.hasRoom(amount)  && location.getAmount(key) - amount >= 0
                    && (money - price) >= 0) {
                money = money - price;
                ship.add(key, amount);
                location.updateAmount(key, location.getAmount(key) - amount);
            }
        }
    }

    public void sell(String key, int amount) {
        if (playerTwo) {
            if (shipmp.canSell(key, amount)) {
                int price = locationmp.getPrice(key) * amount / 2;
                moneymp = moneymp + price;
                shipmp.remove(key, amount);
                locationmp.updateAmount(key.toLowerCase(), locationmp.getAmount(key) + amount);
            }
        } else {
            if (ship.canSell(key, amount)) {
                int price = location.getPrice(key) * amount / 2;
                money = money + price;
                ship.remove(key, amount);
                location.updateAmount(key.toLowerCase(), location.getAmount(key) + amount);
            }
        }
    }
    
    public static void setInstance(Player p) {
        player = p;
    }
    
    public static void setMultiplayer (boolean b) {
        multiplayer = b;
    }
    
    public static void setPlayerTwo (boolean b) {
        playerTwo = b;
    }
    
    public static boolean isPlayerTwo () {
        return playerTwo;
    }
}
