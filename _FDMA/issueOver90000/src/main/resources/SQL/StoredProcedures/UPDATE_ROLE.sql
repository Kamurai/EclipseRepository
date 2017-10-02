create or replace PROCEDURE UPDATE_ROLE
(
  i_roleId IN NUMBER,
  i_Name IN VARCHAR2
)
IS
BEGIN
  UPDATE ROLES SET RoleName = i_Name where roleId = i_roleId;
  COMMIT;
END UPDATE_ROLE;