package dijkstra.cores.lanes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.commons.Algorithm;
import dijkstra.cores.commons.GraphNode;
import dijkstra.cores.units.UnitMagnitude;

public class RouteGenerator {
	FlightLaneRepository laneRepository;
	
	public RouteGenerator(FlightLaneRepository laneRepository) {
		this.laneRepository = laneRepository;
	}

	public Iterable<FlightLane> generate(Airport from, Airport to, UnitMagnitude maxDistance) {
		return generate(from, to, maxDistance.getMagnitude());
	}
	
	public Iterable<FlightLane> generate(Airport from, Airport to, double maxDistance) {
		HashSet<GraphNode> sharedGraph = new HashSet<GraphNode>();
		NodeAdapter fromNode = new NodeAdapter(from, laneRepository, sharedGraph);
		NodeAdapter toNode = new NodeAdapter(to, laneRepository, sharedGraph);
		sharedGraph.add(fromNode);
		sharedGraph.add(toNode);
		List<GraphNode> path = Algorithm.findShortest(fromNode, toNode.getId(), maxDistance);
		
		List<FlightLane> result = new ArrayList<FlightLane>();
		for (int i = 0; i < path.size() - 1; i++) {
			FlightLane lane = laneRepository.getLane((long)path.get(i).getId(),
					(long)path.get(i + 1).getId());
			result.add(lane);
		}
		return result;
	}

	public void addDoubleDirectedLane(Airport city1, Airport city2, UnitMagnitude distance) {
		FlightLane newLane = new FlightLane(city1, city2, distance);
		laneRepository.save(newLane);
		laneRepository.save(newLane.createReverse());
	}
	
	public void addDirectedLane(Airport city1, Airport city2, UnitMagnitude distance) {
		laneRepository.save(new FlightLane(city1, city2, distance));
	}
}
