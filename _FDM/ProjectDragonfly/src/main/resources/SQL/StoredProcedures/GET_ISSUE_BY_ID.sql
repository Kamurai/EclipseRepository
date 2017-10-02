create or replace PROCEDURE GET_ISSUE_BY_ID
(
  i_issueid IN number,
  o_issueid OUT number,
  o_Title OUT VARCHAR2,
  o_UserDescription OUT VARCHAR2,
  o_AdminComment OUT VARCHAR2,
  o_AssignedTo OUT number,
  o_AssignedUsername OUT VARCHAR2,
  o_SubmittedBy OUT number,
  o_SubmittedByUsername OUT VARCHAR2,
  o_StatusId OUT number,
  o_Status OUT VARCHAR2,
  o_priority OUT number,
  o_DateSubmitted OUT date,
  o_DateResolved OUT date,
  o_DeptId OUT number,
  o_DeptName OUT VARCHAR2
)
IS
BEGIN
	SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name
	INTO o_issueid, o_Title, o_UserDescription, o_AdminComment, o_AssignedTo, o_AssignedUsername, o_SubmittedBy, o_SubmittedByUsername, o_StatusId, o_Status, o_priority, o_DateSubmitted, o_DateResolved, o_DeptId, o_DeptName
	FROM ISSUES iss
	JOIN STATUSS stats ON
	iss.statusId = stats.statusId
	JOIN DEPARTMENTS DEP ON
	iss.DeptId = dep.DeptId
	JOIN USERS subUser ON
	SUBMITTEDBY = subUser.USERID
	JOIN USERS assUser ON
	ASSIGNEDTO = assUser.USERID
	WHERE issueid = i_issueid;
END GET_ISSUE_BY_ID;