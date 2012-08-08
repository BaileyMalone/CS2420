package assign8;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * A timing handler for testing the BST
 * on different data sets.
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */
public class HashTimer 
{
	long startTime, stopTime, midpointTime;
	
	public double timeHasher(HashTable table, ArrayList<String> data)
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
				for (String s : data)
				{
					table.add(s);
				}
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
		//System.out.println(size + "		" + averageTime);

		return averageTime;
	}
	
	public double timeBST(HashTableIterator it)
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
		//System.out.println(size + "		" + averageTime);

		return averageTime;
	}
}
