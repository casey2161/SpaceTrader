
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import spacetrader.Universe.Planet;
import spacetrader.Universe.PlanetFactory;

/**
 *
 * @author Casey
 */
public class UniverseTests {
    
    public UniverseTests() {
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
    
    @Test
    public void testPlanetGeneration() {
        PlanetFactory pf = new PlanetFactory(0, 0, 0);
        Planet tp = pf.createPlanet();
        assertNotNull(tp);
        assertNotNull(tp.getName());
        assertNotNull(tp.getTechLevel());
        assertNotNull(tp.spawnsPirates());
        assertNotNull(tp.getX());
        assertNotNull(tp.getY());
        assertNotNull(tp.returnMap());
        assertNotNull(tp.returnPriceMap());
        assertNotNull(tp.getUpgrades());
    }
}
