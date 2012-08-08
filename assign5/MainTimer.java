package assign5;

import java.util.ArrayList;

public class MainTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
				// Create a Timer to time Timeables
				Timer timer = new Timer();
		//		
		//		// Create Timeables to time
		//		TimeableLinkedList<Integer> linkedList = new TimeableLinkedList<Integer>();
		//		TimeableArrayList<Integer>	arrayList = new TimeableArrayList<Integer>();
		//		
		//		
		//		// Set up test data generators
		//		AscendingSequencer ascSeq = new AscendingSequencer();
		//		
		//		
		//		// Do some timing and get some results!
		//		/* 100 < N < 10,000 $ Nk+1 = Nk + 100 */
		//		int count = 0;
		//		ArrayList<Integer> testList = new ArrayList<Integer>();
		//		System.out.println("<Timing>: MyLinkedList addFirst");
		//		for (int N = 10; N <= 500; N += 20)
		//		{
		//			// Make test data of size N
		//			while (count <= N)	{	testList.add(ascSeq.next());	count++;	}
		//			
		//			// Time a Timeable on the size N test data
		//			timer.time(arrayList, testList, N);
		//			//timer.time(linkedList, testList, N);

		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		for (int N = 10; N <= 500; N += 20)
			timer.time(linkedList, 1, N);
	}

}
