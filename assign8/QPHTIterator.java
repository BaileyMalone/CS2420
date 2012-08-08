package assign8;

import java.util.LinkedList;

/**
 * A HashTableIterator for the Quadratic 
 * Probing hash table.
 * Walks down the underling array and returns
 * each non-empty String as it finds it.
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */
public class QPHTIterator extends HashTableIterator<String> 
{
	int lastItemIndex;
	String lastItem;
	
	public QPHTIterator(HashTable t) 
	{	super(t);	}

	@Override
	public String next()
	{
		// Step through the underlying array
		String next = "";
		for (int i = this.currArrayIndex; i < table.capacity; i++)
		{
			if (this.table.array[i] != "")
			{
				this.iterations++;
				next = (String) this.table.array[i];
				
				lastItem = next;
				lastItemIndex = i;
				this.currArrayIndex++;
				return next;
			}
			
			this.currArrayIndex++;
		}
		
		return null;
	}

	@Override
	/**
	 * Removes the last returned String from the table.
	 */
	public void remove() 
	{
		this.table.array[lastItemIndex] = "";
		this.table.size--;
	}
}
