package assign6;

/**
 * Directed graph representation class - Map of named vertexes,
 * each vertex having a list of edges to or from it.
 * 
 * @author Bailey Malone and Jeongyoun Chae

 */
import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;


public class Graph
{
	public enum GraphType	{	DIRECTED, UNDIRECTED	}

	// The graph is represented by the relationships between
	// vertices and edges
	private HashMap<String, Vertex> graph;
	private GraphType Type;

	//public Graph()	{	graph = new HashMap<Vertex, ArrayList<Edge>>();	}
	public Graph()	{	graph = new HashMap<String, Vertex>();	}


	/* Graph Construction Methods */
	public void addEdge(String v1, String v2)
	{
		// Make sure the connected Vertex is a valid Vertex	
		if (v2 == null || v1 == null)	// vs MUST be of type Vertex -- so we just need to check, here, if it's non-null
		{
			System.err.println("NULL Vertexes are not allowed!");
			System.exit(1);
		}

		/* DEBUG */
		//		System.out.println("Creating a new edge: " + v1 + ", " + v2);

		// Create the new Edge
		Vertex vertex1, vertex2;
		if (graph.containsKey(v1) && graph.containsKey(v2))
		{
			vertex1 = graph.get(v1);
			vertex2 = graph.get(v2);
		}
		else if (graph.containsKey(v1))
		{
			vertex1 = graph.get(v1);
			vertex2 = new Vertex(v2);
		}
		else if (graph.containsKey(v2))
		{
			vertex1 = new Vertex(v1);
			vertex2 = graph.get(v2);
		}
		else
		{
			vertex1 = new Vertex(v1);
			vertex2 = new Vertex(v2);
		}

		Edge rightEdge = new Edge(vertex1, vertex2);	
		rightEdge.setDirection(Edge.Direction.FORWARD);
		Edge leftEdge = new Edge(vertex2, vertex1);	
		leftEdge.setDirection(Edge.Direction.BACKWARD);
		vertex1.addEdge(rightEdge);
		vertex2.addEdge(leftEdge);
		vertex2.plusIndegree();

		graph.put(v1, vertex1); // Overrides previous entries?
		graph.put(v2, vertex2);
	}

	/* Graph Search Methods */
	public ArrayList<Edge> getConnections(Vertex v)
	{
		if (graph.containsKey(v.Name()))
			return graph.get(v.Name().trim()).getEdges();

		return null;
	}

	public ArrayList<Edge> getAllConnections()
	{
		ArrayList<Edge> allConnections = new ArrayList<Edge>();

		for (Vertex v : graph.values())
		{
			for (Edge e : v.getEdges())
				allConnections.add(e);
		}

		return allConnections;
	}

	public void	setType(GraphType type)
	{
		this.Type = type;
	}

	/**
	 * Returns the GraphType of the represented Graph
	 * (Directed or Undirected).
	 * This method *fully expects* that the buildFromDotFile()
	 * method in GraphUtil will be used to construct this graph.
	 * 
	 * @return GraphType
	 */
	public GraphType getType()
	{
		return this.Type;
	}

	public Set<String> dumpKeys()
	{
		return graph.keySet();
	}
	public Collection<Vertex> dumpValues()
	{
		return graph.values();
	}
	public Vertex get(String s)
	{
		return graph.get(s);
	}
}
