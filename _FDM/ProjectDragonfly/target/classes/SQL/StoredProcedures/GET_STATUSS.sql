CREATE OR REPLACE PROCEDURE GET_STATUSS
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT STATUSID, STATUS FROM STATUSS
	ORDER BY STATUSID;
END GET_STATUSS;