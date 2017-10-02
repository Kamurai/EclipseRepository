CREATE OR REPLACE PROCEDURE GET_DEPARTMENTS
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT DEPTID, NAME FROM DEPARTMENTS
	ORDER BY DEPTID;
END GET_DEPARTMENTS;