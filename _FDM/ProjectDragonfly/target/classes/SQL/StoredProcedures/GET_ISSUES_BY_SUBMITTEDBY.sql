create or replace PROCEDURE GET_ISSUES_BY_SUBMITTEDBY
(
	i_SubmittedBy IN number,
	o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name 
	FROM ISSUES iss
    JOIN STATUSS stats ON
    iss.statusId = stats.statusId
    JOIN DEPARTMENTS DEP ON
	iss.DeptId = dep.DeptId
	JOIN USERS subUser ON
    SUBMITTEDBY = subUser.USERID
    JOIN USERS assUser ON
    ASSIGNEDTO = assUser.USERID
	where SubmittedBy = i_SubmittedBy
	ORDER BY ISSUEID;
END GET_ISSUES_BY_SUBMITTEDBY;

