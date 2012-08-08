package assign5;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class MyStackUnitTests 
{
	// Test Stack
	MyStack<Integer> stack = new MyStack<Integer>();
	
	@Test
	public void testMyStack()
	{
		assertTrue(stack.size() == 0);
	}

	@Test
	public void testClear() 
	{
		stack.push(3);
		stack.push(2);
		stack.push(1);
		int size1 = stack.size();
		stack.clear();
		int size2 = stack.size();
		
		assertTrue(size1 != size2 && size2 == 0);
	}

	@Test
	public void testIsEmpty()
	{
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testIsEmpty2()
	{
		stack.push(1);
		
		assertFalse(stack.isEmpty());
	}

	@Test(expected=NoSuchElementException.class)
	// Test on an empty stack
	public void testPeek()
	{
		stack.peek();
	}
	
	@Test
	// Test on a non-empty stack
	public void testPeek2()
	{
		stack.push(2);
		stack.push(1);
		
		assertTrue(stack.peek() == 1);
	}
	
	@Test
	// Do a bunch of operations, peek and compare to the expected element
	public void testPeek3()
	{
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.pop();
		stack.pop();
		
		assertTrue(stack.peek() == 3);
	}

	@Test(expected=NoSuchElementException.class)
	// Test on an empty stack
	public void testPop() 
	{
		stack.pop();
	}
	
	@Test
	// Test on a non-empty stack -- see that it returns the correct/expected data
	public void testPop2() 
	{
		stack.push(100);
		stack.push(85);
		stack.push(9001);
		
		assertTrue(stack.pop() == 9001);
	}
	
	@Test(expected=NoSuchElementException.class)
	// Pop more than there are elements in the stack --> NoSuchElementException?
	public void testPop3() 
	{
		stack.push(100);
		stack.push(85);
		stack.push(9001);
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
	}

	@Test
	public void testPush() 
	{
		int size1 = stack.size();
		stack.push(1);
		int size2 = stack.size();
		
		assertTrue(size1 != size2 && size2 == 1 && size1 == 0 && stack.peek() == 1);
	}
	
	@Test
	public void testPush2() 
	{
		int size1 = stack.size();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		int size2 = stack.size();
		
		assertTrue(size1 != size2 && size2 == 3 && size1 == 0 && stack.peek() == 5);
	}
}
