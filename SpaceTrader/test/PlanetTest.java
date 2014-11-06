import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Ship;
import spacetrader.Flea;
import spacetrader.Weapon;
import spacetrader.Universe.Planet;

/**
 *
 * @author Andika Putra
 */
public class PlanetTest {
    
    public PlanetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEncounterShip method, of class Planet.
     */
    @Test
    public void testGetEncounterShip() {
        System.out.println("getEncounterShip");
        Planet instance = new Planet("Test Planet", 1, 1, 0, 0,
                true, null, null);
        Ship result = instance.getEncounterShip();
        String name = result.getName();
        int techLevel = instance.getTechLevel();
        int quality = result.getQuality();
        Weapon newWeapon = result.getWeapon();

        // Test whether or not the type of the enemy ship is Flea
        assertTrue(result instanceof Flea);

        // Test whether or not the enemy ship is either Pirate or Police
        assertTrue(name.equals("Pirate") || name.equals("Police"));

        // Test whether or not the enemy ship has the appropriate quality for
        // the given Planet's tech level
        if (techLevel < 3) {
            assertTrue(quality == 1);
        } else if (techLevel < 5) {
            assertTrue(quality == 2);
        } else {
            assertTrue(quality == 3);
        }

        // Test whether the enemy Ship has a weapon
        assertNotNull(newWeapon);

        // Test whether or not the enemy Ship weapon is a type of Weaker Laser
        assertTrue(newWeapon.getName().equals("Weaker Laser"));
    }
}
