package assign6;
/**
 * Representation of a Graph edge between two vertices.
 * Defined by its edges and the two vertexes it's 
 * connected to. 
 * 
 * @author Bailey Malone and Jeongyoun Chae
 *
 */
public class Edge
{
	public enum Direction	{	FORWARD,	BACKWARD	}
	
	Vertex v1, v2;
	Direction direction;
	
	public Edge(Vertex u, Vertex v)
	{
		this.v1 = u;	this.v2 = v;
	}
	
	public Vertex getV1()	{	return this.v1;	}
	public Vertex getV2()	{	return this.v2;	}
	
	public Vertex getEndingVertex()
	{
		return v2;	// The second Vertex in an Edge should always be the
					// Vertex being directed to by the Edge.
	}
	
	public void setDirection(Direction dir)
	{
		this.direction = dir;
	}
	
	public Direction getDirection()
	{
		return this.direction;
	}
	
	public String toString()
	{
		return v1.Name() + " --> " + v2.Name();
	}
}
