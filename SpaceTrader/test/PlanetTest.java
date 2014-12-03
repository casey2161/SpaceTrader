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
    
    private Planet instance;
    private Ship result;
    String name;
    int techLevel;
    int quality;
    Weapon newWeapon;
    
    
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
        instance = new Planet("Test Planet", 1, 1, 0, 0,
                true, null, null, 1);
        result = instance.getEncounterShip();
        name = result.getName();
        techLevel = instance.getTechLevel();
        quality = result.getQuality();
        newWeapon = result.getWeapon();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test whether or not the type of the enemy ship is Flea
     */
    @Test
    public void testShipInstance() {
        assertTrue(result instanceof Flea);
    }

    /**
     * Test whether or not the enemy ship is either Pirate or Police
     */
    @Test
    public void testShipName() {
        assertTrue(name.equals("Pirate") || name.equals("Police"));
    }

    /**
     * Test whether or not the enemy ship has the appropriate quality for
     * the given Planet's tech level
     */
    @Test
    public void testShipQuality() {
        if (techLevel < 3) {
            assertTrue(quality == 1);
        } else if (techLevel < 5) {
            assertTrue(quality == 2);
        } else {
            assertTrue(quality == 3);
        }
    }

    /**
     * Test whether the enemy Ship has a weapon
     * Test whether or not the enemy Ship weapon is a type of Weaker Laser
     */
    @Test
    public void testShipWeapon() {
        assertNotNull(newWeapon);

        assertTrue(newWeapon.getName().equals("Weaker Laser"));
    }
}
