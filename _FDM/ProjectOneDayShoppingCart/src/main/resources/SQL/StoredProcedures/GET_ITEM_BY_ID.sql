create or replace PROCEDURE GET_ITEM_BY_ID
(
  i_id IN number,
  o_id OUT number,
  o_Name OUT VARCHAR2,
  o_Quantity OUT number,
  o_Price OUT number,
  o_Description OUT VARCHAR2
)
IS
BEGIN
	SELECT id, NAME, quantity, price, description
	INTO o_id, o_Name, o_Quantity, o_Price, o_Description
	FROM ITEMS 
	WHERE id = i_id;
END GET_ITEM_BY_ID;