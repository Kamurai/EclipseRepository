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