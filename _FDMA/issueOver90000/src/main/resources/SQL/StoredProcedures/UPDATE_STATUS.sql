create or replace PROCEDURE UPDATE_STATUS
(
  i_statusId IN NUMBER,
  i_Name IN VARCHAR2
)
IS
BEGIN
  UPDATE STATUSS SET STATUS = i_Name where statusId = i_statusId;
  COMMIT;
END UPDATE_STATUS;