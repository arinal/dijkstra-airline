package dijkstra.cores.airplanes;

import javax.persistence.Entity;

import dijkstra.cores.commons.AbstractEntity;
import dijkstra.cores.commons.Speed;
import dijkstra.cores.units.Unit;
import dijkstra.cores.units.UnitMagnitude;

@Entity
public class Airplane extends AbstractEntity {
	private String type;
	private int seats;
	private Speed speed;
	private UnitMagnitude maxDistance;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {		
		this.seats = seats;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed velocity) {
		this.speed = velocity;
	}
	
	public void setSpeed(Unit speedUnit, double value) {
		setSpeed(new Speed(new UnitMagnitude(speedUnit, value)));
	}

	public UnitMagnitude getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(UnitMagnitude maxDistance) {
		this.maxDistance = maxDistance;
	}

	public void setMaxDistance(Unit unit, double maxDistance) {
		setMaxDistance(new UnitMagnitude(unit, maxDistance));		
	}	
}
