package assign8;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A HashTableIterator for the Chaining
 * hash table.
 * Walks from the beginning of the underlying array,
 * and every time it encounters a linked-list hash 
 * location, it traverses the linked-list, returning
 * each element as it encounters it.
 * 
 * @author Bailey Malone && Jeongyoun Chae
 *
 */
public class CHTIterator extends HashTableIterator<String>
{
	ListIterator<String> listIterator; 

	public CHTIterator(HashTable t) 
	{	
		super(t);	
		this.listIterator = null;
	}

	@Override
	public String next() 
	{
		// Step through the underlying array
		for (int i = this.currArrayIndex; i < table.capacity; i++)
		{
			// Are we already on a list?
			if (this.listIterator != null)
			{
				if (this.listIterator.hasNext())
				{
					this.iterations++;
					return this.listIterator.next();
				}
				else
					this.listIterator = null;
			}
			
			// Did we find a non-empty list in the array?
			LinkedList<String> iList = ((LinkedList<String>)this.table.array[i]);
			if (!iList.isEmpty())
			{
				this.currArrayIndex++;
				this.listIterator = iList.listIterator(0);
				this.iterations++;
				return this.listIterator.next();
			}
		}
		
		return null;
	}

	@Override
	/**
	 * Removes the last element returned by the iteration over
	 * the current Linked-List being traversed in this iterator.
	 */
	// Ha! Clever avoidance - I used a ListIterator!
	// What I meant to say was "thorough knowledge of existing implementations"...
	public void remove() 
	{
		// We can't remove nothing. That's just silly.
		if (this.listIterator == null)
			return;
		else
			this.listIterator.remove();
		
		this.table.size--;
	}
}
