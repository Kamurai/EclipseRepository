package com.fdmgroup.DAO;



public class DBSetup 
{
	private GenericDAO genericDAO;
	
	public DBSetup()
	{
		genericDAO = new GenericDAO();
	}
	
	public void setupDB()
	{
//Tables, Sequences, Triggers
		String query = ""
				+ "CREATE TABLE items ( "
				+ "    id number NOT NULL, "
				+ "    CONSTRAINT pk_items_id PRIMARY KEY(id), "
				+ "    name varchar2(30) NOT NULL, "
				+ "    CONSTRAINT UNIQUE_ITEMS_NAME UNIQUE (name), "
				+ "    QuantityAvailable NUMBER NOT NULL, "
				+ "    price NUMBER NOT NULL, "
				+ "    DESCRIPTION VARCHAR2(300) NOT NULL "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""		
				+ "CREATE SEQUENCE  \"items_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE";
		genericDAO.stmtExecute(query);
		query = ""				
				+ "CREATE OR REPLACE TRIGGER \"items_TRG\" "
				+ "  BEFORE INSERT ON items "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.id IS NULL THEN "
				+ "        SELECT \"items_SEQ\".NEXTVAL INTO :NEW.id FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END; ";
		genericDAO.stmtExecute(query);
		query = ""				
				+ " CREATE TABLE CartRecords ( "
				+ "    id number, "
				+ "    CONSTRAINT pk_CartRecords_id PRIMARY KEY(id), "
				+ "    cartId number NOT NULL, "
				+ "    itemId number NOT NULL, "
				+ "    CONSTRAINT fk_CartRecords_itemId FOREIGN KEY(itemId) REFERENCES items(id), "
				+ "    quantityRequested number NOT NULL "
				+ "  ) ";
		genericDAO.stmtExecute(query);		
		query = ""				
				+ "  CREATE SEQUENCE  \"CartRecords_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ";
		genericDAO.stmtExecute(query);		
		query = ""				
				+ "  CREATE OR REPLACE TRIGGER \"CartRecords_TRG\" "
				+ "  BEFORE INSERT ON CartRecords "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.id IS NULL THEN "
				+ "        SELECT \"CartRecords_SEQ\".NEXTVAL INTO :NEW.id FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END; ";
		genericDAO.stmtExecute(query);
//Stored Procedures
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_ITEM "
				+ "( "
				+ "  i_name IN VARCHAR2, "
				+ "  i_quantityAvailable IN NUMBER, "
				+ "  i_price IN NUMBER, "
				+ "  i_description IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO ITEMS(NAME, quantityAvailable, PRICE, DESCRIPTION) "
				+ "                VALUES (i_name, i_quantityAvailable, i_price, i_description); "
				+ "    COMMIT; "
				+ "END ADD_ITEM;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_RECORD "
				+ "( "
				+ "	i_cartId IN number, "
				+ "	i_itemId IN number, "
				+ "	i_quantityRequested IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  INSERT INTO CARTRECORDS(CARTID, ITEMID, QUANTITYREQUESTED) "
				+ "  VALUES (i_cartId, i_itemId, i_quantityRequested); "
				+ "  COMMIT; "
				+ "END ADD_RECORD;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ITEM_BY_ID "
				+ "( "
				+ "  i_id IN number, "
				+ "  o_id OUT number, "
				+ "  o_Name OUT VARCHAR2, "
				+ "  o_QuantityAvailable OUT number, "
				+ "  o_Price OUT number, "
				+ "  o_Description OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT id, NAME, quantityAvailable, price, description "
				+ "	INTO o_id, o_Name, o_QuantityAvailable, o_Price, o_Description "
				+ "	FROM ITEMS "
				+ "	WHERE id = i_id; "
				+ "END GET_ITEM_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ITEM_BY_NAME "
				+ "( "
				+ "  i_Name IN VARCHAR2, "
				+ "  o_id OUT number, "
				+ "  o_Name OUT VARCHAR2, "
				+ "  o_QuantityAvailable OUT number, "
				+ "  o_Price OUT number, "
				+ "  o_Description OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT id, NAME, quantityAvailable, price, description "
				+ "	INTO o_id, o_Name, o_QuantityAvailable, o_Price, o_Description "
				+ "	FROM ITEMS "
				+ "	WHERE Name = i_Name; "
				+ "END GET_ITEM_BY_NAME;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_ITEMS "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT id, NAME, quantityAvailable, price, description "
				+ "	FROM ITEMS "
				+ "	ORDER BY ID; "
				+ "END GET_ITEMS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_RECORD_BY_ID "
				+ "( "
				+ "  i_id IN number, "
				+ "  o_id OUT number, "
				+ "  o_cartId OUT number, "
				+ "  o_itemId OUT number, "
				+ "  o_itemName OUT VARCHAR2, "
				+ "  o_QuantityAvailable OUT number, "
				+ "  o_Price OUT number, "
				+ "  o_Description OUT VARCHAR2, "
				+ "  o_QuantityRequested OUT number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested "
				+ "	INTO o_id, o_cartId, o_itemId, o_itemName, o_QuantityAvailable, o_Price, o_Description, o_QuantityRequested "
				+ "	FROM CARTRECORDS "
				+ "	JOIN ITEMS ON "
				+ "	CartRecords.itemId = Items.Id "
				+ "	WHERE CartRecords.id = i_id; "
				+ "END GET_RECORD_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_RECORDS_BY_CARTID "
				+ "( "
				+ "  i_cartId IN number, "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested "
				+ "	FROM CARTRECORDS "
				+ "    JOIN ITEMS ON "
				+ "    CartRecords.itemId = Items.Id "
				+ "  WHERE CartRecords.cartId = i_cartId "
				+ "	ORDER BY CartRecords.id; "
				+ "END GET_RECORDS_BY_CARTID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_RECORDS "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested "
				+ "	FROM CARTRECORDS "
				+ "    JOIN ITEMS ON "
				+ "    CartRecords.itemId = Items.Id "
				+ "	ORDER BY CartRecords.id; "
				+ "END GET_RECORDS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_ITEM "
				+ "( "
				+ "  i_id IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	DELETE FROM ITEMS WHERE id = i_id; "
				+ "  	COMMIT; "
				+ "END REMOVE_ITEM;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_RECORD "
				+ "( "
				+ "  i_id IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	DELETE FROM CARTRECORDS WHERE id = i_id; "
				+ "	COMMIT; "
				+ "END REMOVE_RECORD;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_RECORDS_BY_CARTID "
				+ "( "
				+ "  i_cartId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	DELETE FROM CARTRECORDS WHERE cartId = i_cartId; "
				+ "	COMMIT; "
				+ "END REMOVE_RECORDS_BY_CARTID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_ITEM "
				+ "( "
				+ "  i_id IN NUMBER, "
				+ "  i_name IN VARCHAR2, "
				+ "  i_quantityAvailable IN NUMBER, "
				+ "  i_price IN NUMBER, "
				+ "  i_description IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE ITEMS SET name = i_name, quantityAvailable = i_quantityAvailable, price = i_price, description = i_description where id = i_id; "
				+ "  COMMIT; "
				+ "END UPDATE_ITEM;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_RECORD "
				+ "( "
				+ "  i_id IN number, "
				+ "  i_cartId IN number, "
				+ "	i_itemId IN number, "
				+ "	i_quantityRequested IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE CARTRECORDS SET cartId = i_cartId, itemId = i_itemId, quantityRequested = i_quantityRequested "
				+ "  where id = i_id; "
				+ "  COMMIT; "
				+ "END UPDATE_RECORD;";
		genericDAO.stmtExecute(query);
		
		query = "commit";
		genericDAO.stmtExecute(query);
	}
	
