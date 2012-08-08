package assign6;
/**
 * A timing handler for testing the GraphUtil
 * algorithms on multiple DOT files in a loop.
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */
public class GraphTimer 
{
	long startTime, stopTime, midpointTime;
	
	public double timeOnGraphFile(String filename, String startV, String endV)
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
				GraphUtil.breadthFirstSearch(filename, startV, endV);
				//GraphUtil.topologicalSort(filename);
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
