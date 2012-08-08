package assign5;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * LinkedList implementation using the infamous
 * "Ward List<E> interface".
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 * @param <E>
 */
public class MyLinkedList<E> implements List<E> 
{
	/* Inner Node Class */
	/* A singly linked-list node */
	class Node
	{
		E data;
		Node next;

		Node()	{	this.next = null;	this.data = null;	}	// Maybe we'll need this one? Whatever. Here it is.
		Node(E e)	{	this.next = null;	this.data = e;	}
	}


	/* MyLinkedList Data Members */
	Node HEAD;
	Node TAIL;
	int size;

	// Constructor
	public MyLinkedList()
	{	this.HEAD = null;	this.TAIL = null;	this.size = 0;	}

	// Behavioral Methods
	@Override
	/**
	 * Inserts the specified element at the beginning of the list. O(1) for a
	 * singly-linked list.
	 */
	public void addFirst(E element) 
	{
		// Setup the new node to be added
		Node newNode = new Node(element);

		// Rerrange HEAD and the next reference
		// Are we adding the very first element?
		if (this.size() == 0)	
		{
			this.HEAD = newNode;	this.TAIL = newNode;
		}
		// Is there already at least one element in the list?
		else
		{
			newNode.next = HEAD;
			this.HEAD = newNode;
		}

		this.size++;
	}

	@Override
	/**
	 * Inserts the specified element at the end of the list. O(N) for a
	 * singly-linked list with no tail.
	 */
	public void addLast(E o) 
	{
		Node newNode = new Node();
		newNode.data = o;
		if (this.size() == 0)
		{
			this.HEAD = newNode;
			this.TAIL = newNode;
		}
		else
		{
			this.TAIL.next = newNode;
			newNode.next = null;
			this.TAIL = newNode;
		}
		this.size++;
	}

	@Override
	/**
	 * Inserts the specified element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range. O(N) for a
	 * singly-linked list.
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException 
	{
		Node newNode = new Node();
		newNode.data = element;

		// See if the index is at the very end of the list
		// Similarly, see if the index is at the very beginning of the list
		if (index == this.size())
		{
			if (this.size() == 0)
			{
				this.addFirst(element);
				return;
			}	
			else if (this.size() > 0)
			{
				this.addLast(element);
				return;
			}
		}
		else if (index > this.size())	{	throw new IndexOutOfBoundsException();	}
		else if (index < 0)	{	throw new IndexOutOfBoundsException();	}
		else	
		{
			int count = 0;
			Node nextNode = this.HEAD;
			while (nextNode != null)
			{
				if (count == index)
				{
					newNode.next = nextNode;
					break;
				}

				nextNode = nextNode.next;
				count++;
			}
			this.size++;
		}
	}

	@Override
	/**
	 * Returns the first element in the list. Throws NoSuchElementException if
	 * the list is empty. O(1) for a singly-linked list.
	 */
	public E getFirst() throws NoSuchElementException 
	{
		if (this.HEAD == null)	throw new NoSuchElementException();
		return this.HEAD.data;
	}

	@Override
	/**
	 * Returns the last element in the list. Throws NoSuchElementException if
	 * the list is empty. O(N) for a singly-linked list.
	 */
	public E getLast() throws NoSuchElementException 
	{
		if (this.TAIL == null) throw new NoSuchElementException();
		return this.TAIL.data;
	}

	@Override
	/**
	 * Returns the element at the specified position in the list. Throws
	 * IndexOutOfBoundsException if index is out of range. O(N) for a
	 * singly-linked list.
	 */
	public E get(int index) throws IndexOutOfBoundsException
	{
		int count = 0;
		Node getNode = this.HEAD;

		// See if the get will be within the list or not
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();

		// Get is being called withint the list bounds -- find the element
		while (getNode != null)
		{
			if (count == index)
				break;

			getNode = getNode.next;
			count++;
		}

		return getNode.data;
	}

	@Override
	/**
	 * Returns a randomly-selected element from the list. Throws
	 * NoSuchElementException if the list is empty. O(N) for a singly-linked
	 * list.
	 */
	public E getRandom() throws NoSuchElementException 
	{
		// Make sure there is actually something(s) to randomly get
		if (this.size() == 0)	throw new NoSuchElementException();

		// Generate a random but valid index
		Random random = new Random();
		int index = random.nextInt(this.size);

		return get(index);
	}

