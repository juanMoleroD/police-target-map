import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void canBeCompared() {
        Coordinates co1 = new Coordinates(0, 0);
        Coordinates co2 = new Coordinates(0, 0);
        Coordinates co3 = new Coordinates(1, 0);
        Coordinates co4 = new Coordinates(0, 1);
        assertEquals(co1, co2);
        assertNotEquals(co1, co3);
        assertNotEquals(co2, co4);
        assertNotEquals(co3, co4);
    }
}