CREATE OR REPLACE PROCEDURE GET_APPLES
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT * FROM APPLES;
END GET_APPLES;