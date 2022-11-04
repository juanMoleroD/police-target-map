import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertedMapTest {

    ConvertedMap map;

    @Test
    void canCreate3by3() {
        map = new ConvertedMap("_O_;_X_;T__");
        assertEquals(3, map.getLength());
        assertEquals(3, map.getHeight());
    }

    @Test
    void canTransformMapToArray() {
        String mapString = "O__;_X_;_T_";
        map = new ConvertedMap(mapString);
        List<List<String>> expected = new ArrayList<>(List.of(
                new ArrayList<>(List.of("O", "_", "_")),
                new ArrayList<>(List.of("_", "X", "_")),
                new ArrayList<>(List.of("_", "T", "_"))
        ));
        assertEquals(expected, map.getMap());
    }

    @Test
    void canAccessPositionByCoordinates() {
        map = new ConvertedMap("_O_;_X_;T__");
        assertEquals("O", map.getByCoordinates(new Coordinates(1,0)));
        assertEquals("X", map.getByCoordinates(new Coordinates(1,1)));
        assertEquals("T", map.getByCoordinates(new Coordinates(0,2)));
        assertEquals("_", map.getByCoordinates(new Coordinates(2,2)));
    }

    @Test
    void canSetPositionByCoordinates() {
        map = new ConvertedMap("_O_;_X_;T__");
        assertEquals("_", map.getByCoordinates(new Coordinates(0,0)));
        map.setByCoordinates(new Coordinates(0,0), "X");
        assertEquals("X", map.getByCoordinates(new Coordinates(0,0)));
    }
}