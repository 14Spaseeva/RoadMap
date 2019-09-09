package data;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class describes the city. Each city is represented as a node of a graph
 */
public class City {

    private final String     name;
    private final Coordinate coordinate;

    private Set<Road> roads = ConcurrentHashMap.newKeySet();

    public City(String name, int x, int y) {
        this.name = name;
        this.coordinate = new Coordinate(x, y);
    }

    /**
     * adds road to the city
     *
     * @param road to be connected to the city
     */
    public void addRoad(Road road) {
        if (this.roads.contains(road)) {
            System.out.println("This edge has already been used for this node.");
        } else {
            this.roads.add(road);
        }
    }

    /**
     * returns all roads belongs to the city
     *
     * @return Set
     */
    public Set<Road> getAllRoads() {
        return roads;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
