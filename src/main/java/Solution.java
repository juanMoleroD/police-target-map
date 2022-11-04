import java.util.*;

public class Solution {

    public int calculate(String mapString) {
        if (mapDoesNotContainsOfficerAndTarget(mapString)) return -2;
        List<List<String>> map = convertMapToMatrixArray(mapString);
        Coordinates officerCoordinates = getPosition("O", map);
        Coordinates targetCoordinates = getPosition("T", map);


        return 3;
    }

    private boolean mapDoesNotContainsOfficerAndTarget(String mapString) {
        return !mapString.contains("O") && !mapString.contains("T");
    }

    List<List<String>> convertMapToMatrixArray(String mapString) {
        List<List<String>> result = new ArrayList<>();

        Arrays.stream(mapString.split(";"))
                .forEach(rowString -> {
                    result.add(Arrays.stream(rowString.split("")).toList());
                });

        return result;
    }

    Coordinates getPosition(String target, List<List<String>> map) {
        int x = -1, y = -1;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).contains(target)) {
                x = map.get(i).indexOf(target);
                y = i;
            }
        }
        return new Coordinates(x, y);
    }

    public List<Coordinates> calculateNextPossibleMovements(Coordinates officerCoordinates, List<List<String>> map) {
        List<Coordinates> result = new ArrayList<>();

        if (officerCoordinates.getX() != 0) {
            Coordinates moveLeft = new Coordinates(officerCoordinates.getX() - 1, officerCoordinates.getY());
            result.add(moveLeft);
        }
        if(officerCoordinates.getY() != 0) {
            Coordinates moveUp = new Coordinates(officerCoordinates.getX(), officerCoordinates.getY()-1);
            result.add(moveUp);
        }
        if (officerCoordinates.getX() != map.get(0).size() - 1) {
            Coordinates moveRight = new Coordinates(officerCoordinates.getX() + 1, officerCoordinates.getY());
            result.add(moveRight);
        }
        if (officerCoordinates.getY() != map.size() - 1) {
            Coordinates moveDown = new Coordinates(officerCoordinates.getX(), officerCoordinates.getY() + 1);
            result.add(moveDown);
        }

        return result;
    }

}

