package assign8;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CHTIteratorUnitTests 
{
	ChainingHashTable table = new ChainingHashTable(7, new GoodHashFunctor());


	@Test
	public void testNext()
	{
		table.add("1");	table.add("2");	table.add("3");	table.add("4");	table.add("5");
		CHTIterator it = new CHTIterator(table);

		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
			strings.add(it.next());

		assertTrue(strings.contains("1") && strings.contains("2") && strings.contains("3")
				&& strings.contains("4") && strings.contains("5"));
	}

	@Test
	// Try and remove the 3rd element (3)
	public void testRemove() 
	{
		table.add("1");	table.add("2");	table.add("3");	table.add("4");	table.add("5");
		CHTIterator it = new CHTIterator(table);

		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
		{
			String temp = it.next();
			
			if (i != 2)
				strings.add(temp);
			else
				it.remove();
		}
		
		for (String str : strings)
			System.out.print(str + " ");
		System.out.println();

		assertTrue(strings.contains("1") && strings.contains("2") && !strings.contains("3")
				&& strings.contains("4") && strings.contains("5"));
	}

	@Test
	public void testHasNext()
	{
		table.add("1");	table.add("2");	table.add("3");	table.add("4");	table.add("5");
		CHTIterator it = new CHTIterator(table);

		ArrayList<String> strings = new ArrayList<String>();
		while (it.hasNext())
			strings.add(it.next());

		assertTrue(strings.contains("1") && strings.contains("2") && strings.contains("3")
				&& strings.contains("4") && strings.contains("5"));
	}
}
