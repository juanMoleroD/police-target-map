import java.util.*;

public class Solution {

    private ConvertedMap map;

    public void setMap(String mapString) {
        this.map = new ConvertedMap(mapString);
    }
    public ConvertedMap getMap() {
        return this.map;
    }

    public int calculate(String mapString) {
        if (mapDoesNotContainsOfficerAndTarget(mapString)) return -2;
        setMap(mapString);
        Coordinates officerCoordinates = getPosition("O");
        Coordinates targetCoordinates = getPosition("T");

        return 3;
    }

    private boolean mapDoesNotContainsOfficerAndTarget(String mapString) {
        return !mapString.contains("O") && !mapString.contains("T");
    }

    Coordinates getPosition(String target) {
        int x = -1, y = -1;
        for (int i = 0; i < map.getHeight(); i++) {
            if (map.getRow(i).contains(target)) {
                x = map.getRow(i).indexOf(target);
                y = i;
            }
        }
        return new Coordinates(x, y);
    }

    public List<Coordinates> calculateNextPossibleMovements(Coordinates officerXY) {
        Coordinates left = new Coordinates(officerXY.getX() - 1,officerXY.getY());
        Coordinates up = new Coordinates(officerXY.getX(), officerXY.getY() -1);
        Coordinates right = new Coordinates(officerXY.getX() + 1, officerXY.getY());
        Coordinates down = new Coordinates(officerXY.getX(), officerXY.getY() + 1);

        List<Coordinates> result = new ArrayList<>();

        if (officerXY.getX() != 0 && nextIsNotX(map.getByCoordinates(left))) result.add(left);
        if (officerXY.getY() != 0 && nextIsNotX(map.getByCoordinates(up))) result.add(up);
        if (officerXY.getX() != map.getLength()-1 && nextIsNotX(map.getByCoordinates(right))) result.add(right);
        if (officerXY.getY() != map.getHeight()-1 && nextIsNotX(map.getByCoordinates(down))) result.add(down);

        return result;
    }

    private boolean nextIsNotX(String position) {
        return !Objects.equals(position, "X");
    }

}

