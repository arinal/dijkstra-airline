package dijkstra.cores.lanes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.commons.GraphNode;

public class NodeAdapter implements GraphNode {
	private long id;
	private Airport city;
	private boolean isVisited;
	private GraphNode cityBefore;
	private FlightLaneRepository laneRepository;

	private Map<GraphNode, Double> neighbours;
	private Set<GraphNode> sharedGraph;

	public NodeAdapter(Airport city, FlightLaneRepository laneRepository,
			Set<GraphNode> sharedGraph) {
		this.city = city;
		id = city.getId();
		this.laneRepository = laneRepository;
		this.sharedGraph = sharedGraph;
	}

	@Override
	public Object getId() {
		return id;
	}

	@Override
	public boolean isVisited() {
		return isVisited;
	}

	@Override
	public void setVisited(boolean visited) {
		isVisited = visited;
	}

	public Map<GraphNode, Double> getNeighbours() {
		if (neighbours == null) {
			neighbours = new HashMap<GraphNode, Double>();
			Iterable<FlightLane> lanes = laneRepository.getAdjacent(city);
			for (FlightLane lane : lanes) {
				GraphNode node = new NodeAdapter(lane.getTo(), laneRepository,
						sharedGraph);
				for (GraphNode n : sharedGraph)
					if (n.equals(node))
						node = n;
				sharedGraph.add(node);
				neighbours.put(node, lane.getDistance().getMagnitude());
			}
		}
		return neighbours;
	}

	@Override
	public GraphNode getBefore() {
		return cityBefore;
	}

	@Override
	public void setBefore(GraphNode node) {
		cityBefore = node;
	}

	@Override
	public Set<GraphNode> getAdjacentNodes() {
		return getNeighbours().keySet();
	}

	@Override
	public Set<GraphNode> getAdjacentNodes(double maxDistance) {
		Set<GraphNode> result = new HashSet<GraphNode>();
		for (GraphNode node : getAdjacentNodes())
			if (getDistance(node) <= maxDistance)
				result.add(node);
		return result;
	}

	@Override
	public double getDistance(GraphNode node) {
		return getNeighbours().get(node);
	}

	@Override
	public void addNode(GraphNode node, double length) {
		for (GraphNode n : sharedGraph)
			if (n.equals(node))
				node = n;
		getNeighbours().put(node, length);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof NodeAdapter) {
			NodeAdapter otherNode = (NodeAdapter) other;
			return Objects.equals(id, otherNode.id);
		}
		return false;
	}
}
