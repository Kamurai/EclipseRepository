create or replace PROCEDURE GET_ROLE_BY_ID
(
  i_roleId IN number,
  o_roleId OUT number,
  o_Name OUT VARCHAR2
)
IS
BEGIN
  SELECT roleId, RoleName
  INTO o_roleId, o_Name
  FROM ROLES WHERE roleId = i_roleId;
END GET_ROLE_BY_ID;