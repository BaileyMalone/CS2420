package assign4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UnitTests 
{
	// Test data
	ArrayList<Integer> fiveList = new ArrayList<Integer>();
	ArrayList<Integer> fiveList2 = new ArrayList<Integer>();
	ArrayList<Integer> fiveList3 = new ArrayList<Integer>();
	ArrayList<Integer> eightList2 = new ArrayList<Integer>();
	ArrayList<Integer> tenList = new ArrayList<Integer>();
	ArrayList<Integer> tenList2 = new ArrayList<Integer>();
	ArrayList<Integer> tenList3 = new ArrayList<Integer>();
	ArrayList<Integer> twentyFiveList = new ArrayList<Integer>();
	ArrayList<Integer> twentyFiveList2 = new ArrayList<Integer>();
	ArrayList<Integer> duplicateList = new ArrayList<Integer>();
	ArrayList<Integer> negativeList = new ArrayList<Integer>();
	ArrayList<Integer> duplicateList2 = new ArrayList<Integer>();
	ArrayList<Integer> negativeList2 = new ArrayList<Integer>();
	ArrayList<Integer> thousandList = new ArrayList<Integer>();

	ArrayList<Character> charList1 = new ArrayList<Character>();
	ArrayList<Character> charList2 = new ArrayList<Character>();
	ArrayList<Character> charList3 = new ArrayList<Character>();


	@Before
	public void setup()
	{
		// Setup thousand list
		boolean dupFlag2 = true;
		for (int i = 30; i > 0; i--)
		{
			thousandList.add(i);
			if (dupFlag2)
			{
				thousandList.add(i);
				dupFlag2 = false;
			}
			else
			{
				thousandList.add(i+1);
				dupFlag2 = true;
			}
		}
		// Setup tenList
		for (int i = 11; i > 0; i--)
		{
			tenList.add(i);
			tenList2.add(i);
			tenList3.add(i);

			twentyFiveList2.add(i);

			if (i > 0 && i < 9)
				eightList2.add(i);
		}
		// Setup fiveList
		fiveList.add(5);
		fiveList.add(4);
		fiveList.add(3);
		fiveList.add(2);
		fiveList.add(1);
		fiveList2.add(5);
		fiveList2.add(4);
		fiveList2.add(3);
		fiveList2.add(2);
		fiveList2.add(1);
		// Setup 25 list
		for (int i = 25; i > 0; i--)
			twentyFiveList.add(i);
		// Setup duplicateList
		boolean dupFlag = true;	int lastInt = 0;
		for (int i = 0; i < 11; i++)
		{	
			duplicateList.add(i);
			duplicateList2.add(i);

			if (twentyFiveList2.size() <= 25)
				twentyFiveList2.add(i);

			if (dupFlag)
			{
				duplicateList.add(lastInt++);
				duplicateList2.add(lastInt);
				dupFlag = false;
			}
			else
				dupFlag = true;
		}
		// Setup negativeList
		for (int i = -5; i < 6; i++)
		{
			negativeList.add(i);
			negativeList2.add(i);

			if (twentyFiveList2.size() <= 25)
				twentyFiveList2.add(i);

			if (i > 0 && i <= 5)
				fiveList3.add(i);
		}
		// Setup char lists
		charList1.add('y');
		charList1.add('x');
		charList1.add('w');
		charList1.add('v');
		charList1.add('u');
		charList1.add('t');
		charList2.add('c');
		charList2.add('b');
		charList2.add('a');
		charList3.add('s');
		charList3.add('r');
		charList3.add('q');
		charList3.add('p');
		charList3.add('o');
		charList3.add('n');
		charList3.add('m');
		charList3.add('l');
		charList3.add('k');
	}

	@Test
	public void testMergesort1()
	{
		SortUtil.mergesort(tenList2);

		assertTrue((tenList2.get(2) == 3) && (tenList2.get(8) == 9));
	}

	@Test
	public void testMergesort2()
	{
		SortUtil.mergesort(fiveList2);

		assertTrue((fiveList2.get(2) == 3) && (fiveList2.get(4) == 5));

	}

	@Test
	public void testMergesort3()
	{
		SortUtil.mergesort(eightList2);

		assertTrue((eightList2.get(1) == 2) && (eightList2.get(7) == 8));
	}

	@Test
	public void testMergesort4()
	{
		SortUtil.mergesort(twentyFiveList);

		assertTrue((twentyFiveList.get(0) == 1) && (twentyFiveList.get(6) == 7) && (twentyFiveList.get(14) ==15) && (twentyFiveList.get(22) == 23));
	}

	@Test
	public void testMergesort5()
	{
		SortUtil.mergesort(duplicateList);
		
		

		assertTrue((duplicateList.get(0) == 0) && (duplicateList.get(1) == 0) && (duplicateList.get(5) == 2) && (duplicateList.get(10) == 5) && (duplicateList.get(16) == 10));
	}

	@Test
	public void testMergesort6()
	{
		SortUtil.mergesort(negativeList);

		assertTrue((negativeList.get(0) == -5) && (negativeList.get(4) == -1) && (negativeList.get(10) == 5));
	}

	@Test
	public void testMergesort7()
	{
		SortUtil.mergesort(charList1);

		assertTrue((charList1.get(0) == 't') && (charList1.get(5) == 'y'));
	}


	@Test
	public void testQuicksortArrayListOfT1()
	{
		SortUtil.quicksort(tenList);
		
		System.out.println("<Quicksort Test 1>");
		for (Integer x : tenList)
			System.out.print(x + " ");
		System.out.println();

		assertTrue((tenList.get(0) == 1) && (tenList.get(10) == 11));
	}

	@Test
	public void testQuicksortArrayListOfT2()
	{
		SortUtil.quicksort(duplicateList2);
		
		System.out.println("<Quicksort Test 2>");
		for (Integer x : duplicateList2)
			System.out.print(x + " ");
		System.out.println();

		assertTrue((duplicateList2.get(0) == 0) && (duplicateList2.get(6) == 6));
	}

	@Test
	public void testQuicksortArrayListOfT3()
	{
		SortUtil.quicksort(negativeList2);
		
		System.out.println("<Quicksort Test 3>");
		for (Integer x : negativeList2)
			System.out.print(x + " ");
		System.out.println();

		assertTrue((negativeList2.get(0) == -5) && (negativeList2.get(10) == 5));
	}

	@Test
	public void testQuicksortArrayListOfT4()
	{
		SortUtil.quicksort(charList2);
		
		System.out.println("<Quicksort Test 4>");
		for (Character c : charList2)
			System.out.print(c + " ");
		System.out.println();

		assertTrue((charList2.get(0) == 'a') && (charList2.get(2) == 'c'));
	}

	@Test
	public void testQuicksortArrayListOfT5()
	{
		SortUtil.quicksort(charList3);

		assertTrue((charList3.get(0) == 'k') && (charList3.get(4) == 'o'));
	}
	
	@Test
	public void testQuicksortArrayListOfT6()
	{
		SortUtil.quicksort(thousandList);

		System.out.println("<Quicksort Test 6>");
		for (Integer x : thousandList)
			System.out.print(x + " ");
		System.out.println();
		
		assertTrue((thousandList.get(0) == 1) && (thousandList.get(15) == 16));
	}

	@Test
	public void testSwap() 
	{
		ArrayList<String> swapMyElements = new ArrayList<String>();
		swapMyElements.add("We're still in the CADE lab, where are you?");
		swapMyElements.add("Roses are red, violents are blue -- ");

		SortUtil.swap(swapMyElements, 0, 1);

		String messageToStephen = "Roses are red, violents are blue -- We're still in the CADE lab, where are you?";

		assertTrue(messageToStephen.compareTo(swapMyElements.get(0).concat(swapMyElements.get(1))) == 0);
	}

	@Test
	public void testMedianOfThree() 
	{
		SortUtil.MedianOfThree(fiveList3, 0, 4);

		assertTrue(fiveList3.get(0) == 1);
	}

	@Test
	public void testMedianOfThree2() 
	{
		/*
		 * To whom it may concern:
		 * I have blatantly lied to you. This is NOT a list of 25 elements.
		 * It has 26 elements. I'm sorry.
		 * I didn't want you to have to find out this way.
		 */
		SortUtil.MedianOfThree(twentyFiveList2, 0, twentyFiveList2.size()-1);

		assertTrue(twentyFiveList2.get(0) == -2 && twentyFiveList2.get((twentyFiveList2.size()-1)/2) == 1
				&& twentyFiveList2.get(25) == 11);
	}

	@Test
	public void testInsertionSort() 
	{
		SortUtil.insertionSort(tenList3, 0, tenList3.size()-1);

		assertTrue((tenList3.get(0) == 1) && (tenList3.get(9) == 10));
	}

	@Test
	public void testGenerateData() 
	{
		ArrayList<Integer> descendingInts = SortUtil.generateData(10, new DescendingSequencer(10));

		assertTrue(descendingInts.get(2) > descendingInts.get(3));
	}
	
	@Test
	public void testGenerateData2() 
	{
		ArrayList<Integer> ascendingInts = SortUtil.generateData(10, new AscendingSequencer());
		
		assertTrue(ascendingInts.get(2) < ascendingInts.get(3));
	}
	
	@Test
	public void testGenerateData3() 
	{
		ArrayList<Integer> permutedInts1 = SortUtil.generateData(10, new PermutedSequencer(10));
		ArrayList<Integer> permutedInts2 = SortUtil.generateData(10, new PermutedSequencer(10));
		
		System.out.println("<Permuted Ints 1>");
		for (Integer x1 : permutedInts1)
			System.out.print(x1 + " ");
		System.out.println();
		
		System.out.println("<Permuted Ints 2>");
		for (Integer x2 : permutedInts2)
			System.out.print(x2 + " ");
		System.out.println();
		
		
		assertTrue((permutedInts1.get(0) != permutedInts2.get(0)) && (permutedInts1.get(3) != permutedInts2.get(3)));
	}
}
