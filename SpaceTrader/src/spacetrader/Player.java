package spacetrader;

public class Player {
    private String name;
    private int diff;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int money;

    private static int DEFAULT_DIFF = 1;
    private static int DEFAULT_SKILL = 4;

    public Player(String name, int diff, int pilotPoints, int fighterPoints,
        int traderPoints, int engineerPoints) {
            this.name = name;
            this.diff = diff;
            this.pilotPoints = pilotPoints;
            this.fighterPoints = fighterPoints;
            this.traderPoints = traderPoints;
            this.engineerPoints = engineerPoints;
            this.money = 1500;
    }


    public Player(String name) {
        this(name, DEFAULT_DIFF);
    }

    public Player(String name, int diff) {
        this (name, diff, DEFAULT_SKILL, DEFAULT_SKILL, DEFAULT_SKILL,
            DEFAULT_SKILL);
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

    public int getMoney() {
        return money;
    }
    
    public void setMoney(int i) {
        money = i;
    }
}