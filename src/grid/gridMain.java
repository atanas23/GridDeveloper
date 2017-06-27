package grid;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class gridMain {

	// Integer is for EventID, quadruple is for (x coord, y coord, price of
	// tickets, quantity of tickets)
	public static TreeMap<Integer, quadruple<Integer, Integer, Double, Integer>> events;

	// input
	static int x;
	static int y;

	public static void main(String[] args) {
		// initialise the TreeMap
		events = new TreeMap<Integer, quadruple<Integer, Integer, Double, Integer>>();

		// create objects of the two classes
		createEvents crE = new createEvents();
		calculateNearest crN = new calculateNearest();

		// create the events
		crE.makeEvents();

		// get the input from the user
		// open scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a number between -10 and 10, which will be used as a X coordinate");

		// check the value of X
		x = sc.nextInt();
		while (!(-10 < x && x < 10)) {
			System.out.println("Write a number between -10 and 10, which will be used as a X coordinate");
			x = sc.nextInt();
		}
		System.out.println("Write a number between -10 and 10, which will be used as an Y coordinate");

		// check the value of Y
		y = sc.nextInt();
		while (!(-10 < y && y < 10)) {
			System.out.println("Write a number between -10 and 10, which will be used as an Y coordinate");
			y = sc.nextInt();
		}
		sc.close();

		// calculate the nearest events
		TreeMap<Double, quadruple<Integer, Integer, Double, Integer>> nearest = crN.calcNearest(x, y);

		// print the required information
		System.out.println("Thank you for the input, the five nearest events to (" + x + ", " + y + ") are: ");
		int n = 0;
		for (Map.Entry<Double, quadruple<Integer, Integer, Double, Integer>> event : nearest.entrySet()) {
			// check that prevent from printing more than 5 events
			if (n >= 5)
				break;

			// get the info
			double dist = event.getKey();
			quadruple<Integer, Integer, Double, Integer> info = event.getValue();

			System.out.println("Event " + info.getX() + " - $" + info.getP() + ", " + "Distance " + dist);
			n++;
		}
		
	}
}