	@Override
	/**
	 * Removes and returns the first element from the list. Throws
	 * NoSuchElementException if the list is empty. O(1) for a singly-linked
	 * list.
	 */
	public E removeFirst() throws NoSuchElementException 
	{
		// Is there a first to remove?
		if (this.HEAD == null)
			throw new NoSuchElementException();

		// Ok, it's there -- remove it
		E firstNode = getFirst();
		this.HEAD = this.HEAD.next;
		this.size--;
		return firstNode;
	}

	@Override
	/**
	 * Removes and returns the last element from the list. Throws
	 * NoSuchElementException if the list is empty. O(N) for a singly-linked
	 * list.
	 */
	public E removeLast() throws NoSuchElementException 
	{
		// Is there a last element to remove?
		if (this.TAIL == null)
			throw new NoSuchElementException();

		// There's a TAIL -- remove it
		Node lastNode = this.TAIL;
		this.TAIL = null;
		this.size--;
		return lastNode.data;
	}

	@Override
	/**
	 * Removes and returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range. O(N) for a
	 * singly-linked list.
	 */
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		int count = 0;
		Node currNode = this.HEAD;	Node prevNode = this.HEAD;
		// If get returns, the no error is thrown -- get already catches.
		E thisNode = this.get(index);

		// Are we inside the linked-list
		if (index >= this.size() || index < 0)	throw new IndexOutOfBoundsException();

		// Remove the node
		while (currNode != null)
		{
			if (count == index)
			{
				if (this.size() == 1)
				{
					// Nullify TAIL and HEAD -- this only element is also
					// the HEAD and TAIL
					this.HEAD = null;	this.TAIL = null;
					break;
				}
				else	// Found the index -- more than 1 element in the list
				{
					// Is the element we're removing the HEAD and/or the TAIL?
					if (currNode == TAIL)
					{
						this.TAIL = prevNode;
					}
					else if (currNode == HEAD)
					{
						this.HEAD = currNode.next;
					}
					else
					{
						prevNode.next = currNode.next;
						break;
					}
				}
			}

			prevNode = currNode;
			currNode = currNode.next;
			count++;
		}

		this.size--;
		return thisNode;
	}

	@Override
	/**
	 * Returns the index of the first occurrence of the specified element in the
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 */
	public int indexOf(E element) 
	{
		Node currNode = this.HEAD;

		int index = 0;	int foundIndex  = -1;
		while (currNode != null)
		{
			if (currNode.data.equals(element))
			{
				foundIndex = index;
				break;	// Found it - stop looking
			}

			index++;
			currNode = currNode.next;
		}

		return foundIndex;
	}

	@Override
	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 */
	public int lastIndexOf(E element)
	{
		Node currNode = this.HEAD;

		int index = 0;	int foundIndex  = -1;
		while (currNode != null)
		{
			if (currNode.data.equals(element))	// In this case, if we find it, we just keep looking
				foundIndex = index;				// because there might be yet another occurrence.

			index++;
			currNode = currNode.next;
		}

		return foundIndex;
	}

	@Override
	/**
	 * Returns the number of elements in this list. O(1) for a singly-linked
	 * list.
	 */
	public int size() 
	{	return this.size;	}

	@Override
	/**
	 * Returns true if this collection contains no elements. O(1) for a
	 * singly-linked list.
	 */
	public boolean isEmpty() 
	{	return (this.size() == 0) ? true : false;}

	@Override
	/**
	 * Removes all of the elements from this list. O(1) for a singly-linked
	 * list.
	 */
	public void clear() 
	{
		// Ok. Act as if the linked-list has no start and no end. Now there's no list.
		this.HEAD = null;	this.TAIL = null;
		this.size = 0;
	}

	@Override
	/**
	 * Puts every element in the linked-list into an Object array.
	 * If the list is empty, an empty array is returned.
	 */
	public Object[] toArray() 
	{
		// Setup the array we'll use
		Object[] elements = new Object[this.size()];

		Node currNode = this.HEAD;	int i = 0;
		while (currNode != null)
		{
			elements[i] = currNode;
			i++;	currNode = currNode.next;
		}

		return elements;
	}

	/**
	 * <DEBUG METHOD>
	 * Prints all the elements of the list in order.
	 */
	public void PrintList()
	{
		Object[] objects = this.toArray();
		System.err.println("Printing a list of size " + this.size());
		for (int i = 0; i < objects.length; i++)
		{
			System.err.print((E)objects[i].toString() + " ");
		}
		System.err.println();
	}
}
