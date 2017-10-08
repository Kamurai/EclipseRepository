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