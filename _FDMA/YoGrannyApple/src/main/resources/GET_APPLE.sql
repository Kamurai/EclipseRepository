CREATE OR REPLACE PROCEDURE GET_APPLE
(
  i_appleid IN VARCHAR2,
  o_appleid OUT VARCHAR2,
  o_name OUT VARCHAR2,
  o_price OUT VARCHAR2,
  o_picurl OUT VARCHAR2
)
IS
BEGIN
  SELECT appleid, name, price, picurl INTO o_appleid, o_name, o_price, o_picurl FROM APPLES WHERE appleid = i_appleid;
END GET_APPLE;