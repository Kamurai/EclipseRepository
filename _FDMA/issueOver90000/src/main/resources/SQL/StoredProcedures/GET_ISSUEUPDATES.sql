create or replace PROCEDURE GET_ISSUEUPDATES
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT ISSUEUPDATEID, ISSUEID, SUBMITTEDBY, USERNAME, UPDATEDATE, UPDATECOMMENT 
	FROM ISSUEUPDATES
	JOIN USERS ON
	SUBMITTEDBY = USERID
	ORDER BY ISSUEID, ISSUEUPDATEID;
END GET_ISSUEUPDATES;

