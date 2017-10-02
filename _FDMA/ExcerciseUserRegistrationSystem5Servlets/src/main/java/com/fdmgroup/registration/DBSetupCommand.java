package com.fdmgroup.registration;

public class DBSetupCommand {
	private TableDAO tableDAO = new TableDAO();
	private LoggingObject loggingObject = new LoggingObject();

	public DBSetupCommand() {
		setUpDB();
	}

	public void setUpDB() {
		createUserTable();
		createBasicUsers();
		createStoredProcedures();
	}

	public void tearDownDB() {
		dropUserTable();
		dropStoredProcedures();
	}

	public void createUserTable() {
		// create user table
		String query = "CREATE TABLE Users (";
		query += "username varchar2(255),";
		query += "password varchar2(255),";
		query += "role varchar2(255)";
		query += ")";

		tableDAO.stmtExecute(query);

		commitToDB();
	}

	public void createBasicUsers() {
		// create Basic Users
		String query = "insert into Users values ('Peter.Parker',  'Felicia', 'Spiderman' )";
		tableDAO.stmtExecuteUpdate(query);
		query = "insert into Users values ('Steve.Rogers',  'Peggy',   'Captain America' )";
		tableDAO.stmtExecuteUpdate(query);
		query = "insert into Users values ('Scott.Lang',    'Cassie',  'Antman' )";
		tableDAO.stmtExecuteUpdate(query);
		query = "insert into Users values ('Matt.Murdock',  'Electra', 'Daredevil' )";
		tableDAO.stmtExecuteUpdate(query);
		query = "insert into Users values ('Tony.Stark',    'Pepper',  'Iron Man' )";
		tableDAO.stmtExecuteUpdate(query);
		query = "insert into Users values ('Rhodey.Rhodes', 'Tony',    'War Machine' )";
		tableDAO.stmtExecuteUpdate(query);

		commitToDB();
	}

	public void createStoredProcedures() {
		// create Stored Procedures
		// get Add User Stored Procedure
		String query = getAddUserStoredProcedure();
		tableDAO.stmtExecute(query);

		query = getUpdateUserStoredProcedure();
		tableDAO.stmtExecute(query);
		
		query = getRemoveUserStoredProcedure();
		tableDAO.stmtExecute(query);

		commitToDB();
	}

	public String getAddUserStoredProcedure() {
		String query = "CREATE OR REPLACE PROCEDURE ADD_USER ";
		query += "( ";
		query += "i_username IN VARCHAR2, ";
		query += "i_password IN VARCHAR2, ";
		query += "i_role IN VARCHAR2 ";
		query += ") ";
		query += "IS ";
		query += "BEGIN ";
		query += "insert into Users values ( i_username, i_password, i_role ) ";
		query += "COMMIT ";
		query += "END ";

		return query;
	}

	public String getUpdateUserStoredProcedure() {
		String query = "CREATE OR REPLACE PROCEDURE UPDATE_USER ";
		query += "( ";
		query += "i_username IN VARCHAR2, ";
		query += "i_password IN VARCHAR2, ";
		query += "i_role IN VARCHAR2 ";
		query += ") ";
		query += "IS ";
		query += "BEGIN ";
		query += "UPDATE USERS SET USER_ID = i_uid, PASSWORD = i_password, ROLE = i_role where username = i_username ";
		query += "COMMIT ";
		query += "END ";

		return query;
	}

	public String getRemoveUserStoredProcedure() {
		String query = "CREATE OR REPLACE PROCEDURE REMOVE_USER ";
		query += "( ";
		query += "i_username IN VARCHAR2 ";
		query += ") ";
		query += "IS ";
		query += "BEGIN ";
		query += "DELETE FROM USERS WHERE USERNAME = i_username ";
		query += "COMMIT ";
		query += "END ";

		return query;
	}

	public void dropUserTable() {
		// drop Users table
		String query = "DROP TABLE Users";

		tableDAO.stmtExecute(query);

		commitToDB();
	}

	public void dropStoredProcedures() {
		// drop stored procedures drop procedure remove_user;
		String query = "DROP procedure add_user";
		tableDAO.stmtExecute(query);
		query = "DROP procedure update_user";
		tableDAO.stmtExecute(query);
		query = "DROP procedure remove_user";
		tableDAO.stmtExecute(query);
		
		commitToDB();
	}

	public void commitToDB() {
		String query = "commit";
		tableDAO.stmtExecuteUpdate(query);
	}

}