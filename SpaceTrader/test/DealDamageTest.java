/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import spacetrader.Wasp;
import spacetrader.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author georgeli94
 */
public class DealDamageTest {
    private Wasp ship;
    private Wasp opponent;
    private Weapon laser;
    private Weapon laser2;
    private Weapon laser3;
    
    /*
    * This creates the elements needed to fully test the dealDamage() method.
    */
    @Before
    public void setUp() {
        ship = new Wasp();
        opponent = new Wasp();
        laser = new Weapon("Laser", 10, 30, 1, 10);
        laser2 = new Weapon("Laser", 10, 30, 1, 10);
        laser3 = new Weapon("Laser", 10, 30, 1, 10);
    }
    
    /*
    * The possible scenarios for dealDamage is attacking a non-existent ship,
    * attacking a ship with no weapon, attacking a ship with less weapons than
    * the total amount of available slots, and attacking a ship will a full slot
    * of weapons. These scenarios are all tested here.
    */
    @Test
    public void testDealDamage() {
        assertEquals(0, ship.dealDamage(null));
        assertEquals(0, ship.dealDamage(opponent));

        ship.addWeapon(laser);
        assertEquals(10, ship.dealDamage(opponent));
        
        ship.addWeapon(laser2);
        assertEquals(20, ship.dealDamage(opponent));

        ship.addWeapon(laser3);
        assertEquals(30, ship.dealDamage(opponent));
    }

}
