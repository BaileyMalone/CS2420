package assign5;

import java.io.FileNotFoundException;
/**
 * Tests the BalancedSymbolChecker class for .txt files
 * of source code.
 * 
 * @author Bailey Malone and Jeongyoun Chae
 *
 */
public class SymbolBalancingTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
			String checkResult = BalancedSymbolChecker.checkFile("/home/bmalone/workspace/CS2420/src/Class12.txt");

			System.out.println(checkResult);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
