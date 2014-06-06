package dijkstra.cores.commons;

import java.util.Set;

public interface GraphNode {
	Object getId();
	
	boolean isVisited();
	void setVisited(boolean visited);
	
	GraphNode getBefore();
	void setBefore(GraphNode node);
		
	Set<GraphNode> getAdjacentNodes();
	Set<GraphNode> getAdjacentNodes(double maxDistance);
	
	double getDistance(GraphNode node);
	void addNode(GraphNode node, double length);
}
