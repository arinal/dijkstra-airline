package dijkstra.cores.units;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Immutable;

@Immutable @Embeddable
public class UnitMagnitude {
	private final double magnitude;
	private final Unit unit;

	public UnitMagnitude(Unit unit, double magnitude) {
		this.unit = unit;
		this.magnitude = magnitude;
	}
	
	@SuppressWarnings("unused")
	private UnitMagnitude() {
		this(null, 0);
	}

	public double getMagnitude() {
		return magnitude;
	}

	public Unit getUnit() {
		return unit;
	}

	public UnitMagnitude convertTo(Unit unit) {
		return new UnitMagnitude(unit, getMagnitude()
				* getUnit().getConvertionRatio(unit));
	}

	@Override
	public String toString() {
		return getMagnitude() + " " + getUnit().getSymbol();
	}
}
