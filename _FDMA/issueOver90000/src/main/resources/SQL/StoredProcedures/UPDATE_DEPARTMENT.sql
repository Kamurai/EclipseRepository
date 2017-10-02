create or replace PROCEDURE UPDATE_DEPARTMENT
(
  i_deptId IN NUMBER,
  i_Name IN VARCHAR2
)
IS
BEGIN
  UPDATE DEPARTMENTS SET Name = i_Name where deptId = i_deptId;
  COMMIT;
END UPDATE_DEPARTMENT;