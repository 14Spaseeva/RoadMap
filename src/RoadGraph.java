import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RoadGraph implements APIable {

    private Set<City> vertices = new HashSet<>();

    @Override
    public void addCity(City city) {
        vertices.add(city);
    }

    @Override
    public void addRoad(Road road) {
        addRoad(road.getStart(), road);
        addRoad(road.getStop(), road);
    }

    private void addRoad(City cityToUpdate, Road road) {
        Optional<City> city = vertices.stream().filter(c -> c.equals(cityToUpdate)).findFirst();
        if (city.isPresent())
            city.get().getConnections().add(road);
        else
            throw new IllegalArgumentException("Attempting to connect nonexistent cities");
    }

    @Override
    public void deleteRoad(Road road) {
        deleteRoad(road.getStart(), road);
        deleteRoad(road.getStop(), road);
    }

    private void deleteRoad(City cityToUpdate, Road road) {
        Optional<City> city = vertices.stream().filter(c -> c.equals(cityToUpdate)).findFirst();
        if (city.isPresent())
            city.get().getConnections().remove(road);
        else
            throw new IllegalArgumentException("Attempting to connect nonexistent cities");
    }

    @Override
    public City getCity(String cityName) {
        return vertices.stream()
                .filter(c -> c.getName().equals(cityName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no city %s", cityName)));
    }

    void getGraphInfo() {
        System.out.println(String.format("%n________INFO_______"));
        vertices.forEach(v ->
                         {
                             System.out.println(String.format("%nCity %s with roads : ", v.getName()));
                             v.getConnections().forEach(c -> System.out.print(c.getName() + " "));
                         });
    }
}
