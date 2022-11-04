import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertedMap {

    private List<List<String>> map;

    public ConvertedMap(String mapString) {
        this.map = convertMapToMatrixArray(mapString);
    }

    public static List<List<String>> convertMapToMatrixArray(String mapString) {
        List<List<String>> result = new ArrayList<>();

        Arrays.stream(mapString.split(";"))
                .forEach(rowString -> {
                    result.add(Arrays.stream(rowString.split("")).collect(Collectors.toList()));
                });

        return result;
    }

    public int getHeight() {
        return map.size();
    }
    public int getLength() {
        return map.get(0).size();
    }

    List<List<String>> getMap() {
        return this.map;
    }

    public List<String> getRow(int index) {
        return map.get(index);
    }

    public String getByCoordinates(Coordinates coordinates) {
        return map.get(coordinates.getY()).get(coordinates.getX());
    }

    public void setByCoordinates(Coordinates coordinates, String newValue) {
        map.get(coordinates.getY()).set(coordinates.getX(), newValue);
    }
}
