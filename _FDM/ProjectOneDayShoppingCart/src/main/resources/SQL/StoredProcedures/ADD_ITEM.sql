CREATE OR REPLACE PROCEDURE ADD_ITEM
(
  i_name IN VARCHAR2,
  i_quantityAvailable IN NUMBER,
  i_price IN NUMBER,
  i_description IN VARCHAR2
)
IS
BEGIN
    INSERT INTO USERS(NAME, quantityAvailable, PRICE, DESCRIPTION) 
                VALUES (i_name, i_quantityAvailable, i_price, i_description);
    COMMIT;
END ADD_ITEM;