CREATE OR REPLACE PROCEDURE ADD_USERROLE
(
  i_userId IN NUMBER,
  i_roleId IN NUMBER
)
IS
BEGIN
    INSERT INTO USERROLES(userId, roleId) 
                VALUES (i_userId, i_roleId);
    COMMIT;
END ADD_USERROLE;