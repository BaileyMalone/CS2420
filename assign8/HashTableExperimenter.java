package assign8;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * There are 5 files of the dictionary.txt file, of
 * 100 of the words, 200, 400, 800 and 1600. Each file
 * is read into an ArrayList and passed as an argument 
 * to a HashTimer function that times the hashing and
 * measures the collisions of adding the ArrayList
 * of words.
 * 
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */
public class HashTableExperimenter 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/* Read in dictionary-section-files into ArrayLists */
		File oneHundred = new File("/home/bmalone/workspace/CS2420/100");
		File twoHundred = new File("/home/bmalone/workspace/CS2420/200");
		File fourHundred = new File("/home/bmalone/workspace/CS2420/400");
		File eightHundred = new File("/home/bmalone/workspace/CS2420/800");
		File sixteenHundred = new File("/home/bmalone/workspace/CS2420/1600");
		
		ArrayList<String> listOne = new ArrayList<String>();
		ArrayList<String> listTwo = new ArrayList<String>();
		ArrayList<String> listFour = new ArrayList<String>();
		ArrayList<String> listEight = new ArrayList<String>();
		ArrayList<String> listSixteen = new ArrayList<String>();

		try
		{
			Scanner OneH = new Scanner(oneHundred);
			Scanner TwoH = new Scanner(twoHundred);
			Scanner FourH = new Scanner(fourHundred);
			Scanner EightH = new Scanner(eightHundred);
			Scanner SixteenH = new Scanner(sixteenHundred);
			
			// Read in from files
			for (int i = 0; i < 1600; i++)
			{
				if (i < 100)
					listOne.add(OneH.next());
				if (i < 200)
					listTwo.add(TwoH.next());
				if (i < 400)
					listFour.add(FourH.next());
				if (i < 800)
					listEight.add(EightH.next());
				if (i < 1600)
					listSixteen.add(SixteenH.next());
			}
		}
		catch (IOException ioe)
		{
			System.err.println("What file?!");
			ioe.printStackTrace();
		}

		/* Run the timings -- Get Results! */
		// 1,601 is prime :)
		ChainingHashTable qpTable1 = new ChainingHashTable(1601, new BadHashFunctor());
		ChainingHashTable qpTable2 = new ChainingHashTable(1601, new MediocreHashFunctor());
		ChainingHashTable qpTable3 = new ChainingHashTable(1601, new GoodHashFunctor());
		
		HashTimer timer = new HashTimer();
		
		// Results
		ArrayList<Double> badHasherTimes = new ArrayList<Double>();
		ArrayList<Double> medHasherTimes = new ArrayList<Double>();
		ArrayList<Double> goodHasherTimes = new ArrayList<Double>();
		
		ArrayList<Integer> badHasherCollisions = new ArrayList<Integer>();
		ArrayList<Integer> medHasherCollisions = new ArrayList<Integer>();
		ArrayList<Integer> goodHasherCollisions = new ArrayList<Integer>();
		
		// RUN RUN RUN YOU WANKER RUN
		/* Bad Hasher */
		badHasherTimes.add(timer.timeHasher(qpTable1, listOne));
		badHasherCollisions.add(qpTable1.numberOfCollisions);	
		qpTable1.numberOfCollisions = 0; qpTable1.clear();
		
		badHasherTimes.add(timer.timeHasher(qpTable1, listTwo));
		badHasherCollisions.add(qpTable1.numberOfCollisions);
		qpTable1.numberOfCollisions = 0; qpTable1.clear();
		
		badHasherTimes.add(timer.timeHasher(qpTable1, listFour));
		badHasherCollisions.add(qpTable1.numberOfCollisions);
		qpTable1.numberOfCollisions = 0; qpTable1.clear();
		
		badHasherTimes.add(timer.timeHasher(qpTable1, listEight));
		badHasherCollisions.add(qpTable1.numberOfCollisions);
		qpTable1.numberOfCollisions = 0; qpTable1.clear();
		
		badHasherTimes.add(timer.timeHasher(qpTable1, listSixteen));
		badHasherCollisions.add(qpTable1.numberOfCollisions);
		qpTable1.numberOfCollisions = 0; qpTable1.clear();
		
		/* Mediocre Hasher */
		medHasherTimes.add(timer.timeHasher(qpTable2, listOne));
		medHasherCollisions.add(qpTable2.numberOfCollisions);
		qpTable2.numberOfCollisions = 0; qpTable2.clear();
		
		medHasherTimes.add(timer.timeHasher(qpTable2, listTwo));
		medHasherCollisions.add(qpTable2.numberOfCollisions);
		qpTable2.numberOfCollisions = 0; qpTable2.clear();
		
		medHasherTimes.add(timer.timeHasher(qpTable2, listFour));
		medHasherCollisions.add(qpTable2.numberOfCollisions);
		qpTable2.numberOfCollisions = 0; qpTable2.clear();
		
		medHasherTimes.add(timer.timeHasher(qpTable2, listEight));
		medHasherCollisions.add(qpTable2.numberOfCollisions);
		qpTable2.numberOfCollisions = 0; qpTable2.clear();
		
		medHasherTimes.add(timer.timeHasher(qpTable2, listSixteen));
		medHasherCollisions.add(qpTable2.numberOfCollisions);
		qpTable2.numberOfCollisions = 0; qpTable2.clear();
		
		/* Good Hasher */
		goodHasherTimes.add(timer.timeHasher(qpTable3, listOne));
		goodHasherCollisions.add(qpTable3.numberOfCollisions);
		qpTable3.numberOfCollisions = 0; qpTable3.clear();
		
		goodHasherTimes.add(timer.timeHasher(qpTable3, listTwo));
		goodHasherCollisions.add(qpTable3.numberOfCollisions);
		qpTable3.numberOfCollisions = 0; qpTable3.clear();
		
		goodHasherTimes.add(timer.timeHasher(qpTable3, listFour));
		goodHasherCollisions.add(qpTable3.numberOfCollisions);
		qpTable3.numberOfCollisions = 0; qpTable3.clear();
		
		goodHasherTimes.add(timer.timeHasher(qpTable3, listEight));
		goodHasherCollisions.add(qpTable3.numberOfCollisions);
		qpTable3.numberOfCollisions = 0; qpTable3.clear();
		
		goodHasherTimes.add(timer.timeHasher(qpTable3, listSixteen));
		goodHasherCollisions.add(qpTable3.numberOfCollisions);
		qpTable3.numberOfCollisions = 0; qpTable3.clear();
		
		
		/* <RESULTS> */
		int N = 100;
		/* Bad Hash Functor Results */
		System.out.println("<Bad Hash Functor>");
		// Times
		for (int i = 0; i < 5; i++)
		{
			System.out.println(N + "\t" + badHasherTimes.get(i));
			N *= 2;
		}
		N = 100; System.out.println("\n");
		// Collisions
		for (int i = 0; i < 5; i++)
		{
			System.out.println(N + "\t" + badHasherCollisions.get(i));
			N *= 2;
		}
		N = 100; System.out.println("\n");
		// -----------------------------------
		/* Mediocre Hash Functor Results */
		System.out.println("<Mediocre Hash Functor>");
		// Times
		for (int i = 0; i < 5; i++)
		{
			System.out.println(N + "\t" + medHasherTimes.get(i));
			N *= 2;
		}
		N = 100; System.out.println("\n");
		// Collisions
		for (int i = 0; i < 5; i++)
		{
			System.out.println(N + "\t" + medHasherCollisions.get(i));
			N *= 2;
		}
		N = 100; System.out.println("\n");
		// -----------------------------------
		/* Good Hash Functor Results */
		System.out.println("<Good Hash Functor>");
		// Times
		for (int i = 0; i < 5; i++)
		{
			System.out.println(N + "\t" + goodHasherTimes.get(i));
			N *= 2;
		}
		N = 100; System.out.println("\n");
		// Collisions
		for (int i = 0; i < 5; i++)
		{
			System.out.println(N + "\t" + goodHasherCollisions.get(i));
			N *= 2;
		}
		// -----------------------------------
		
	}
}
