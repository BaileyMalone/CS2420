package assign8;

import java.util.Iterator;

/**
 * An abstract class defining the backbone of HashTable
 * iterators implementing Iterator for our QuadProbe-
 * HashTable and ChainingHashTable.
 * 
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 * @param <String>
 */

public abstract class HashTableIterator<String> implements Iterator<String>
{
	protected int currArrayIndex;
	protected int iterations;
	protected HashTable table;

	public HashTableIterator(HashTable t)
	{
		this.currArrayIndex = 0;	this.iterations = 0;
		this.table = t;
	}
	
	@Override
	public boolean hasNext() 
	{	return (iterations < table.size()) ? true : false;	}

	@Override
	public abstract String next();

	@Override
	public abstract void remove();
}
