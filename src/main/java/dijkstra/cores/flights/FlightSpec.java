package dijkstra.cores.flights;

import dijkstra.cores.airports.Airport;

public class FlightSpec {
	private Airport from;
	private Airport to;
	private int passengers;

	public FlightSpec(Airport from, Airport to, int passengers) {
		this.from = from;
		this.to = to;
		this.passengers = passengers;
	}

	public boolean isSatisfiedBy(Flight flight) {
		return flight.getFrom() != null && flight.getFrom().equals(from)
				&& flight.getTo() != null && flight.getTo().equals(to)
				&& flight.getAirplane().getSeats() >= passengers;
	}
}
