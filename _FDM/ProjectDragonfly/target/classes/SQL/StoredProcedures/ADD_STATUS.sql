CREATE OR REPLACE PROCEDURE ADD_STATUS
(
  i_Name IN VARCHAR2 
)
IS
BEGIN
    INSERT INTO STATUSS(STATUS) 
                VALUES (i_Name);
    COMMIT;
END ADD_STATUS;