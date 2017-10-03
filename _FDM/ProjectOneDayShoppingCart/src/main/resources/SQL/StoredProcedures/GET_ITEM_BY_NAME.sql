create or replace PROCEDURE GET_ITEM_BY_NAME
(
  i_Name IN VARCHAR2,
  o_id OUT number,
  o_Name OUT VARCHAR2,
  o_QuantityAvailable OUT number,
  o_Price OUT number,
  o_Description OUT VARCHAR2
)
IS
BEGIN
	SELECT id, NAME, quantityAvailable, price, description
	INTO o_id, o_Name, o_QuantityAvailable, o_Price, o_Description
	FROM ITEMS 
	WHERE NAME = i_Name;
END GET_ITEM_BY_NAME;