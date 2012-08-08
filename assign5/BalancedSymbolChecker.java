package assign5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Stephen Ward and Bailey Malone and Jeongyoun Chae
 */
public class BalancedSymbolChecker
{
	// Tokens list
	public static int numberOfTokens = 6;
	static ArrayList<String> tokens = new ArrayList<String>();


	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	public static String checkFile(String filename) throws FileNotFoundException 
	{
		MyStack<String> stack = new MyStack<String>();
		
		// Put the tokens into a list
		tokens.add("{");	tokens.add("}");	tokens.add("[");	tokens.add("]");
		tokens.add("(");	tokens.add(")");

		try	
		{
			// Read in the file (?)
			File file  = new File(filename);
			Scanner input = new Scanner(file);
			input.useDelimiter("");

			// Go through the file and find out
			String s;
			while (input.hasNext())
			{
				s = input.next().trim(); 
				
				if (tokens.contains(s))
				{
					// See if we're pushing an open brace of some kind
					if (Tokens.isAnOpenToken(s))
					{
						stack.push(s);
					}
					else //(Tokens.matches( stack.pop(), s))
					{
						if (stack.size() == 0)	// throw unexpectedSymbol
						{
							return unexpectedSymbol(s.toCharArray()[0]);
						}
						else	// We *were* expecting a closing symbol. Does it match?
						{
							String poppedToken = stack.pop();
							
							if (Tokens.matches(poppedToken, s))
							{
								continue;
							}
							else
							{
								return unexpectedSymbol(Tokens.expectedClose(poppedToken), s.toCharArray()[0]);
							}
						}
					}
				}
			}// End of WHILE-Loop
			
			if (stack.size() > 0) // We have an unclosed open brace!
			{
				return unexpectedEOF(Tokens.expectedClose(stack.pop()));
			}
			
		}
		catch (FileNotFoundException fnf)
		{
			throw new FileNotFoundException();
		}

		return allSymbolsMatch();
	}

	/**
	 * Returns an error message for having found a closing symbol when no
	 * closing symbol was expected.
	 */
	private static String unexpectedSymbol(char found) 
	{
		return "ERROR: Symbol not expected, but found '" + found + "'.";
	}

	/**
	 * Returns an error message for having found a closing symbol that
	 * does not match the expected symbol.
	 */
	private static String unexpectedSymbol(char expected, char found)
	{
		return "ERROR: Expected '" + expected + "', but found '" + found + "'.";
	}

	/**
	 * Returns an error message for having reached the end of the file
	 * before finding the expected closing symbol.
	 */
	private static String unexpectedEOF(char expected) 
	{
		return "ERROR: Reached end of file before finding expected symbol '" + expected + "'.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private static String allSymbolsMatch() 
	{
		return "No errors found. All symbols match.";
	}
}
