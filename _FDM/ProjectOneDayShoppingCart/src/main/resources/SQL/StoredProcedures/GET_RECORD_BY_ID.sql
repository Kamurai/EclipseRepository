create or replace PROCEDURE GET_RECORD_BY_ID
(
  i_id IN number,
  o_id OUT number,
  o_cartId OUT number,
  o_itemId OUT number,
  o_itemName OUT VARCHAR2,
  o_QuantityAvailable OUT number,
  o_Price OUT number,
  o_Description OUT VARCHAR2,
  o_QuantityRequested OUT number
)
IS
BEGIN
	SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested
	INTO o_id, o_cartId, o_itemId, o_itemName, o_QuantityAvailable, o_Price, o_Description, o_QuantityRequested
	FROM CARTRECORDS
	JOIN ITEMS ON
	CartRecords.itemId = Items.Id
	WHERE CartRecords.id = i_id;
END GET_RECORD_BY_ID;