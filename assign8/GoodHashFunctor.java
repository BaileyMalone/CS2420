package assign8;

import assign8.HashTable.HashType;

/**
 * A "good" hash function meant to hash values with 
 * skills representative of a power level of 9,000.
 * 
 * 
 * NOTE: Because of the way the methods were written,
 * we can't mod by table size in this method. Modular
 * arithmetic *must* be performed in the using HashTable
 * class before use.
 * 
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */

public class GoodHashFunctor implements HashFunctor 
{
	private HashType type = HashType.GOOD;
	
	public HashType getType()
	{	return type;	}
	
	@Override
	public int hash(String item) 
	{
		return item.hashCode();
	}
}
