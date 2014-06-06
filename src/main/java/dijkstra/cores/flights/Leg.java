package dijkstra.cores.flights;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.commons.Speed;
import dijkstra.cores.lanes.FlightLane;
import dijkstra.cores.units.UnitMagnitude;

public class Leg {	
	private Flight flight;
	private FlightLane lane;

	public Leg(FlightLane lane, Flight flight) {	
		this.lane = lane;
		this.flight = flight;
	}
	
	public FlightLane getLane() {
		return lane;
	}

	public Airport getFrom() {
		return lane.getFrom();
	}
	
	public Airport getTo() {
		return lane.getTo();
	}
	
	public UnitMagnitude getDistance() {
		return lane.getDistance();
	}

	public Flight getFlight() {
		return flight;
	}
	
	public UnitMagnitude getFlightTime() {
		Speed v = getFlight().getAirplane().getSpeed();
		return v.getTimeSpan(getDistance());
	}
}
