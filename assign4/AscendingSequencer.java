package assign4;
/**
 * 
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 */
public class AscendingSequencer implements Sequencer 
{
	int previous;

	public AscendingSequencer ()
	{
		previous = 0;
	}
	@Override
	public int next()
	{
		return previous++;
	}

}
