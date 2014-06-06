package dijkstra.cores.commons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NodeImpl implements GraphNode {
	
	private Object id;
	private boolean visited;
	private GraphNode before;
	private HashMap<GraphNode, Double> neighbours;
	
	public NodeImpl(Object id) {
		this.id = id;
		neighbours = new HashMap<GraphNode, Double>();
	}
	
	public Object getId() {
		return id;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public GraphNode getBefore() {
		return before;
	}

	public void setBefore(GraphNode before) {
		this.before = before;
	}
	
	public Set<GraphNode> getAdjacentNodes() {
		return neighbours.keySet();
	}
	
	public Set<GraphNode> getAdjacentNodes(double maxRange) {
		Set<GraphNode> nodes = new HashSet<GraphNode>();
		Set<GraphNode> adjacents = neighbours.keySet();
		for ( GraphNode n : adjacents ) {
			if ( this.getDistance(n) > maxRange )
				continue;
			nodes.add(n);
		}
		return nodes;
	}
	
	public double getDistance(GraphNode node) {
		return neighbours.get(node);
	}
	
	public void addNode(GraphNode node, double length) {
		neighbours.put(node, length);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);	
	}

	@Override
	public boolean equals(Object other) {
		if (other.getClass() == getClass()) {
			NodeImpl otherEntity = (NodeImpl)other;
			return Objects.equals(getId(), otherEntity.getId());			
		}
		return false;
	}	
}
