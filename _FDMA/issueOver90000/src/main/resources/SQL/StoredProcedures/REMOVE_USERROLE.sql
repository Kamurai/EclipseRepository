CREATE OR REPLACE PROCEDURE REMOVE_USERROLE
(
  i_userId IN NUMBER,
  i_roleId IN NUMBER
)
IS
BEGIN
  DELETE FROM USERROLES WHERE userId = i_userId AND roleId = i_roleId;
  COMMIT;
END REMOVE_USERROLE;