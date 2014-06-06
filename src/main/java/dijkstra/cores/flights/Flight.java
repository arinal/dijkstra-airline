package dijkstra.cores.flights;

import java.util.ArrayList;
import java.util.List;

import dijkstra.cores.airplanes.Airplane;
import dijkstra.cores.airports.Airport;
import dijkstra.cores.commons.AbstractEntity;
import dijkstra.cores.lanes.FlightLane;

public class Flight extends AbstractEntity {
	
	private Airplane airplane;		
	private FlightSpec spec;
	private List<Leg> legs;
	
	public Flight(Airport from, Airport to, Airplane airplane, int passengers) {
		this.spec = new FlightSpec(from, to, passengers);		
		this.airplane = airplane;
		legs = new ArrayList<Leg>();
	}
	
	public boolean isValid() {
		return this.spec.isSatisfiedBy(this);
	}
	
	public Airport getFrom() {
		return legs.size() > 0? legs.get(0).getFrom() : null;
	}

	public Airport getTo() {
		return legs.size() > 0? legs.get(legs.size() - 1).getTo() : null;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Iterable<Leg> getLegs() {
		return legs;
	}
	
	public void addLeg(FlightLane lane) {
		if (legs.size() > 0) {
			Leg lastLeg = legs.get(legs.size() - 1);
			if (lane.getFrom().equals(lastLeg.getTo()))
				legs.add(new Leg(lane, this));
		}
		else
			legs.add(new Leg(lane, this));
	}
}
