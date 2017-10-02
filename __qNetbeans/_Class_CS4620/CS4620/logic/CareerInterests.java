package logic;

/**
 *
 * @author Chris Kemerait
 */
import java.util.ArrayList;
import java.util.List;

public class CareerInterests
{
    private List<String> interests;

    public CareerInterests ()
    {
        interests = new ArrayList();
    }

    public String getStudentCI(int index)
    {
        return interests.get(index);
    }

    public int getSizeofStudentCI()
    {
        return interests.size();
    }

    public CareerInterests(List inputlist)
    {
        interests = new ArrayList(inputlist);
    }

    public List<String> getCareerInterests()
    {
        return getInterests();
    }

    public void addInterest(String interest)
    {
        if (!interests.contains(interest))
        {
            getInterests().add(interest);
        }
    }

    public String addci(int index, String input)
    {
        //if input string is empty
        if( input.compareTo("") == 0 )
        {
            interests.remove(index-1);

            //return blank
            return "";
        }
        //if index is out of bounds
        else if( index >= interests.size() )
        {
            //add interest
            addInterest(input);
        }
        //all else
        else
        {
            //set interest
            interests.set(index, input);
        }


        return "";
    }

    public String setInterest(int index, String interest)
    {
        if( interest.compareTo("") != 0)
        {
            //if index is out of bounds
            if( index >= interests.size() )
            {
                return " ";
            }
            //if index is in bounds
            else if( index < interests.size() )
            {
                getInterests().set(index, interest);

                //return set String
                return getInterests().get(index);
            }
        }
        //else
        else
        {
            if( interests.size() > 0 )
            {
                getInterests().set(index, interest);
            }
        }
        
        //return blank
        return  "";

    }

    /*
    public void setInterest(int index, String interest)
    {
        getInterests().set(index, interest);
    }
    */

    /**
     * @return the interests
     */
    public List<String> getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(List interests) {
        this.interests = interests;
    }
}