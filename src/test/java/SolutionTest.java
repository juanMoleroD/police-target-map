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
    void canCalculateOfficersNextPotentialMoves_noObstacles() {
        solution.setMap("O__;___;_T_");
        Coordinates officerCoordinates = solution.getPosition("O");
        List<Coordinates> expected = new ArrayList<>(List.of(
                new Coordinates(1,0),
                new Coordinates(0,1)
        ));
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates));

        solution.setMap("X__;_O_;__T");
        officerCoordinates = solution.getPosition("O");
        expected = new ArrayList<>(List.of(
                new Coordinates(0,1),
                new Coordinates(1,0),
                new Coordinates(2,1),
                new Coordinates(1,2)
        ));
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates));
    }

    @Test
    void calculateNextPotentialMove_withObstacles() {
        solution.setMap("_X_;XOX;_XT");
        Coordinates officerCoordinates = solution.getPosition("O");
        List<Coordinates> expected = new ArrayList<>();
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates));

        solution.setMap("___;_OX;_XT");
        officerCoordinates = solution.getPosition("O");
        expected = new ArrayList<>(List.of(
                new Coordinates(0,1), new Coordinates(1,0)
        ));
        assertEquals(expected, solution.calculateNextPossibleMovements(officerCoordinates));
    }



    //    @Test
//    void returnsNumberOfMovesCountingStart() {
//        assertEquals(3, solution.calculate("O__;_T_;___"));
//        assertEquals(5, solution.calculate("O__;___;__T"));
//    }
}
