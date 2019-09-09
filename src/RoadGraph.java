import data.City;
import data.Road;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RoadGraph implements APIable {

    private Set<City> vertices = ConcurrentHashMap.newKeySet();

    /**
     * adds the city to the Road map
     *
     * @param city to be added
     */
    @Override
    public void addCity(City city) {
        vertices.add(city);
    }

    /**
     * adds the road to the road map
     *
     * @param road to be added
     */
    @Override
    public void addRoad(Road road) {
        addRoad(road.getStart(), road);
        addRoad(road.getStop(), road);
    }

    private void addRoad(City cityToUpdate, Road road) {
        Optional<City> city = vertices.stream().filter(c -> c.equals(cityToUpdate)).findFirst();
        if (city.isPresent())
            city.get().addRoad(road);
        else
            throw new IllegalArgumentException("Attempting to connect nonexistent cities");
    }

    /**
     * deletes the road from the road map
     *
     * @param road to be deleted
     */
    @Override
    public void deleteRoad(Road road) {
        deleteRoad(road.getStart(), road);
        deleteRoad(road.getStop(), road);
    }

    private void deleteRoad(City cityToUpdate, Road road) {
        Optional<City> city = vertices.stream().filter(c -> c.equals(cityToUpdate)).findFirst();
        if (city.isPresent())
            city.get().getAllRoads().remove(road);
        else
            throw new IllegalArgumentException("Attempting to connect nonexistent cities");
    }

    /**
     * returns the city by name
     *
     * @param cityName the city name
     *
     * @return city
     */
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
                             v.getAllRoads().forEach(c -> System.out.print(String.format("%s (%s km), ", c.getName(), c.getLength())));
                         });
    }
}
