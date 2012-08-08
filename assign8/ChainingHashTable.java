package assign8;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * 
 * @author Bailey Malone && Jeongyoun Chae
 */

public class ChainingHashTable extends HashTable 
{
	/* For experiments */
	public int numberOfCollisions;
	
	/** Constructs a hash table of the given capacity that uses the hashing function
	 * specified by the given functor.
	 */
	public ChainingHashTable(int capacity, HashFunctor functor)
	{
		/* **************************************** */
		/* Change to NEXT PRIME NUMBER FOR CAPACITY */
		this.numberOfCollisions = 0;
		this.size = 0;	this.capacity = capacity;
		this.hasher = functor;
		this.array = new LinkedList[capacity];

		// initialize the table to empty linked lists
		for (int i = 0; i < capacity; i++)
			this.array[i] = new LinkedList<String>();
	}

	@Override
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
		if ((this.size() / this.capacity) >= 0.5)
			this.resize();


		// Get the hash-value
		int hashValue = Math.abs(this.hasher.hash(item)); // Starting table index
		hashValue = hashValue % this.capacity;


		/* Chaining -- just add the item to the list that's */
					/* located at the index 'hashValue' */
		if (!((LinkedList<String>)this.array[hashValue]).isEmpty())
			this.numberOfCollisions++;
		((LinkedList<String>)this.array[hashValue]).add(item);

		this.size++;
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
		LinkedList<String>[] copy = new LinkedList[this.capacity];
		for (int i = 0; i < copy.length; i++)
			copy[i] = new LinkedList<String>();
		CopyArray((LinkedList[])this.array, copy);


		// Make new HashTable backend
		this.array = new LinkedList[newCapacity];
		for (int i = 0; i < newCapacity; i++)
			this.array[i] = new LinkedList<String>();
		this.capacity = newCapacity;
		
		
		// Rehash the linked lists in the original table
		for (int i = 0; i < copy.length; i++)
		{
			LinkedList<String> list = copy[i];
			
			// Non-empty list to rehash?
			if (!list.isEmpty())
			{
				for (String s : list)
					this.add(s);
			}														
		}
	}
	
	private void CopyArray(LinkedList[] array, LinkedList[] copy) 
	{
		if (array.length > copy.length)
			throw new ArrayIndexOutOfBoundsException();

		for (int i = 0; i < array.length; i++)
		{
			copy[i] = array[i];
		}
	}

	@Override
	public void clear() 
	{
		this.size = 0;
		this.array = new LinkedList[this.capacity];
		
		// Initialize empty lists
		for (int i = 0; i < this.capacity; i++)
			this.array[i] = new LinkedList<String>();
	}

	@Override
	public boolean contains(String item) 
	{
		if (item == null)
			return false;
		
		// Find the linked list at item's hash index
		int hashValue = Math.abs(this.hasher.hash(item));
		hashValue = hashValue % this.capacity;

		// Now check the linked list for the string
//		System.out.println("Index --> " + hashValue);
//		System.out.println("Checking " + ((LinkedList<String>)this.array[hashValue]) + " for " + item + "...");
		
		return ((LinkedList<String>)this.array[hashValue]).contains(item);
	}

	@Override
	public Iterator<String> iterator() 
	{	return new CHTIterator(this);	}
	
	
	/* DEBUG METHOD(s) */

	public LinkedList<String> get(int index)
	{	
		if (index >= this.capacity)
			index = index % this.capacity;
		return (LinkedList<String>) this.array[index];	
	}
}
