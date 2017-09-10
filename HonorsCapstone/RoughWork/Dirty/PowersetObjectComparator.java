/**
 * 
 */
package Dirty;

import java.util.Comparator;
import java.util.Set;

/**
 * @author SGR
 *
 */
@SuppressWarnings("serial")
public class PowersetObjectComparator 
	implements Comparator<Set<Integer>>, java.io.Serializable {

	@Override
	public int compare(Set<Integer> o1, Set<Integer> o2) {		
		if (o1.size() < o2.size())
			return -1;
		if (o1.size() > o2.size())
			return 1;
		if (o1.size() == o2.size())
			return o1.toString().compareTo(o2.toString());
	
		return 0;
	}

}
