CREATE OR REPLACE PROCEDURE GET_ITEMS
(
  o_recordset OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN o_recordset FOR
    SELECT id, NAME, quantity, price, description
	FROM ITEMS 
	ORDER BY ID;
END GET_ITEMS;