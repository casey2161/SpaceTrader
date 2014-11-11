package spacetrader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import spacetrader.Universe.Planet;
import spacetrader.Universe.Universe;

public class PlayerTest {
    @Test
    public void TestTravel() {
        Player.clearInstance();
        Universe.recreateInstance();
        Planet start = new Planet("Start", 1, 1, 0, 0, false, null, null);
        Player p1 = new Player("Lindsey", 1, 5, 5, 5, 5, start);
        System.out.println(p1.location().getX() + "," + p1.location().getY());
        Planet destination = new Planet("TestPlanet", 1, 1, 28, 70, false, null, null);
        assertTrue("Check your code", p1.canTravel(destination));
        p1.travel(destination);
        Planet newDest = new Planet("New Dest", 1, 1, 300, 500, false, null, null);
        assertFalse("Check your code", p1.canTravel(newDest));
        assertEquals(destination, p1.location());


    }
}