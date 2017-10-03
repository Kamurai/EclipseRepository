create or replace PROCEDURE GET_RECORDS_BY_CARTID
(
	i_cartId IN number,
  	o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested
	FROM CARTRECORDS
    JOIN ITEMS ON
    CartRecords.itemId = Items.Id
  WHERE CARTRECORDS.cartId = i_cartId
	ORDER BY CARTRECORDS.id;
END GET_RECORDS_BY_CARTID;