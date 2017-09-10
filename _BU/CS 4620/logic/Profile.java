package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris Kemerait
 */
public class Profile
{
    /** * * */
    private CareerInterests interests;
    public Profile ()
    {
        interests = new CareerInterests();
    }

    public int getSizeofStudentCI()
    {
        return interests.getSizeofStudentCI();
    }

    public String getStudentCI(int index)
    {
        return interests.getStudentCI(index);
    }

    public Profile (List<String> inputlist )
    {
        interests = new CareerInterests(inputlist);
    }

    public Profile(CareerInterests interests)
    {
        this.interests = interests;
    }
    /** * @return the interests */

    public CareerInterests getInterests()
    {
        return interests;
    }
    /** * @param interests the interests to set */

    public void setInterests(CareerInterests interests)
    {
        this.interests = interests;
    }
}