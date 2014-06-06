package dijkstra.cores.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algorithm {

	public static List<GraphNode> findShortest(GraphNode from, Object toId, double maxDistance) {
		List<GraphNode> path = new ArrayList<GraphNode>();
		if (from == null || toId == null)
			return path;

		GraphNode currentNode = from;

		HashMap<GraphNode, Double> distances = new HashMap<GraphNode, Double>();
		distances.put(currentNode, 0.0);
		currentNode.setVisited(true);

		Set<GraphNode> nextNodes = new HashSet<GraphNode>(from.getAdjacentNodes(maxDistance));

		boolean found = false;
		while (!found && !nextNodes.isEmpty()) {
			Set<GraphNode> adjacents = currentNode.getAdjacentNodes(maxDistance);
			for (GraphNode node : adjacents) {
				if (node.isVisited())
					continue;
				double distance = distances.containsKey(node) ? distances.get(node) : Double.MAX_VALUE;
				double foundDistance = distances.get(currentNode) + currentNode.getDistance(node);
				if (foundDistance < distance) {
					distances.put(node, foundDistance);
					node.setBefore(currentNode);
				}
			}
			double min = Double.MAX_VALUE;
			GraphNode minNode = null;
			for (GraphNode node : nextNodes)
				if (min > distances.get(node)) {
					min = distances.get(node);
					minNode = node;
				}
			currentNode = minNode;
			currentNode.setVisited(true);
			if (currentNode.getId().equals(toId))
				found = true;
			else {
				nextNodes.remove(currentNode);
				adjacents = currentNode.getAdjacentNodes(maxDistance);
				for (GraphNode node : adjacents)
					if (!node.isVisited())
						nextNodes.add(node);
			}
		}

		if (!currentNode.getId().equals(toId))
			return path;

		while (!currentNode.equals(from)) {
			path.add(currentNode);
			currentNode = currentNode.getBefore();
		}
		path.add(from);
		for (int i = 0; i < path.size() / 2; i++) {
			GraphNode temp = path.get(i);
			path.set(i, path.get(path.size() - i - 1));
			path.set(path.size() - i - 1, temp);
		}
		return path;
	}
}
