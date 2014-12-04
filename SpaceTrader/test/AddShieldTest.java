import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Wasp;
import spacetrader.Shield;

/**
 *
 * @author georgeli94
 */
public class AddShieldTest {
    Wasp ship;
    Shield shield1, shield2, shield3;

    public AddShieldTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /*
    * Sets up the necessary elements to test addShield().
    */
    @Before
    public void setUp() {
        ship = new Wasp();
        shield1 = new Shield(10, false, false, 10);
        shield2 = new Shield(10, false, false, 10);
        shield3 = new Shield(10, false, false, 10);
        
    }

    @After
    public void tearDown() {
    }

    /*
    * The possible scenarios are no shield slots used, some shield slots used,
    * all shield slots used, and trying to add a shield after all shield slots
    * were used, which is tested by making sure the extra shield is not used
    * when the ship is taking damage.
    */
    @Test
    public void testAddWeapon() {
        assertEquals(2, ship.getShieldSlots());
        ship.addShield(shield1);
        assertEquals(1, ship.getShieldSlots());
        ship.addShield(shield2);
        assertEquals(0, ship.getShieldSlots());
        ship.addShield(shield3);
        assertEquals(0, ship.getShieldSlots());
        ship.takeDamage(20);
        assertEquals(160, ship.getHull());
        ship.takeDamage(10);
        assertEquals(150, ship.getHull());
        
    }
}
