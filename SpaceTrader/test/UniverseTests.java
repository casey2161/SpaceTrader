
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import spacetrader.Universe.Planet;
import spacetrader.Universe.PlanetFactory;

/**
 * 
 * @author Casey
 */
public class UniverseTests {
    
    @Test
    /**
     * This tests the generation of a SolarSystem.
     * It reaches branch coverage by testing for all values of techLevel
     */
    public void testPlanetGeneration() {
        PlanetFactory factory;
        for (int i = 0; i < 8; i++) {        
            factory = new PlanetFactory(i, 0, 0);
            Planet tp = factory.createPlanet();
            assertNotNull(tp);
            assertNotNull(tp.getName());
            assertEquals(i, tp.getTechLevel());
            assertNotNull(tp.spawnsPirates());
            assertNotNull(tp.getX());
            assertNotNull(tp.getY());
            assertNotNull(tp.returnMap());
            assertNotNull(tp.returnPriceMap());
            assertNotNull(tp.getUpgrades());
        }
    }
}
