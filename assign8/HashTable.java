package assign8;

import assign7.*;
import java.util.*;

/**
 * An abstract class facilitating the implementation of a concrete hash table. 
 * @author Stephen Ward
 *
 */
public abstract class HashTable implements Set<String> 
{
	
	protected enum	HashType	{GOOD, BAD, MEDIOCRE};
	
	/*
	 * FILL IN MEMBER VARIABLES!
	 * 
	 * Any member variables that you would maintain in both your QuadProbeHashTable and
	 * your ChainingHashTable (such as, say, a size variable) probably belong here in
	 * the parent class. Should the variable(s) be public, private, or protected?
	 */
	protected int size;
	protected int capacity;
	protected HashFunctor hasher;
	protected Object[] array;	// backend array FTW
	protected HashType HasherQuality;
	
	
	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items
	 *            - the collection of items whose presence is ensured in this
	 *            set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually inserted);
	 *         otherwise, returns false
	 */
	public final boolean addAll(Collection<? extends String> items) 
	{
		// Setup Flag
		boolean haveAddedSomething = false;
		
		// Check for all the items in the Collection
		for (String s : items)
		{
			if (!this.contains(s))
			{	
				haveAddedSomething = true;
				this.add(s.trim());
			}
		}
		
		
		return haveAddedSomething;
	}
	
	/**
	 * Determines if for each item in the specified collection, there is an item
	 * in this set that is equal to it.
	 * 
	 * @param items
	 *            - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an
	 *         item in this set that is equal to it; otherwise, returns false
	 */
	public final boolean containsAll(Collection<? extends String> items) 
	{
		for (String s : items)
			if (!this.contains(s))
				return false;
		
		return true;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	public final boolean isEmpty()
	{	return (this.size() == 0) ? true : false;	}

	/**
	 * Returns the number of items in this set.
	 */
	public final int size() 
	{	return this.size;	}
}
