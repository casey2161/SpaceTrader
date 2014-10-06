
package spacetrader.Universe;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Casey
 */
public class PlanetFactory {
    private String[] planetNames;
    private int techLevel;
    private int x,y;
    private int count;
    
    public PlanetFactory(int techLevel, int x, int y) {
        initNames();
        this.techLevel = techLevel;
        this.x = x;
        this.y = y;
    }
    
    public Planet createPlanet() {
        Random gen = new Random();
        
        String name = planetNames[Math.abs((gen.nextInt()) % planetNames.length)];
        int rscLevel = Math.abs(gen.nextInt() % 12);
        int xval = (gen.nextInt()%2) * count + x;
        int yval = (gen.nextInt()%2) * count + y;
        HashMap<String, Integer> prices, amount;
        prices = generatePrices(techLevel, rscLevel);
        amount = generateAmount(techLevel, rscLevel);
        boolean pirates = gen.nextDouble() < 0.2;
        count++;
        return new Planet(name, techLevel, rscLevel, xval, yval, pirates, prices, amount);
    }
    private HashMap<String, Integer> generatePrices(int techLevel, int rscLevel) {
        HashMap<String, Integer> cargo = new HashMap<String, Integer>();
        cargo.put("water",(int) (30 + 3*techLevel + (Math.random() * 4)));
        cargo.put("furs", (int) (250 + 10*techLevel + Math.random() * 10));
        if(techLevel >= 1) {
            cargo.put("food", (int) (100 + 5*(techLevel - 1) + Math.random()*5));
        }
        if(techLevel >= 2) {
            cargo.put("ore", (int) (350 + 20*(techLevel - 2) + Math.random()*10));
        }
        if(techLevel >= 3) {
            cargo.put("games", (int) (250 + (-10)*(techLevel - 3) + Math.random()*5));
            cargo.put("firearms", (int) (1250 + (-75)*(techLevel - 3) + Math.random()*100));
        }
        if(techLevel >= 4) {
            cargo.put("medicine", (int) (650 + (-20)*(techLevel - 4) + Math.random()*10));
            cargo.put("machines", (int) (900 + (-30)*(techLevel - 4) + Math.random()*5));
        }
        if(techLevel >= 5) {
            cargo.put("narcotics", (int) (3500 + (-125)*(techLevel - 5) + Math.random()*150));
        }
        if(techLevel >= 6) {
            cargo.put("robots", (int) (5000 + (-150)*(techLevel - 5) + Math.random()*100));
        }
        
        return cargo;
    }
    
    private HashMap<String, Integer> generateAmount(int techLevel, int rscLevel) {
        HashMap<String, Integer> cargo = new HashMap<String, Integer>();
        if(techLevel >= 4) {
            cargo.put("robots", (int) (5000 + (-150)*(techLevel - 4) + Math.random()*100) / 2);
        }
        if(techLevel >= 3) {
            cargo.put("machines", (int) (900 + (-30)*(techLevel - 3) + Math.random()*5) / 2);
        }
        if(techLevel >= 2) {
            cargo.put("ore", (int) (350 + 20*(techLevel - 2) + Math.random()*10) / 2);
        }
        if(techLevel >= 1) {
            cargo.put("medicine", (int) (650 + (-20)*(techLevel - 1) + Math.random()*10) / 2);
            cargo.put("games", (int) (250 + (-10)*(techLevel - 1) + Math.random()*5) / 2);
            cargo.put("firearms", (int) (1250 + (-75)*(techLevel - 1) + Math.random()*100) / 2);
        }
        cargo.put("water",(int) (30 + 3*techLevel + (Math.random() * 4)) / 2);
        cargo.put("furs", (int) (250 + 10*techLevel + Math.random() * 10) / 2);
        cargo.put("narcotics", (int) (3500 + (-125)*(techLevel - 5) + Math.random()*150) / 2);
        cargo.put("food", (int) (100 + 5*(techLevel - 1) + Math.random()*5) / 2);
        return cargo;
    }
    private void initNames() {
        planetNames = new String[]
        {
            "Acamar",
            "Adahn",		// The alternate personality for The Nameless One in "Planescape: Torment"
            "Aldea",
            "Andevian",
            "Antedi",
            "Balosnee",
            "Baratas",
            "Brax",			// One of the heroes in Master of Magic
            "Bretel",		// This is a Dutch device for keeping your pants up.
            "Calondia",
            "Campor",
            "Capelle",		// The city I lived in while programming this game
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
            "Frolix",		// A solar system in one of Philip K. Dick's novels
            "Gemulon",
            "Guinifer",		// One way of writing the name of king Arthur's wife
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
            "Kravat",		// Interesting spelling of the French word for "tie"
            "Krios",
            "Laertes",		// A king in a Greek tragedy
            "Largo",
            "Lave",			// The starting system in Elite
            "Ligon",
            "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
            "Magrat",		// The second of the witches in Pratchett's Discworld
            "Malcoria",
            "Melina",
            "Mentar",		// The Psilon home system in Master of Orion
            "Merik",
            "Mintaka",
            "Montor",		// A city in Ultima III and Ultima VII part 2
            "Mordan",
            "Myrthe",		// The name of my daughter
            "Nelvana",
            "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
            "Nyle",			// An interesting spelling of the great river
            "Odet",
            "Og",			// The last of the witches in Pratchett's Discworld
            "Omega",		// The end of it all
            "Omphalos",		// Greek for navel
            "Orias",
            "Othello",		// From Shakespeare
            "Parade",		// This word means the same in Dutch and in English
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
            "Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
            "Utopia",		// The ultimate goal
            "Vadera",
            "Vagra",
            "Vandor",
            "Ventax",
            "Xenon",
            "Xerxes",		// A Greek hero
            "Yew",			// A city which is in almost all of the Ultima games
            "Yojimbo",		// A film by Akira Kurosawa
            "Zalkon",
            "Zuul"			// From the first Ghostbusters movie
        };
    }
}
