package logic;

/**
 *
 * @author Chris Kemerait
 */

import data.DataBean;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper
{
    DataBean db = new DataBean();
    //WriteBean wb = new WriteBean();

	private List<Student> students;

	public StudentMapper()
	{
            students = new ArrayList<Student>();
            initialize();//new ArrayList<Student>();
            //stubCollection();

	}

        public Student getLocalStudent(int index)
        {
            return students.get(index);
        }

	/**
	 * @return
	 */
	public StudentNameCollection getAllStudentNames()
	{
		// begin-user-code
		StudentNameCollection names = new StudentNameCollection();
		//for (int i = 0; i < students.size(); i++)
			//names.addName(students.get(i).getName());

                ResultSet rs = null;

                //build tables properly
                try
                {
                    //find all words
                    String sqlWord = "SELECT * FROM studentinfo";
                    rs = db.executeQueryStatement(sqlWord);

                    //goto last
                    rs.last();
                    //get rowcount
                    int tablesize = rs.getRow();

                    //count total number of words
                    rs.beforeFirst();

                    //walkthrough tablenames from database
                    for(int x = 0; x < tablesize; x++)
                    {
                        //goto new row
                        rs.next();
                        names.addName(rs.getString("studentname"));
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

		return names;
		// end-user-code
	}

        //return entire student by name
	public Student getStudent(String name)
	{
		// begin-user-code
		Student s = null;
		int location = getStudentLocation (name);
		if (location >= 0)
			s = students.get(location);
		return s;
		// end-user-code
	}

        //write student to database
	public void storeStudent(Student s)
	{
            String sqlstatement;
            int rowcount = 0;
            int temp = 0;
            ResultSet rs = null;

            int limit = s.getProfile().getInterests().getCareerInterests().size();

            //update local data
		// begin-user-code
		int location = getStudentLocation(s.getName());
		//if (location >= 0)
		if ( location < limit )
			students.set(location, s);
		else
			students.add(s);
		// end-user-code


           //update database
//problem
                //get career interest ids
                sqlstatement = "select ciid from careerinterest where studentid = " + s.getId();

                //store in result set
                rs = db.executeQueryStatement(sqlstatement);

            try
            {
                //go to last row
                rs.last();
                //get the row number (last row number)
                rowcount = rs.getRow();
                //go back to start of list
                rs.first();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }     

                //loop through career interests
                for(int x = 0; x < limit; x++)
                {
                    try
                    {
                        //get career interest index
                        temp = rs.getInt("ciid");
                        //go to next row for next iteration
                        rs.next();
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }


                    //if updating an empty string
                    if( s.getProfile().getInterests().getCareerInterests().get(x).equals("") )
                    {
                        //set table to delete from
                        sqlstatement = "delete from careerinterest where ciid = " + temp;

                        //only delete if NOT the last
                        if( (rowcount > 1) && (s.getProfile().getInterests().getCareerInterests().size() > 1) )
                        {
                            //execute deletion statement
                            db.writeTo(sqlstatement);
                            rowcount--;
                            s.getProfile().getInterests().getCareerInterests().remove(x);
                            x--;
                            limit--;
                        }
                    }
                    //if its a current career interest is being updated
                    else if( x < rowcount )
                    {
                        //set table to update
                        sqlstatement = "update careerinterest SET";

                        //set column
                        sqlstatement += " ci = '" + s.getProfile().getInterests().getCareerInterests().get(x);

                        //set conditional
                        sqlstatement += "' WHERE studentid = " + s.getId() + " and ciid = " + temp;
                        //execute update statement
                        db.writeTo(sqlstatement);
                    }
                    //if a new careerinterest is being added
                    else
                    {
                        //set table to insert new
                        sqlstatement = "insert into careerinterest (ciid, studentid, ci) VALUES (";

                        //get nextavailable id
                        temp = db.getnextavailableid("careerinterest", "ciid");

                        //set conditional
                        sqlstatement += temp + ", " + s.getId() + ", '" + s.getProfile().getInterests().getCareerInterests().get(x) + "')";


                        //execute insert statement
                        db.writeTo(sqlstatement);
                    }
                }

                //reset rowcount and limit
                    //go to last row
                try
                {
                    //go to last row
                    rs.last();
                    //get the row number (last row number)
                    rowcount = rs.getRow();
                    //go back to start of list
                    rs.first();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                limit = s.getProfile().getInterests().getCareerInterests().size();

                //for(int y = 0; y < limit; y++)
                {
                    //resolve cases where there are "extra" records in the database
                        //if number of rows in database is greater than the list of career interests
                    if( rowcount > limit )
                    {
                        //loop through remainder
                        //for(int x = 0; x < (rowcount - s.getProfile().getInterests().getCareerInterests().size()); x++)
                        for(int x = s.getProfile().getInterests().getCareerInterests().size(); x < rowcount; x++)
                        {
                            try
                            {
                                //get career interest index
                                temp = rs.getInt("ciid");
                                //go to next row for next iteration
                                rs.next();
                            }
                            catch(Exception ex)
                            {
                                ex.printStackTrace();
                            }

                            //set table to delete from
                            sqlstatement = "delete from careerinterest where ciid = " + temp;

                            //only delete if NOT the last
                            if( (rowcount > 1) && (s.getProfile().getInterests().getCareerInterests().size() > 1) )
                            {
                                //execute deletion statement
                                db.writeTo(sqlstatement);
                            }
                        }
                    }
                }
        }

        //return index of student in the local list
	public int getStudentLocation (String name)
	{
		int i = 0;
		while (i < students.size() && !students.get(i).getName().equals(name))
			i++;
		if (i == students.size())
			i = -1;
		return i;
	}

        private void initialize()
        {
            ResultSet srs = null;
            ResultSet crs = null;
            int srowcount = 0;
            int crowcount = 0;

            List ci = new ArrayList<String>();

            Student tempstudent;
            String tempstring1;
            String tempstring2;

            //build tables properly
            try
            {
                //find all students
                String sqlWord = "SELECT * FROM studentinfo";
                srs = db.executeQueryStatement(sqlWord);


                //goto last
                srs.last();
                //get rowcount
                srowcount = srs.getRow();

                //count total number of words
                srs.beforeFirst();
                
                //walkthrough tablenames from database
                for (int x = 0; x < srowcount; x++)
                {
                    //goto new row
                    srs.next();

                    //find all career interests per student
                    sqlWord = "SELECT * FROM careerinterest where studentid = " + srs.getInt("studentid");
                    crs = db.executeQueryStatement(sqlWord);

                     //goto last
                    crs.last();
                    //get rowcount
                    crowcount = crs.getRow();

                    //count total number of words
                    //crs.beforeFirst();
                    //goto new row
                    //crs.next();

                    ci.clear();
                    crs.beforeFirst();

                    for(int y = 0; y < crowcount; y++)
                    {
                        crs.next();
                        ci.add( crs.getString("ci") );
                    }


                    tempstring1 = srs.getString("studentname");
                    tempstring2 = Integer.toString(srs.getInt("studentid"));

                    tempstudent = new Student( tempstring1, tempstring2 );

                    //add new student to list
                    students.add( tempstudent );

                    //set student's profile
                    students.get(students.size()-1).setProfile(new Profile(ci));

                }



            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
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