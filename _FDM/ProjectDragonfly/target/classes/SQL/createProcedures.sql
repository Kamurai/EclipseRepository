CREATE OR REPLACE PROCEDURE ADD_DEPARTMENT
(
  i_Name IN NUMBER 
 
)
IS
BEGIN
    INSERT INTO DEPARTMENTS(NAME) 
                VALUES (i_Name);
    COMMIT;
END ADD_DEPARTMENT;

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

CREATE OR REPLACE PROCEDURE ADD_ISSUEUPDATE
(
  i_issueUpdateId IN number,
  i_issueId IN number,
  i_submittedby IN number,
  i_updateDate IN date,
  i_updateComment IN varchar
)
IS
BEGIN
    INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) 
    VALUES (i_issueId, i_submittedby, i_updateDate, i_updateComment);
    COMMIT;
END ADD_ISSUEUPDATE;

CREATE OR REPLACE PROCEDURE ADD_ROLE
(
  i_Name IN VARCHAR2 
)
IS
BEGIN
    INSERT INTO ROLES(ROLENAME) 
                VALUES (i_Name);
    COMMIT;
END ADD_ROLE;

CREATE OR REPLACE PROCEDURE ADD_STATUS
(
  i_Name IN VARCHAR2 
)
IS
BEGIN
    INSERT INTO STATUSS(STATUS) 
                VALUES (i_Name);
    COMMIT;
END ADD_STATUS;

CREATE OR REPLACE PROCEDURE ADD_USER
(
i_deptid IN NUMBER,
i_username IN VARCHAR2,
i_password IN VARCHAR2,
i_email IN VARCHAR2  
)
IS
BEGIN
  INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) 
			  VALUES (i_deptid, i_username, i_password, i_email);
  COMMIT;
END ADD_USER;

create or replace PROCEDURE GET_DEPARTMENT_BY_ID
(
  i_deptId IN number,
  o_Name OUT number
)
IS
BEGIN
  SELECT Name
  INTO o_Name
  FROM DEPARTMENTS WHERE deptId = i_deptId;
END GET_DEPARTMENT_BY_ID;

CREATE OR REPLACE PROCEDURE GET_DEPARTMENTS
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT * FROM DEPARTMENTS;
END GET_DEPARTMENTS;

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
	SUBMITTEDBY = assUser.USERID
	WHERE issueid = i_issueid;
END GET_ISSUE_BY_ID;

