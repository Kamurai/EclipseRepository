create or replace PROCEDURE UPDATE_USERROLE
(
	i_userId IN NUMBER,
	i_roleId IN NUMBER,
	i_NewUserId IN NUMBER,
	i_NewRoleId IN NUMBER
)
IS
BEGIN
  UPDATE USERROLES SET userId = i_NewUserId, roleId = i_NewRoleId where userId = i_userId and roleId = i_roleId;
  COMMIT;
END UPDATE_USERROLE;