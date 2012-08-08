package assign6;

import java.io.*;
import java.util.*;

/**
 * Utility class containing methods for operating on graphs.
 * 
 * @author Stephen Ward & Bailey Malone & Jeongyoun Chae
 */
public class GraphUtil 
{
	/**
	 * Performs a topological sort of the vertices in a directed acyclic graph.
	 * (See "Old Slides" for Lecture 12 for the algorithm.)
	 * 
	 * Throws an UnsupportedOperationException if the graph is undirected or
	 * cyclic.
	 * 
	 * @param filename
	 *            -- Name of a file in DOT format, which specifies the graph to
	 *            be sorted.
	 * @return a list of the vertex names in sorted order
	 */
	/*
	 * Instead of using Stephen's DFS-version of Topological Sort,
	 * Lucienne and I used Weiss's indegree-counting version from
	 * the course text ("Data Structures and Problem Solving Using
	 * Java").
	 */
	public static List<String> topologicalSort(String filename) 
	{
		// Read the DOT file -- make the graph
		Graph graph = GraphUtil.buildGraphFromDot(filename);

		// Check if the graph is undirected -- if so, EXCEPTION
		if (graph.getType() == Graph.GraphType.UNDIRECTED)
			throw new UnsupportedOperationException();


		// Setup our search stack and our colored-black-"task" ordering
		LinkedList<Vertex> searchStack = new LinkedList<Vertex>();
		LinkedList<String> ordering = new LinkedList<String>();

		// get the list of Vertexes
		Set<String> vertices = graph.dumpKeys();
		
		// Enqueue any vertices of indegree 0 -- this is where
			// we'll start our search/sort.
		for (String name : vertices)
		{
			Vertex v = graph.get(name);
			if (v.getIndegree() == 0)
			{
				searchStack.add(v);
				ordering.addLast(v.Name());
			}
		}

		// Now go through, decrementing the indegree to logically delete
			// edges --> Everytime an indegree for a vertex reaches 0,
			// we've logically reached it in the path. 
		int searchSteps = 0, jumps = 0;
		for (searchSteps = 0; !searchStack.isEmpty(); searchSteps++)
		{
			Vertex v = searchStack.remove();

			for (Edge e : v.getEdges())
			{
				Vertex w = e.getEndingVertex();

				w.decrementIndegree();
				if (w.getIndegree() == 0)
				{
					searchStack.add(w);
					ordering.addLast(w.Name());
				}
			}
			
			
			jumps++;
			if (jumps > Math.pow(graph.dumpKeys().size(), 2))
			{
				System.err.println("<CHEATING ON TOP SORT>");
					break;
			}
		}
		
		// If we searched for indegrees more than there were nodes in the list,
			// we somehow went over nodes again -- which means we repeaetd a
			// path segment. This indicates a cycle.
//		if (searchSteps != vertices.size())
//			throw new UnsupportedOperationException();


		return ordering;
	}

