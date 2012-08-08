package assign5;

import java.util.*;

import assign5.MyLinkedList.Node;

/**
 * Represents a generic stack (First-In, Last-Out).
 * 
 * @author Stephen Ward and Bailey Malone and Jeongyoun Chae
 * 
 * @param <E> the type of elements contained in the stack
 */
public class MyStack<E> 
{
	private int size;
	private List<E> stack;

	public MyStack() 
	{
		stack = new MyLinkedList<E>();
		this.size = 0;
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear()
	{
		stack = new MyLinkedList<E>(); // Ta da!
	}

	/**
	 * Returns true if the stack contains no elements.
	 */
	public boolean isEmpty()
	{	return this.size() == 0 ? true : false;	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. Throws NoSuchElementException if the stack is empty.
	 */
	public E peek() throws NoSuchElementException 
	{
		// ***** Note on NoSuchElementException *****
		// getFirst() throws a NoSuchElementException if there is no HEAD.
		// Since HEAD ~ TOP for our implementation, we can leave that work for getFirst().
		return stack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack. Throws
	 * NoSuchElementException if the stack is empty.
	 */
	public E pop() throws NoSuchElementException 
	{
		// Get the current HEAD ~ top of the stack
		// ***** Note on NoSuchElementException *****
		// getFirst() throws a NoSuchElementException if there is no HEAD.
		// Since HEAD ~ TOP for our implementation, we can leave that work for getFirst().
		E element = stack.getFirst();

		stack.removeFirst();

		this.size--;
		return element;
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) 
	{
		// Head ~ TOP --> put the new TOP before the current HEAD
		// addFirst reassigns the HEAD for us. Shabam.
		stack.addFirst(item);
		this.size++;
	}

	/**
	 * Returns the number of items in the stack.
	 */
	public int size() 
	{	return stack.size();	}
}
