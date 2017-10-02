create or replace PROCEDURE GET_ISSUE_BY_ID2
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
  o_DateResolved OUT date
)
IS
BEGIN
	SELECT issueId, title, userDescription, adminComment, assignedTo, (CASE WHEN ASSIGNEDTO IS NOT NULL THEN assUser.username ELSE 'Unassigned' END ), submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved
	INTO o_issueid, o_Title, o_UserDescription, o_AdminComment, o_AssignedTo, o_AssignedUsername, o_SubmittedBy, o_SubmittedByUsername, o_StatusId, o_Status, o_priority, o_DateSubmitted, o_DateResolved
	FROM ISSUES iss
	JOIN STATUSS stats ON
	iss.statusId = stats.statusId
	JOIN USERS subUser ON
	SUBMITTEDBY = subUser.USERID
	JOIN USERS assUser ON
	SUBMITTEDBY = assUser.USERID
	WHERE issueid = i_issueid;
END GET_ISSUE_BY_ID2;