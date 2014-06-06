package dijkstra.cores.units;

import java.util.HashMap;

public class Units {
	// Lengths
	public final static Unit Centimeter = add(new BaseUnit("centimeter", "cm", 0.01));
	public final static Unit Meter = add(new BaseUnit("meter", "m", 1.0));
	public final static Unit Kilometer = add(new BaseUnit("Kilometer", "km", 1000.0));
	public final static Unit Mile = add(new BaseUnit("mile", "mi", 1609.34));
	
	// Mass
	public final static Unit Gram = add(new BaseUnit("gram", "gr", 0.001));
	public final static Unit Kilogram = add(new BaseUnit("kilogram", "Kg", 1.0));	
	
	// Times
	public final static Unit Second = add(new BaseUnit("second", "s", 1.0));
	public final static Unit Minute = add(new BaseUnit("minute", "minute", 60.0));
	public final static Unit Hour = add(new BaseUnit("hour", "h", 3600.0));
	
	// Charges
	public final static Unit Coulomb = add(new BaseUnit("Coulomb", "C", 1.0));
	public final static Unit ElectronCharge = add(new BaseUnit("Electron in Coulomb", "e", 1.602E-19));	
	
	// Areas
	public final static Unit MeterSquare = add(new MultiplyUnit(Units.Meter, Units.Meter,
			"Meter Square", "m^2"));
	public final static Unit KiloMeterSquare = add(new MultiplyUnit(Units.Kilometer, Units.Kilometer,
			"Kilometer Square", "km^2"));
	
	// Speeds
	public final static Unit MeterPerSecond = add(new DivisionUnit(Units.Meter, Units.Second));
	public final static Unit KiloMeterPerHour = add(new DivisionUnit(Units.Kilometer, Units.Hour));
	public final static Unit MilePerHour = add(new DivisionUnit(Units.Mile, Units.Hour));
	
	// Accelerations
	public final static Unit MeterPerSecondSquare = add(new DivisionUnit(Units.MeterPerSecond, Units.Second));
	
	// Force
	public final static Unit Newton = add(new MultiplyUnit(Units.Kilogram, Units.MeterPerSecondSquare, "Newton", "N"));
	
	// Energies
	public final static Unit Joule = add(new MultiplyUnit(Units.Newton, Units.Meter, "Joule", "J"));
	
	// Potentials (voltage)
	public final static Unit Volt = add(new DivisionUnit(Units.Joule, Units.Coulomb, "Volt", "V"));
	
	// Energies
	public final static Unit ElectronVolt = add(new MultiplyUnit(Units.ElectronCharge, Units.Volt, "Electron Volt", "eV"));
	
	// Current
	public final static Unit Ampere = add(new DivisionUnit(Units.ElectronCharge, Units.Second, "Ampere", "A"));

	private static HashMap<String, Unit> unitMap;
	
	private static Unit add(Unit unit) {		
		getMap().put(unit.getSymbol(), unit);
		return unit;
	}
	
	public static Unit of(String unit) {		
		return getMap().get(unit);
	}
	
	private static HashMap<String, Unit> getMap() {
		if (unitMap == null)
			 unitMap = new HashMap<String, Unit>();
		return unitMap;
	}
}
