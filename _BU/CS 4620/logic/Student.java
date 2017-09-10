package logic;


/**
 *
 * @author Chris Kemerait
 */

public class Student
{
    private Profile profile;
    private String name;
    private String id;

    public Student(String name, String studentNum)
    {
        this.id = studentNum;
        this.name = name;
        profile = new Profile();
    }

    public int getSizeofStudentCI()
    {
        return profile.getSizeofStudentCI();
    }

    public String getStudentCI(int index)
    {
        return profile.getStudentCI(index);
    }

    public Profile getProfile()
    {
        // begin-user-code
        return profile;
        // end-user-code
    }
    
    /** * * * @param theProfile the profile to set */

    public void setProfile(Profile theProfile)
    {
        // begin-user-code
        profile = theProfile;
        // end-user-code
    }

    /** * @return the name */
    public String getName()
    {
        return name;
    }

    /** * @param name the name to set */
    public void setName(String name)
    {
        this.name = name;
    }

    /** * @return the name */
    public String getId()
    {
        return id;
    }

    /** * @param name the name to set */
    public void setId(String id)
    {
        this.id = id;
    }
}