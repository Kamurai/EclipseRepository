CREATE OR REPLACE PROCEDURE ADD_RECORD
(
	i_cartId IN number,
	i_itemId IN number,
	i_quantityRequested IN number
)
IS
BEGIN
  INSERT INTO ISSUES(CARTID, ITEMID, QUANTITYREQUESTED) 
  VALUES (i_cartId, i_itemId, i_quantityRequested);
  COMMIT;
END ADD_RECORD;