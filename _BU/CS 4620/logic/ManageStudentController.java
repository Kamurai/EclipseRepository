package logic;

//import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris Kemerait
 */
public class ManageStudentController
{
	private StudentInfoManager manager;
        private List<String> localupdates = new ArrayList<String>();

	public ManageStudentController()//StudentInfoManager manager)
	{
		this.manager = new StudentInfoManager();//manager;
                
                for(int x = 0; x < manager.getAllStudentNames().getNames().size(); x++)
                {
                    localupdates.add("");
                }
	}

        public Student getLocalStudent(int index)
        {
            return manager.getLocalStudent(index);
        }

        public int getSizeofStudents()
        {
            return getStudentNames().getSize();
        }

        public int getSizeofStudentCI(Student s)
        {
            return s.getSizeofStudentCI();
        }

	/**
	 * @param id
	 * @return
	 */
	public Student getStudent(String id)
	{
		// begin-user-code
		return manager.getStudent(id);
		// end-user-code
	}

	/**
	 * @param s
	 * @return
	 */
	public String saveStudent(Student s)
	{
            int sindex = manager.getAllStudentNames().getNames().indexOf(s.getName());
            int ciindex = getStudent(s.getName()).getProfile().getInterests().getCareerInterests().size();

            //updates a career interest of a student
                //add a new career interest if filled in
            if( getLocalupdates().get(sindex).compareTo("") != 0 )
            {
                update(sindex, ciindex, getLocalupdates().get(sindex));
            }


		// begin-user-code
		boolean valid = validateStudent (s);
		if (valid)
                {
			manager.storeStudent(s);
                }

                for(int x = 0; x < localupdates.size(); x++)
                {
                    localupdates.set(x, "");
                }

		return "managestudent";
		// end-user-code
	}

        //update method to update career interests of a particular student based on student name
        public String update(int sindex, int ciindex, String ci)
        {
            //use student index to find student
                //use career interest index to set specific career interest
            return getStudent(getStudentNames().getName(sindex)).getProfile().getInterests().addci(ciindex, ci);
        }

	/**
	 * @param s
	 * @return
	 */
	private Boolean validateStudent(Student s)
	{
		// begin-user-code
		// TODO Auto-generated method stub
		return true;
		// end-user-code
	}

        public StudentNameCollection getStudentNames()
	{
		// begin-user-code
		return manager.getAllStudentNames();
		// end-user-code
	}

   

    /**
     * @return the localupdates
     */
    public List<String> getLocalupdates() {
        return localupdates;
    }

    /**
     * @param localupdates the localupdates to set
     */
    public void setLocalupdates(List<String> localupdates) {
        this.localupdates = localupdates;
    }

	
}
