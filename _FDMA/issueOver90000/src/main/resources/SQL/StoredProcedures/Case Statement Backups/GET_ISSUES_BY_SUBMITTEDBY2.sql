create or replace PROCEDURE GET_ISSUES_BY_SUBMITTEDBY2
(
	i_SubmittedBy IN number,
	o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT issueId, title, userDescription, adminComment, assignedTo, (CASE WHEN ASSIGNEDTO IS NOT NULL THEN assUser.username ELSE 'Unassigned' END ), submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved 
	FROM ISSUES iss
	JOIN STATUSS stats ON
	iss.statusId = stats.statusId
	JOIN USERS subUser ON
	SUBMITTEDBY = subUser.USERID
	JOIN USERS assUser ON
	SUBMITTEDBY = assUser.USERID
	where SubmittedBy = i_SubmittedBy
	ORDER BY ISSUEID;
END GET_ISSUES_BY_SUBMITTEDBY2;

