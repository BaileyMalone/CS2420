package assign5;

import java.util.ArrayList;
/*
 * **************************************************
 * How to set up a configurable/adjustable switch $
 * change the method being tested WITHOUT coming into
 * the modifcationOperation method here and changing
 * the call?
 * **************************************************
 */
public class TimeableLinkedList<T> implements Timeable<T>
{
	// Put in the data structure (HAS-A)
	MyLinkedList<T> linkedList = new MyLinkedList<T>();

	// Constructor 
	public TimeableLinkedList()	{}
	
	@Override
	public void modificationOperation(ArrayList<T> args)
	{
		for (T t : args)
			linkedList.addFirst(t);	// This is the method currently being timed!!!
	}
}
