package assign5;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 */

public class Timer 
{
	private long startTime, midpointTime, stopTime;
	private Timeable timeable;

	// First, spin computing stuff until one second has gone by.
	// This allows this thread to stabilize.
	
	// Constructor
	public Timer()	{}

	//public <T extends Comparable<? super T>> double time(Timeable<T> timeable, ArrayList<T> params, int size)
	public <T extends Comparable<? super T>> double time(MyLinkedList<T> list, T t, int size)
	{
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) 
		{ // empty block
		}

		// Now, run the test.

		long timesToLoop = 10;

		startTime = System.nanoTime();
		
		for (long i = 0; i < timesToLoop; i++)
			for (double d = 1; d <= 10; d++)	// *** Call what you are timing! Woo!
			{
				list.addFirst(t);
				//timeable.modificationOperation(params);
				//util.TestingSort(list, threshold, sortType);
			}
		

		midpointTime = System.nanoTime();

		// Run an empty loop to capture the cost of running the loop.

		for (long i = 0; i < timesToLoop; i++) 
		{ // empty block
		}

		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and computing square roots.
		// Average it over the number of runs.

		long averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;
		
		//System.out.println("<Time in ns>");
		System.out.println(size + "		" + averageTime);
		
		return averageTime;

//		System.out.println("It takes exactly " + averageTime
//				+ " nanoseconds to compute the square roots of the"
//				+ " numbers 1..10.");
	}
}
