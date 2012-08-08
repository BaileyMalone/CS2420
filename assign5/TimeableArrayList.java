package assign5;

import java.util.ArrayList;

public class TimeableArrayList<T> implements Timeable<T>
{
	// Put in the data structure (HAS-A)
	ArrayList<T> list = new ArrayList<T>();

	// Constructor 
	public TimeableArrayList()	{}
	
	@Override
	public void modificationOperation(ArrayList<T> args)
	{
		for (T t : args)
			list.add(t);	// This is the method currently being timed!!!
	}
}
