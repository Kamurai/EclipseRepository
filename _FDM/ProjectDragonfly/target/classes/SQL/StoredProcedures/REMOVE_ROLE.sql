CREATE OR REPLACE PROCEDURE REMOVE_ROLE
(
  i_roleId IN NUMBER
)
IS
BEGIN
	DELETE FROM USERROLES WHERE roleId = i_roleId;
 	DELETE FROM ROLES WHERE roleId = i_roleId;
	COMMIT;
END REMOVE_ROLE;