package assign4;
import java.util.ArrayList;
import java.util.Random;

/**
 * A generic Sorting Utility class implementing Hybrid-Mergesort
 * and quicksort with three styles of pivot choice.
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 */
public class SortUtil
{
	private static int mergeThreshold = 5;


	public SortUtil()
	{}

	/**
	 * <<TESTING/EXPERIMENTAL METHOD ONLY>>
	 * DO not use for other purposes. That would be silly.
	 * YOU - would be silly.
	 * 
	 * @param list
	 * @param threshold
	 */
	public <T extends Comparable<? super T>> void TestingSort(ArrayList<T> list, int threshold, String flag)
	{	
		if (flag.compareTo("mergesort") == 0)
		{
			SortUtil.mergeThreshold = threshold;
			mergesort(list);
		}
		else if (flag.compareTo("quicksort") == 0)
		{
			quicksort(list);
		}
	}

	/**
	 * This method performs a mergesort on the generic ArrayList 
	 * given as input.
	 * 
	 * @param list
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list)
	{	
		int low = 0;
		int high = list.size() - 1;
		mergesort(list, low, high);
	}

	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list, int low, int high)
	{
		if (list.size() == 0 || list.size() == 1)
			return;

		// Step 1: Partition/Divide
		int start=0, mid=0, end=0;
		if (high-low + 1 >= mergeThreshold)
		{			
			start = low;
			end = high;
			mid = (start + end) / 2;

			// Step 2: Recurse
			mergesort(list, start, mid);	// L
			mergesort(list, mid + 1, high);	// R

			// Step 3: Merge
			merge(list, start, mid, high);
		}
		else
		{
			insertionSort(list, start, high);
		}
	}

	public static <T extends Comparable<? super T>> void merge(ArrayList<T> list, int start, int mid, int high)
	{
		// Setup our merge indexes
		int i = start;
		int j = mid + 1;

		// Walk through both arrays, finding the minimum of each's element, and
		// place that minimum in the "new" array
		ArrayList<T> sublist = new ArrayList<T>(high-start+1);

		while (i <= mid && j <= high)
		{
			// Compare L and R array values for the next min
			if (list.get(i).compareTo(list.get(j)) < 0)
				sublist.add(list.get(i++));
			else 
				sublist.add(list.get(j++));
		}
		while (i <= mid)
		{
			sublist.add(list.get(i++));
		}
		while (j <= high)
		{
			sublist.add(list.get(j++));
		}

		// Now, put the sorted version of the values into the main list
		int counter = 0;
		for (int x = start; x < high+1; x++)
			list.set(x, sublist.get(counter++));
	}

	/**
	 * This method performs a quicksort on the generic ArrayList 
	 * given as input.
	 * 
	 * Handling duplicates is done by simply removing them from the
	 * list. Our quicksort likes uniqueness.
	 * 
	 * <Driver Method for quickSort(ArrayList<T>, int, int)>
	 * 
	 * @param list
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list)
	{
		// Remove duplicates
		for (int k = 0; k < list.size(); k++)
		{
			T t = list.get(k);
			int first = list.indexOf(t);
			for (int i = first+1; i < list.size(); i++)
				if (list.get(i) == t)
					list.remove(i);
		}

		// Quicksort this monkey
		list.trimToSize();
		quicksort(list, 0, list.size() -1);
	}

	/**
	 * Quicksorts the parameter list from indexes 'low' to 'high'.
	 * 
	 * @param list
	 * @param low
	 * @param high
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list, 
			int low, int high)
	{	
		// Check for Base Case
		if ((high - low) <= 0)
			return;
		
		// **Select Pivot**
		/*
		 * 1. Median-of-3 
		 * 2. pseudo-random Median-of-3
		 * 3. Leftmost element is the pivot (obvious worst case)
		 */
		int v = MedianOfThree(list, low, high);
		//int v = RandomMedianOfThree(list, low, high);
		//int v = (high+low)/3;
		//int v = (high+low)/2;
		// ****************//
		// Place pivot at end
		swap(list, v, high-1);
		T pivot = list.get(high-1);

		// Use (i=low, j=high-1) indexing and swap around to sort this [sub]array
		int i = low;
		int j = high-1;
		// Step through from both directions
		boolean swapping = true;
		boolean settingI = true;	boolean settingJ = true;
		while (swapping)
		{
			// i still seeking next larger value?
			while (settingI)
			{
				if (!(list.get(i).compareTo(pivot) < 0))
					settingI = false;
//				else if ((list.get(i).compareTo(pivot) == 0))
//					list.remove(i);
				else
					i++;
			}

			// j still seeking next smaller value?
			while (settingJ)
			{
//				/* DEBUG */
//				System.out.println("(i, j) = (" + i + ", " + j + ")");
//				System.out.println("list(i) = " + list.get(i) + ", pivot = " + pivot
//									+ ", list(j) = " + list.get(j));
//				System.out.println("low = " + low + ", " + "high = " + high);
				
				
				if (!(list.get(j).compareTo(pivot) > 0))
					settingJ = false;
//				else if (list.get(j).compareTo(pivot) == 0)
//					list.remove(j);
				else
					j--;
			}

			// We found a smallest and largest to swap
			swap(list, i, j);
			settingI = true;	settingJ = true;


			if (i >= j)	swapping = false;
		}
		
