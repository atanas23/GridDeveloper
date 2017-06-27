package grid;

import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class createEvents {

	TreeMap<Integer, quadruple<Integer, Integer, Double, Integer>> events = gridMain.events;

	/**
	 * Creates the events, sets thir x and y, ticket price and quantity
	 */
	void makeEvents() {

		// format the price price of the ticket(e.g. 150.25)
		DecimalFormat df = new DecimalFormat("#.##");

		double ticketPrice;
		int ticketCount;

		int numberOfEvents = ThreadLocalRandom.current().nextInt(50, 101);
		@SuppressWarnings("unchecked")
		quadruple<Integer, Integer, Integer, Integer>[] coords = new quadruple[numberOfEvents];

		for (int i = 1; i <= numberOfEvents; i++) {
			// get the x, y coordinates and make sure there are no duplicate
			// pairs
			int xAxis = ThreadLocalRandom.current().nextInt(-10, 11);
			int yAxis = ThreadLocalRandom.current().nextInt(-10, 11);

			while (isIn(coords, new quadruple<Integer, Integer, Integer, Integer>(xAxis, yAxis, 0, 0))) {
				xAxis = ThreadLocalRandom.current().nextInt(-10, 11);
				yAxis = ThreadLocalRandom.current().nextInt(-10, 11);
			}
			coords[i - 1] = new quadruple<Integer, Integer, Integer, Integer>(xAxis, yAxis, 0, 0);

			ticketPrice = Double.valueOf(df.format(ThreadLocalRandom.current().nextDouble(1, 501)));
			ticketCount = ThreadLocalRandom.current().nextInt(0, 2001);

			// create the quadruple and assign values
			quadruple<Integer, Integer, Double, Integer> event = new quadruple<Integer, Integer, Double, Integer>(xAxis,
					yAxis, ticketPrice, ticketCount);
			events.put(i, event);
		}
	}

	/**
	 * Helper method that checks is a pair of coordinates already exists
	 * 
	 * @param q
	 *            array of all existing pairs of coordinates
	 * @param newQ
	 *            the new pair of coordinates
	 * @return true if there is already such a pair, false otherwise
	 */
	boolean isIn(quadruple<Integer, Integer, Integer, Integer>[] q,
			quadruple<Integer, Integer, Integer, Integer> newQ) {
		for (int i = 0; i < q.length; i++) {
			if (q[i] != null && q[i].getX() == newQ.getX() && q[i].getY() == newQ.getY())
				return true;
		}
		return false;
	}
}
