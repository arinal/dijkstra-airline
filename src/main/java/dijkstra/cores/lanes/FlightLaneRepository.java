package dijkstra.cores.lanes;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.commons.Repository;

public interface FlightLaneRepository extends Repository<FlightLane> {
	Iterable<FlightLane> getByCity(Airport city);
	Iterable<FlightLane> getAdjacent(Airport city);
	FlightLane getLane(long idFrom, long idTo);	
}
