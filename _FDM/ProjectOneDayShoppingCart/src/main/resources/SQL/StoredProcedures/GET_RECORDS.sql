create or replace PROCEDURE GET_RECORDS
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested
	FROM CARTRECORDS
    JOIN ITEMS ON
    CartRecords.itemId = Items.Id
	ORDER BY id;
END GET_RECORDS;