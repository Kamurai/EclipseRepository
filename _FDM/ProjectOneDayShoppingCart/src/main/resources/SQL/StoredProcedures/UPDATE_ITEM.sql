create or replace PROCEDURE UPDATE_ITEM
(
  i_id IN NUMBER,
  i_name IN VARCHAR2,
  i_quantityAvailable IN NUMBER,
  i_price IN NUMBER,
  i_description IN VARCHAR2
)
IS
BEGIN
  UPDATE USERS SET name = i_name, quantityAvailable = i_quantityAvailable, price = i_price, description = i_description where id = i_id;
  COMMIT;
END UPDATE_ITEM;