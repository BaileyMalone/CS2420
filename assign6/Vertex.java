package assign6;

import java.util.ArrayList;

import assign6.Edge.Direction;

/**
 * Representation of a Graph Vertex.
 * Keeps track of indegree (incoming edge
 * count), whether or not it's been visited in a
 * search, and its associated edges.
 * 
 * @author Bailey Malone and Jeongyoun Chae
 *
 */
public class Vertex
{
	public static int visitedCount = 0;
	int visitedSerial;
	
	String name;	// generic would have been nice...?
	int distanceFromStart;	// Used for graph searching. "-1" indicates an unitialized distance.
	public boolean visited;
	ArrayList<Edge> edges;
	// ***
	int indegree;

	public Vertex(String str)	
	{	
		this.name = str;	
		this.distanceFromStart = -1;
		this.visited = false;
		edges = new ArrayList<Edge>();
		this.indegree = 0;
	}

	public String Name()	{	return this.name;	}

	public void setDistance(int x)
	{	this.distanceFromStart = x;	}

	public int getDistance()
	{	return this.distanceFromStart;	}

	public ArrayList<Edge> getEdges()
	{
		return this.edges;
	}

	public void addEdge(Edge e)
	{
		this.edges.add(e);
	}

	public void plusIndegree()
	{
		this.indegree++;
	}
	
	public int getIndegree()
	{
		return this.indegree;
	}
	
	public void decrementIndegree()
	{
		this.indegree--;
	}
	
	public boolean hasUnvisitedNeighbor()
	{
		ArrayList<Edge> edges = this.getEdges();

		int visitedCount = 0;
		for (Edge e : edges)
		{	
			//if (e.direction == Direction.FORWARD && e.getEndingVertex().visited == true)
			if (e.getEndingVertex().visited == true)
			{
				visitedCount++;
				/* DEBUG */
//				System.out.println("Edge -> " + e);
//				
//				for (Edge e2 : e.getEndingVertex().getEdges())
//					System.err.println("    " + e2);
			}
		}

		if (visitedCount == edges.size())
			return false;
		
		return true;
	}

	public int getNeighborCount()
	{
		ArrayList<Edge> edges = this.getEdges();

		int visitedCount = 0;
		for (Edge e : edges)
			if (e.getEndingVertex().visited == true)
				visitedCount++;

		return edges.size() - visitedCount;
	}
	
//	PUBLIC VOID REMOVEEDGE(EDGE E)
//	{
//		THIS.EDGES.REMOVE(E);
//	}

	public String toString()
	{
		return this.Name();
	}

	public boolean equals(Vertex u)
	{
		if (this.name == u.name)
			return true;

		return false;
	}
}

