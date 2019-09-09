package data;

/**
 * This class describes the Road. Each road is represented as an edge of a graph.
 */
public class Road {

    private final String name;
    private final double length;
    private final City   start;
    private final City   stop;

    public Road(String name, City start, City stop) {
        this.length = Math.sqrt(
                        Math.pow(start.getCoordinate().getX() - stop.getCoordinate().getX(), 2)
                        + Math.pow(start.getCoordinate().getY() - stop.getCoordinate().getY(), 2)
                       );
        this.name = name;
        this.start = start;
        this.stop = stop;

    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public City getStart() {
        return start;
    }

    public City getStop() {
        return stop;
    }
}


