package dijkstra.cores.airplanes;

import dijkstra.cores.commons.Repository;

public interface AirplaneRepository extends Repository<Airplane> {
	Airplane getByType(String type);
	Iterable<Airplane> whereDistanceLessThan(double distance);	
	Iterable<Airplane> getBySeatsGreater(int seats);	
}
