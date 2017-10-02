package com.fdmgroup.Services;

import java.util.List;

import com.fdmgroup.DAO.DepartmentDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Entity.User;

public class IssueServices {
	private DepartmentDAO deptDAO;
	
	
	public Boolean checkIfGeneralAdmin(User user){
		Boolean verifyGenAdmin = false;
		for(Role role : user.getRoleList()){
			if(role.getRoleId()==2){
				verifyGenAdmin = true;
			}
		}
		
		return verifyGenAdmin;
		
	}
	public Boolean checkIfDepartmentAdmin(User user){
		Boolean verifyDeptAdmin = false;
		for(Role role : user.getRoleList()){
			if(role.getRoleId()==1){
				verifyDeptAdmin = true;
			}
		}
		
		return verifyDeptAdmin;
		
	}
	public Boolean checkIfDepartmentIsAValidDepartment(int deptID){
		Boolean verifyDepartment = false;
		deptDAO = new DepartmentDAO();
		List<Department> deptList = deptDAO.getDepartments();
		for(Department d: deptList){
			if(d.getDeptId()==deptID){
				verifyDepartment = true;
			}
		}
		return verifyDepartment;
		
	}
	public Boolean checkIfDataIsValidForNewIssue(String title, String descriptions, int priority, int deptId){
		Boolean verifyIssueData = false;
		if(title != null && !title.isEmpty()){
			if(descriptions != null && !descriptions.isEmpty()){
				if(priority == 1 || priority == 2 || priority == 3 || priority == 4 || priority == 5 ){
					if(checkIfDepartmentIsAValidDepartment(deptId)==true){
						verifyIssueData = true;
						
					}
				}
			}
		}
		
		
		return verifyIssueData;
		
	}
	

}
