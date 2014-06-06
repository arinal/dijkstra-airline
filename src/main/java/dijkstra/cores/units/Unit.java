package dijkstra.cores.units;

public interface Unit extends Comparable<Unit> {
	double getNormal();	
	String getName();
	String getSymbol();
	double getConvertionRatio(Unit unit);
	UnitMagnitude get(double magnitude);
}