package assign6;

public class InvalidVertexException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public InvalidVertexException(String str)
	{
		this.message = str;
		
		System.err.println(str);
		System.exit(1);
	}
}
