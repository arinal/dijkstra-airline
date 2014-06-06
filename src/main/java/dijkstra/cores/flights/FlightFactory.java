package dijkstra.cores.flights;

import dijkstra.cores.airplanes.Airplane;
import dijkstra.cores.airports.Airport;
import dijkstra.cores.lanes.FlightLane;
import dijkstra.cores.lanes.RouteGenerator;

public class FlightFactory {

	private RouteGenerator routeGenerator;

	public FlightFactory(RouteGenerator laneService) {
		this.routeGenerator = laneService;
	}

	public Flight generateFlight(Airport from, Airport to, Airplane airplane, int passengers) {
		Iterable<FlightLane> route = routeGenerator.generate(from, to, airplane.getMaxDistance());
		Flight newFlight = new Flight(from, to, airplane, passengers);
		for (FlightLane lane : route)
			newFlight.addLeg(lane);
		return newFlight;
	}
}
