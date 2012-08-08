package assign8;

import assign8.HashTable.HashType;

/**
 * A "medicore" hash function meant to hash values with 
 * better regard for unique hashing (but not ideal) than
 * the bad hash functor.
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

public class MediocreHashFunctor implements HashFunctor 
{
	private HashType type = HashType.MEDIOCRE;
	
	public HashType getType()
	{	return type;	}

	@Override
	public int hash(String item) 
	{
		if (item == null)
			return -1;
		
		int pieceLength = item.length() / 4;
		long sum = 0;
		for (int i = 0; i < pieceLength; i++)
		{
			// Grab the substring of 4 bytes
			char chars[] = item.substring(i*4, (i*4) + 4).toCharArray();
			
			// Multiply these 4 bytes
			long mult = 1;
			for (int j = 0; j < chars.length; j++)
			{
				sum += chars[j] * mult;
				mult *= 256;
			}
		}
		
		// Add and mod all the 4-byte half-hashed chunks
		char str[] = item.substring(pieceLength * 4).toCharArray();
		long mult = 1;
		for (int k = 0; k < str.length; k++)
		{
			sum += str[k] * mult;
			mult *= 256;
		}
		
		return (int) (Math.abs(sum));
	}
}
