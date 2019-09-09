import java.util.*;

public class City {

    private final String     name;
    private final Coordinate coordinate;

    private Set<Road> connections = new HashSet<>();

    public City(String name, int x, int y) {
        this.name = name;
        this.coordinate = new Coordinate(x, y);
    }

    public void addConnection(Road road) {
        if (this.connections.contains(road)) {
            System.out.println("This edge has already been used for this node.");
        } else {
            System.out.println("Successfully added " + road);
            this.connections.add(road);
        }
        //TODO add coordinate check
    }

    public Set<Road> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
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

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
