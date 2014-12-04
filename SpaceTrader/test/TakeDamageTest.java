import spacetrader.Wasp;
import spacetrader.Shield;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author georgeli94
 */
public class TakeDamageTest {
    private Wasp ship;
    private Shield shield;
    
    /*
    * This creates the elements needed to fully test the takeDamage() method.
    */
    @Before
    public void setUp() {
        ship = new Wasp();
        shield = new Shield(10, false, false, 10);
    }
    
    /*
    * The possible scenarios for takeDamage() are taking damage that's absobed
    * by a shield, resulting in no damage to the hull, taking damage that breaks
    * the shield and taking the remaining damage to the hull, taking damage to
    * the hull normally, and being destroyed utterly.
    */
    @Test
    public void testTakeDamage() {
        ship.addShield(shield);
        ship.takeDamage(5);
        assertEquals(160, ship.getHull());
        ship.takeDamage(10);
        assertEquals(155, ship.getHull());
        ship.takeDamage(10);
        assertEquals(145, ship.getHull());
        ship.takeDamage(1000);
        assertEquals(0, ship.getHull());
    }

}
