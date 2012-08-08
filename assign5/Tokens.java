package assign5;
/**
 * A wrapping class representing the braces/brackets/
 * parentheses and methods to handle checking and
 * comparing them.
 * 
 * @author Bailey Malone and Jeongyoun Chae
 *
 */
public class Tokens 
{
	// Tokens List
	public static String OPEN_CURLY = "{";
	public static String CLOSED_CURLY = "}";
	public static String OPEN_BRACKET = "[";
	public static String CLOSED_BRACKET = "]";
	public static String OPEN_PAREN = "(";
	public static String CLOSED_PAREN = ")";

	
	/**
	 * Compares the parameter string to the Tokens
	 * and returns true if the token is an opening
	 * token, false otherwise.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isAnOpenToken(String str)
	{
		if (str.equals(OPEN_CURLY) || str.equals(OPEN_BRACKET) || str.equals(OPEN_PAREN))
			return true;
		
		return false;
	}

	/**
	 * Compares to str1 to str2 to see if the two parameters
	 * represent a matching set of open and close Tokens.
	 * 
	 * @param str1 -- previous token in the file
	 * @param str2 -- next token in the file
	 * @return
	 */
	public static boolean matches(String str1, String str2)
	{
		if (str1.compareTo(OPEN_CURLY) == 0)
		{
			return str2.compareTo(CLOSED_CURLY) == 0 ? true : false;
		}
		else if (str1.compareTo(OPEN_BRACKET) == 0)
		{
			return str2.compareTo(CLOSED_BRACKET) == 0 ? true : false;
		}
		else if (str1.compareTo(OPEN_PAREN) == 0)
		{
			return str2.compareTo(CLOSED_PAREN) == 0 ? true : false;
		}
		else
		{
			System.err.println("INVALID MATCHING OF TOKENS!\nExiting program!");
			System.exit(1);
			return false;
		}
	}

	/**
	 * Returns the closing Token matching the parameter token.
	 * It is fully expected that the parameter String is
	 * an open Token.
	 * 
	 * @param poppedToken
	 * @return
	 */
	public static char expectedClose(String poppedToken) 
	{
		if (poppedToken.equals(OPEN_BRACKET))
			return CLOSED_BRACKET.toCharArray()[0];
		else if (poppedToken.equals(OPEN_CURLY))
			return CLOSED_CURLY.toCharArray()[0];
		else if (poppedToken.equals(OPEN_PAREN))
			return CLOSED_PAREN.toCharArray()[0];
		
		return '0';	// This really the best way to handle this.... ?
	}
}
