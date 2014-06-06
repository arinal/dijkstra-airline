package dijkstra.cores.commons;

import dijkstra.cores.units.DivisionUnit;
import dijkstra.cores.units.Unit;
import dijkstra.cores.units.UnitMagnitude;

public class Speed {
	private UnitMagnitude speedValue;
	private DivisionUnit speedUnit;

	public Speed(UnitMagnitude speedValue) {
		this.speedValue = speedValue;
		this.speedUnit = (DivisionUnit) speedValue.getUnit();
	}

	public UnitMagnitude getTimeSpan(UnitMagnitude distance) {
		UnitMagnitude converted = distance.convertTo(speedUnit.getUnit1());
		return new UnitMagnitude(speedUnit.getUnit2(), 
				converted.getMagnitude() / speedValue.getMagnitude());
	}
	
	@Override
	public String toString() {
		return speedValue.toString();
	}

	public Speed convertTo(Unit target) {
		return new Speed(speedValue.convertTo(target));
	}
}
