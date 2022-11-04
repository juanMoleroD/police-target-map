import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    void ifNoOfficerAndTarget_returnMinus2() {
        assertEquals(-2, solution.calculate("___;_X_;___"));
    }

    @Test
    void canTransformMapToArray() {
        String map = "O__;_X_;_T_";
        List<List<String>> expected = new ArrayList<>(List.of(
                new ArrayList<>(List.of("O", "_", "_")),
                new ArrayList<>(List.of("_", "X", "_")),
                new ArrayList<>(List.of("_", "T", "_"))
        ));
        assertEquals(expected, solution.convertMapToMatrixArray(map));
    }

    @Test
    void canReturnPositionCoordinatesFromMap() {
        List<List<String>> map = solution.convertMapToMatrixArray("O__;_X_;_T_");
        Coordinates expected = new Coordinates( 0, 0);
        assertEquals(expected, solution.getPosition("O", map));
        expected = new Coordinates(1, 2);
        assertEquals(expected, solution.getPosition("T", map));
    }

    @Test
    void canCalculateOfficersNextPotentialMoves_noObstacles() {
        List<List<String>> map = solution.convertMapToMatrixArray("O__;___;_T_");
        Coordinates officerCoordinates = solution.getPosition("O", map);
        List<Coordinates> expected = new ArrayList<>(List.of(
                new Coordinates(1,0),
                new Coordinates(0,1)
        ));
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates, map));

        map = solution.convertMapToMatrixArray("X__;_O_;__T");
        officerCoordinates = solution.getPosition("O", map);
        expected = new ArrayList<>(List.of(
                new Coordinates(0,1),
                new Coordinates(1,0),
                new Coordinates(2,1),
                new Coordinates(1,2)
        ));
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates, map));
    }

    @Test
    void calculateNextPotentialMove_withObstacles() {
        List<List<String>> map = solution.convertMapToMatrixArray("_X_;XOX;_XT");
        Coordinates officerCoordinates = solution.getPosition("O", map);
        List<Coordinates> expected = new ArrayList<>();
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates, map));

        map = solution.convertMapToMatrixArray("___;_OX;_XT");
        officerCoordinates = solution.getPosition("O", map);
        expected = new ArrayList<>(List.of(
                new Coordinates(0,1), new Coordinates(1,0)
        ));
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates, map));
    }



    //    @Test
//    void returnsNumberOfMovesCountingStart() {
//        assertEquals(3, solution.calculate("O__;_T_;___"));
//        assertEquals(5, solution.calculate("O__;___;__T"));
//    }
}
