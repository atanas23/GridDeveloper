package grid;

import java.util.Map;
import java.util.TreeMap;

public class calculateNearest {

	TreeMap<Integer, quadruple<Integer, Integer, Double, Integer>> events = gridMain.events;

	/**
	 * Calculates and returns the 5 nearest events to the given coords
	 * 
	 * @param x
	 *            the x coord
	 * @param y
	 *            the y coord
	 * @return the 5 nearest events to the given x and y coords
	 */
	public TreeMap<Double, quadruple<Integer, Integer, Double, Integer>> calcNearest(int x, int y) {
		// the quadruple consists of (EventID, 0, TicketPrice, 0) and the double
		// is for the distance
		TreeMap<Double, quadruple<Integer, Integer, Double, Integer>> nearest = new TreeMap<Double, quadruple<Integer, Integer, Double, Integer>>();
		double dist;

		// iterate through the map to find the distance to all events
		for (Map.Entry<Integer, quadruple<Integer, Integer, Double, Integer>> events : events.entrySet()) {
			int eventID = events.getKey();
			quadruple<Integer, Integer, Double, Integer> coords = events.getValue();

			// calculate Manhattan Distance
			dist = Math.abs(coords.getX() - x) + Math.abs(coords.getY() - y);

			// add to hashmap
			nearest.put(dist, new quadruple<Integer, Integer, Double, Integer>(eventID, 0, coords.getP(), 0));
		}

		return nearest;
	}
}
