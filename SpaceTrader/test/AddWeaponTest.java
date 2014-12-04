import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Wasp;
import spacetrader.Weapon;

/**
 *
 * @author georgeli94
 */
public class AddWeaponTest {
    Wasp ship;
    Wasp opponent;
    Weapon laser1, laser2, laser3, laser4;

    public AddWeaponTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /*
    * Sets up the necessary elements to test addWeapon().
    */
    @Before
    public void setUp() {
        ship = new Wasp();
        opponent = new Wasp();
        laser1 = new Weapon("Laser", 10, 30, 1, 10);
        laser2 = new Weapon("Laser", 10, 30, 1, 10);
        laser3 = new Weapon("Laser", 10, 30, 1, 10);
        laser4 = new Weapon("Laser", 10, 30, 1, 10);
        
    }

    @After
    public void tearDown() {
    }

    /*
    * The possible scenarios are no weapon slots used, some weapon slots used,
    * all weapon slots used, and trying to add a weapon after all weapon slots
    * have been used, which is tested by making sure the extra weapon is not
    * used when dealing damage.
    */
    @Test
    public void testAddWeapon() {
        assertEquals(3, ship.getWeaponSlots());
        ship.addWeapon(laser1);
        assertEquals(2, ship.getWeaponSlots());
        ship.addWeapon(laser2);
        assertEquals(1, ship.getWeaponSlots());
        ship.addWeapon(laser3);
        assertEquals(0, ship.getWeaponSlots());
        ship.addWeapon(laser4);
        assertEquals(0, ship.getWeaponSlots());
        assertEquals(30, ship.dealDamage(opponent));
    }
}
