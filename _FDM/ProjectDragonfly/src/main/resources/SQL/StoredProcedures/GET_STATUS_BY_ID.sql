create or replace PROCEDURE GET_STATUS_BY_ID
(
  i_statusId IN number,
  o_statusId OUT number,
  o_Name OUT VARCHAR2
)
IS
BEGIN
  SELECT statusId, status
  INTO o_statusId, o_Name
  FROM STATUSS WHERE statusId = i_statusId;
END GET_STATUS_BY_ID;