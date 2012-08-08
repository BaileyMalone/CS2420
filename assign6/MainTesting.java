package assign6;

import java.util.List;
/**
 * Testing class for GraphUtil.
 * Tests the algorithms on the DOT examples provided
 * in the assignmen 6 description.
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */
public class MainTesting 
{

	/**
	 * @param args
	 */
//	public static void main(String[] args) 
//	{
//		/* Breadth-First Search -- Linked Dot Example 1*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph.dot", 
//		//														"vertex 1", "vertex 2");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 2*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph2.dot", 
//		//														"A", "D");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 3*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph3.dot", 
//		//														"n2", "n0");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 4*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph4.dot", 
//		//														"u0", "u4");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 5*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph5.dot", 
//		//														"1", "5");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 6*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph6.dot", 
//		//														"1", "5");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 7*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph7.dot", 
//		//														"CS 1410", "CS 4500");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		/* Breadth-First Search -- Linked Dot Example 8*/
//		//		List<String> path = GraphUtil.breadthFirstSearch("/home/bmalone/workspace/CS2420/src/examplegraph8.dot", 
//		//														"Salt Lake City", "San Diego");
//		//		
//		//		for (String s : path)
//		//			System.out.print(s + " --> ");
//		
//		
//		// ----------------------------------------------------------------------------------------------------------------
//
//		
//		/* Topological Sort -- Linked Dot Example 1*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//		/* Topological Sort -- Linked Dot Example 2*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph2.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//		/* Topological Sort -- Linked Dot Example 3*/
////				List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph3.dot");
////		
////				for (String s : taskSchedule)
////				{
////					System.out.println(s);
////				}
//		/* Topological Sort -- Linked Dot Example 4*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph4.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//		/* Topological Sort -- Linked Dot Example 5*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph5.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//		/* Topological Sort -- Linked Dot Example 6*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph6.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//		/* Topological Sort -- Linked Dot Example 7*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph7.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//		/* Topological Sort -- Linked Dot Example 8*/
//		//		List<String> taskSchedule = GraphUtil.topologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph8.dot");
//		//
//		//		for (String s : taskSchedule)
//		//		{
//		//			System.out.println(s);
//		//		}
//
//		// --------------------------------------------------------------------------------------------------------------------
//
//		/* Experiment Running */
//		/* Generated Files --> /home/bmalone/workspace/CS2420/[filename] */
//		//GraphGenerator.generateRandomDotFile("RandomGraph1", 20);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph1", 200);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph2", 800);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph3", 1600);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph4", 3200);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph5", 6400);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph6", 12800);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph7", 25600);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph8", 51200);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph9", 124000);
//		//		GraphGenerator.generateRandomDotFile("RandomGraph10", 1000000);
//
//				
//		/*
//		 * Experimenting Code -- Timing and looping to time GraphUtil.
//		 */
////		String testPathBase = "/home/bmalone/workspace/CS2420/Acyclic";
////		String testPath = "/home/bmalone/workspace/CS2420/Acyclic";
////
////		int count = 1;
////		int N = 100;
////		System.out.println("BFS -- Dense Data");
////		GraphTimer timer = new GraphTimer();
////		while (count < 11)
////		{
////			testPath += count + ".dot";
////			
////
////			String target = Integer.toString(N - (N/4)).trim();
////			String endVertex = "v" + target;
////			
////			double RunningTime = timer.timeOnGraphFile(testPath.trim(), "v0", endVertex);
////			N *= 2;
////			System.out.println(N + "    " + RunningTime);
////			
////			count++;
////			testPath = testPathBase;
////		}
//
//
//
//		//		List<String> topSort = PretendUtil.pretendTopologicalSort("/home/bmalone/workspace/CS2420/src/examplegraph7.dot");
//		//		for (String s : topSort)
//		//			System.out.print(s + " --> ");
//
//
//
//		/* buildGraphFromDot Test 1 -- Temporarily made public to test */
//		//		Graph graph = GraphUtil.buildGraphFromDot("/home/bmalone/workspace/CS2420/src/examplegraph.dot");
//		//		ArrayList<ArrayList<Edge>> edges = graph.getAllConnections();
//		//		
//		//		for (ArrayList<Edge> list : edges)
//		//		{
//		//			for (Edge e : list)
//		//			{
//		//				System.out.println(e.toString());
//		//			}
//		//		}
//	}
}
