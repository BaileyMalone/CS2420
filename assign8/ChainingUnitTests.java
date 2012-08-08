package assign8;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;

/**
 * 
 * 
 * @author Bailey Malone && Jeongyoun Chae
 */

public class ChainingUnitTests 
{
	// Test Table
	ChainingHashTable table = new ChainingHashTable(7, new BadHashFunctor());

	@Test
	// Add 5 elements that should all be added fine
	public void testAdd1() 
	{
		int size1 = table.size();
		table.add("1");	table.add("2");
		table.add("3");	table.add("4");
		table.add("5");
		int size2 = table.size();

		assertTrue(size2 > size1 && size2 == 5);
	}

	@Test
	// Add an empty string -- should not get added
	public void testAdd2() 
	{
		assertTrue(!table.add("") && table.size() == 0);
	}

	@Test
	// Add null -- should not get added
	public void testAdd3() 
	{
		assertTrue(!table.add(null) && table.size() == 0);
	}

	@Test
	// Add past load balance
	public void testAdd4() 
	{
		int cap1 = table.capacity;	int size1 = table.size();
		// Capacity 17, so past load balance is 9
		table.add("1");	table.add("2");	table.add("9");
		table.add("3");	table.add("4");	table.add("8");
		table.add("5"); table.add("6");	table.add("7");	table.add("10");
		int cap2 = table.capacity;	int size2 = table.size();

		assertTrue(table.capacity > 7 && size1 < size2 && cap1 < cap2);	// Also check contains the above strings...
	}

	@Test
	// Add anagrams, and check indexes in the table to verify
	// chaining
	public void testAdd5() 
	{
		table.add("apt");	table.add("pat");	table.add("tap");

		// If chaing, we should have a linked list of there 3 elements
		// at index "hash"
		int hash = table.hasher.hash("apt");
		hash = hash % table.capacity;
		LinkedList<String> list = table.get(hash);

		assertTrue(list.contains("apt") && list.contains("pat") && list.contains("tap"));
	}

	/* Resize() was tested in the tests for add -- it did the one thing it needs to */

	@Test
	// Clear an empty table
	public void testClear1() 
	{
		table.clear();
		Random R = new Random();
		int randomIndex = R.nextInt(table.capacity);

		assertTrue(table.size() == 0 && table.get(randomIndex).isEmpty());
	}

	@Test
	// Clear an non-empty table
	public void testClear2() 
	{
		int realIndex = table.hasher.hash("1");
		table.add("1");	table.add("2");	table.add("3");
		int size1 = table.size();
		table.clear();
		int size2 = table.size();

		assertTrue(size1 > size2 && size2 == 0 && table.get(realIndex).isEmpty());
	}

	@Test
	// Test on an elements we KNOW are in the list
	public void testContains1() 
	{
		table.add("orange");	table.add("apple");	
		table.add("banana");

		assertTrue(table.contains("orange") && table.contains("apple") 
				&& table.contains("banana"));
	}

	@Test
	// Test on an elements we KNOW are -not- in the list
	public void testContains2() 
	{
		table.add("clemen");	table.add("kiwi");	
		table.add("strawberry");

		assertFalse(table.contains("orange") && table.contains("apple") 
				&& table.contains("banana"));
	}

	@Test
	// Test on null
	/* Should be FALSE */
	public void testContains3() 
	{
		assertTrue(!table.contains(null));
	}

	@Test
	// Test resize changes size and keeps all elements
	public void testresize1() 
	{
		int cap1 = table.capacity;
		table.add("1");	table.add("2");	table.add("9");	table.add("12"); 
		table.add("3");	table.add("4");	table.add("8"); table.add("11"); 
		table.add("5"); table.add("6");	table.add("7");	table.add("10"); 
		int cap2 = table.capacity;
		
		assertTrue(cap2 > cap1 && cap1 == 7 && table.contains("1")
					&& table.contains("2") && table.contains("3") && table.contains("4")
					&& table.contains("5") && table.contains("6") && table.contains("7")
					&& table.contains("8") && table.contains("9") && table.contains("10")
					&& table.contains("11") && table.contains("12"));
	}
}
