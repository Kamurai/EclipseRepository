create or replace PROCEDURE UPDATE_USER
(
  i_userid IN NUMBER,
  i_deptid IN NUMBER,
  i_username IN VARCHAR2,
  i_password IN VARCHAR2,
  i_email IN VARCHAR2
)
IS
BEGIN
  UPDATE USERS SET deptid = i_deptid, username = i_username, password = i_password, email = i_email where userid = i_userid;
  COMMIT;
END UPDATE_USER;