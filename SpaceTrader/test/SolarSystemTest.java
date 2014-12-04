import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Universe.SolarSystem;
import spacetrader.Universe.Planet;

/**
 *
 * @author georgeli94
 */
public class SolarSystemTest {
    SolarSystem solarSystem;
    private Planet[] testPlanets;
    int numPlanets;
    
    public SolarSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /*
    * Creates the elements needed to test SolarSystem.
    */
    @Before
    public void setUp() {
        solarSystem = new SolarSystem("Test System", 1, 0, 0);
        testPlanets = solarSystem.getPlanets();
        numPlanets = solarSystem.getNumPlanets();
    }
    
    @After
    public void tearDown() {
    }

    /*
    * Tests to make sure each planet's tech level is the correct tech level.
    */
    @Test
    public void testPlanetTechLevel() {
        for (int i = 0; i < testPlanets.length; i++) {
            assertEquals(1, testPlanets[i].getTechLevel());
        }
    }
    /*
    * Tests to make sure the getNumPlanets() method returns the correct amount
    * of planets.
    */
    @Test
    public void testGetNumPlanets() {
        assertEquals(numPlanets, testPlanets.length);
    }
}
