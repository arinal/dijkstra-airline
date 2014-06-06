package dijkstra.infras.data.inmemory;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.lanes.FlightLane;
import dijkstra.cores.lanes.FlightLaneRepository;

public class FlightLaneInMemoryRepo extends InMemoryRepositoryBase<FlightLane>
		implements FlightLaneRepository {
	private static ArrayList<FlightLane> data = new ArrayList<FlightLane>();

	@Override
	protected ArrayList<FlightLane> getData() {
		return data;
	}

	@Override
	public Page<FlightLane> search(String key, Pageable page) {
		ArrayList<FlightLane> result = new ArrayList<FlightLane>();
		for (FlightLane a : this)
			if (a.getFrom().getCity().contains(key)
					|| a.getTo().getCity().contains(key))
				result.add(a);
		return new PageImpl<FlightLane>(result, page, result.size());
	}

	@Override
	public Iterable<FlightLane> getByCity(Airport city) {
		ArrayList<FlightLane> result = new ArrayList<FlightLane>();
		for (FlightLane a : this)
			if (a.getFrom().equals(city) || a.getTo().equals(city))
				result.add(a);
		return result;
	}

	@Override
	public Iterable<FlightLane> getAdjacent(Airport city) {
		ArrayList<FlightLane> result = new ArrayList<FlightLane>();
		for (FlightLane a : this)
			if (a.getFrom().equals(city))
				result.add(a);
		return result;
	}

	@Override
	public FlightLane getLane(long from, long to) {
		for (FlightLane f : this)
			if (f.getFrom().getId() == from && f.getTo().getId() == to)
				return f;
		return null;
	}
}