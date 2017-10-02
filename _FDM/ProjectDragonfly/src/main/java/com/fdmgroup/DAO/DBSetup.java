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
				+ "CREATE TABLE departments ( "
				+ "    deptid number NOT NULL, "
				+ "    CONSTRAINT pk_departments_deptid PRIMARY KEY(deptid), "
				+ "    name varchar2(30) NOT NULL "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""				
				+ "CREATE SEQUENCE  \"departments_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"departments_TRG\" "
				+ "  BEFORE INSERT ON departments "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.deptid IS NULL THEN "
				+ "        SELECT \"departments_SEQ\".NEXTVAL INTO :NEW.deptid FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE TABLE roles ( "
				+ "    roleid number, "
				+ "    CONSTRAINT pk_roles_roleid PRIMARY KEY(roleid), "
				+ "    rolename varchar2(30) NOT NULL "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE SEQUENCE  \"roles_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"roles_TRG\" "
				+ "  BEFORE INSERT ON roles "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.roleid IS NULL THEN "
				+ "        SELECT \"roles_SEQ\".NEXTVAL INTO :NEW.roleid FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "  CREATE TABLE users ( "
				+ "    userid number, "
				+ "    CONSTRAINT pk_users_userid PRIMARY KEY (userid), "
				+ "    deptid number NOT NULL, "
				+ "    CONSTRAINT fk_users_deptid FOREIGN KEY(deptid) REFERENCES departments(deptid), "
				+ "    username varchar2(30) NOT NULL, "
				+ "    CONSTRAINT UNIQUE_USERS_USERNAME UNIQUE (USERNAME), "			    
				+ "    password varchar2(30) NOT NULL, "
				+ "    email varchar2(50) NOT NULL "
				+ "  ) ";
		genericDAO.stmtExecute(query);
		query = ""
				+ "  CREATE SEQUENCE  \"USERS_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"USERS_TRG\" "
				+ "  BEFORE INSERT ON USERS "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.USERID IS NULL THEN "
				+ "        SELECT \"USERS_SEQ\".NEXTVAL INTO :NEW.USERID FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE TABLE userroles ( "
				+ "    userid number NOT NULL, "
				+ "    CONSTRAINT fk_userroles_userid FOREIGN KEY(userid) REFERENCES users(userid), "
				+ "    roleid number NOT NULL, "
				+ "    CONSTRAINT fk_userroles_roleid FOREIGN KEY(roleid) REFERENCES roles(roleid) "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"USERS_USERROLES_TRG\" "
				+ "  AFTER INSERT ON USERS "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    INSERT INTO USERROLES VALUES (\"USERS_SEQ\".CURRVAL, 0); "
				+ "  END;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE TABLE statuss ( "
				+ "    statusid number, "
				+ "    CONSTRAINT pk_statuss_statusid PRIMARY KEY(statusid), "
				+ "    status varchar2(30) NOT NULL "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE SEQUENCE  \"statuss_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"statuss_TRG\" "
				+ "  BEFORE INSERT ON statuss "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.statusid IS NULL THEN "
				+ "        SELECT \"statuss_SEQ\".NEXTVAL INTO :NEW.statusid FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE TABLE issues ( "
				+ "    issueid number CONSTRAINT pk_issues_issueid PRIMARY KEY, "
				+ "    Title varchar2(30) NOT NULL, "
				+ "    CONSTRAINT UNIQUE_ISSUES_TITLE UNIQUE (TITLE), "			    
				+ "    UserDescription varchar2(300) NOT NULL, "
				+ "    AdminComment varchar2(300), "
				+ "    AssignedTo number, "
				+ "    CONSTRAINT fk_issues_AssignedTo FOREIGN KEY(AssignedTo) REFERENCES users(userid), "
				+ "    SubmittedBy number NOT NULL, "
				+ "    CONSTRAINT fk_issues_SubmittedBy FOREIGN KEY(SubmittedBy) REFERENCES users(userid), "
				+ "    StatusId number NOT NULL, "
				+ "    CONSTRAINT fk_issues_StatusId FOREIGN KEY(StatusId) REFERENCES statuss(StatusId), "
				+ "    priority number NOT NULL, "
				+ "    DateSubmitted date NOT NULL, "
				+ "    DateResolved date, "
				+ "    DeptId number NOT NULL, "
				+ "    CONSTRAINT fk_issues_DeptId FOREIGN KEY(DeptId) REFERENCES departments(deptid) "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE SEQUENCE  \"issues_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"issues_TRG\" "
				+ "  BEFORE INSERT ON issues "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.issueid IS NULL THEN "
				+ "        SELECT \"issues_SEQ\".NEXTVAL INTO :NEW.issueid FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE TABLE issueupdates ( "
				+ "    issueupdateid number, "
				+ "    CONSTRAINT pk_issueupdates_issueupdateid PRIMARY KEY(issueupdateid), "
				+ "    issueid number, "
				+ "    CONSTRAINT fk_issueupdates_issueid FOREIGN KEY(issueid) REFERENCES issues(issueid), "
				+ "    submittedby number NOT NULL, "
				+ "    CONSTRAINT fk_issueupdates_submittedby FOREIGN KEY(submittedby) REFERENCES users(userid), "
				+ "    updateDate date NOT NULL, "
				+ "    updateComment varchar2(300) NOT NULL "
				+ "  )";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE SEQUENCE  \"issueupdates_SEQ\"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE TRIGGER \"issueupdates_TRG\" "
				+ "  BEFORE INSERT ON issueupdates "
				+ "  FOR EACH ROW "
				+ "  BEGIN "
				+ "    <<COLUMN_SEQUENCES>> "
				+ "    BEGIN "
				+ "      IF INSERTING AND :NEW.issueupdateid IS NULL THEN "
				+ "        SELECT \"issueupdates_SEQ\".NEXTVAL INTO :NEW.issueupdateid FROM SYS.DUAL; "
				+ "      END IF; "
				+ "    END COLUMN_SEQUENCES; "
				+ "  END;";
		genericDAO.stmtExecute(query);
//Stored Procedures
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_DEPARTMENT "
				+ "( "
				+ "  i_Name IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO DEPARTMENTS(NAME) "
				+ "                VALUES (i_Name); "
				+ "    COMMIT; "
				+ "END ADD_DEPARTMENT;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_ISSUE "
				+ "( "
				+ "  i_title IN VARCHAR2, "
				+ "  i_userdescription IN VARCHAR2, "
				+ "  i_submittedby IN number, "
				+ "  i_statusid IN number, "
				+ "  i_priority IN number, "
				+ "  i_datesubmitted IN date, "
				+ "  i_deptid IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) "
				+ "    VALUES (i_title, i_userdescription, i_submittedby, i_statusid, i_priority, i_datesubmitted, i_deptid); "
				+ "    COMMIT; "
				+ "END ADD_ISSUE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_ISSUEUPDATE "
				+ "( "
				+ "  i_issueId IN number, "
				+ "  i_submittedby IN number, "
				+ "  i_updateDate IN date, "
				+ "  i_updateComment IN varchar "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) "
				+ "    VALUES (i_issueId, i_submittedby, i_updateDate, i_updateComment); "
				+ "    COMMIT; "
				+ "END ADD_ISSUEUPDATE;";
		genericDAO.stmtExecute(query);
		query = ""+ "CREATE OR REPLACE PROCEDURE ADD_ROLE "
				+ "( "
				+ "  i_Name IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO ROLES(ROLENAME) "
				+ "                VALUES (i_Name); "
				+ "    COMMIT; "
				+ "END ADD_ROLE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_STATUS "
				+ "( "
				+ "  i_Name IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO STATUSS(STATUS) "
				+ "                VALUES (i_Name); "
				+ "    COMMIT; "
				+ "END ADD_STATUS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_USER "
				+ "( "
				+ "  i_deptid IN NUMBER, "
				+ "  i_username IN VARCHAR2, "
				+ "  i_password IN VARCHAR2, "
				+ "  i_email IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) "
				+ "                VALUES (i_deptid, i_username, i_password, i_email); "
				+ "    COMMIT; "
				+ "END ADD_USER;";		
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE ADD_USERROLE "
				+ "( "
				+ "  i_userId IN NUMBER, "
				+ "  i_roleId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "    INSERT INTO USERROLES(userId, roleId) "
				+ "                VALUES (i_userId, i_roleId); "
				+ "    COMMIT; "
				+ "END ADD_USERROLE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_DEPARTMENT_BY_ID "
				+ "( "
				+ "  i_deptId IN number, "
				+ "  o_deptId OUT number, "
				+ "  o_Name OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  SELECT deptId, Name "
				+ "  INTO o_deptId, o_Name "
				+ "  FROM DEPARTMENTS WHERE deptId = i_deptId; "
				+ "END GET_DEPARTMENT_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_DEPARTMENTS "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT DEPTID, NAME FROM DEPARTMENTS "
				+ "	ORDER BY DEPTID; "
				+ "END GET_DEPARTMENTS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUE_BY_ID "
				+ "( "
				+ "  i_issueid IN number, "
				+ "  o_issueid OUT number, "
				+ "  o_Title OUT VARCHAR2, "
				+ "  o_UserDescription OUT VARCHAR2, "
				+ "  o_AdminComment OUT VARCHAR2, "
				+ "  o_AssignedTo OUT number, "
				+ "  o_AssignedUsername OUT VARCHAR2, "
				+ "  o_SubmittedBy OUT number, "
				+ "  o_SubmittedByUsername OUT VARCHAR2, "
				+ "  o_StatusId OUT number, "
				+ "  o_Status OUT VARCHAR2, "
				+ "  o_priority OUT number, "
				+ "  o_DateSubmitted OUT date, "
				+ "  o_DateResolved OUT date, "
				+ "  o_DeptId OUT number, "
				+ "  o_DeptName OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "	INTO o_issueid, o_Title, o_UserDescription, o_AdminComment, o_AssignedTo, o_AssignedUsername, o_SubmittedBy, o_SubmittedByUsername, o_StatusId, o_Status, o_priority, o_DateSubmitted, o_DateResolved, o_DeptId, o_DeptName "
				+ "	FROM ISSUES iss "
				+ "	JOIN STATUSS stats ON "
				+ "	iss.statusId = stats.statusId "
				+ "	JOIN DEPARTMENTS DEP ON "
				+ "	iss.DeptId = dep.DeptId "
				+ "	JOIN USERS subUser ON "
				+ "	SUBMITTEDBY = subUser.USERID "
				+ "	JOIN USERS assUser ON "
				+ "	ASSIGNEDTO = assUser.USERID "
				+ "	WHERE issueid = i_issueid; "
				+ "END GET_ISSUE_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUE_BY_TITLE "
				+ "( "
				+ "  i_Title IN VARCHAR2, "
				+ "  o_issueid OUT number, "
				+ "  o_Title OUT VARCHAR2, "
				+ "  o_UserDescription OUT VARCHAR2, "
				+ "  o_AdminComment OUT VARCHAR2, "
				+ "  o_AssignedTo OUT number, "
				+ "  o_AssignedUsername OUT VARCHAR2, "
				+ "  o_SubmittedBy OUT number, "
				+ "  o_SubmittedByUsername OUT VARCHAR2, "
				+ "  o_StatusId OUT number, "
				+ "  o_Status OUT VARCHAR2, "
				+ "  o_priority OUT number, "
				+ "  o_DateSubmitted OUT date, "
				+ "  o_DateResolved OUT date, "
				+ "  o_DeptId OUT number, "
				+ "  o_DeptName OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "	INTO o_issueid, o_Title, o_UserDescription, o_AdminComment, o_AssignedTo, o_AssignedUsername, o_SubmittedBy, o_SubmittedByUsername, o_StatusId, o_Status, o_priority, o_DateSubmitted, o_DateResolved, o_DeptId, o_DeptName "
				+ "	FROM ISSUES iss "
				+ "	JOIN STATUSS stats ON "
				+ "	iss.statusId = stats.statusId "
				+ "	JOIN DEPARTMENTS DEP ON "
				+ "	iss.DeptId = dep.DeptId "
				+ "	JOIN USERS subUser ON "
				+ "	SUBMITTEDBY = subUser.USERID "
				+ "	JOIN USERS assUser ON "
				+ "	ASSIGNEDTO = assUser.USERID "
				+ "	WHERE Title = i_Title; "
				+ "END GET_ISSUE_BY_TITLE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUES_BY_ASSIGNEDTO "
				+ "( "
				+ "	i_AssignedTo IN number, "
				+ "	o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  if i_AssignedTo IS NULL THEN "
				+ "    OPEN o_recordset FOR "
				+ "      SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "    FROM ISSUES iss "
				+ "    JOIN STATUSS stats ON "
				+ "    iss.statusId = stats.statusId "
				+ "    JOIN DEPARTMENTS DEP ON "
				+ "    iss.DeptId = dep.DeptId "
				+ "    JOIN USERS subUser ON "
				+ "    SUBMITTEDBY = subUser.USERID "
				+ "    JOIN USERS assUser ON "
				+ "    ASSIGNEDTO = assUser.USERID "
				+ "    where ASSIGNEDTO IS NULL "
				+ "	ORDER BY ISSUEID; "
				+ "	else "
				+ "		OPEN o_recordset FOR "
				+ "      SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "    FROM ISSUES iss "
				+ "    JOIN STATUSS stats ON "
				+ "    iss.statusId = stats.statusId "
				+ "    JOIN DEPARTMENTS DEP ON "
				+ "    iss.DeptId = dep.DeptId "
				+ "    JOIN USERS subUser ON "
				+ "    SUBMITTEDBY = subUser.USERID "
				+ "    JOIN USERS assUser ON "
				+ "    ASSIGNEDTO = assUser.USERID "
				+ "    where ASSIGNEDTO = i_AssignedTo "
				+ "	ORDER BY ISSUEID; "
				+ "	end if; "
				+ "	 "
				+ "END GET_ISSUES_BY_ASSIGNEDTO;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUES_BY_SUBMITTEDBY "
				+ "( "
				+ "	i_SubmittedBy IN number, "
				+ "	o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "	FROM ISSUES iss "
				+ "	JOIN STATUSS stats ON "
				+ "	iss.statusId = stats.statusId "
				+ " JOIN DEPARTMENTS DEP ON "
				+ " iss.DeptId = dep.DeptId "
				+ "	JOIN USERS subUser ON "
				+ "	SUBMITTEDBY = subUser.USERID "
				+ "	JOIN USERS assUser ON "
				+ "	ASSIGNEDTO = assUser.USERID "
				+ "	where SubmittedBy = i_SubmittedBy "
				+ "	ORDER BY ISSUEID; "
				+ "END GET_ISSUES_BY_SUBMITTEDBY;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUES_UNASSIGNED "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "	FROM ISSUES iss "
				+ "	JOIN STATUSS stats ON "
				+ "	iss.statusId = stats.statusId "
				+ " JOIN DEPARTMENTS DEP ON "
				+ " iss.DeptId = dep.DeptId "
				+ "	JOIN USERS subUser ON "
				+ "	SUBMITTEDBY = subUser.USERID "
				+ "	JOIN USERS assUser ON "
				+ "	ASSIGNEDTO = assUser.USERID "
				+ "	where ASSIGNEDTO IS NULL "
				+ "	ORDER BY ISSUEID; "
				+ "END GET_ISSUES_UNASSIGNED;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUES "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT issueId, title, userDescription, adminComment, assignedTo, assUser.username, submittedBy, subUser.Username, iss.statusId, Status, Priority, dateSubmitted, dateResolved, iss.deptid, dep.Name "
				+ "	FROM ISSUES iss "
				+ "    JOIN STATUSS stats ON "
				+ "    iss.statusId = stats.statusId "
				+ "    JOIN DEPARTMENTS DEP ON "
				+ "    iss.DeptId = dep.DeptId "
				+ "    JOIN USERS subUser ON "
				+ "    SUBMITTEDBY = subUser.USERID "
				+ "    JOIN USERS assUser ON "
				+ "    ASSIGNEDTO = assUser.USERID "
				+ "	ORDER BY ISSUEID; "
				+ "END GET_ISSUES;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUEUPDATE_BY_ID "
				+ "( "
				+ "	i_issueUpdateId IN number, "
				+ "	o_issueUpdateId OUT number, "
				+ "	o_issueid OUT number, "
				+ "	o_SubmittedBy OUT number, "
				+ "	o_SubmittedByUsername OUT VARCHAR2, "
				+ "	o_UpdateDate OUT date, "
				+ "	o_UpdateComment OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT issueUpdateId, issueid, SubmittedBy, USERNAME, UpdateDate, UpdateComment "
				+ "	INTO o_issueUpdateId, o_issueid, o_SubmittedBy, o_SubmittedByUsername, o_UpdateDate, o_UpdateComment "
				+ "	FROM ISSUEUPDATES "
				+ "	JOIN USERS ON "
				+ "	SUBMITTEDBY = USERID "
				+ "	WHERE issueUpdateId = i_issueUpdateId; "
				+ "END GET_ISSUEUPDATE_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUEUPDATES_BY_ISSUEID "
				+ "( "
				+ "  i_issueId IN NUMBER, "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT ISSUEUPDATEID, ISSUEID, SUBMITTEDBY, USERNAME, UPDATEDATE, UPDATECOMMENT "
				+ "	FROM ISSUEUPDATES "
				+ "	JOIN USERS ON "
				+ "	SUBMITTEDBY = USERID "
				+ "	where ISSUEID = i_issueId; "
				+ "END GET_ISSUEUPDATES_BY_ISSUEID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ISSUEUPDATES "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT ISSUEUPDATEID, ISSUEID, SUBMITTEDBY, USERNAME, UPDATEDATE, UPDATECOMMENT "
				+ "	FROM ISSUEUPDATES "
				+ "	JOIN USERS ON "
				+ "	SUBMITTEDBY = USERID "
				+ "	ORDER BY ISSUEID, ISSUEUPDATEID; "
				+ "END GET_ISSUEUPDATES;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_ROLE_BY_ID "
				+ "( "
				+ "  i_roleId IN number, "
				+ "  o_roleId OUT number, "
				+ "  o_Name OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  SELECT roleId, RoleName "
				+ "  INTO o_roleId, o_Name "
				+ "  FROM ROLES WHERE roleId = i_roleId; "
				+ "END GET_ROLE_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_ROLES_BY_USERID "
				+ "( "
				+ "	i_userId IN number, "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT ROL.ROLEID, ROL.ROLENAME "
				+ "	FROM ROLES ROL "
				+ "	JOIN USERROLES UR ON "
				+ "	UR.ROLEID = ROL.ROLEID "
				+ "	JOIN USERS US ON "
				+ "	UR.USERID = US.USERID "
				+ "	where US.USERID = i_userId "
				+ "	ORDER BY ROL.ROLEID; "
				+ "END GET_ROLES_BY_USERID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_ROLES "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT ROLEID, ROLENAME FROM ROLES "
				+ "	ORDER BY ROLEID; "
				+ "END GET_ROLES;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_STATUS_BY_ID "
				+ "( "
				+ "  i_statusId IN number, "
				+ "  o_statusId OUT number, "
				+ "  o_Name OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  SELECT statusId, status "
				+ "  INTO o_statusId, o_Name "
				+ "  FROM STATUSS WHERE statusId = i_statusId; "
				+ "END GET_STATUS_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_STATUSS "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT STATUSID, STATUS FROM STATUSS "
				+ "	ORDER BY STATUSID; "
				+ "END GET_STATUSS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_USER_BY_ID "
				+ "( "
				+ "  i_userid IN number, "
				+ "  o_userid OUT number, "
				+ "  o_deptid OUT number, "
				+ "  o_deptName OUT VARCHAR2, "
				+ "  o_username OUT VARCHAR2, "
				+ "  o_password OUT VARCHAR2, "
				+ "  o_email OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT userid, USERS.DEPTID, DEPT.NAME, username, password, email "
				+ "	INTO o_userid, o_deptid, o_deptName, o_username, o_password, o_email "
				+ "	FROM USERS "
				+ "	JOIN DEPARTMENTS DEPT ON "
				+ "	USERS.DEPTID = DEPT.DEPTID "
				+ "	WHERE userid = i_userid; "
				+ "END GET_USER_BY_ID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE GET_USER_BY_USERNAME "
				+ "( "
				+ "  i_username IN VARCHAR2, "
				+ "  o_userid OUT number, "
				+ "  o_deptid OUT number, "
				+ "  o_deptName OUT VARCHAR2, "
				+ "  o_username OUT VARCHAR2, "
				+ "  o_password OUT VARCHAR2, "
				+ "  o_email OUT VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	SELECT userid, USERS.DEPTID, DEPT.NAME, username, password, email "
				+ "	INTO o_userid, o_deptid, o_deptName, o_username, o_password, o_email "
				+ "	FROM USERS "
				+ "	JOIN DEPARTMENTS DEPT ON "
				+ "	USERS.DEPTID = DEPT.DEPTID "
				+ "	WHERE username = i_username; "
				+ "END GET_USER_BY_USERNAME;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_USERROLES "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	OPEN o_recordset FOR "
				+ "    SELECT userId, roleId FROM USERROLES "
				+ "	ORDER BY userId, roleId; "
				+ "END GET_USERROLES;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE GET_USERS "
				+ "( "
				+ "  o_recordset OUT SYS_REFCURSOR "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  OPEN o_recordset FOR "
				+ "    SELECT USERID, USERS.DEPTID, DEPT.NAME, USERNAME, PASSWORD, EMAIL FROM USERS "
				+ "	JOIN DEPARTMENTS DEPT ON "
				+ "	USERS.DEPTID = DEPT.DEPTID "
				+ "	ORDER BY USERID; "
				+ "END GET_USERS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_DEPARTMENT "
				+ "( "
				+ "  i_deptId IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  DELETE FROM DEPARTMENTS WHERE deptId = i_deptId; "
				+ "  COMMIT; "
				+ "END REMOVE_DEPARTMENT;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_ISSUE "
				+ "( "
				+ "  i_issueid IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  DELETE FROM ISSUEUPDATES WHERE issueId = i_issueId; "
				+ "  DELETE FROM ISSUES WHERE issueid = i_issueid; "
				+ "  COMMIT; "
				+ "END REMOVE_ISSUE;";		
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_ISSUEUPDATE_BY_ISSUEID "
				+ "( "
				+ "  i_issueId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  DELETE FROM ISSUEUPDATES WHERE issueId = i_issueId; "
				+ "   "
				+ "  COMMIT; "
				+ "END REMOVE_ISSUEUPDATE_BY_ISSUEID;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_ISSUEUPDATE "
				+ "( "
				+ "  i_issueUpdateId IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  DELETE FROM ISSUEUPDATES WHERE issueUpdateId = i_issueUpdateId; "
				+ "  COMMIT; "
				+ "END REMOVE_ISSUEUPDATE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_ROLE "
				+ "( "
				+ "  i_roleId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	DELETE FROM USERROLES WHERE roleId = i_roleId; "
				+ " 	DELETE FROM ROLES WHERE roleId = i_roleId; "
				+ "	COMMIT; "
				+ "END REMOVE_ROLE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_STATUS "
				+ "( "
				+ "  i_statusId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "	DELETE FROM STATUSS WHERE statusId = i_statusId; "
				+ "	COMMIT; "
				+ "END REMOVE_STATUS;";		
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_USER "
				+ "( "
				+ "  i_userid IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  DELETE FROM USERROLES WHERE userid = i_userid; "
				+ "  DELETE FROM USERS WHERE userid = i_userid; "
				+ "  COMMIT; "
				+ "END REMOVE_USER;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "CREATE OR REPLACE PROCEDURE REMOVE_USERROLE "
				+ "( "
				+ "  i_userId IN NUMBER, "
				+ "  i_roleId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  DELETE FROM USERROLES WHERE userId = i_userId AND roleId = i_roleId; "
				+ "  COMMIT; "
				+ "END REMOVE_USERROLE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_DEPARTMENT "
				+ "( "
				+ "  i_deptId IN NUMBER, "
				+ "  i_Name IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE DEPARTMENTS SET Name = i_Name where deptId = i_deptId; "
				+ "  COMMIT; "
				+ "END UPDATE_DEPARTMENT;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_ISSUE "
				+ "( "
				+ "  i_issueid IN number, "
				+ "  i_Title IN VARCHAR2, "
				+ "  i_UserDescription IN VARCHAR2, "
				+ "  i_AdminComment IN VARCHAR2, "
				+ "  i_AssignedTo IN number, "
				+ "  i_SubmittedBy IN number, "
				+ "  i_StatusId IN number, "
				+ "  i_priority IN number, "
				+ "  i_DateSubmitted IN date, "
				+ "  i_DateResolved IN date, "
				+ "  i_DeptId IN number "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE ISSUES SET Title = i_Title, UserDescription = i_UserDescription, AdminComment = i_AdminComment, AssignedTo = i_AssignedTo, SubmittedBy = i_SubmittedBy, "
				+ "  StatusId = i_StatusId, priority = i_priority, DateSubmitted = i_DateSubmitted, DateResolved = i_DateResolved, DeptId = i_DeptId "
				+ "  where issueid = i_issueid; "
				+ "  COMMIT; "
				+ "END UPDATE_ISSUE;";
		genericDAO.stmtExecute(query);						
		query = ""
				+ "create or replace PROCEDURE UPDATE_ISSUEUPDATE "
				+ "( "
				+ "  i_issueUpdateId IN number, "
				+ "  i_issueId IN number, "
				+ "  i_SubmittedBy IN number, "
				+ "  i_UpdateDate IN date, "
				+ "  i_UpdateComment IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE ISSUEUPDATES SET issueId = i_issueId, SubmittedBy = i_SubmittedBy, UpdateDate = i_UpdateDate, UpdateComment = i_UpdateComment "
				+ "  where issueUpdateId = i_issueUpdateId; "
				+ "  COMMIT; "
				+ "END UPDATE_ISSUEUPDATE;";
		genericDAO.stmtExecute(query);						
		query = ""
				+ "create or replace PROCEDURE UPDATE_ROLE "
				+ "( "
				+ "  i_roleId IN NUMBER, "
				+ "  i_Name IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE ROLES SET RoleName = i_Name where roleId = i_roleId; "
				+ "  COMMIT; "
				+ "END UPDATE_ROLE;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_STATUS "
				+ "( "
				+ "  i_statusId IN NUMBER, "
				+ "  i_Name IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE STATUSS SET STATUS = i_Name where statusId = i_statusId; "
				+ "  COMMIT; "
				+ "END UPDATE_STATUS;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_USER "
				+ "( "
				+ "  i_userid IN NUMBER, "
				+ "  i_deptid IN NUMBER, "
				+ "  i_username IN VARCHAR2, "
				+ "  i_password IN VARCHAR2, "
				+ "  i_email IN VARCHAR2 "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE USERS SET deptid = i_deptid, username = i_username, password = i_password, email = i_email where userid = i_userid; "
				+ "  COMMIT; "
				+ "END UPDATE_USER;";
		genericDAO.stmtExecute(query);
		query = ""
				+ "create or replace PROCEDURE UPDATE_USERROLE "
				+ "( "
				+ "	i_userId IN NUMBER, "
				+ "	i_roleId IN NUMBER, "
				+ "	i_NewUserId IN NUMBER, "
				+ "	i_NewRoleId IN NUMBER "
				+ ") "
				+ "IS "
				+ "BEGIN "
				+ "  UPDATE USERROLES SET userId = i_NewUserId, roleId = i_NewRoleId where userId = i_userId and roleId = i_roleId; "
				+ "  COMMIT; "
				+ "END UPDATE_USERROLE;";
		genericDAO.stmtExecute(query);
		
		query = "commit";
		genericDAO.stmtExecute(query);
	}
	
	public void stubDBwithHeroes()
	{
		String query = ""
			+ "INSERT INTO departments(NAME) VALUES( 'heroes' )";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO departments(NAME) VALUES( 'antiheroes' )";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO roles(ROLENAME) VALUES( 'basic' )";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO roles(ROLENAME) VALUES( 'deptadmin' )";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO roles(ROLENAME) VALUES( 'genadmin' )";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Steve.Rogers', 'peggy', 'Steve.Rogers@marvel.com' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Tony.Stark', 'pepper', 'Tony.Stark@marvel.com' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Matt.Murdock', 'foggy', 'Matt.Murdock@marvel.com' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Luke.Cage', 'jessica', 'Luke.Cage@marvel.com' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Jessica.Jones', 'luke', 'Jessica.Jones@marvel.com' )";
		genericDAO.stmtExecute(query);
		query = ""
				+ "INSERT INTO userroles VALUES( 0, 2 ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO userroles VALUES( 1, 1 ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO STATUSS(STATUS) VALUES( 'New' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO STATUSS(STATUS) VALUES( 'Work In Progress' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO STATUSS(STATUS) VALUES( 'Waiting on Resources' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO STATUSS(STATUS) VALUES( 'Resolved' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO STATUSS(STATUS) VALUES( 'Complete' )";		
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) "
			+ "VALUES( 'Need Unobtainium', 'I do not have enough unobtainium', 2, 0, 1, to_date('19-09-2017 09:00:00', 'dd-mm-yyyy hh24:mi:ss'), 0 ) ";
		genericDAO.stmtExecute(query);
		query = ""
				+"UPDATE ISSUES SET ASSIGNEDTO = 1 WHERE ISSUEID = 0";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) "
			+ "VALUES( 'Broke desk chair', 'My desk chair is broken', 3, 0, 1, to_date('19-09-2017 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 0 )";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 0, 2, to_date('19-09-2017 09:10:00', 'dd-mm-yyyy hh24:mi:ss'), 'Unable to obtain unobtainium' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 0, 2, to_date('19-09-2017 09:20:00', 'dd-mm-yyyy hh24:mi:ss'), 'Unobtainium may not be real' ) ";
		genericDAO.stmtExecute(query);
		query = ""
			+ "INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 1, 3, to_date('19-09-2017 10:30:00', 'dd-mm-yyyy hh24:mi:ss'), 'I am too awesome' )";
		genericDAO.stmtExecute(query);
	
		query = "commit";
		genericDAO.stmtExecute(query);
	}
	
	public void stubDBwithDemo()
	{
		String query = ""
					+ "INSERT INTO departments(NAME) VALUES( 'IT Dept' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO departments(NAME) VALUES( 'Web Support' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO departments(NAME) VALUES( 'Legal' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO roles(ROLENAME) VALUES( 'Basic' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO roles(ROLENAME) VALUES( 'Dept Admin' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO roles(ROLENAME) VALUES( 'General Admin' )";
			genericDAO.stmtExecute(query);
			
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Steve.Rogers', 'peggy', 'Steve.Rogers@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Tony.Stark', 'pepper', 'Tony.Stark@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Hank.Pym', 'janet', 'Hank.Pym@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 1, 'Peter.Parker', 'gwen', 'Peter.Parker@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 1, 'Jessica.Drew', 'tony', 'Jessica.Drew@marvel.com' )";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 2, 'Matt.Murdock', 'foggy', 'Matt.Murdock@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 2, 'Jennifer.Walters', 'bruce', 'Jennifer.Walters@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Bruce.Banner', 'betty', 'Bruce.Banner@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 1, 'Cindy.Moon', 'peter', 'Cindy.Moon@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 2, 'Patrick.Mulligan', 'toxin', 'Patrick.Mulligan@marvel.com' ) ";
			genericDAO.stmtExecute(query);
			
			
			query = ""
					+ "INSERT INTO userroles VALUES( 0, 2 ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO userroles VALUES( 1, 1 ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO userroles VALUES( 2, 1 ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO userroles VALUES( 3, 1 ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO userroles VALUES( 4, 1 ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO userroles VALUES( 5, 1 ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO userroles VALUES( 6, 1 ) ";
			genericDAO.stmtExecute(query);
			
			query = ""
					+ "INSERT INTO STATUSS(STATUS) VALUES( 'New' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO STATUSS(STATUS) VALUES( 'Work In Progress' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO STATUSS(STATUS) VALUES( 'Waiting on Resources' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO STATUSS(STATUS) VALUES( 'Resolved' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO STATUSS(STATUS) VALUES( 'Complete' )";		
			genericDAO.stmtExecute(query);
			
			
			query = ""
					+ "INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) "
					+ "VALUES( 'No Internet', 'I can not search the internet for....solutions.', 7, 0, 1, to_date('19-09-2017 09:00:00', 'dd-mm-yyyy hh24:mi:ss'), 0  ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+"UPDATE ISSUES SET ASSIGNEDTO = 1 WHERE ISSUEID = 0";
			genericDAO.stmtExecute(query);
			
			query = ""
					+ "INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) "
					+ "VALUES( 'Link Broken', 'When clicking homepage link I am taken to an adult website.', 8, 0, 2, to_date('10-09-2017 20:00:00', 'dd-mm-yyyy hh24:mi:ss'), 1  )";
			genericDAO.stmtExecute(query);
			query = ""
					+"UPDATE ISSUES SET ASSIGNEDTO = 3 WHERE ISSUEID = 1";
			genericDAO.stmtExecute(query);
			
			query = ""
					+ "INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED, DEPTID) "
					+ "VALUES( 'No Paycheck', 'I have not been paid for 1 month now.', 9, 0, 3, to_date('29-08-2017 10:30:00', 'dd-mm-yyyy hh24:mi:ss'), 2  )";
			genericDAO.stmtExecute(query);
			query = ""
					+"UPDATE ISSUES SET ASSIGNEDTO = 5 WHERE ISSUEID = 2";
			genericDAO.stmtExecute(query);
			
			
			query = ""
					+ "INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 0, 1, to_date('11-09-2017 20:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'Link to adult website is still present.' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 0, 2, to_date('07-09-2017 11:20:00', 'dd-mm-yyyy hh24:mi:ss'), 'I STILL have not received a paycheck.' ) ";
			genericDAO.stmtExecute(query);
			query = ""
					+ "INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 1, 2, to_date('14-09-2017 12:10:00', 'dd-mm-yyyy hh24:mi:ss'), 'Do I still work here?' )";
			genericDAO.stmtExecute(query);
		
			query = "commit";
			genericDAO.stmtExecute(query);
	}
	
	public void tearDownDB()
	{
//Tables
		String query = "";
		query += "drop table issueupdates";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"issueupdates_SEQ\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table issues";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"issues_SEQ\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table statuss";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"statuss_SEQ\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table userroles";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table users";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"USERS_SEQ\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table departments";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"departments_SEQ\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop table roles";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop sequence \"roles_SEQ\"";
		genericDAO.stmtExecute(query);
//Stored Procedures
		query = "";
		query += "drop PROCEDURE \"ADD_DEPARTMENT\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"ADD_ISSUE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"ADD_ISSUEUPDATE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"ADD_ROLE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"ADD_STATUS\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"ADD_USER\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"ADD_USERROLE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_DEPARTMENT_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_DEPARTMENTS\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUE_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUE_BY_TITLE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUES_BY_ASSIGNEDTO\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUES_BY_SUBMITTEDBY\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUES_UNASSIGNED\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUES\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUEUPDATE_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUEUPDATES_BY_ISSUEID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ISSUEUPDATES\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ROLE_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ROLES_BY_USERID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_ROLES\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_STATUS_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_STATUSS\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_USER_BY_ID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_USER_BY_USERNAME\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_USERROLES\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"GET_USERS\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_DEPARTMENT\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_ISSUE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_ISSUEUPDATE_BY_ISSUEID\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_ISSUEUPDATE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_ROLE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_STATUS\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_USER\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"REMOVE_USERROLE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_DEPARTMENT\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_ISSUE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_ISSUEUPDATE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_ROLE\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_STATUS\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_USER\"";
		genericDAO.stmtExecute(query);
		query = "";
		query += "drop PROCEDURE \"UPDATE_USERROLE\"";
		genericDAO.stmtExecute(query);
		
		query = "commit";
		genericDAO.stmtExecute(query);
	}
	
}
