package assign8;

import assign8.HashTable.HashType;

/**
 * A "bad" hash function meant to hash values with little
 * regard to unique hashing.
 * 
 * 
 * NOTE: Because of the way the methods were written,
 * we can't mod by table size in this method. Modular
 * arithmetic *must* be performed in the using HashTable
 * class before use.
 * 
 * <Algorithm came from Online Source>:
 * http://research.cs.vt.edu/AVresearch/hashing/strings.php
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */

public class BadHashFunctor implements HashFunctor 
{
	private HashType type = HashType.BAD;
	
	public HashType getType()
	{	return type;	}
	
	@Override
	public int hash(String item) 
	{
		if (item == null)
			return -1;
		
		// Turn the string into a char[]
		char chars[];
		chars = item.toCharArray();
		
		int sum = 0;
		for (int i = 0; i < item.length(); i++)
			sum += chars[i];
		
		return sum;
	}
}
