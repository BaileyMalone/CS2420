package assign4;

public class DescendingSequencer implements Sequencer 
{
	int previous;
	public DescendingSequencer (int size)
	{
		previous = size;
	}
	@Override
	public int next() 
	{
		return previous--;
	}

}
