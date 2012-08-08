package assign6;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/* DEBUG */
		System.err.println("<Args>");
		for (String s : args)
			System.err.println(s);



		// Run Breadth-First Search
		List<String> path = GraphUtil.breadthFirstSearch(args[0], args[1], args[2]);
		// Run Topological Sort
		//List<String> path = GraphUtil.topologicalSort(args[1]);


		/* Print out the path! */
		for (String s : path)
		{
			System.out.println(s);
		}
	}
}