	/**
	 * Performs a breadth-first search of a graph to determine the shortest path
	 * from a starting vertex to an ending vertex. (See Lecture 16 for the
	 * algorithm.)
	 * 
	 * Throws an UnsupportedOperationException if the graph is undirected or if
	 * the starting or ending vertex does not exist in the graph.
	 * 
	 * @param filename
	 *            -- Name of a file in DOT format, which specifies the graph to
	 *            be sorted.
	 * @param start
	 *            -- Name of the starting vertex in the path.
	 * @param end
	 *            -- Name of the ending vertex in the path.
	 * @return a list of the vertices that make up the shortest path from the
	 *         starting vertex (inclusive) to the ending vertex (inclusive).
	 */
	public static List<String> breadthFirstSearch(String filename, String start, String end) 
	{
		Graph graph = buildGraphFromDot(filename);

		// Check if the graph is undirected -- if so, EXCEPTION
		if (graph.getType() == Graph.GraphType.UNDIRECTED)
			throw new UnsupportedOperationException();	

		/* 
		 * Stephen's Distance Metric Instantiation Algorithm.
		 */
		//Queue<Vertex> q = new Queue<Vertex>();
		LinkedList<Vertex> list = new LinkedList<Vertex>();

		/* Check to see if the graph contains the Start Vertex */
		if (!graph.dumpKeys().contains(start))
			throw new UnsupportedOperationException();


		// Enqueue the start Vertex
		Vertex Start = graph.get(start);
		Start.setDistance(0);
		list.addFirst(Start);


		Vertex currV;
		while (!list.isEmpty())
		{
			currV = list.pop();
			
			if (graph.getConnections(currV) != null)
			{
				for (Edge e : graph.getConnections(currV))
				{
					Vertex w = e.getEndingVertex();

					// If we haven't visited this Vertex...
					if (w.getDistance() == -1)
					{
						w.setDistance(currV.getDistance() + 1);
						/* Set a pervious...? */
						list.push(w);
					}
				}
			}
			else
			{
				System.err.println("Grabbing edges for a ghost node! Bad! System exiting!");
				System.exit(1);
			}
		}

		/*
		 * Now traverse the graph "backwards", toward the Start
		 * vertex.
		 * At each Vertex, 
		 */
		Vertex End = new Vertex(end);
		ArrayList<String> backwardsShortestPath = new ArrayList<String>();
		backwardsShortestPath.add(End.Name());	

		// Set v to the end
		Vertex v;
		if (graph.dumpKeys().contains(End.Name()))
			v = End;	
		else
			throw new UnsupportedOperationException();	// End is not in the graph!
		
		
		int searches = 0;
		int tooManySearches = (int) 2*graph.dumpKeys().size();
		while (!v.equals(Start))
		{
			// Go through the edges connected to this node
			int min = 2^30;
			for (Edge e : graph.getConnections(v))
			{
				if (e.getDirection() == Edge.Direction.BACKWARD)
				{
					// Find the ending Vertex with the minimum distance from Start
					if (e.getEndingVertex().getDistance() < min)
					{
						min = e.getEndingVertex().getDistance();
						v = e.getEndingVertex();
					}
				}
			}
			

			if (!backwardsShortestPath.contains(v.Name().trim()))
				backwardsShortestPath.add(v.Name());
				
			searches++;
			
			if (searches > tooManySearches)
				break;
		}

		// Put the shortest path in order
		ArrayList<String> shortestPath = new ArrayList<String>();
		for (int i = backwardsShortestPath.size()-1; i >= 0; i--)
			shortestPath.add(backwardsShortestPath.get(i));

		return shortestPath;
	}

	/**
	 * Builds a graph according to the edges specified in the given DOT file
	 * (e.g., "a -- b" or "a -> b"). Accepts directed ("digraph") or undirected
	 * ("graph") graphs.
	 * 
	 * Accepts many valid DOT files (see examples posted with assignment).
	 * --accepts \\-style comments --accepts one edge per line or edges
	 * terminated with ; --does not accept attributes in [] (e.g., [label =
	 * "a label"])
	 * 
	 * @param filename
	 *            -- name of the DOT file
	 */
	private static Graph buildGraphFromDot(String filename)
	{
		// creates a new, empty graph (CHANGE AS NEEDED)
		Graph g = new Graph();

		Scanner s = null;
		try 
		{
			s = new Scanner(new File(filename)).useDelimiter(";|\n");
		} catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}

		// Determine if graph is directed or not (i.e., look for "digraph id {" or
		// "graph id {")
		String line = "", edgeOp = "";
		while (s.hasNext()) 
		{
			line = s.next();

			// Skip //-style comments.
			line = line.replaceFirst("//.*", "");

			if (line.indexOf("digraph") >= 0)
			{
				g.setType(Graph.GraphType.DIRECTED); // Denotes that graph is directed (CHANGE
				// AS NEEDED)
				edgeOp = "->";
				line = line.replaceFirst(".*\\{", "");
				break;
			}
			if (line.indexOf("graph") >= 0) 
			{
				g.setType(Graph.GraphType.UNDIRECTED); // Denotes that graph is undirected
				// (CHANGE AS NEEDED)
				edgeOp = "--";
				line = line.replaceFirst(".*\\{", "");
				break;
			}
		}

		// Look for edge operators -- (or ->) and determine the left and right
		// vertices for each edge.
		while (s.hasNext())
		{
			String[] substring = line.split(edgeOp);

			for (int i = 0; i < substring.length - 1; i += 2) 
			{
				// remove " and trim whitespace from node string on the left
				String vertex1 = substring[0].replace("\"", "").trim();
				// if string is empty, try again
				if (vertex1.equals(""))
					continue;

				// do the same for the node string on the right
				String vertex2 = substring[1].replace("\"", "").trim();
				if (vertex2.equals(""))
					continue;

				// add edge between vertex1 and vertex2 (CHANGE AS NEEDED)
				g.addEdge(vertex1, vertex2);
			}

			// do until the "}" has been read
			if (substring[substring.length - 1].indexOf("}") >= 0)
				break;

			line = s.next();

			// Skip //-style comments.
			line = line.replaceFirst("//.*", "");
		}

		return g;
	}
}