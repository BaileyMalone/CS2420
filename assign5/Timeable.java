package assign5;

import java.util.ArrayList;
/**
 * Defines a data-structure wrapper to pass data structures
 * as functors to time an desired method in that structure.
 * 
 * @author bmalone
 *
 * @param <T>
 */
public interface Timeable<T>
{
	void modificationOperation(ArrayList<T> args);
}