create or replace PROCEDURE GET_ISSUE_BY_TITLE
(
  i_Title IN VARCHAR2,
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
	SUBMITTEDBY = assUser.USERID
	WHERE Title = i_Title;
END GET_ISSUE_BY_TITLE;

create or replace PROCEDURE GET_ISSUES
(
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
    SUBMITTEDBY = assUser.USERID
	ORDER BY ISSUEID;
END GET_ISSUES;

create or replace PROCEDURE GET_ISSUES_BY_ASSIGNEDTO
(
	i_AssignedTo IN number,
	o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  if i_AssignedTo IS NULL THEN
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
    SUBMITTEDBY = assUser.USERID
    where ASSIGNEDTO IS NULL
	ORDER BY ISSUEID;
	else
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
    SUBMITTEDBY = assUser.USERID
    where ASSIGNEDTO = i_AssignedTo
	ORDER BY ISSUEID;
	end if;
	
END GET_ISSUES_BY_ASSIGNEDTO;

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
    SUBMITTEDBY = assUser.USERID
	where SubmittedBy = i_SubmittedBy
	ORDER BY ISSUEID;
END GET_ISSUES_BY_SUBMITTEDBY;

create or replace PROCEDURE GET_ISSUES_UNASSIGNED
(
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
    SUBMITTEDBY = assUser.USERID
	where ASSIGNEDTO IS NULL
	ORDER BY ISSUEID;
END GET_ISSUES_UNASSIGNED;

create or replace PROCEDURE GET_ISSUEUPDATE_BY_ID
(
	i_issueUpdateId IN number,
	o_issueid OUT number,
	o_SubmittedBy OUT number,
	o_UpdateDate OUT date,
	o_UpdateComment OUT VARCHAR2
)
IS
BEGIN
  SELECT issueid, SubmittedBy, UpdateDate, UpdateComment
  INTO o_issueid, o_SubmittedBy, o_UpdateDate, o_UpdateComment
  FROM ISSUEUPDATES WHERE issueUpdateId = i_issueUpdateId;
END GET_ISSUEUPDATE_BY_ID;

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

create or replace PROCEDURE GET_USER_BY_ID
(
  i_userid IN number,
  o_userid OUT number,
  o_deptid OUT number,
  o_deptName OUT VARCHAR2,
  o_username OUT VARCHAR2,
  o_password OUT VARCHAR2,
  o_email OUT VARCHAR2
)
IS
BEGIN
	SELECT userid, USERS.DEPTID, DEPT.NAME, username, password, email
	INTO o_userid, o_deptid, o_deptName, o_username, o_password, o_email
	FROM USERS 
	JOIN DEPARTMENTS DEPT ON
	USERS.DEPTID = DEPT.DEPTID
	WHERE userid = i_userid;
END GET_USER_BY_ID;

create or replace PROCEDURE GET_USER_BY_USERNAME
(
  i_username IN VARCHAR2,
  o_userid OUT number,
  o_deptid OUT number,
  o_deptName OUT VARCHAR2,
  o_username OUT VARCHAR2,
  o_password OUT VARCHAR2,
  o_email OUT VARCHAR2  
)
IS
BEGIN
	SELECT userid, USERS.DEPTID, DEPT.NAME, username, password, email
	INTO o_userid, o_deptid, o_deptName, o_username, o_password, o_email
	FROM USERS 
	JOIN DEPARTMENTS DEPT ON
	USERS.DEPTID = DEPT.DEPTID
	WHERE username = i_username;
END GET_USER_BY_USERNAME;

CREATE OR REPLACE PROCEDURE GET_USERS
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT USERID, USERS.DEPTID, DEPT.NAME, USERNAME, PASSWORD, EMAIL FROM USERS
	JOIN DEPARTMENTS DEPT ON
	USERS.DEPTID = DEPT.DEPTID
	ORDER BY USERID;
END GET_USERS;

CREATE OR REPLACE PROCEDURE REMOVE_DEPARTMENT
(
  i_deptId IN VARCHAR2
)
IS
BEGIN
  DELETE FROM DEPARTMENTS WHERE deptId = i_deptId;
  COMMIT;
END REMOVE_DEPARTMENT;

CREATE OR REPLACE PROCEDURE REMOVE_ISSUE
(
  i_issueid IN VARCHAR2
)
IS
BEGIN
  DELETE FROM ISSUES WHERE issueid = i_issueid;
  COMMIT;
END REMOVE_ISSUE;

CREATE OR REPLACE PROCEDURE REMOVE_ISSUEUPDATE
(
  i_issueUpdateId IN VARCHAR2
)
IS
BEGIN
  DELETE FROM ISSUEUPDATES WHERE issueUpdateId = i_issueUpdateId;
  COMMIT;
END REMOVE_ISSUEUPDATE;

CREATE OR REPLACE PROCEDURE REMOVE_USER
(
  i_userid IN VARCHAR2
)
IS
BEGIN
  DELETE FROM USERS WHERE userid = i_userid;
  COMMIT;
END REMOVE_USER;

create or replace PROCEDURE UPDATE_DEPARTMENT
(
  i_deptId IN NUMBER,
  i_Name IN VARCHAR2
)
IS
BEGIN
  UPDATE DEPARTMENTS SET Name = i_Name where deptId = i_deptId;
  COMMIT;
END UPDATE_DEPARTMENT;

create or replace PROCEDURE UPDATE_ISSUE
(
  i_issueid IN number,
  i_Title IN VARCHAR2,
  i_UserDescription IN VARCHAR2,
  i_AdminComment IN VARCHAR2,
  i_AssignedTo IN number,
  i_SubmittedBy IN number,
  i_StatusId IN number,
  i_priority IN number,
  i_DateSubmitted IN date,
  i_DateResolved IN date,
  i_DeptId IN number
)
IS
BEGIN
  UPDATE ISSUES SET Title = i_Title, UserDescription = i_UserDescription, AdminComment = i_AdminComment, AssignedTo = i_AssignedTo, SubmittedBy = i_SubmittedBy,
  StatusId = i_StatusId, priority = i_priority, DateSubmitted = i_DateSubmitted, DateResolved = i_DateResolved, DeptId = i_DeptId
  where issueid = i_issueid;
  COMMIT;
END UPDATE_ISSUE;

create or replace PROCEDURE UPDATE_ISSUEUPDATE
(
  i_issueUpdateId IN number,
  i_issueId IN VARCHAR2,
  i_SubmittedBy IN VARCHAR2,
  i_UpdateDate IN VARCHAR2,
  i_UpdateComment IN VARCHAR2
)
IS
BEGIN
  UPDATE ISSUEUPDATES SET issueId = i_issueId, SubmittedBy = i_SubmittedBy, UpdateDate = i_UpdateDate, UpdateComment = i_UpdateComment
  where issueUpdateId = i_issueUpdateId;
  COMMIT;
END UPDATE_ISSUEUPDATE;

create or replace PROCEDURE UPDATE_USER
(
  i_userid IN NUMBER,
  i_deptid IN VARCHAR2,
  i_username IN VARCHAR2,
  i_password IN VARCHAR2,
  i_email IN VARCHAR2
)
IS
BEGIN
  UPDATE USERS SET deptid = i_deptid, username = i_username, password = i_password, email = i_email where userid = i_userid;
  COMMIT;
END UPDATE_USER;
