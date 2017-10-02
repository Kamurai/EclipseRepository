package com.fdmgroup.demos;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		
		// This demo shows the effects of overriding equals() and hashCode()
		
		Employee emp1 = new Employee(1,"Billy",20000.0,Calendar.getInstance());
		Employee emp2 = new Employee(2,"Mary",40000.0,Calendar.getInstance());
		Employee emp3 = new Employee(3,"Joe",50000.0,Calendar.getInstance());
		Employee emp4 = new Employee(4,"Sandy",60000.0,Calendar.getInstance());
		Employee emp5 = new Employee(5,"Charles",10000.0,Calendar.getInstance());
		Employee emp6 = new Employee(6,"John",90000.0,Calendar.getInstance());
		Employee emp7 = new Employee(7,"Erica",120000.0,Calendar.getInstance());
		
		Set<Employee> employeeSet = new HashSet<Employee>();
		
		employeeSet.add(emp1);
		employeeSet.add(emp2);
		employeeSet.add(emp3);
		employeeSet.add(emp4);
		employeeSet.add(emp5);
		employeeSet.add(emp6);
		employeeSet.add(emp7);
		
		Employee empToFind = new Employee(7,null,0,null);  	// Trying to retrieve information
															// about employee with id 7 from Set
		
		System.out.println("Set contains employee with id 7: "+ employeeSet.contains(empToFind));
		
		// Next, comment out Employee's equals() and hashCode() and run this again
	}
}
