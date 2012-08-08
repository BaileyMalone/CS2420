package assign4;
import java.util.ArrayList;
import java.util.Random;

/**
 * Generates pseudo-random numbers.
 * We hope.
 * 
 * @author Bailey Malone, Jeongyoun Chae
 *
 */
public class PermutedSequencer implements Sequencer
{
	int range;
	Random rng;
	ArrayList<Integer> adds;

	public PermutedSequencer (int size)
	{
		range = size;
		rng = new Random();
		adds = new ArrayList<Integer>();
	}
	@Override
	public int next() 
	{
		int R = (rng.nextInt(1000 * range)) % range;
		while (adds.contains(R))
		{
			R = (rng.nextInt(1000 * range)) % range;
		}

		adds.add(R);
		return R;
	}
}
