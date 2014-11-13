
package spacetrader.Universe;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *  This class is a factory for planets. It generates planets for the universe.
 * @author Casey
 */
public class PlanetFactory implements Serializable {

    private String[] planetNames;
    private int techLevel;
    private int xPos;
    private int yPos;
    private int count;
    
    /**
     * Constructor for a PlanetFactory.
     * @param techLevel the tech level.
     * @param xLoc the x location.
     * @param yLoc the y location.
     */
    public PlanetFactory(int techLevel, int xLoc, int yLoc) {
        initNames();
        this.techLevel = techLevel;
        xPos = xLoc;
        yPos = yLoc;
    }
    /**
     * This method creates a planet based on the factories settings.
     * @return a planet
     */
    public Planet createPlanet() {
        Random gen = new Random();

        String name = planetNames[Math.abs((gen.nextInt())
                % planetNames.length)];
        int rscLevel = Math.abs(gen.nextInt() % 12);
        int xval = (gen.nextInt() % 5) * count + xPos;
        int yval = (gen.nextInt() % 5) * count + yPos;
        HashMap<String, Integer> prices, amount;
        prices = (HashMap<String, Integer>) generatePrices();
        amount = (HashMap<String, Integer>) generateAmount();
        boolean pirates = gen.nextDouble() < 0.2;
        count++;
        return new Planet(name, techLevel, rscLevel, xval, yval, pirates,
                prices, amount);
    }

    /**
     * This generates the market prices.
     * @return a map containing market prices.
     */
    private Map<String, Integer> generatePrices() {
        Map<String, Integer> cargo = new HashMap<>();
        cargo.put("water", (int) (30 + 3 * techLevel + (Math.random() * 4)));
        cargo.put("fur", (int) (250 + 10 * techLevel + Math.random() * 10));
        if (techLevel >= 1) {
            cargo.put("food", (int) (100 + 5 * (techLevel - 1)
                    + Math.random() * 5));
        }
        if (techLevel >= 2) {
            cargo.put("ore", (int) (350 + 20 * (techLevel - 2)
                    + Math.random() * 10));
        }
        if (techLevel >= 3) {
            cargo.put("games", (int) (250 + (-10) * (techLevel - 3)
                    + Math.random() * 5));
            cargo.put("firearms", (int) (1250 + (-75) * (techLevel - 3)
                    + Math.random() * 100));
        }
        if (techLevel >= 4) {
            cargo.put("medicine", (int) (650 + (-20) * (techLevel - 4)
                    + Math.random() * 10));
            cargo.put("machines", (int) (900 + (-30) * (techLevel - 4)
                    + Math.random() * 5));
        }
        if (techLevel >= 5) {
            cargo.put("narcotics", (int) (3500 + (-125) * (techLevel - 5)
                    + Math.random() * 150));
        }
        if (techLevel >= 6) {
            cargo.put("robots", (int) (5000 + (-150) * (techLevel - 5)
                    + Math.random() * 100));
        }
        return cargo;
    }

    /**
     * Generates the amount of an item
     * @return the amount map.
     */
    private Map<String, Integer> generateAmount() {
        HashMap<String, Integer> cargo = new HashMap<>();
        cargo.put("water", (int) (Math.random() * 50));
        cargo.put("fur", (int) (Math.random() * 50));
        if (techLevel >= 1) {
            cargo.put("food", (int) (Math.random() * 50));
        }
        if (techLevel >= 2) {
            cargo.put("ore", (int) (Math.random() * 50));
        }
        if (techLevel >= 3) {
            cargo.put("games", (int) (Math.random() * 50));
            cargo.put("firearms", (int) (Math.random() * 50));
        }
        if (techLevel >= 4) {
            cargo.put("medicine", (int) (Math.random() * 50));
            cargo.put("machines", (int) (Math.random() * 50));
        }
        if (techLevel >= 5) {
            cargo.put("narcotics", (int) (Math.random() * 50));
        }
        if (techLevel >= 6) {
            cargo.put("robots", (int) (Math.random() * 50));
        }
        return cargo;
    }

