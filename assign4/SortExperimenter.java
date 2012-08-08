package assign4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Experimental class for timing SortUtil sorting methods on
 * test data to determine efficient cutoff and pivot
 * choices.
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 */

public class SortExperimenter 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//boolean gettingAllData = true;

		int runCounter = 0;
		//while (gettingAllData)
		{
			// Generate Test Data
			// 10,000 Elements, average over 5 runs
			ArrayList<Integer> ascData = SortUtil.generateData(100, new PermutedSequencer(8000));
			ArrayList<Integer> ascData2 = SortUtil.generateData(200, new PermutedSequencer(8000));
			ArrayList<Integer> ascData3 = SortUtil.generateData(400, new PermutedSequencer(8000));
			ArrayList<Integer> ascData4 = SortUtil.generateData(800, new PermutedSequencer(8000));
			
			
			//ArrayList<Integer> ascData = SortUtil.generateData(200, new AscendingSequencer());
			//ArrayList<Integer> desctData = SortUtil.generateData(400, new DescendingSequencer(8000));
			//ArrayList<Integer> testData4 = SortUtil.generateData(800, new PermutedSequencer(8000));
			//ArrayList<Integer> testData5 = SortUtil.generateData(1600, new PermutedSequencer(8000));


			ArrayList<ArrayList<Integer>> DATA = new ArrayList<ArrayList<Integer>>();
			DATA.add(ascData);		DATA.add(ascData2);		DATA.add(ascData3);		DATA.add(ascData4);	
			//DATA.add(ascData);	DATA.add(desctData);
			//DATA.add(testData4);	DATA.add(testData5);

			// RESULTS. GET 'EM. 'R DONE.
			ArrayList<Double> results = new ArrayList<Double>();
			SortUtil su = new SortUtil();

			// Loop 5 runs, average the time over 5 runs for each threshold
			int THRESHOLD = 0;
			Timer timer = new Timer();
			for (int i = 0; i < 4; i++)
			{
				// Set the THRESHOLD
				//THRESHOLD = 1;
				//THRESHOLD = 5;
				//THRESHOLD = 2;
				//THRESHOLD = DATA.get(i).size() / 2;
				//THRESHOLD = DATA.get(i).size() / 3;
				THRESHOLD = DATA.get(i).size() / 10;
				//--THRESHOLD = DATA.get(i).size() / 50;

				// The pivot --> Set in the quicksort method...



				// Run the timing
				double runTime1 = timer.time(su, DATA.get(i), THRESHOLD, "mergesort");
				double runTime2 = timer.time(su, DATA.get(i), THRESHOLD, "quicksort");
				results.add(runTime1);	results.add(runTime2);
			}

			// Output results / average AND current threshold
			String line0 = "Timing Results for MergeSort - n/10 threshold\n\t\t**VS**\n\t\tQuicksort - median-of-3 pivot";
			String line1 = "Mergesort:\t\t" + results.get(0) + " ns\n";
			String line2 = "\t\t" + results.get(2) + " ns\n";
			String line3 = "\t\t" + results.get(4) + " ns\n";
			String line4 = "\t\t" + results.get(6) + " ns\n\n";
			String line5 = "Quicksort:\t\t" + results.get(1) + " ns\n";
			String line6 = "\t\t" + results.get(3) + " ns\n";
			String line7 = "\t\t" + results.get(5) + " ns\n";
			String line8 = "\t\t" + results.get(7) + " ns\n\n";
//			String line3 = "N = 400\t\t" + results.get(4) + " ns\n";
//			String line4 = "N = 800\t\t" + results.get(6) + " ns\n";
//			String line5 = "N = 1600\t\t" + results.get(7) + " ns\n";

			String output = line0 + "\n" + line1 + "\n" + line2 + "\n"+ line3 + "\n" + line4 + "\n" + 
					line5 + "\n" + line6 + "\n" + line7 + "\n" + line8 + "\n";

			System.out.println(output);
			System.out.println("------------------------------------------------------------------");
		}
	}
}
