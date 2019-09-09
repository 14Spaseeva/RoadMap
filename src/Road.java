public class Road {

    private final String name;
    private final double length;
    private final City   start;
    private final City   stop;

    public Road(String name, double length, City start, City stop) {
        this.name = name;
        this.length = length;
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