    /**
     * Generates the selling prices.
     * @return the map of the selling prices.
     *
    private Map<String, Integer> generateSellMap() {
        HashMap<String, Integer> cargo = new HashMap<String, Integer>();
        if (techLevel >= 4) {
            cargo.put("robots", (int) (5000 + (-150) * (techLevel - 4)
                    + Math.random() * 100) / 2);
        }
        if (techLevel >= 3) {
            cargo.put("machines", (int) (900 + (-30) * (techLevel - 3)
                    + Math.random() * 5) / 2);
        }
        if (techLevel >= 2) {
            cargo.put("ore", (int) (350 + 20 * (techLevel - 2)
                    + Math.random() * 10) / 2);
        }
        if (techLevel >= 1) {
            cargo.put("medicine", (int) (650 + (-20) * (techLevel - 1)
                    + Math.random() * 10) / 2);
            cargo.put("games", (int) (250 + (-10) * (techLevel - 1)
                    + Math.random() * 5) / 2);
            cargo.put("firearms", (int) (1250 + (-75) * (techLevel - 1)
                    + Math.random() * 100) / 2);
        }
        cargo.put("water", (int) (30 + 3 * techLevel
                + (Math.random() * 4)) / 2);
        cargo.put("furs", (int) (250 + 10 * techLevel
                + Math.random() * 10) / 2);
        cargo.put("narcotics", (int) (3500 + (-125) * (techLevel - 5)
                + Math.random() * 150) / 2);
        cargo.put("food", (int) (100 + 5 * (techLevel - 1)
                + Math.random() * 5) / 2);
        return cargo;
    }
    */
    /**
     * Initiates possible names.
     */
    private void initNames() {
        planetNames = new String[]
        {
            "Acamar",
            "Adahn",
            "Aldea",
            "Andevian",
            "Antedi",
            "Balosnee",
            "Baratas",
            "Brax",			// One of the heroes in Master of Magic
            "Bretel",
            "Calondia",
            "Campor",
            "Capelle",
            "Carzon",
            "Castor",		// A Greek demi-god
            "Cestus",
            "Cheron",
            "Courteney",	// After Courteney Cox…
            "Daled",
            "Damast",
            "Davlos",
            "Deneb",
            "Deneva",
            "Devidia",
            "Draylon",
            "Drema",
            "Endor",
            "Esmee",		// One of the witches in Pratchett's Discworld
            "Exo",
            "Ferris",		// Iron
            "Festen",		// A great Scandinavian movie
            "Fourmi",		// An ant, in French
            "Frolix",		// A solar system in one of Philip K. Dick's
            "Gemulon",
            "Guinifer",
            "Hades",		// The underworld
            "Hamlet",		// From Shakespeare
            "Helena",		// Of Troy
            "Hulst",		// A Dutch plant
            "Iodine",		// An element
            "Iralius",
            "Janus",		// A seldom encountered Dutch boy's name
            "Japori",
            "Jarada",
            "Jason",		// A Greek hero
            "Kaylon",
            "Khefka",
            "Kira",			// My dog's name
            "Klaatu",		// From a classic SF movie
            "Klaestron",
            "Korma",		// An Indian sauce
            "Kravat",
            "Krios",
            "Laertes",		// A king in a Greek tragedy
            "Largo",
            "Lave",			// The starting system in Elite
            "Ligon",
            "Lowry",
            "Magrat",
            "Malcoria",
            "Melina",
            "Mentar",		// The Psilon home system in Master of Orion
            "Merik",
            "Mintaka",
            "Montor",		// A city in Ultima III and Ultima VII part 2
            "Mordan",
            "Myrthe",		// The name of my daughter
            "Nelvana",
            "Nix",
            "Nyle",
            "Odet",
            "Og",
            "Omega",		// The end of it all
            "Omphalos",		// Greek for navel
            "Orias",
            "Othello",		// From Shakespeare
            "Parade",
            "Penthara",
            "Picard",		// The enigmatic captain from ST:TNG
            "Pollux",		// Brother of Castor
            "Quator",
            "Rakhar",
            "Ran",			// A film by Akira Kurosawa
            "Regulas",
            "Relva",
            "Rhymus",
            "Rochani",
            "Rubicum",		// The river Ceasar crossed to get into Rome
            "Rutia",
            "Sarpeidon",
            "Sefalla",
            "Seltrice",
            "Sigma",
            "Sol",			// That's our own solar system
            "Somari",
            "Stakoron",
            "Styris",
            "Talani",
            "Tamus",
            "Tantalos",		// A king from a Greek tragedy
            "Tanuga",
            "Tarchannen",
            "Terosa",
            "Thera",		// A seldom encountered Dutch girl's name
            "Titan",		// The largest moon of Jupiter
            "Torin",		// A hero from Master of Magic
            "Triacus",
            "Turkana",
            "Tyrus",
            "Umberlee",
            "Utopia",		// The ultimate goal
            "Vadera",
            "Vagra",
            "Vandor",
            "Ventax",
            "Xenon",
            "Xerxes",		// A Greek hero
            "Yew",
            "Yojimbo",		// A film by Akira Kurosawa
            "Zalkon",
            "Zuul"			// From the first Ghostbusters movie
        };
    }
}