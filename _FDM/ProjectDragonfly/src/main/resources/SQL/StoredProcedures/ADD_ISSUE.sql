CREATE OR REPLACE PROCEDURE ADD_ISSUE
(
	i_title IN VARCHAR2,
	i_userdescription IN VARCHAR2,
	i_submittedby IN number,
	i_statusid IN number,
	i_priority IN number,
	i_datesubmitted IN date,
	i_deptid IN number
)
IS
BEGIN
  INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) 
  VALUES (i_title, i_userdescription, i_submittedby, i_statusid, i_priority, i_datesubmitted, i_deptid);
  COMMIT;
END ADD_ISSUE;