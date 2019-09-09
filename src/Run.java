public class Run {

    public static void main(String[] args) {
        RoadGraph roadGraph = new RoadGraph();

        City A = new City("A", 1, 2);
        City B = new City("B", 3, 2);
        City C = new City("C", 5, 2);
        City D = new City("D", 6, 2);

        roadGraph.addCity(A);
        roadGraph.addCity(B);
        roadGraph.addCity(C);
        roadGraph.addCity(D);

        Road ab = new Road("R_ab", 2, A, B);
        Road ac = new Road("R_ac", 2, A, C);
        Road ad = new Road("R_ad", 2, A, D);

        roadGraph.addRoad(ab);
        roadGraph.addRoad(ac);
        roadGraph.addRoad(ad);

        roadGraph.getGraphInfo();

        roadGraph.deleteRoad(ab);

        roadGraph.getGraphInfo();
    }

}
