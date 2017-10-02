create or replace PROCEDURE GET_ISSUEUPDATE_BY_ID
(
	i_issueUpdateId IN number,
	o_issueUpdateId OUT number,
	o_issueid OUT number,
	o_SubmittedBy OUT number,
	o_SubmittedByUsername OUT VARCHAR2,
	o_UpdateDate OUT date,
	o_UpdateComment OUT VARCHAR2
)
IS
BEGIN
	SELECT issueUpdateId, issueid, SubmittedBy, USERNAME, UpdateDate, UpdateComment
	INTO o_issueUpdateId, o_issueid, o_SubmittedBy, o_SubmittedByUsername, o_UpdateDate, o_UpdateComment
	FROM ISSUEUPDATES 
	JOIN USERS ON
	SUBMITTEDBY = USERID
	WHERE issueUpdateId = i_issueUpdateId;
END GET_ISSUEUPDATE_BY_ID;