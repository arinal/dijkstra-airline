package dijkstra.cores.lanes;

import javax.persistence.ManyToOne;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.commons.AbstractEntity;
import dijkstra.cores.units.UnitMagnitude;
import dijkstra.cores.units.Units;

public class FlightLane extends AbstractEntity {	
	@ManyToOne private Airport from;
	@ManyToOne private Airport to;
	private UnitMagnitude distance;

	public FlightLane(Airport from, Airport to, UnitMagnitude distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	
	public FlightLane() {
		this(null, null, new UnitMagnitude(Units.Kilometer, 0));
	}
	
	public Airport getFrom() {
		return from;
	}

	public void setFrom(Airport city) {
		this.from = city;
	}
	
	public Airport getTo() {
		return to;
	}

	public void setTo(Airport city) {
		this.to = city;
	}

	public UnitMagnitude getDistance() {
		return distance;
	}

	public void setDistance(UnitMagnitude distance) {
		this.distance = distance;
	}
	
	public FlightLane createReverse() {
		return new FlightLane(to, from, distance);
	}
}
