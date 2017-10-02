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