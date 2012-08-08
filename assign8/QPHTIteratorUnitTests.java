package assign8;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QPHTIteratorUnitTests
{
	// Test Data
	QuadProbeHashTable table = new QuadProbeHashTable(7, new GoodHashFunctor());
	
	
	@Test
	// See if next() returns all the elements known to be in the table
	public void testNext() 
	{
		table.add("1");	table.add("2");	table.add("3");	table.add("4");	table.add("5");
		QPHTIterator it = new QPHTIterator(table);
		
		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
			strings.add(it.next());
		
		assertTrue(strings.contains("1") && strings.contains("2") && strings.contains("3")
					&& strings.contains("4") && strings.contains("5"));
	}

	@Test
	// Try and remove 4th (4) -- call right after 4th element is returned by iterator
	public void testRemove() 
	{
		table.add("1");	table.add("2");	table.add("3");	table.add("4");	table.add("5");
		QPHTIterator it = new QPHTIterator(table);
		
		// Put the table elements in a list
		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
		{
			String temp = it.next();
			
			if (i != 3)
				strings.add(temp);
			
			if (i == 3)
				it.remove();
		}

		assertTrue(strings.contains("1") && strings.contains("2") && strings.contains("3")
					&& !strings.contains("4") && strings.contains("5"));
	}

	@Test
	// Rerun AddTest1 which works -- see if "hasNext()" functions correctly
	public void testHasNext() 
	{
		table.add("1");	table.add("2");	table.add("3");	table.add("4");	table.add("5");
		QPHTIterator it = new QPHTIterator(table);
		
		ArrayList<String> strings = new ArrayList<String>();
		while (it.hasNext())
			strings.add(it.next());
		
		assertTrue(strings.contains("1") && strings.contains("2") && strings.contains("3")
					&& strings.contains("4") && strings.contains("5"));
	}
}
