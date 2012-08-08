package assign8;

import java.util.Iterator;

/**
 * 
 * 
 * NOTE: Does not allow duplicates.
 * && Doesn't allow adding of empty strings.
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */

public class QuadProbeHashTable extends HashTable
{
	/* For experiments */
	public int numberOfCollisions;
	
	/** Constructs a hash table of the given capacity that uses the hashing function
	 * specified by the given functor.
	 */
	public QuadProbeHashTable(int capacity, HashFunctor functor)
	{
		/* **************************************** */
		/* Change to NEXT PRIME NUMBER FOR CAPACITY */
		numberOfCollisions = 0;
		this.size = 0;	this.capacity = capacity;
		this.hasher = functor;
		this.array = new String[capacity];

		// initialize the table to empty strings -- easy detection
		// of element added or not 
		for (int i = 0; i < capacity; i++)
			array[i] = "";
	}

	@Override
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * NOTE: The HashFunctor interface does not mod by the table's
	 * capacity, so we have to mod the hash value ourselves IN
	 * THE HASHTABLE CLASSES.
	 * 
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually inserted); otherwise, returns
	 *         false
	 */
	public boolean add(String item) 
	{
		// Did some silly user pass us a NULL value?
		if (item == null)
			return false;

		// WE DON'T ALLOW ADDING EMPTY STRINGS
		if (item.compareTo("") == 0)
			return false;

		// Are we adding a duplicate? We don't like duplicates.
		if (this.contains(item))
			return false;

		// Are we at the load balance limit?
		if ((this.size() / (double)this.capacity) >= 0.5)
			this.resize();


		// Get the hash-value
		int hashValue = Math.abs(this.hasher.hash(item)); // Starting table index
		hashValue = hashValue % this.capacity;

		/* Quadratic Probing */
		int looks = 1;
		int currentSpot = hashValue;
		boolean notFoundEmptySpot = true;
		while (notFoundEmptySpot)
		{
			// Find an empty spot along our quadratic trail?
			if (this.array[currentSpot] == "")
			{
				this.array[currentSpot] = item;
				notFoundEmptySpot = false;
			}
			else	// Look further!
			{
				int step = (int) Math.pow(looks, 2);
				currentSpot = (hashValue + step) % this.capacity;
				looks++;
				
				numberOfCollisions++;
			}
		}

		this.size++;
		return true;
	}

	/**
	 * A duplicate of the add method except it does NOT adjust
	 * size.
	 * (Normally a flag would have been used for this, but we can't
	 * alter the add() method's signature).
	 * 
	 * @param item
	 * @return
	 */
	public boolean copyAdd(String item)
	{
		// Did some silly user pass us a NULL value?
		if (item == null)
			return false;

		// WE DON'T ALLOW ADDING EMPTY STRINGS
		if (item.compareTo("") == 0)
			return false;

		// Are we adding a duplicate? We don't like duplicates.
		if (this.contains(item))
			return false;

		// Are we at the load balance limit?
		if ((this.size() / (double)this.capacity) >= 0.5)
			this.resize();


		// Get the hash-value
		int hashValue = Math.abs(this.hasher.hash(item)); // Starting table index
		hashValue = hashValue % this.capacity;

		/* Quadratic Probing */
		int looks = 1;
		int currentSpot = hashValue;
		boolean notFoundEmptySpot = true;
		while (notFoundEmptySpot)
		{
			// Find an empty spot along our quadratic trail?
			if (this.array[currentSpot] == "")
			{
				this.array[currentSpot] = item;
				notFoundEmptySpot = false;
			}
			else	// Look further!
			{
				int step = (int) Math.pow(looks, 2);
				currentSpot = (hashValue + step) % this.capacity;
				looks++;
			}
		}

		return true;
	}

	/**
	 * Resizes the backend array to twice the previous size.
	 */
	public void resize()
	{
		// Set new capacity
		int newCapacity = this.capacity*2;

		// Copy the old array
		String[] copy = new String[this.capacity];
		for (int i = 0; i < copy.length; i++)
			copy[i] = "";
		CopyArray((String[])this.array, copy);


		// Make new HashTable backend
		this.array = new String[newCapacity];
		for (int j = 0; j < newCapacity; j++)
			this.array[j] = "";
		this.capacity = newCapacity;


		// Re-Add all the values in the old array into the new array
		int index = 0;
		for (int i = 0; i < copy.length; i++)
		{
			// Find a value to rehash to the new array?
			if (copy[i] != "")
				this.copyAdd(copy[i]);
		}
	}

	private void CopyArray(String[] array, String[] copy) 
	{
		if (array.length > copy.length)
			throw new ArrayIndexOutOfBoundsException();

		for (int i = 0; i < array.length; i++)
			copy[i] = array[i];
	}

	@Override
	public void clear() 
	{
		this.size = 0;
		this.array = new String[this.capacity];

		// Initialize with empty strings
		for (int i = 0; i < capacity; i++)
			array[i] = "";
	}

	@Override
	// This sucks for this table -- have to walk through
	// Better for chaining tables! Use that!
	public boolean contains(String item)
	{
		if (item == null)	// Contains NULL, so NULL never gets added
			return true;

		// Get hash value for the string
		int hashValue = Math.abs(this.hasher.hash(item));
		hashValue = hashValue % this.capacity;
		
		//System.err.println("<Add Hash>: " + hashValue);

		// Walk through array from hashValue --> hashValue
		// (Reduce probability of definitely linear time! Woo!)
		int index = hashValue;
		boolean stillWalking = true;
		while (stillWalking)
		{
			// Make sure we wrap around if we need to...
			if (index >= this.capacity)
				index = index % this.capacity;

			// Is this it?
			if (((String)this.array[index]).compareTo(item) == 0)
			{
				stillWalking = false;
				return true;
			}

			index = (index + 1) % this.capacity;

			// Have we walked all the way through and not found it?
			if (index == hashValue)
				stillWalking = false;
		}

		return false;
	}

	@Override
	public Iterator<String> iterator()
	{
		// TO-DO: Implement this, you aspiring code monkeys!
		return null;
	}

	/* DEBUG METHOD(s) */

	public String get(int index)
	{	
		if (index >= this.capacity)
			index = index % this.capacity;
		return (String) this.array[index];	
	}
}
