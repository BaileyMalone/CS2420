package assign4;

import java.util.ArrayList;

/**
 * Sorter in SortUtil timing class!!
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 */

public class Timer 
{
	private long startTime, midpointTime, stopTime;
	private SortUtil sorter;

	// First, spin computing stuff until one second has gone by.
	// This allows this thread to stabilize.
	
	// Constructor
	public Timer()	{}

	public <T extends Comparable<? super T>> double time(SortUtil util, ArrayList<T> list, int threshold, String sortType)
	{
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) 
		{ // empty block
		}

		// Now, run the test.

		long timesToLoop = 5;

		startTime = System.nanoTime();
		
		for (long i = 0; i < timesToLoop; i++)
			for (double d = 1; d <= 10; d++)
				util.TestingSort(list, threshold, sortType);
		

		midpointTime = System.nanoTime();

		// Run an empty loop to capture the cost of running the loop.

		for (long i = 0; i < timesToLoop; i++) 
		{ // empty block
		}

		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and computing square roots.
		// Average it over the number of runs.

		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;
		
		return averageTime;

//		System.out.println("It takes exactly " + averageTime
//				+ " nanoseconds to compute the square roots of the"
//				+ " numbers 1..10.");
	}
}
