import data.City;
import data.Road;

import java.util.Set;

interface APIable {

    /**
     * adds city
     * @param city to be added
     */
    void addCity(City city);

    /**
     * adds road
     * @param road to be added
     */
    void addRoad(Road road);

    /**
     * deletes road
     * @param road to be  deleted
     */
    void deleteRoad(Road road);

    /**
     * returns the city
     * @param cityName
     * @return city
     */
    City getCity(String cityName);

    /**
     * returns all roads which are belong to the city
     * @param cityName
     * @return Set
     */
    default Set<Road> getRoads(String cityName) {
        return getCity(cityName).getAllRoads();
    }



}
