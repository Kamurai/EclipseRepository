create or replace PROCEDURE GET_ISSUES_UNASSIGNED2
(
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
	where ASSIGNEDTO IS NULL
	ORDER BY ISSUEID;
END GET_ISSUES_UNASSIGNED2;