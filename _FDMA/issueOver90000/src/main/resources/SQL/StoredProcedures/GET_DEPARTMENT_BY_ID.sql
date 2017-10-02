create or replace PROCEDURE GET_DEPARTMENT_BY_ID
(
  i_deptId IN number,
  o_deptId OUT number,
  o_Name OUT VARCHAR2
)
IS
BEGIN
  SELECT deptId, Name
  INTO o_deptId, o_Name
  FROM DEPARTMENTS WHERE deptId = i_deptId;
END GET_DEPARTMENT_BY_ID;