import java.util.Set;

interface APIable {

    void addCity(City city);

    void addRoad(Road road);

    void deleteRoad(Road road);

    City getCity(String cityName);

    default Set<Road> getRoads(String cityName) {
        return getCity(cityName).getConnections();
    }



}