		// <Recurse>
		quicksort(list, low, i);
		quicksort(list, i+1, high);
	}

	/**
	 * Swaps the elements at x and y places in the parameter ArrayList.
	 * 
	 * @param list
	 * @param x
	 * @param y
	 */
	public static <T> void swap(ArrayList<T> list, int x, int y)
	{
		try
		{
			T temp = list.get(x);
			list.set(x, list.get(y));
			list.set(y, temp);
		}
		catch (IndexOutOfBoundsException err)
		{
			System.err.println("<IndexOutOfBoundsException> in swap: (x, y) = (" + x + ", "+ y + ")");
		}
	}

	/**
	 * Uses the Median-of-3 method on the parameter list.
	 * 
	 * @param list
	 * @param low
	 * @param high
	 */
	public static <T extends Comparable<? super T>> int MedianOfThree(ArrayList<T> list, int low, int high)
	{
		int mid = (low + high) / 2;

		try
		{
			// low lower than mid?
			if (list.get(mid).compareTo(list.get(low)) < 0)
				swap(list, low, mid);

			// low lower than high?
			if (list.get(high).compareTo(list.get(low)) < 0)
				swap(list, high, low);

			// high lower than mid?
			if (list.get(high).compareTo(list.get(mid)) < 0)
				swap(list, high, mid);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.err.println("<OutOfBounds> in MedianOfThree -- low = " + low + ", high = " + high);
		}


		return (low + high) / 2;
	}

	/**
	 * Uses the Median-of-3 method on the parameter list, but selects
	 * three numbers at random in the list to sort at both ends and the
	 * middle, instead of the 'natural' ones.
	 * 
	 * @param list
	 * @param low
	 * @param high
	 */
	public static <T extends Comparable<? super T>> int RandomMedianOfThree(ArrayList<T> list, int low, int high)
	{

		Random rng = new Random();

		ArrayList<Integer> indexes = new ArrayList<Integer>();

		boolean settingUniqueIndexes = true;
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		while (settingUniqueIndexes)
		{
			index1 = rng.nextInt(high - low);
			index1 += low;
			indexes.add(index1);

			boolean index2NotUnique = true;
			while (index2NotUnique)
			{
				index2 = rng.nextInt(high - low);
				index2 += low;
				if (!indexes.contains(index2))
				{
					indexes.add(index2);
					index2NotUnique = false;
				}
			}

			boolean index3NotUnique = true;
			while (index3NotUnique)
			{
				index3 = rng.nextInt(high - low);
				index3 += low;
				if (!indexes.contains(index3))
				{
					indexes.add(index3);
					index3NotUnique = false;
				}
			}

			settingUniqueIndexes = false;
		}

		// Place the new indexes in the first, middle and last positions
		int mid = (low + high) / 2;
		swap(list, index1, low);
		swap(list, index2, mid);
		swap(list, index3, high);


		return MedianOfThree(list, low, high);
	}

	/**
	 * Performs an Insertion Sort on the parameter list.
	 * 
	 * @param list
	 */
	public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list,
			int x, int y)
	{	
		if (list == null )
		{
			System.err.println("Cannot sort with null parameters!\nInsertion Sort failed!");
			return;
		}

		ArrayList<T> tempList = new ArrayList<T>();
		tempList.add(list.get(0));
		// Step through the array
		int boundary;
		for (int i = 1; i < list.size(); i++)
		{
			// Iterate through all the spots less than where we are in the
			// sorted portion, comparing until we find the spot
			/* While we're still in the sorted portion AND the current value is lesser */
			// For shifting, we'll want to preserve the current value
			T currValue = list.get(i);
			boundary = i;
			while (boundary > 0 && list.get(boundary-1).compareTo(currValue) > 0)
			{
				list.set(boundary, list.get(boundary-1));
				boundary--; // Move down the sorted portion
			}

			list.set(boundary, currValue);
		}
	}

	/**
	 * This method generates and returns an ArrayList of integers. 
	 * The order of the integers is determined by the specified 
	 * Sequencer functor. 
	 * 
	 * @param size
	 * @param sequencer
	 * @return
	 */
	public static ArrayList<Integer> generateData(int size, Sequencer sequencer)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i <= size; i++)
		{
			list.add(sequencer.next());
		}

		return list;
	}
}
