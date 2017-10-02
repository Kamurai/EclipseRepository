CREATE OR REPLACE PROCEDURE REMOVE_DEPARTMENT
(
  i_deptId IN NUMBER
)
IS
BEGIN
  DELETE FROM DEPARTMENTS WHERE deptId = i_deptId;
  COMMIT;
END REMOVE_DEPARTMENT;