	public void stubDB()
	{
		String query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Cucumber', 50, 10.00, 'Great for pickling.  Guaranteed long and thick.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Carrot', 150, 5.00, 'Sweet and tasty.  Firm and hearty.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Eggplant', 5, 20.00, 'Best product we carry.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Banana', 2000, 1.00, 'Sold still green. Aimed to last.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Butternut Squash', 5000, 0.50, 'Does no one love the squash?  Do you?' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Yam', 10000, 0.05, 'Yam it up over here.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Zucchini', 200, 7.50, 'A lighter, sweet version of the cucumber.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Turnip', 2500, 0.25, 'Firm and tasty tubers.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Broccoli', 2000, 1.00, 'The unexpected treat.' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO items(NAME, QUANTITYAVAILABLE, PRICE, DESCRIPTION) VALUES( 'Monstera Deliciosa', 5, 150.00, 'Delicious, but deadly.' )";
			genericDAO.stmtExecute(query);
		
			query = "commit";
			genericDAO.stmtExecute(query);
	}
	
	public void tearDownDB()
	{
//Tables
		String query = "";
		query += "drop table CartRecords";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"CartRecords_SEQ\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table items";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"items_SEQ\"";
		genericDAO.stmtExecute(query);
//Stored Procedures
		query = ""
				+ "drop PROCEDURE \"ADD_RECORD\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"GET_RECORD_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"GET_RECORDS\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"GET_RECORDS_BY_CARTID\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"REMOVE_RECORD\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"REMOVE_RECORDS_BY_CARTID\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"UPDATE_RECORD\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"ADD_ITEM\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"GET_ITEM_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"GET_ITEMS\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"REMOVE_ITEM\"";
		genericDAO.stmtExecute(query);
		query = ""
				+ "drop PROCEDURE \"UPDATE_ITEM\"";
		genericDAO.stmtExecute(query);
		
		query = "commit";
		genericDAO.stmtExecute(query);
	}
	
}
