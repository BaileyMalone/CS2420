package assign5;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListUnitTests<E> 
{
	// Test Data
	MyLinkedList<Integer> list = new MyLinkedList<Integer>();


	@Test
	public void testMyLinkedList() 
	{
		assertTrue(list.HEAD == null && list.TAIL == null);
	}

	// <AddFirst Note>
	/* NOTE: We recognize that "==" is not a valid generic comparison, but since the
	 * test data is contrived anyway, we don't care.
	 * lololololololololol
	 */
	
	@Test
	/**
	 * <TEST>: Inserts the specified element at the beginning of the list. O(1) for a
	 * singly-linked list.
	 */
	public void testAddFirst() 
	{
		// Add an element at the front
		list.addFirst(2);
		// Make sure HEAD and size have changed, indicating success
		assertTrue(list.size() == 1 && list.HEAD != null && list.HEAD.data == 2);	
	}
	
	@Test
	public void testAddFirst2() 
	{
		// Add an element at the front
		list.addFirst(2);
		list.addFirst(1);
		
		// Make sure HEAD and size have changed, indicating success
		assertTrue(list.size() == 2 && list.HEAD != null && list.HEAD.data == 1);
	}

	@Test
	/**
	 * <TEST>: Inserts the specified element at the end of the list. O(N) for a
	 * singly-linked list with no tail.
	 */
	public void testAddLast() 
	{
		list.addLast(3);
		assertTrue(list.size() == 1 && list.TAIL != null && list.TAIL.data == 3);
	}
	
	@Test
	public void testAddLast2() 
	{
		list.addLast(3);
		list.addLast(4);
		
		assertTrue(list.size() == 2 && list.TAIL != null && list.TAIL.data == 4);
	}

	@Test
	/**
	 * <TEST>: Inserts the specified element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range. O(N) for a
	 * singly-linked list.
	 */
	// Handle valid adds?
	public void testAdd() 
	{	
		list.addFirst(1);
		list.addLast(3);
		list.add(1, 2);
		
		// We should have {1 -> 2 -> 3} 
		assertTrue(list.size() == 3 && list.HEAD.data == 1 && list.TAIL.data == 3);
	}
	
	@Test
	// Add at index 0 for empty list works?
	public void testAdd2() 
	{
		list.add(0, 15);
		assertTrue(list.size() == 1 && list.HEAD.data == 15 && list.TAIL.data == 15);
	}

	@Test
	// Add at index 'size' on a non-empty list works?
	public void testAdd3() 
	{
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		list.add(3, 4);	// Add 4 at spot 3, which is also the size of the list right now
		assertTrue(list.size() == 4 && list.HEAD.data == 1 && list.TAIL.data == 4);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Throws IndexOutOfBoundsException when index is... outside of size?
	public void testAdd4() 
	{
		list.addFirst(1);
		list.add(5, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Throws IndexOutOfBoundsException when index is... negative?
	public void testAdd5() 
	{
		list.add(-3, 0);
	}

	@Test
	/**
	 * <TEST>: Returns the first element in the list. Throws NoSuchElementException if
	 * the list is empty. O(1) for a singly-linked list.
	 */
	// Return an existing HEAD that should be there
	public void testGetFirst() 
	{
		list.addFirst(92);
		assertTrue(list.getFirst() == 92);
	}
	
	@Test(expected=NoSuchElementException .class)
	// Call on an empty list --> Throw a NoSuchElementException (should)
	public void testGetFirst2() 
	{
		assertTrue(list.getFirst() == 92);
	}

	@Test
	/**
	 * <TEST>: Returns the last element in the list. Throws NoSuchElementException if
	 * the list is empty. O(N) for a singly-linked list.
	 */
	// Return an existing TAIL that should be there
	public void testGetLast()
	{
		list.addFirst(93);
		assertTrue(list.getLast() == 93);
	}
	
	@Test(expected=NoSuchElementException .class)
	// Call on an empty list --> Throw a NoSuchElementException (should)
	public void testGetLast2()
	{
		assertTrue(list.getLast() == 93);
	}

	@Test
	/**
	 * <TEST>: Returns the element at the specified position in the list. Throws
	 * IndexOutOfBoundsException if index is out of range. O(N) for a
	 * singly-linked list.
	 */
	// Get an element in the middle of a non-empty list
	public void testGet()
	{
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		
		assertTrue(list.get(1) == 2);
	}
	
	@Test
	// Get the 0th element in a non-empty list
	public void testGet2()
	{
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		
		assertTrue(list.get(0) == 3);
	}
	
	@Test
	// Get the last (size() - 1) element in a non-empty list
	public void testGet3()
	{
		list.addFirst(6);
		list.addLast(7);
		list.addLast(8);
		
		assertTrue(list.get(list.size()-1) == 8);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Get on a negative index
	public void testGet4()
	{
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		
		assertTrue(list.get(-2) == 5);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Get outside of the size of the list
	public void testGet5()
	{
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		
		assertTrue(list.get(6) == 5);
	}

	@Test
	/**
	 * <TEST>: Returns a randomly-selected element from the list. Throws
	 * NoSuchElementException if the list is empty. O(N) for a singly-linked
	 * list.
	 */
	/*
	 * Because this method embeds a call to get() (which is tested above), we
	 * really only need to test two behaviors for getRandom():
	 *  - it gets a pseudo-random, valid element from a non-empty list, and
	 *  - throws an exception for getRandom() on an empty list.
	 */
	// Get a Random element is valid?
	public void testGetRandom() 
	{
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		
		int x = list.getRandom();	// Wrapper classes, go!
		assertTrue(x == 1 || x == 2 || x == 3 || x == 4 || x == 5);
	}
	
	@Test
	// Get a Random element is valid?
	public void testGetRandom2() 
	{
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		
		int x = list.getRandom();	// Wrapper classes, go!
		assertTrue(x == 1 || x == 2 || x == 3 || x == 4 || x == 5);
	}
	
	@Test(expected=NoSuchElementException.class)
	// Exception/special case test
	public void testGetRandom3() 
	{
		int x = list.getRandom();	// Wrapper classes, go!
		// Execution should interrupt and never move past here, so no assertions...
		// EXCEPT THAT UNIT TESTS ARE COOL! BAM!
	}

	@Test
	/**
	 * <TEST>: Removes and returns the first element from the list. Throws
	 * NoSuchElementException if the list is empty. O(1) for a singly-linked
	 * list.
	 */
	// Remove on a non-empty list
	public void testRemoveFirst() 
	{
		list.add(0, 1);
		list.removeFirst();
		
		assertTrue(list.HEAD == null);
	}
	
	@Test(expected=NoSuchElementException.class)
	// Remove on an empty list -- should throw NoSuchElementException 
	public void testRemoveFirst2() 
	{
		list.removeFirst();
	}

	@Test
	/**
	 * <TEST>: Removes and returns the last element from the list. Throws
	 * NoSuchElementException if the list is empty. O(N) for a singly-linked
	 * list.
	 */
	public void testRemoveLast() 
	{
		list.addLast(1);
		list.removeLast();
		
		assertTrue(list.TAIL == null);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveLast2() 
	{
		list.removeLast();
	}

	@Test
	/**
	 * <TEST>: Removes and returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range. O(N) for a
	 * singly-linked list.
	 */
	// Remove from the middle of a non-empty list
	public void testRemove()
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		
		list.remove(1);
		
		assertTrue(list.size() == 2 && list.get(1) == 3);
	}
	
	@Test
	// Remove from the beginning of a non-empty list
	public void testRemove2()
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		
		list.remove(0);
		
		assertTrue(list.size() == 2 && list.get(0) == 2);
	}
	
	@Test
	// Remove from the end of a non-empty list
	public void testRemove3()
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		
		list.remove(2);
		
		assertTrue(list.size() == 2 && list.get(1) == 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Remove an empty list
	public void testRemove4()
	{
		list.remove(15);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Remove with a negative index
	public void testRemove5()
	{
		list.remove(-3);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	// Remove from past the end of the list
	public void testRemove6()
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		
		list.remove(9);
	}

	@Test
	/**
	 * <TEST>: Returns the index of the first occurrence of the specified element in the
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 */
	public void testIndexOf()
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(2);
		
		assertTrue(list.indexOf(2) == 1);
	}
	
	@Test
	public void testIndexOf2()
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(2);
		
		assertTrue(list.indexOf(4) == -1);
	}

	@Test
	/**
	 * <TEST>: Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 */
	public void testLastIndexOf() 
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(2);
		
		assertTrue(list.lastIndexOf(2) == 3);
	}
	
	@Test
	public void testLastIndexOf2() 
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(2);
		
		assertTrue(list.lastIndexOf(4) == -1);
	}

	@Test
	/**
	 * <TEST>: Returns the number of elements in this list. O(1) for a singly-linked
	 * list.
	 */
	public void testSize() 
	{
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(2);
		
		assertTrue(list.size() == 4);
	}

	@Test
	/**
	 * <TEST>: Returns true if this collection contains no elements. O(1) for a
	 * singly-linked list.
	 */
	public void testIsEmpty() 
	{
		list.addLast(2);
		list.addLast(3);
		
		assertTrue(list.isEmpty() == false);
	}
	
	@Test
	public void testIsEmpty2() 
	{
		assertTrue(list.isEmpty() == true);
	}


	@Test
	/**
	 * <TEST>: Removes all of the elements from this list. O(1) for a singly-linked
	 * list.
	 */
	public void testClear() 
	{
		list.addLast(2);
		list.addLast(3);
		int size1 = list.size();
		list.clear();
		int size2 = list.size();
		
		assertTrue(size1 != size2);
	}
}
