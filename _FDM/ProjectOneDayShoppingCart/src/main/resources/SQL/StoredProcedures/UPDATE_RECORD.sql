create or replace PROCEDURE UPDATE_RECORD
(
  	i_id IN number,
  	i_cartId IN number,
	i_itemId IN number,
	i_quantityRequested IN number
)
IS
BEGIN
  UPDATE CARTRECORDS SET cartId = i_cartId, itemId = i_itemId, quantityRequested = i_quantityRequested
  where id = i_id;
  COMMIT;
END UPDATE_RECORD;