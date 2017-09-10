package logic;

/**
 *
 * @author Chris Kemerait
 */
import java.util.ArrayList;
import java.util.List;

public class StudentNameCollection
{
	private List<String> names;

	public StudentNameCollection()
	{
		names = new ArrayList<String>();
	}

	/**
	 * @return the names
	 */
	public List<String> getNames()
	{
		return names;
	}

        public String getName(int index)
        {
            return names.get(index);
        }

	public void addName (String name)
	{
		names.add(name);
	}

        public int getSize()
        {
            return names.size();
        }
}