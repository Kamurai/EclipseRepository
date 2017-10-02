package logic;

/**
 *
 * @author Chris Kemerait
 */


import logic.StudentMapper;


public class StudentInfoManager
{
    StudentMapper sm;
    //DataBean db = new DataBean();
    //WriteBean wb = new WriteBean();

	//private List<Student> students;

	public StudentInfoManager()
	{
            //stubCollection();
		sm = new StudentMapper();
	}

        public Student getLocalStudent(int index)
        {
            return sm.getLocalStudent(index);
        }

	/**
	 * @return
	 */
	public StudentNameCollection getAllStudentNames()
	{
                return sm.getAllStudentNames();
	}

        //return entire student by name
	public Student getStudent(String name)
	{
            return sm.getStudent(name);
	}

        //write student to database
	public void storeStudent(Student s)
	{
            sm.storeStudent(s);
        }

        //return index of student in the local list
	public int getStudentLocation (String name)
	{
            return sm.getStudentLocation(name);
        }

        


        /*
	private void stubCollection()
	{
		Student s1 = new Student ("Bubba Dawg", "666666666");
		CareerInterests c1 = new CareerInterests();
		c1.addInterest("Taco Bell");
		c1.addInterest("chewing tobacco");
		Profile p1 = new Profile (c1);
		s1.setProfile(p1);
		students.add(s1);
		Student s2 = new Student ("Barbara Brilliant", "999999999");
		CareerInterests c2 = new CareerInterests();
		c2.addInterest("medicine");
		c2.addInterest("nuclear physics");
		Profile p2 = new Profile (c2);
		s2.setProfile(p2);
		students.add(s2);
		Student s3 = new Student ("Joe Selfish", "000000000");
		CareerInterests c3 = new CareerInterests();
		c3.addInterest("politics");
		c3.addInterest("power");
		Profile p3 = new Profile (c3);
		s3.setProfile(p3);
		students.add(s3);
	}
         * */
         
}